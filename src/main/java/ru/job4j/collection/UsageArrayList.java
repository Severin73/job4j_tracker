package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class UsageArrayList {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Petr");
        strings.add("Ivan");
        strings.add("Stepan");

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
