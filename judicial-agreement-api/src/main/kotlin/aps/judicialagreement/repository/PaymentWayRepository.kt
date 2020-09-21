package aps.judicialagreement.repository

import aps.judicialagreement.entity.PaymentWay
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentWayRepository : JpaRepository<PaymentWay, Long>