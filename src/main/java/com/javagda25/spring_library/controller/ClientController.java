package com.javagda25.spring_library.controller;

import com.javagda25.spring_library.model.Client;
import com.javagda25.spring_library.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/client/")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("clients", clientService.getAll());

        return "client-list";
    }

    @GetMapping("/add")
    public String getForm(Model model, Client client) {

        model.addAttribute("client", client);

        return "client-add";
    }

    @PostMapping("/add")
    public String addClient(Client client) {
        clientService.saveClient(client);
        return "redirect:/client/list";
    }

    @GetMapping("/remove/{id}")
    public String remove(
            HttpServletRequest request,
            @PathVariable(name = "id") Long id) {
        String referer = request.getHeader("referer");
        clientService.remove(id);

        if (referer != null) {
            return "redirect:" + referer;
        }
        return "redirect:/client/list";
    }

    @GetMapping("/edit/{id}")
    public String getForm(Model model, @PathVariable(name = "id") Long id) {
        Optional<Client> optionalClient = clientService.getById(id);

        if (optionalClient.isPresent()) {
            model.addAttribute("client", optionalClient.get());

            return "client-add";
        }

        return "redirect:/client/list";
    }
}
