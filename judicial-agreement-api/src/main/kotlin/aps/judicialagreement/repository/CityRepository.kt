package aps.judicialagreement.repository

import aps.judicialagreement.entity.City
import org.springframework.data.jpa.repository.JpaRepository

interface CityRepository : JpaRepository<City, Long>