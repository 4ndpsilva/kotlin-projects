package app.financeapi.service

import java.time.LocalDate
import java.util.DoubleSummaryStatistics
import org.springframework.stereotype.Service

import app.financeapi.service.LancamentoService
import app.financeapi.entity.Lancamento
import app.financeapi.entity.Operacao


@Service
class DashboardService(private val service: LancamentoService){
  fun calculate(): List<ResultDTO>{
  } 
}