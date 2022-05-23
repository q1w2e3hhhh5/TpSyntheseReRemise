package com.example.tp3.service;

import com.example.tp3.model.Document;
import com.example.tp3.repository.DocumentRepository;
import com.example.tp3.dto.DocumentDto;
import com.example.tp3.util.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public List<DocumentDto> findDocuments() {
        List<Document> documents = documentRepository.findAll();
        List<DocumentDto> documentDtos = DtoUtils.getDocumentsDto(documents);
        return documentDtos;
    }

    public List<DocumentDto> findDocumentsByTitle(String title) {
        List<Document> documents = documentRepository.findDocumentsByTitleContains(title);
        List<DocumentDto> documentDtos = DtoUtils.getDocumentsDto(documents);
        return documentDtos;
    }

    public List<DocumentDto> findDocumentsByAuthor(String author) {
        List<Document> documents = documentRepository.findDocumentsByAuthor(author);
        List<DocumentDto> documentDtos = DtoUtils.getDocumentsDto(documents);
        return documentDtos;
    }

    public List<DocumentDto> findDocumentsPublicationYear(int publicationYear) {
        List<Document> documents = documentRepository.findDocumentsByPublicationYear(publicationYear);
        List<DocumentDto> documentDtos = DtoUtils.getDocumentsDto(documents);
        return documentDtos;
    }

    public List<DocumentDto> findDocumentsByCategory(String category) {
        List<Document> documents = documentRepository.findDocumentsByCategory(category);
        List<DocumentDto> documentDtos = DtoUtils.getDocumentsDto(documents);
        return documentDtos;
    }

    public List<DocumentDto> findDocumentsByEditor(String editor) {
        List<Document> documents = documentRepository.findDocumentsByEditor(editor);
        List<DocumentDto> documentDtos = DtoUtils.getDocumentsDto(documents);
        return documentDtos;
    }

    public List<DocumentDto> findAllBooks() {
        List<Document> documents = documentRepository.findByDocumentType("Book");
        List<DocumentDto> documentDtos = DtoUtils.getBooksDto(documents);
        return documentDtos;
    }

    public List<DocumentDto> findAllCds() {
        List<Document> documents = documentRepository.findByDocumentType("Cd");
        List<DocumentDto> documentDtos = DtoUtils.getCdsDto(documents);
        return documentDtos;
    }

    public List<DocumentDto> findAllDvds() {
        List<Document> documents = documentRepository.findByDocumentType("Dvd");
        List<DocumentDto> documentDtos = DtoUtils.getDvdsDto(documents);
        return documentDtos;
    }

    public Document findDocumentById(Long id){
        return  documentRepository.findDocumentById(id);
    }

    public Document saveDocument(Document document){
        return  documentRepository.save(document);
    }



}
