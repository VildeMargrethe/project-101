package no.acntech.project101.web.employee.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import no.acntech.project101.employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("employees")
public class EmployeeResource {

    private final EmployeeService employeeService;

    //TODO The constructor needs to accept the required dependencies and assign them to class variables
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll() {
        //TODO create a GET endpoint find all employees in the database and return them
        final EmployeeDto employees = new EmployeeDto(987654L,"Trine","Hansen", LocalDate.of(1923,12,12),4536476L);
        List<EmployeeDto> employeeList = new ArrayList<>();
        employeeList.add(employees);
        return ResponseEntity.ok(employeeList);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable final Long id) { // lurt å bruke final - fast variabel. Må spesifisere type (Long) siden første gang introduserer.
        // TODO create a GET endpoint that fetches a spesific employee based on its ID
        final EmployeeDto employee = new EmployeeDto(id,"Olav","Thue", LocalDate.of(1963,07,23),4536476L);

        return ResponseEntity.ok(employee);
    }
    @PostMapping
    public ResponseEntity createEmployee(@RequestBody final EmployeeDto employeeDto) {
        //TODO Create a POST endpoint that accepts an employeeDTO and saves it in the database
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(975864L) //lager en statisk id - konverterer til Long
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteEmployee(@PathVariable final Long id) {
        // TODO Create a DELETE endpoint that deletes a specific employee

        return ResponseEntity.accepted().build(); // har ingen employee å slette - så bare sender tilbake at sletting er suksessfull
    }

    @PatchMapping("{id}")
    public ResponseEntity updateEmployee(@PathVariable final Long id, @RequestBody final EmployeeDto employeeDto) {
        //TODO Create a PATCH endpoint that updates an employee with new values
        if (id==123456L) {
            final EmployeeDto employee = new EmployeeDto(id,"Kari","Bjørgvin", LocalDate.of(1972,07,23),123456L);
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
