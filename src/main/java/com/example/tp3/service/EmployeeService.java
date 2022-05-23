package com.example.tp3.service;

import com.example.tp3.dto.*;
import com.example.tp3.model.*;
import com.example.tp3.repository.*;
import com.example.tp3.util.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository adminRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmployeeRepository employeeRepository;



    public Employee createEmployee(String email, String passwords, String fullName) {
        return adminRepository.save(new Employee(email, passwords, fullName));
    }

    public Client createClient(String email, String password, String fullName) {
        Client client = Client.builder().email(email).password(password).fullName(fullName).fee(0).build();
        return clientRepository.save(client);
    }

    public Book createBook(String title, int nbPages, String author,
                           String category, String editor, int publicationYear, int quantity) {
        Book book = Book.builder().title(title).nbPages(nbPages).
                category(category).author(author).editor(editor).
                publicationYear(publicationYear).documentType("Book").
                quantity(quantity).borrowTimePeriod(3).build();
        return documentRepository.save(book);
    }

    public Book createBook(BookDto bookDto) {
        Book book = Book.builder().title(bookDto.getTitle()).
                nbPages(bookDto.getNbPages()).
                category(bookDto.getCategory()).
                author(bookDto.getAuthor()).editor(bookDto.getEditor()).
                publicationYear(bookDto.getPublicationYear())
                .documentType("Book").quantity(bookDto.getQuantity()).
                borrowTimePeriod(3).build();
        return documentRepository.save(book);
    }

    public Cd createCd(String title, int publicationYear, String author,
                       String editor, String category, int timeLength, int quantity) {
        Cd cd = Cd.builder().title(title).publicationYear(publicationYear).
                author(author).editor(editor).
                genre(category).timeLength(timeLength).documentType("Cd").
                quantity(quantity).borrowTimePeriod(2).build();
        return documentRepository.save(cd);
    }

    public Cd createCd(CdDto cdDto) {
        Cd cd = Cd.builder().title(cdDto.getTitle()).publicationYear(cdDto.getPublicationYear()).
                author(cdDto.getAuthor()).editor(cdDto.getEditor()).
                genre(cdDto.getCategory()).timeLength(cdDto.getTimeLength()).documentType("Cd").
                quantity(cdDto.getQuantity()).borrowTimePeriod(2).build();
        return documentRepository.save(cd);
    }


    public Dvd createDvd(String title, int publicationYear, String author,
                         String editor, String category, int timeLength, int quantity) {
        Dvd dvd = Dvd.builder().title(title).
                publicationYear(publicationYear).author(author).editor(editor).
                category(category).timeLength(timeLength).documentType("Dvd").
                quantity(quantity).borrowTimePeriod(1).build();
        return documentRepository.save(dvd);
    }

    public Client createClient(ClientDto clientDto) {
        Client client = Client.builder().email(clientDto.getEmail()).
                password(clientDto.getPassword()).
                fullName(clientDto.getFullName()).fee(0).build();
        return clientRepository.save(client);
    }

    public Dvd createDvd(DvdDto dvdDto) {
        Dvd dvd = Dvd.builder().title(dvdDto.getTitle()).
                publicationYear(dvdDto.getPublicationYear()).
                author(dvdDto.getAuthor()).editor(dvdDto.getEditor()).
                category(dvdDto.getCategory()).timeLength(dvdDto.getTimeLength())
                .documentType("Dvd").quantity(dvdDto.getQuantity()).borrowTimePeriod(1).build();
        return documentRepository.save(dvd);
    }


    public void chargeFee(Client client, int amount) {
        client.setFee(client.getFee() + amount);
        clientRepository.save(client);
    }

    @Transactional
    public List<ClientDto> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDto> ClientDto = DtoUtils.getClientsDTO(clients);
        return ClientDto;
    }


    @Transactional
    public List<EmployeeDto> findAllEmployees(){
        List<Employee> employees =  employeeRepository.findAll();
        List<EmployeeDto> employeeDto = DtoUtils.getEmployeesDto(employees);
        return  employeeDto;

    }

    @Transactional
    public ClientDto findClientByEmail(String email) {
        Client client = clientRepository.findByEmail(email);
        ClientDto ClientDto = DtoUtils.getClientDTO(client);
        return ClientDto;
    }

    @Transactional
    public Optional<Client> findClientById(Long id){
        return clientRepository.findById(id);
    }


    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
