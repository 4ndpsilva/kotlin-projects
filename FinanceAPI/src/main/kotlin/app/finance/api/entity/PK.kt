package app.finance.api.entity

import java.io.Serializable

class PK(var id: Long, var usuario: Long) : Serializable{
	constructor(): this(0L, 0L)
  
  	override fun equals(other: Any?): Boolean {
		if(this === other){ 
			return true
		}
		if(javaClass != other?.javaClass){ 
			return false
		}	
		if(other is PK) {
			if(id == other?.id && usuario == other?.usuario){
				return true
			}
		}

		return false
	}

	override fun hashCode() = id.hashCode() + usuario.hashCode()

	override fun toString() = "PK(id = $id, usuario = $usuario)"
}