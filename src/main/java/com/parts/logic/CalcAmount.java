package com.parts.logic;

import com.parts.domain.Part;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalcAmount {

    public static Integer calculate(List<Part> part){
        List<Part> newParts = new ArrayList<>();

        for (Part p : part){
            if (p.getNeed()==1)
                newParts.add(p);
        }

        newParts.sort(Comparator.comparingInt(Part::getNumber));

        if (newParts.size()==0)
            return 0;
        else
            return newParts.get(0).getNumber();
    }

}
