package alura.orgs.ui.activity

import alura.orgs.database.AppDatabase
import alura.orgs.databinding.ActivityFormularioProdutoBinding
import alura.orgs.extensions.tentaCarregarImagem
import alura.orgs.model.Produto
import alura.orgs.ui.dialog.FormularioImagemDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }
    private var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar produto"
        configuraBotaoSalvar()
        binding.activityFormularioProdutoImagem
            .setOnClickListener {
                FormularioImagemDialog(this).mostra { imagem ->
                    binding.activityFormularioProdutoImagem.tentaCarregarImagem(imagem)
                }
            }
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.activityFormularioProdutoBotaoSalvar
        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "orgs.db"
        ).allowMainThreadQueries()
            .build()

        val dao = db.produtoDao()

        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.salva(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = binding.activityFormularioProdutoNome
        val nome = campoNome.text.toString()
        val campoDescricao = binding.activityFormularioProdutoDescricao
        val descricao = campoDescricao.text.toString()
        val campoValor = binding.activityFormularioProdutoValor
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            preco = valor,
            imagem = url
        )
    }

}