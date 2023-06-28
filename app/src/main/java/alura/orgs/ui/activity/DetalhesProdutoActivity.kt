package alura.orgs.ui.activity

import alura.orgs.R
import alura.orgs.database.AppDatabase
import alura.orgs.databinding.ActivityDetalhesProdutoBinding
import alura.orgs.extensions.formataParaMoedaBrasileira
import alura.orgs.extensions.tentaCarregarImagem
import alura.orgs.model.Produto
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class DetalhesProdutoActivity : AppCompatActivity() {
    private var produtoId: Long? = null
    private var produto: Produto? = null

    private val dao by lazy { AppDatabase.instancia(this).produtoDao() }

    private val binding by lazy {
        ActivityDetalhesProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tentaCarregarProduto()
    }

    override fun onResume() {
        produtoId?.let { id ->
            produto = dao.buscaPorId(id)
        }
        produto?.let {
            preencheCampos(it)
        } ?: finish()

        super.onResume()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalhes_produto, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_detalhes_produto_remover -> {
                produto?.let{ dao.remove(it) }
                finish()
            }

            R.id.menu_detalhes_produto_editar -> {
                Intent(this, FormularioProdutoActivity::class.java).apply {
                    putExtra(CHAVE_PRODUTO, produto)
                    startActivity(this)
                }
            }
        }

        return super.onOptionsItemSelected(item)

    }

    private fun tentaCarregarProduto() {
        intent.getParcelableExtra<Produto>(CHAVE_PRODUTO)?.let { produtoCarregado ->
            produtoId = produtoCarregado.id
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