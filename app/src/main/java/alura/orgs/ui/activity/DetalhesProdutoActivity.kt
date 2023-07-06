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
    private var produtoId: Long = 0L
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
        super.onResume()
        buscaProduto()
    }

    private fun buscaProduto() {
        produto = dao.buscaPorId(produtoId)

        produto?.let {
            preencheCampos(it)
        } ?: finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalhes_produto, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_detalhes_produto_remover -> {
                produto?.let { dao.remove(it) }
                finish()
            }

            R.id.menu_detalhes_produto_editar -> {
                Intent(this, FormularioProdutoActivity::class.java).apply {
                    putExtra(CHAVE_PRODUTO_ID, produtoId)
                    startActivity(this)
                }
            }
        }

        return super.onOptionsItemSelected(item)

    }

    private fun tentaCarregarProduto() {
        produtoId = intent.getLongExtra(CHAVE_PRODUTO_ID, 0L)
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