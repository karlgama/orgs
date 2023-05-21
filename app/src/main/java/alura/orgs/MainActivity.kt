package alura.orgs

import android.app.Activity
import android.os.Bundle
import android.widget.TextView


class MainActivity: Activity() {
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
    }
}