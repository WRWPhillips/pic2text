package com.wrwp.pic2text.controllers;

import com.wrwp.pic2text.repositories.AsciiRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AsciiController {
    private final AsciiRepository asciiRepository;

    public AsciiController(AsciiRepository asciiRepository) {
        this.asciiRepository = asciiRepository;
    }

    @RequestMapping("/asciis")
    public String getAsciis(Model model) {
        model.addAttribute("asciis", asciiRepository.findAll());

        return "asciis/list";
    }
}
