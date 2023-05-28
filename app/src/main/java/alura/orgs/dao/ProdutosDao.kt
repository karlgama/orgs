package alura.orgs.dao

import alura.orgs.model.Produto

class ProdutosDao {

    fun adicionar(produto: Produto){
        Companion.produtos.add(produto)
    }

    fun listar():List<Produto>{
        return Companion.produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}