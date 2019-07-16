package com.parts;

import com.parts.Repos.PartRepo;
import com.parts.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private PartRepo partRepo;

    @GetMapping("/greeting")
    public String greeting(Map<String, Object> model) {

        Iterable<Part> parts = partRepo.findAll();

        model.put("parts", parts);
        return "greeting";
    }

    @PostMapping
    public String add(@RequestParam String nameComp, @RequestParam boolean need, @RequestParam int numberOfPieces, Map<String, Object> model){
        Part part = new Part(nameComp,need,numberOfPieces);

        partRepo.save(part);
        Iterable<Part> parts = partRepo.findAll();

        model.put("parts", parts);

        return "greeting";

    }

}
