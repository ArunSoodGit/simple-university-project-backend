package arunsood.ziibdprojekt.repository;

import arunsood.ziibdprojekt.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public  interface  EmployeesRepository extends JpaRepository<Employees,Long>{
    Employees findByEmployeeId(Long id);
    @Modifying
    @Query("update Employees e " +
            "set e.firstName = :#{#employee.getFirstName()}," +
            "e.lastName = :#{#employee.getLastName()}," +
            "e.email = :#{#employee.getEmail()}," +
            "e.jobId = :#{#employee.getJobId()}," +
            "e.salary = :#{#employee.getSalary()}," +
            "e.managerId = :#{#employee.getManagerId()}," +
            "e.phoneNumber = :#{#employee.getPhoneNumber()} " +
            "where e.employeeId = :#{#employee.getEmployeeId()}")
    void updateEmployee(@Param("employee") Employees employee);

}
