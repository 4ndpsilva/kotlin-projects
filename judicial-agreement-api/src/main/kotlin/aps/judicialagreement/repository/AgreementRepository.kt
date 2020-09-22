package aps.judicialagreement.repository

import aps.judicialagreement.entity.Agreement
import org.springframework.data.jpa.repository.JpaRepository

interface AgreementRepository : JpaRepository<Agreement, Long>