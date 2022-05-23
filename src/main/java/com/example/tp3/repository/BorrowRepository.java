package com.example.tp3.repository;

import com.example.tp3.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    List<Borrow> findBorrowByClient_Id(long id);

    List<Borrow> findBorrowByClient_Email(String email);

    void deleteBorrowByDocumentTitle(String title);

    void deleteByDocument_Title(String title);

    Borrow findBorrowByClient_EmailAndAndDocument_Title(String email, String title);

    Borrow findBorrowByDocumentId(Long id);

}
