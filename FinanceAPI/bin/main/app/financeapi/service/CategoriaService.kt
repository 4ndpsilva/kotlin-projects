class CategoriaService{
    fun list(){
        val cat1 = Categoria(1, "Alimentação")
	    val cat2 = Categoria(2, "Transporte")
	    val cat3 = Categoria(3, "Renda")
		
	    return listOf(cat1, cat2, cat3)
    }
}