package app.financeapi.service

import org.springframework.stereotype.Service
import org.springframework.data.jpa.domain.Specification

import app.financeapi.repository.LancamentoRepository
import app.financeapi.repository.specification.QuerySpec
import app.financeapi.entity.Lancamento


@Service
class LancamentoService(private val repository: LancamentoRepository) : BaseService<Lancamento>(repository) {
	override fun find(params: MutableMap<String, Any>? = null): List<Lancamento> {
 	    var spec = Specification.where<Lancamento>(null)
		
		if(params.get("dataInicio") != null && params.get("dataFim") != null){
			spec = QuerySpec.between(DateUtil.toLocalDate(params.dataInicio, "dd-MM-yyyy"), DateUtil.toLocalDate(dto.dataFim, "dd-MM-yyyy"))
		}
	    if(params.get("idCategoria") != null){
			spec = spec.and(QuerySpec.byCategoria(params.get("idCategoria") as Long))
		}
		if(params.get("idConta") != null){
			spec = spec.and(QuerySpec.byConta(params.get("idConta") as Long))
		}
		if(params.get("operacao") != null){
			spec = spec.and(QuerySpec.byOperacao(params.get("operacao").toString()))
		}
		
		return repository.findAll(Specification.where<Lancamento>(spec))
	}
}

/*

Here is a function to read a property from an instance of a class given the property name (throws exception if property not found, but you can change that behaviour):

import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

@Suppress("UNCHECKED_CAST")
fun <R> readInstanceProperty(instance: Any, propertyName: String): R {
    val property = instance::class.memberProperties
                     // don't cast here to <Any, R>, it would succeed silently 
                     .first { it.name == propertyName } as KProperty1<Any, *> 
    // force a invalid cast exception if incorrect type here
    return property.get(instance) as R  
}
example usage:

// some data class
data class MyData(val name: String, val age: Int)
val sample = MyData("Fred", 33)

// and reading property "name" from an instance...
val name: String = readInstanceProperty(sample, "name")

// and reading property "age" placing the type on the function call...
val age = readInstanceProperty<Int>(sample, "age")

println(name) // Fred
println(age)  // 33

*/