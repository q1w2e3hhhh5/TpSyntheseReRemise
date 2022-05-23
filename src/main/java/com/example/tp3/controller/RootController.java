package com.example.tp3.controller;

import com.example.tp3.dto.*;
import com.example.tp3.model.*;
import com.example.tp3.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RootController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    public String getRootRequest(Model model) {
        model.addAttribute("pageTitle1", "Library");
        model.addAttribute("h1Text", "Java Town Library");
        return "index";
    }

    @GetMapping("/Client")
    public String getClients(Model model) {
        model.addAttribute("pageTitle", "All Clients");
        var clients = employeeService.findAllClients();
        model.addAttribute("clients", clients);
        return "client";
    }

    @GetMapping("/Documents")
    public String getDocuments(Model model) {
        model.addAttribute("pageTitle", "All Documents");
        var documents = documentService.findDocuments();
        model.addAttribute("documents", documents);
        return "documents";
    }

    @GetMapping("/CreateClient")
    public String ClientCreate(Model model) {
        var clientDto = new ClientDto();
        model.addAttribute("client", clientDto);
        return "CreateClient";
    }

    @PostMapping("/CreateClient")
    public RedirectView clientPost(@ModelAttribute ClientDto clientDto, RedirectAttributes redirectAttributes) {
        final Client client = clientService.createClient(clientDto);
        clientDto.setId(client.getId());

        redirectAttributes.addFlashAttribute("clients", clientDto);

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/Client");
        return redirectView;
    }

    @GetMapping("/CreateDocument")
    public String getCreateDocuments(Model model) {
        model.addAttribute("dvd", new DvdDto());
        model.addAttribute("cd", new CdDto());
        model.addAttribute("book", new BookDto());
        return "CreateDocument";
    }

    @PostMapping("/DvdCreate")
    public RedirectView dvdPost(@ModelAttribute DvdDto dvdDto, RedirectAttributes redirectAttributes) {
        final Dvd dvd = employeeService.createDvd(dvdDto);
        dvdDto.setId(dvd.getId());

        redirectAttributes.addFlashAttribute("dvd", dvdDto);
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/Documents");
        return redirectView;
    }

    @PostMapping("/CdCreate")
    public RedirectView cdPost(@ModelAttribute CdDto cdDto, RedirectAttributes redirectAttributes) {
        final Cd cd = employeeService.createCd(cdDto);
        cdDto.setId(cd.getId());

        redirectAttributes.addFlashAttribute("cd", cdDto);
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/Documents");
        return redirectView;
    }

    @PostMapping("/BookCreate")
    public RedirectView bookPost(@ModelAttribute BookDto bookDto, RedirectAttributes redirectAttributes) {
        final Book book = employeeService.createBook(bookDto);
        bookDto.setId(book.getId());

        redirectAttributes.addFlashAttribute("book", bookDto);
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/Documents");
        return redirectView;
    }

}
