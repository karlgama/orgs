package alura.orgs.ui.activity

import alura.orgs.R
import alura.orgs.dao.ProdutosDao
import alura.orgs.model.Produto
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_produto_botao_salvar)
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            val produto = criaProduto()
            dao.adicionar(produto)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.activity_formulario_produto_nome)
        val nome = campoNome.text.toString()

        val campoDescricao = findViewById<EditText>(R.id.activity_formulario_produto_descricao)
        val descricao = campoDescricao.text.toString()

        val campoValor = findViewById<EditText>(R.id.activity_formulario_produto_valor)
        val valorEmTexto = campoValor.text.toString()

        val valor = if (valorEmTexto.isBlank())
            BigDecimal.ZERO
        else
            BigDecimal(valorEmTexto)

        return Produto(
            nome,
            descricao,
            valor
        )
    }
}