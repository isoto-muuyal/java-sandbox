package com.iss.leetcode.helpers;

import java.util.function.Predicate;

public class ValidationHelper {

    private static final Predicate<String> businessLogic =  s ->
    {
        if (s == null) {
            return false;
        }
        String trimmed = s.trim();
        if (trimmed.isEmpty()) {
            return false;
        }
        return trimmed.length() != 1;
    };

    /**
     * esta funcion valida que el texto no este vacio ni nulo
     * y lo imprime en un log
     * @param val
     */
    public static void validate(String val){
        if (isValid(val)) {
            System.out.println("texto no puede ir vacio");
        } else {
            System.out.println("si es valido");
        }
    }

    /**
     * este metodo regresa cierto si no es vacio ni nulo
     * @param val
     * @return
     */
    public static boolean isValid(String val) {
        boolean result = false;

        if (businessLogic.test(val)) {
            System.out.println("string is valid");
            result = true;
        } else {
            System.out.println("string is not valid");
        }
        return result;
    }
}
