package com.parts.controllers;

import com.parts.Repos.PartRepo;
import com.parts.domain.Part;
import com.parts.logic.CalcAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class MainController {

    @Autowired
    private PartRepo partRepo;

    @GetMapping("/main")
    public String greeting(Map<String, Object> model,
                           @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Part> page = partRepo.findAll(pageable);

        Integer countMin = CalcAmount.calculate(partRepo.findAll());

        model.put("page", page);
        model.put("countAll", page.getTotalElements());
        model.put("countMin", countMin);
        model.put("url", "/main");
        return "main";
    }

    @GetMapping("/delete{id}")
    public String delete(@PathVariable("id") Integer id,
                         Map<String, Object> model,
                         @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Part partRepoById = partRepo.findById(id);

        if (partRepoById != null)
            partRepo.delete(partRepoById);

        Page<Part> page = partRepo.findAll(pageable);
        Integer countMin = CalcAmount.calculate(partRepo.findAll());

        model.put("page", page);
        model.put("countAll", page.getTotalElements());
        model.put("countMin", countMin);
        model.put("url", "/main");
        return "main";
    }

}
