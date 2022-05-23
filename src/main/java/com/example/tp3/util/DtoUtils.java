package com.example.tp3.util;

import com.example.tp3.model.*;
import com.example.tp3.dto.*;

import java.util.ArrayList;
import java.util.List;

public class DtoUtils {

    public static BorrowDto toDto(Borrow borrow) {
        BorrowDto borrowDto = new BorrowDto();

        borrowDto.setId(borrow.getId());
        borrowDto.setDocumentDto(getDocumentDto(borrow.getDocument()));
        borrowDto.setLocalDateTimeOfBorrow(borrow.getLocalDateTimeOfBorrow());
        borrowDto.setLocalDateTimeOfReturn(borrow.getLocalDateTimeOfReturn());

        return borrowDto;
    }

    public static ClientDto getClientDTO(Client client) {
        ClientDto clientDTO = new ClientDto();

        clientDTO.setId(client.getId());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPassword(client.getPassword());
        clientDTO.setFullName(client.getFullName());
        for (Borrow b : client.getBorrows()) {
            clientDTO.addBorrow(DtoUtils.toDto(b));
        }
        return clientDTO;
    }

    public static DocumentDto getDocumentDto(Document document) {
        DocumentDto documentDto = new DocumentDto();

        documentDto.setId(document.getId());
        documentDto.setDocumentType(document.getDocumentType());
        documentDto.setAuthor(document.getAuthor());
        documentDto.setCategory(documentDto.getCategory());
        documentDto.setEditor(document.getEditor());
        documentDto.setQuantity(document.getQuantity());

        documentDto.setTitle(document.getTitle());
        documentDto.setPublicationYear(document.getPublicationYear());
        documentDto.setBorrowTimePeriod(document.getBorrowTimePeriod());

        return documentDto;

    }

    public static BorrowDto getBorrowDto(Borrow borrow) {
        BorrowDto borrowDto = new BorrowDto();

        borrowDto.setClientDto(getClientDTO(borrow.getClient()));
        borrowDto.setDocumentDto(getDocumentDto(borrow.getDocument()));
        borrowDto.setLocalDateTimeOfBorrow(borrowDto.getLocalDateTimeOfBorrow());
        borrowDto.setLocalDateTimeOfReturn(borrow.getLocalDateTimeOfReturn());
        return borrowDto;
    }

    public static List<BorrowDto> getBorrowsDto(List<Borrow> borrows) {
        List<BorrowDto> borrowDtos = new ArrayList<>();
        for (Borrow b : borrows) {
            borrowDtos.add(getBorrowDto(b));
        }
        return borrowDtos;

    }

    public static List<DocumentDto> getDocumentsDto(List<Document> documents) {
        List<DocumentDto> documentDtos = new ArrayList<>();
        for (Document d : documents) {
            documentDtos.add(getDocumentDto(d));
        }
        return documentDtos;
    }

    public static List<ClientDto> getClientsDTO(List<Client> clients) {
        List<ClientDto> clientDtos = new ArrayList<>();
        for (Client c : clients) {
            clientDtos.add(getClientDTO(c));
        }
        return clientDtos;
    }

    public static List<EmployeeDto> getEmployeesDto(List<Employee> employees) {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for(Employee e : employees){
            employeeDtos.add(getEmployeeDTO(e));
        }
    return employeeDtos;

    }


    public static EmployeeDto getEmployeeDTO(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPassword(employee.getPassword());
        employeeDto.setFullName(employee.getFullName());
        return employeeDto;
    }


    public static List<DocumentDto> getBooksDto(List<Document> books) {
        List<DocumentDto> documentDtos = new ArrayList<>();
        for (Document b : books) {
            documentDtos.add(getDocumentDto(b));
        }
        return documentDtos;
    }

    public static List<DocumentDto> getCdsDto(List<Document> cd) {
        List<DocumentDto> documentDtos = new ArrayList<>();
        for (Document c : cd) {
            documentDtos.add(getDocumentDto(c));
        }
        return documentDtos;

    }

    public static List<DocumentDto> getDvdsDto(List<Document> dvd) {
        List<DocumentDto> documentDtos = new ArrayList<>();
        for (Document d : dvd) {
            documentDtos.add(getDocumentDto(d));
        }
        return documentDtos;
    }



}
