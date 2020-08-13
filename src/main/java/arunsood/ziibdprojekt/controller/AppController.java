package arunsood.ziibdprojekt.controller;
import arunsood.ziibdprojekt.models.Countries;
import arunsood.ziibdprojekt.models.Departments;
import arunsood.ziibdprojekt.models.Employees;
import arunsood.ziibdprojekt.models.Jobs;
import arunsood.ziibdprojekt.repository.CountriesRepository;
import arunsood.ziibdprojekt.repository.DepartmentsRepository;
import arunsood.ziibdprojekt.repository.EmployeesRepository;
import arunsood.ziibdprojekt.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class AppController {

    final EmployeesRepository employeesRepository;
    final JobsRepository jobsRepository;
    final DepartmentsRepository departmentsRepository;
    final CountriesRepository countriesRepository;

    @Autowired
    public AppController(EmployeesRepository employeesRepository, JobsRepository jobsRepository, DepartmentsRepository departmentsRepository, CountriesRepository countriesRepository) {
        this.employeesRepository = employeesRepository;
        this.jobsRepository = jobsRepository;
        this.departmentsRepository = departmentsRepository;
        this.countriesRepository = countriesRepository;
    }

    @GetMapping("/employees")
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employees getEmployee(@PathVariable("id") Long id) {
        return employeesRepository.findByEmployeeId(id);
    }

    @GetMapping("/jobs")
    public List<Jobs> getJobs() {
        return jobsRepository.findAll();
    }

    @GetMapping("/job/{id}")
    public Jobs getJob(@PathVariable("id") Long id) {
        return jobsRepository.findByJobId(id);
    }

    @GetMapping("/departments")
    public List<Departments> getDepartments() {
        return departmentsRepository.findAll();
    }

    @GetMapping("/department/{id}")
    public Departments getDepartment(@PathVariable("id") Long id) {
        return departmentsRepository.findByDepartmentId(id);
    }

    @GetMapping("/countries")
    public List<Countries> getCountries() {
        return countriesRepository.findAll();
    }

    @GetMapping("/country/{id}")
    public Countries getCountry(@PathVariable("id") Long id) {
        return countriesRepository.findByCountryId(id);
    }

    @Transactional
    @PostMapping("/employee")
    public void updateEmployee(@RequestBody Employees data) {
        employeesRepository.updateEmployee(data);
    }


    @Transactional
    @PostMapping("/job")
    public void updateJob(@RequestBody Jobs data) {
        jobsRepository.updateEmployee(data);
    }

    @Transactional
    @PostMapping("/department")
    public void updateDepartment(@RequestBody Departments data) {
        departmentsRepository.updateDepartment(data);
    }

    @Transactional
    @PostMapping("/country")
    public void updateCountry(@RequestBody Countries data) {
        countriesRepository.updateCountry(data);
    }

    @Transactional
    @PostMapping("/add-employee")
    public void addEmployees(@RequestBody Employees data){
        employeesRepository.save(data);
    }


}
