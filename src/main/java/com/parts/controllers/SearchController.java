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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class SearchController {

    @Autowired
    private PartRepo partRepo;


    @PostMapping("/search")
    public String search(@RequestParam(required = false) String name,
                         Map<String, Object> model,
                         @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable){
        Page<Part> page;
        if (!name.equals("")) {
            page = partRepo.findByName(name, pageable);
            if (page.getNumberOfElements()==0){
                page = partRepo.findAll(pageable);
            }
        }
        else
            page = partRepo.findAll(pageable);

        List<Integer> information = CalcAmount.getInfo(page);

        model.put("page", page);
        model.put("countAll", page.getSize());
        model.put("countMin", information.get(0));
        model.put("url", "/search");

        return "search";
    }
}
