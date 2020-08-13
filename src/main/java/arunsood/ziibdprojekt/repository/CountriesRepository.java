package arunsood.ziibdprojekt.repository;

import arunsood.ziibdprojekt.models.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Long> {
    Countries findByCountryId(Long id);

    @Modifying
    @Query("update Countries c " +
            "set c.countryName = :#{#country.getCountryName()}," +
            "c.regionId = :#{#country.getRegionId()} " +
            "where c.countryId = :#{#country.getCountryId()}")
    void updateCountry(@Param("country") Countries country);
}
