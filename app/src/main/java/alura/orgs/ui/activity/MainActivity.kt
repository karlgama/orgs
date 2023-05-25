package alura.orgs.ui.activity

import alura.orgs.R
import alura.orgs.model.Produto
import alura.orgs.ui.recylerview.adapter.ListaProdutoAdapter
import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.math.BigDecimal


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);

        recyclerView.adapter = ListaProdutoAdapter(
            context = this, produtos = listOf(
                Produto("Alface", descricao = "verdura 200g", preco = BigDecimal("19.99")),
                Produto("Abacaxi", descricao = "fruta 600g", preco = BigDecimal("19.99")),
                Produto("Batata", descricao = "legume 1kg", preco = BigDecimal("19.99")),
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(this)


    }
}