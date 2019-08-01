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

import java.util.Map;

@Controller

public class SelectController {

    @Autowired
    private PartRepo partRepo;

    @GetMapping("/select{need}")
    public String getSelectNeed(
            @PathVariable Integer need,
            Map<String, Object> model,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Part> page;
        Integer countMin = CalcAmount.calculate(partRepo.findAll());

        if (need == 1)
            page = partRepo.findByNeed(need,pageable);
        else if (need == 0)
            page = partRepo.findByNeed(need,pageable);
        else
            page = partRepo.findAll(pageable);

        model.put("page", page);
        model.put("countAll", page.getTotalElements());
        model.put("countMin", countMin);
        model.put("url", "/select" + need.toString());
        return "select";
    }


}
