package app.finance.api.entity

import java.io.Serializable

class PK(var id: Long, var usuario: Long) : Serializable{
  constructor(): this(0L, 0L)
}