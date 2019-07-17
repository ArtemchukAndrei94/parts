package com.parts.logic;

import com.parts.domain.Part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
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

    public static Integer calculate(Iterable<Part> part){

        List<Part> partList = new ArrayList<>();
        List<Part> newParts = new ArrayList<>();

        for (Part p : part){
            partList.add(p);
        }

        for (Part p : partList){
            if (p.getNeed()==1)
                newParts.add(p);
        }



        newParts.sort((o1, o2) -> o1.getNumber() - o2.getNumber());

        return newParts.get(0).getNumber();
    }

    public static List<Integer> getInfo(Iterable<Part> parts){
        List<Integer> information = new ArrayList<>();
        information.add(((Collection<?>)parts).size());
        information.add(CalcAmount.calculate(parts));

        return information;
    }


}
