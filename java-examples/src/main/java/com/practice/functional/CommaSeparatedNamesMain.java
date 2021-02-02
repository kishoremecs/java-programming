package com.practice.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommaSeparatedNamesMain {

    public static void main(String... args) {
        List<String> names = new ArrayList<>();

        names.add("Hello");
        names.add("World");
        names.add("in ");
        names.add("functional thinking");

        Optional<String> s = names.stream().filter(name -> name.length() > 1)
                .map(CommaSeparatedNamesMain::capitalize)
                .reduce((x, y) -> x + "," + y);
        System.out.println(" $$$$ " + s.get());
    }

    public static String capitalize(String input) {
        return input != null?input.substring(0, 1).toUpperCase() + input.substring(1): null;
    }
}
