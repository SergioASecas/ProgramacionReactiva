package com.example.demo.webflux.Controller;

import com.example.demo.webflux.EmployeeRepository;
import com.example.demo.webflux.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable Integer id){
        return employeeRepository.findEmployeeById(id);
        
    }

    @GetMapping("/employees")
    public Flux<Employee> getAllEmployees(){
        return employeeRepository.findAllEmployees();
    }

    @GetMapping("/employeeRx/{id}")
    public Observable<Employee> getEmployeeRX(@PathVariable Integer id){
        return employeeRepository.findEmployeeByIdRx(id);
    }

    @GetMapping("/employeesRx")
    public Observable<Employee> getAllEmployeesRX(){
        return employeeRepository.findAllEmployeesRX();
    }


    @GetMapping("/empleado")
    public String saludo(){
        return "Hola Spring!";
    }

    
    

}
