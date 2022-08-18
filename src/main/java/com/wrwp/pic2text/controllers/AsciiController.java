package com.wrwp.pic2text.controllers;

import com.wrwp.pic2text.domain.Ascii;
import com.wrwp.pic2text.repositories.AsciiRepository;
import com.wrwp.pic2text.utilities.AsciiBuilder;
import com.wrwp.pic2text.utilities.TempDirectorySingleton;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class AsciiController {
    private final AsciiRepository asciiRepository;

    public AsciiController(AsciiRepository asciiRepository) {
        this.asciiRepository = asciiRepository;
    }

    @RequestMapping("/asciis")
    public String getAsciis(Model model) {
        model.addAttribute("asciis", asciiRepository.findAll());

        return "asciis/index";
    }
    @RequestMapping(value= "/asciis/new")
    public String showNewAsciiForm(Ascii ascii) {
        return "asciis/new_ascii";
    }

    @PostMapping (value = "/asciis/save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.TEXT_PLAIN_VALUE)
    public String testUpload1(
            @RequestParam("file") MultipartFile uploadedFile,
            @RequestParam("height") int height,
            @RequestParam("width") int width,
            @RequestParam("palette") String palette,
            @RequestParam(value = "reverse", required = false) boolean reverse,
            @RequestParam("title") String title,
            @RequestParam("description") String description
            ) throws IOException {

        TempDirectorySingleton tempDirectory = TempDirectorySingleton.getInstance();

        File file = new File(tempDirectory.getTmpdir() + uploadedFile.getOriginalFilename());

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(uploadedFile.getBytes());
        }

        boolean reverseSelected = reverse ? true : false;

        AsciiBuilder builder = new AsciiBuilder(width, height, palette, reverseSelected, file);
        Ascii ascii = new Ascii(title, description, builder.toString());

        asciiRepository.save(ascii);

        return "redirect:";
    }
}
