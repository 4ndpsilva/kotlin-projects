package aps.judicialagreement.repository

import aps.judicialagreement.entity.State
import org.springframework.data.jpa.repository.JpaRepository

interface StateRepository : JpaRepository<State, Long>