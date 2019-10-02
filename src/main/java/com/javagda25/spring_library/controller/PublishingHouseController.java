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

    @GetMapping(path = "/list")
    public String list(Model model){
        List<PublishingHouse> publishingHouseList = publishingHouseService.getAll();
        model.addAttribute("phouses", publishingHouseList);
        return "ph-list";
    }

    @GetMapping(path = "/add")
    public String addPh(Model model, PublishingHouse ph){
        model.addAttribute("ph", ph);

        return "ph-add";
    }

    @PostMapping("/add")
    public String addPh(PublishingHouse ph){
        publishingHouseService.addPh(ph);

        return "redirect:/ph/list";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(Model model,
                       @PathVariable(name = "id") Long phId) {
        Optional<PublishingHouse> phOptional = publishingHouseService.findId(phId);
        if (phOptional.isPresent()) {
            model.addAttribute("ph", phOptional.get());
            model.addAttribute("phId", phId);
            return "ph-add";
        }
        return "redirect:/ph/list";
    }

    @GetMapping(path = "/remove/{id}")
    public String delete(Model model,
                         @PathVariable(name = "id") Long phId) {
        model.addAttribute("id", phId);
        publishingHouseService.delete(phId);

        return "redirect:/ph/list";
    }
}
