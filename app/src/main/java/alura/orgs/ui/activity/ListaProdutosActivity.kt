package alura.orgs.ui.activity

import alura.orgs.R
import alura.orgs.dao.ProdutosDao
import alura.orgs.ui.recylerview.adapter.ListaProdutoAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {
    private val dao = ProdutosDao()
    private val adapter = ListaProdutoAdapter(
        context = this, produtos = dao.listar()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.listar())
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produto_recyclerView);
        recyclerView.adapter = adapter
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_lista_produto_floatingActionButton)
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }


}