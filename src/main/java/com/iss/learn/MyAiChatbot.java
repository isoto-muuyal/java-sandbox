package com.iss.learn;

import com.iss.learn.records.Policy;
import com.iss.learn.service.OllamaService;

import java.io.BufferedReader;
import java.io.IOException;

public class MyAiChatbot {

    private static OllamaService ollamaService = new OllamaService();

    private static String saludo(){
        return "Hola";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String entry = br.readLine();

        Policy policy = new Policy(1, "Policy 1", 10, 0.1);
        System.out.println( saludo() + "World! " + policy);

        System.out.println("----------------  Wrapping ollama model ipe2 --------------");
        String ollamaRes = ollamaService.processUserMessage(entry);
        System.out.printf("""
                ------------- from Ollama:
                 %s
                 ---------%n""", ollamaRes);
    }

}
