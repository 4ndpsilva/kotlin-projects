package app.financeapi.service

import org.springframework.stereotype.Service
import org.springframework.data.jpa.domain.Specification

import app.financeapi.constant.Constants
import app.financeapi.util.DateUtil
import app.financeapi.repository.LancamentoRepository
import app.financeapi.repository.specification.QuerySpec
import app.financeapi.entity.Lancamento


@Service
class LancamentoService(private val repository: LancamentoRepository) : BaseService<Lancamento>(repository) {
	override fun find(params: MutableMap<String, Any>?): List<Lancamento> {
		params?.let{
			if(params.contains(Constants.ID_USUARIO)){
				super.spec = super.spec.and(QuerySpec.byConta<Lancamento>(params.get("idUsuario").toString().toLong()))
			}
			if(params.contains(Constants.ID_CATEGORIA)){
				super.spec = super.spec.and(QuerySpec.byCategoria<Lancamento>(params.get("idCategoria").toString().toLong()))
			}
			if(params.contains(Constants.ID_CONTA)){
			    println(Constants.ID_CONTA +": "+params.get("idConta"))
				super.spec = super.spec.and(QuerySpec.byConta<Lancamento>(params.get("idConta").toString().toLong()))
			}
			if(params.contains(Constants.DATA_INICIO) && params.contains(Constants.DATA_FIM)){
				val inicio = DateUtil.toLocalDate(params.get(Constants.DATA_INICIO).toString(), Constants.DATE_FORMAT)
				val fim = DateUtil.toLocalDate(params.get(Constants.DATA_FIM).toString(), Constants.DATE_FORMAT)
				super.spec = super.spec.and(QuerySpec.between<Lancamento>(inicio, fim))
			}
			if(params.contains("operacao")){
				super.spec = super.spec.and(QuerySpec.byOperacao<Lancamento>(params.get("operacao").toString()))
			}
		}
				
		return repository.findAll(Specification.where<Lancamento>(super.spec))
	}
}