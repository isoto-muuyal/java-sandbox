package com.iss.learn;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Examples {

    public static void main(String[] args) {
        Path path1 = Paths.get("\\Users\\isoto\\workspace\\tmp\\readme.txt");
        Path path2 = Paths.get("index.html");

        Path finalPath = path1.relativize(path2);
        System.out.println(finalPath);


                String name = "John";
                System.out.print(name.matches("[A-z].*{0,}"));
                System.out.print(name.matches("[\\w].*{1,4}"));


    }

}
