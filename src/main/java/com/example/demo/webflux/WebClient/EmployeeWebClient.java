package com.example.demo.webflux.WebClient;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class EmployeeWebClient {

    WebClient client = WebClient.create("http://localhost:8080");
   
}
