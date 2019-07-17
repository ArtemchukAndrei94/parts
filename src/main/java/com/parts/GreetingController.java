package com.parts;

import com.parts.Repos.PartRepo;
import com.parts.domain.Part;
import com.parts.logic.CalcAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private PartRepo partRepo;

    @GetMapping("/greeting")
    public String greeting(Map<String, Object> model) {

        Iterable<Part> parts = partRepo.findAll();

        List<Integer> information = CalcAmount.getInfo(parts);


        model.put("parts", parts);
        model.put("information", information);
        return "greeting";
    }

    @PostMapping("add")
    public String add(@RequestParam String name, @RequestParam int need, @RequestParam int number, Map<String, Object> model){
        Part part = new Part(name,need,number);
        partRepo.save(part);

        Iterable<Part> parts = partRepo.findAll();
        List<Integer> information = CalcAmount.getInfo(parts);

        model.put("parts", parts);
        model.put("information", information);
        return "greeting";

    }

    @PostMapping("delete")
    public String delete(@RequestParam String name, Map<String, Object> model){
        List<Part> partList = partRepo.findByName(name);

        if (!partList.isEmpty())
            partRepo.delete(partList.get(0));


        Iterable<Part> parts = partRepo.findAll();
        List<Integer> information = CalcAmount.getInfo(parts);

        model.put("parts", parts);
        model.put("information", information);
        return "greeting";


    }



























}
