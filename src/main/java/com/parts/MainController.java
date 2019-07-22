package com.parts;

import com.parts.Repos.PartRepo;
import com.parts.domain.Part;
import com.parts.logic.CalcAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/")
@Controller
public class MainController {

    @Autowired
    private PartRepo partRepo;

    @GetMapping("/main")
    public String greeting(Map<String, Object> model) {

        Iterable<Part> parts = partRepo.findAll();

        List<Integer> information = CalcAmount.getInfo(parts);


        model.put("parts", parts);
        model.put("countAll", information.get(0));
        model.put("countMin", information.get(1));
        return "main";
    }



    @GetMapping("/delete{id}")
    public String delete(@PathVariable("id") Integer id, Map<String, Object> model){
        Part partRepoById = partRepo.findById(id);

        if (partRepoById != null)
            partRepo.delete(partRepoById);


        Iterable<Part> parts = partRepo.findAll();
        List<Integer> information = CalcAmount.getInfo(parts);

        model.put("parts", parts);
        model.put("countAll", information.get(0));
        model.put("countMin", information.get(1));
        return "main";


    }



























}
