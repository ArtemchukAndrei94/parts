package com.parts;

import com.parts.Repos.PartRepo;
import com.parts.domain.Part;
import com.parts.logic.CalcAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class EditController {

    @Autowired
    private PartRepo partRepo;

    @GetMapping("/edit{id}")
    public String edit(@PathVariable Integer id, Map<String, Object> model){
        Part part = partRepo.findById(id);

        model.put("part", part);

        return "edit";


    }

    @PostMapping("/edit{id}")
    public String add(@PathVariable Integer id,
                      @RequestParam String name,
                      @RequestParam int need,
                      @RequestParam int number,
                      Map<String, Object> model){

        Part part = new Part(id,name,need,number);
        partRepo.save(part);

        Iterable<Part> parts = partRepo.findAll();
        List<Integer> information = CalcAmount.getInfo(parts);

        model.put("parts", parts);
        model.put("countAll", information.get(0));
        model.put("countMin", information.get(1));
        return "main";

    }



}
