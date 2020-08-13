package arunsood.ziibdprojekt.repository;

import arunsood.ziibdprojekt.models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {
    Jobs findByJobId(Long id);

    @Modifying
    @Query("update Jobs j " +
            "set j.jobTitle = :#{#job.getJobTitle()}," +
            "j.minSalary = :#{#job.getMinSalary()}," +
            "j.maxSalary = :#{#job.getMaxSalary()} " +
            "where j.jobId = :#{#job.getJobId()}")
    void updateEmployee(@Param("job") Jobs job);

}
