package com.practice.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommaSeparatedNamesMain {

    public static void main(String... args) {
        List<String> names = new ArrayList<>();

        names.add("Hello");
        names.add("World");
        names.add("in ");
        names.add("functional thinking");

        String s = names.stream().filter(name -> name.length() > 1)
                .map(CommaSeparatedNamesMain::capitalize)
                .collect(Collectors.joining(","));
                //.reduce((x, y) -> x + "," + y); This also work.
        System.out.println(" $$$$ " + s);
    }

    public static String capitalize(String input) {
        return input != null?input.substring(0, 1).toUpperCase() + input.substring(1): null;
    }
}
