package com.parts.logic;

import com.parts.domain.Part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CalcAmount {

    public static void main(String[] args) {
        List<Part> p = new ArrayList<>();

        p.add(new Part("Big", 1, 25));
        p.add(new Part("middle", 1, 20));
        p.add(new Part("High", 1, 500));
        p.add(new Part("low", 1, 3));

        System.out.println(calculate(p)); //result -> 3

        Iterable<Part> parts = p;

        System.out.println(((Collection<?>)parts).size());

    }

    public static Integer calculate(List<Part> part){


        List<Part> newParts = new ArrayList<>();

        for (Part p : part){
            if (p.getNeed()==1)
                newParts.add(p);
        }



        newParts.sort((o1, o2) -> o1.getNumber() - o2.getNumber());

        if (newParts.size()==0)
            return 0;
        else
            return newParts.get(0).getNumber();
    }




}
