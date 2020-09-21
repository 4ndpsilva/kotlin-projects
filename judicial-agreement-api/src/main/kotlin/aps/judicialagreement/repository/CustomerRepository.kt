package aps.judicialagreement.repository

import aps.judicialagreement.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long>