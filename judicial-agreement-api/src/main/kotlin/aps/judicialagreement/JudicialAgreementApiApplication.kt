package aps.judicialagreement

import aps.judicialagreement.entity.*
import aps.judicialagreement.repository.CityRepository
import aps.judicialagreement.repository.CustomerRepository
import aps.judicialagreement.repository.PaymentWayRepository
import aps.judicialagreement.repository.StateRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.LocalDate

@SpringBootApplication
class JudicialAgreementApiApplication{
    @Autowired
    lateinit var stateRepo: StateRepository

    @Autowired
    lateinit var paymentWayRepo: PaymentWayRepository

    @Autowired
    lateinit var cityRepo: CityRepository

    @Autowired
    lateinit var customerRepo: CustomerRepository

    @Bean
    fun init() = CommandLineRunner {
        val payment = PaymentWay("Cartão de Crédito")
        paymentWayRepo.save(payment)

        val state = State("São Paulo", "SP")
        stateRepo.save(state)

        val c1 = City("Assis", state)
        val c2 = City("Bauru", state)
        val c3 = City("Ourinhos", state)

        cityRepo.saveAll(listOf(c1, c2, c3))

        val customer = Customer(
                "André Pereira da Silva",
                LocalDate.of(1985, 5, 12),
                "12345678901",
                "email@provedor.com")

        val tel1 = Telephone("18", "996425256", TelephoneType.RESIDENTIAL.value)
        val tel2 = Telephone("14", "998885225", TelephoneType.RESIDENTIAL.value)
        val tel3 = Telephone("14", "999999999", TelephoneType.COMMERCIAL.value)
        tel1.customer = customer
        tel2.customer = customer
        tel3.customer = customer

        customer.telephones = mutableListOf(tel1, tel2, tel3)

        val address = Address("19880000", "Rua fulano de tal", "111", "Centro")
        address.city = c1
        customer.address = address
        customerRepo.save(customer)
    }
}

fun main(args: Array<String>){
    runApplication<JudicialAgreementApiApplication>(*args)
}