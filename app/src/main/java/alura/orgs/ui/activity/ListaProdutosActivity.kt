package alura.orgs.ui.activity

import alura.orgs.database.AppDatabase
import alura.orgs.databinding.ActivityListaProdutosBinding
import alura.orgs.ui.recylerview.adapter.ListaProdutoAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class ListaProdutosActivity : AppCompatActivity() {

    private val adapter = ListaProdutoAdapter(context = this)
    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()

        val db = AppDatabase.instancia(this)
        val dao = db.produtoDao()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = binding.activityListaProdutoFloatingActionButton
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.activityListaProdutoRecyclerView
        recyclerView.adapter = adapter
        adapter.quandoClicaNoItem = {
            val intent = Intent(
                this,
                DetalhesProdutoActivity::class.java
            ).apply {
                putExtra(CHAVE_PRODUTO_id, it.id)
            }
            startActivity(intent)
        }
    }

}