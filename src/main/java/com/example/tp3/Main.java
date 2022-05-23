package com.example.tp3;

import com.example.tp3.model.*;
import com.example.tp3.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private BorrowService borrowService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        adminService.createAdmin("admin@gmail.com", "admin", "Steve admin");

        employeeService.createEmployee("Employe1", "q1w2e3", "Bob the builder");
        employeeService.createEmployee("Emp", "0", "jeff");

        clientService.createClient("salah@gmail.com", "1234", "Salah");
        employeeService.createClient("edine@gmail.com", "4321", "Edine");

        employeeService.createBook("Marvel", 189, "stan lee", "action", "Amazon", 1990, 10);
        employeeService.createBook("Hello kitty", 12, "me", "Horror", "Amazon", 2000, 5);
        employeeService.createBook("Hello bob the builder", 189, "you", "sci-fi", "Amazon", 2022, 10);

        employeeService.createCd("Billie Jeans", 1990, "MJ", "MJ", "Country", 28, 30);

        employeeService.createDvd("Kung fu panda", 1990, "me", "disney?", "family", 68, 50);


        clientService.borrowDocument("salah@gmail.com", "Billie Jeans");
        clientService.borrowDocument("edine@gmail.com","Kung fu panda");
        clientService.borrowDocument("edine@gmail.com","Hello kitty");
        //clientService.returnDocument("salah@gmail.com", "Billie Jeans");
        borrowService.findBorrowsByClientEmail("salah@gmail.com");

    }
}
