package com.example.demo.webflux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.webflux.Model.Employee;
import org.springframework.stereotype.Repository;
import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class EmployeeRepository {

    public List<Employee> crearLista(){
        List<Employee> empleados = new ArrayList<>();

        Employee empleado1 = new Employee();        
        empleado1.setId(1);
        empleado1.setName("Franco Bonilla");
        empleado1.setAge(35);
        empleado1.setCargo("Comediante");

        Employee empleado2 = new Employee();
        empleado2.setId(2);
        empleado2.setName("Sergio Villalba");
        empleado2.setAge(28);
        empleado2.setCargo("Developer");

        Employee empleado3 = new Employee();
        empleado3.setId(3);
        empleado3.setName("Junior Cardona");
        empleado3.setAge(35);
        empleado3.setCargo("Instructor");

        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);

        return empleados;
    }

    /**
     * Método con Reactor
     * 
     * @param emp Listado de empleados
     * @param id Id empleado
     * @return Empleado con el id ingresado por parámetro
     */
    public Mono<Employee> buscarEmpleado(List<Employee> emp, Integer id){
        List<Employee> empl = emp.stream().filter(x->x.getId().equals(id)).collect(Collectors.toList());     
        return Mono.just(empl.get(0));   
    }

    /**
     *  Método co Java RX
     * @param emp Listado de empleados
     * @param id Id empleado
     * @return Empleado con el id ingresado por parámetro
     */
    public Observable<Employee> buscarEmpleadoRX(List<Employee> emp, Integer id){
        List<Employee> empl = emp.stream().filter(x->x.getId().equals(id)).collect(Collectors.toList());     
        return Observable.just(empl.get(0));
    }

    /**
     * Método con Reactor
     * @param empl Listado de empleados
     * @return flux con lista de empleados
     */
    private Flux<Employee> buscarTodosLosEmpleados(List<Employee> empl) {
        return Flux.fromIterable(empl);
    }

     /**
     * Método con RX
     * @param empl Listado de empleados
     * @return Observable con lista de empleados
     */
    public Observable<Employee> buscarTodosLosEmpleadosRX(List<Employee> empl){
        return Observable.fromIterable(empl);
    }

    public Observable<Employee> findEmployeeByIdRx(Integer id){
        return buscarEmpleadoRX(crearLista(), id);
    }

    public Observable<Employee> findAllEmployeesRX(){
        return buscarTodosLosEmpleadosRX(crearLista());
    }

    public Mono<Employee> findEmployeeById(Integer id){
        return buscarEmpleado(crearLista(), id);        
    }

    public Flux<Employee> findAllEmployees(){
        return buscarTodosLosEmpleados(crearLista());
    }  

    
}
