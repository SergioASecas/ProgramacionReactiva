package com.example.demo.webflux;


import com.example.demo.webflux.Model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);

		WebClient client = WebClient.create("http://localhost:8080");
		Mono<Employee> employeeMono = client.get()
				.uri("/employees/{id}", "2")
				.retrieve()
				.bodyToMono(Employee.class);
				
		employeeMono.subscribe(System.out::println);
	
		
		Flux<Employee> employeeFlux = client.get()
				.uri("/employees/employees")
				.retrieve()
				.bodyToFlux(Employee.class);
			
		employeeFlux.subscribe(System.out::println);
		
	}

}
