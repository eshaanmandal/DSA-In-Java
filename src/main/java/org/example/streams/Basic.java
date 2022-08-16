package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Basic {
    static int addNums(int a, int b){
        return a+b;
    }
    public static void main(String[] args){
        List<String> names = Arrays.asList("Eshaan", "Aman", "Kartik", "Anonymous", "Cow", "DeezNuts", "Valhalla", "Anmol");

        List<String> sorted_names = names.stream().sorted().collect(Collectors.toList());
        sorted_names.forEach(System.out::println);

    }
}
