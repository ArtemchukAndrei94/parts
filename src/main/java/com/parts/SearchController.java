package com.parts;

import com.parts.Repos.PartRepo;
import com.parts.domain.Part;
import com.parts.logic.CalcAmount;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String search(@RequestParam(required = false) String name, Map<String, Object> model){
        Iterable<Part> parts;
        if (!name.equals(""))
            parts = partRepo.findByName(name);
        else
            parts = partRepo.findAll();

        List<Integer> information = CalcAmount.getInfo(parts);

        model.put("parts", parts);
        model.put("countAll", information.get(0));
        model.put("countMin", information.get(1));

        return "search";
    }
}
