package com.example.tp3.controller;

import com.example.tp3.model.*;
import com.example.tp3.dto.*;
import com.example.tp3.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//http://localhost:8085/api/v1/ ...
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/Clients")
    public List<ClientDto> getAllCients() {
        return employeeService.findAllClients();
    }

    @GetMapping("/Employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @PostMapping("/Clients")
    public Client createEmployee(@RequestBody ClientDto clientDto){
        return employeeService.createClient(clientDto);
    }

    @PostMapping("/Book")
    public Book createBook(@RequestBody BookDto bookDto){
        return employeeService.createBook(bookDto);
    }

    @PostMapping("/Dvd")
    public Dvd createDvd(@RequestBody DvdDto dvdDto){
        return employeeService.createDvd(dvdDto);
    }

    @PostMapping("/Cd")
    public Cd createCd(@RequestBody CdDto cdDto){
        return employeeService.createCd(cdDto);
    }

    @PostMapping("/Borrows/{id}")
    public void borrowDocument(@PathVariable Long id, @RequestBody Document  document){
        System.out.println(document.toString());
        clientService.borrowDocument(id,document);
    }

    @GetMapping("/Documents")
    public List<DocumentDto> getAllDocuments() {
        return documentService.findDocuments();
    }

    @GetMapping("/Documents/{id}")
    public Document getDocumentById(@PathVariable Long id) {
        return documentService.findDocumentById(id);
    }

    @GetMapping("/Borrows/{id}")
    public ResponseEntity<List<Document>> getBorrowsByClient(@PathVariable Long id){
        return ResponseEntity.ok(borrowService.getDocumentsOfBorrows(id));
    }

    @GetMapping("/Client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
        Client client1  = clientService.getClientById(id)
                .orElseThrow(() -> new ResourceAccessException("Client does not exist with id :" + id));

        return ResponseEntity.ok(client1);
    }

    @PutMapping("/Client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client){
        Client client1  = clientService.getClientById(id)
                .orElseThrow(() -> new ResourceAccessException("Client does not exist with id :" + id));

        client1.setEmail(client.getEmail());
        client1.setFullName(client.getFullName());
        client1.setPassword(client.getPassword());

        Client updatedClient = clientService.saveClient(client1);

        return ResponseEntity.ok(updatedClient);
    }

    @PutMapping("/Documents/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable Long id,@RequestBody Document document){
        Document orignalDocument = documentService.findDocumentById(id);

        orignalDocument.setTitle(document.getTitle());
        orignalDocument.setPublicationYear(document.getPublicationYear());
        orignalDocument.setAuthor(document.getAuthor());
        orignalDocument.setEditor(document.getEditor());
        orignalDocument.setCategory(document.getCategory());
        orignalDocument.setQuantity(document.getQuantity());

        Document updatedDocument = documentService.saveDocument(orignalDocument);
        return  ResponseEntity.ok(updatedDocument);
    }

    @DeleteMapping("/Borrows/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBorrow(@PathVariable Long id){
        Borrow borrow = borrowService.getBorrowByDocumentId(id);

        borrowService.removeBorrow(borrow);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
