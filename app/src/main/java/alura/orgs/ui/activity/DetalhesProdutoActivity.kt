package alura.orgs.ui.activity

import alura.orgs.R
import alura.orgs.databinding.ActivityDetalhesProdutoBinding
import alura.orgs.extensions.formataParaMoedaBrasileira
import alura.orgs.extensions.tentaCarregarImagem
import alura.orgs.model.Produto
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity

class DetalhesProdutoActivity: AppCompatActivity(){
    private val binding by lazy {
        ActivityDetalhesProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tentaCarregarProduto()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalhes_produto,menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun tentaCarregarProduto() {
        intent.getParcelableExtra<Produto>(CHAVE_PRODUTO)?.let { produtoCarregado ->
            preencheCampos(produtoCarregado)
        } ?: finish()
    }

    private fun preencheCampos(produtoCarregado: Produto) {
        with(binding) {
            activityDetalhesProdutoImagem.tentaCarregarImagem(produtoCarregado.imagem)
            activityDetalhesProdutoNome.text = produtoCarregado.nome
            activityDetalhesProdutoDescricao.text = produtoCarregado.descricao
            activityDetalhesProdutoValor.text =
                produtoCarregado.preco.formataParaMoedaBrasileira()
        }
    }
}