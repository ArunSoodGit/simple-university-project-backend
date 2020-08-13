package arunsood.ziibdprojekt.repository;

import arunsood.ziibdprojekt.models.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
    Departments findByDepartmentId(Long id);

    @Modifying
    @Query("update Departments d " +
            "set d.managerId = :#{#department.getManagerId()}," +
            "d.departmentName = :#{#department.getDepartmentName()}, " +
            "d.locationId = :#{#department.getLocationId()} " +
            "where d.departmentId = :#{#department.getDepartmentId()}")
    void updateDepartment(@Param("department") Departments department);

}
