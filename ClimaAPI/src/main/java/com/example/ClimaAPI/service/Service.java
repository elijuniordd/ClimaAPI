package com.example.ClimaAPI.service;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@org.springframework.stereotype.Service
public class Service {

    private String token = "e88dac79bb1a4bd89f9205540262708";

    private String apiUrl = "http://api.weatherapi.com/v1/current.json";

    public String preverTempo(String cidade) {

        URI uri = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("key", token)
                .queryParam("q", cidade)
                .queryParam("lang", "pt")
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
            return responseEntity.getBody();
        } catch (HttpStatusCodeException e) {
            return "Falha ao obter dados meteorológicos. Código: " + e.getStatusCode()
                    + " - " + e.getResponseBodyAsString();
        }
    }
}
