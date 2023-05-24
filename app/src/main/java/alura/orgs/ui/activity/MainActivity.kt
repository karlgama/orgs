package alura.orgs.ui.activity

import alura.orgs.R
import alura.orgs.ui.recylerview.adapter.ListaProdutoAdapter
import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val nome = findViewById<TextView>(R.id.nome)
//        val descricao = findViewById<TextView>(R.id.descricao)
//        val preco = findViewById<TextView>(R.id.preco)
//
//        nome.text = "Teste"
//        descricao.text = "Teste"
//        preco.text = "Teste"
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        recyclerView.adapter = ListaProdutoAdapter()
    }
}