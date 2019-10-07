package com.javagda25.spring_library.controller;

import com.javagda25.spring_library.model.PublishingHouse;
import com.javagda25.spring_library.service.PublishingHouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/ph/")
public class PublishingHouseController {
    private final PublishingHouseService publishingHouseService;

    @GetMapping("/list")
    public String list(Model model) {
        List<PublishingHouse> publishingHouses = publishingHouseService.getAll();
        model.addAttribute("phouses", publishingHouses);

        return "ph-list";
    }

    @GetMapping("/add")
    public String add(Model model, PublishingHouse publishingHouse) {
        model.addAttribute("publishingHouse", publishingHouse);
        return "ph-add";
    }

    @GetMapping("/remove/{id}")
    public String add(@PathVariable(name = "id") Long id) {
        publishingHouseService.remove(id);
        return "redirect:/ph/list";
    }

    @GetMapping("/edit/{id}")
    public String add(Model model,
                      @PathVariable(name = "id") Long id) {
        Optional<PublishingHouse> publishingHouseOptional = publishingHouseService.getById(id);
        if (publishingHouseOptional.isPresent()) {
            model.addAttribute("publishingHouse", publishingHouseOptional.get());

            return "ph-add";
        }
        return "redirect:/ph/list";
    }

    @PostMapping("/add")
    public String add(PublishingHouse publishingHouse) {
        publishingHouseService.save(publishingHouse);

        return "redirect:/ph/list";
    }

    @GetMapping("/books/{id}")
    public String getPHBooks(Model model, @PathVariable(name = "id") Long id) {
        Optional<PublishingHouse> publishingHouseOptional = publishingHouseService.getById(id);
        if (publishingHouseOptional.isPresent()) {
            PublishingHouse publishingHouse = publishingHouseOptional.get();

            model.addAttribute("books", publishingHouse.getBooks());

            return "book-list";
        }
        return "redirect:/ph/list";
    }
}
