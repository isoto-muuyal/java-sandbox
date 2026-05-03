package com.iss.learn.service;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OllamaService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String processUserMessage(String message) {
        String prompt = """
                you are a chatbot that will help people learn spanish, anything they ask in english
                you will respond with a spanish translation of the question and also reply the question in spanish
                and add a line showing the answer in english below the spanish translation.
                User: %s
                """.formatted(message);

        JSONObject ollamaRequest = new JSONObject();
        ollamaRequest.put("prompt", prompt);
        ollamaRequest.put("model", "ipe2");
        ollamaRequest.put("stream", false);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(ollamaRequest.toString(), httpHeaders);
        System.out.println("--------- entity ----------- " + entity);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:11434/api/generate", entity, String.class);

        String answer =  response.getBody();
        String rawAnswer = new JSONObject(response.getBody()).getString("response");

        System.out.println("--------- answer -----------");
        System.out.println(answer);
        System.out.println("--------- rawAnswer -----------");
        System.out.println(rawAnswer);

        return rawAnswer;
    }

}
