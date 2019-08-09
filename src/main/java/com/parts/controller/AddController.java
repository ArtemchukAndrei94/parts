package com.parts.controller;


import com.parts.Repos.PartRepo;
import com.parts.domain.Part;
import com.parts.logic.CalcAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AddController {
    @Autowired
    private PartRepo partRepo;

    @GetMapping("/add")
    public String addPart(){

        return "add";
    }

    @PostMapping("/add")
    public String add(@RequestParam String name,
                      @RequestParam int need,
                      @RequestParam int number,
                      Map<String, Object> model,
                      @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable){
        Part part = new Part(name,need,number);
        partRepo.save(part);

        Page<Part> page = partRepo.findAll(pageable);

        model.put("page", page);
        model.put("countAll", page.getTotalElements());
        model.put("countMin", CalcAmount.calculate(partRepo.findAll()));
        model.put("url", "/main");
        return "main";

    }

}
