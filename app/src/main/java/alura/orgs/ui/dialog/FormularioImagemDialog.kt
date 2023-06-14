package alura.orgs.ui.dialog

import alura.orgs.databinding.FormularioImagemBinding
import alura.orgs.extensions.tentaCarregarImagem
import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class FormularioImagemDialog(private val context: Context) {
    fun mostra(quandoImagemCarregada: (imagem:String)->Unit) {
        val binding = FormularioImagemBinding.inflate(LayoutInflater.from(context))
        binding.formularioImagemBotaoCarregar.setOnClickListener {
            val url = binding.formularioImagemUrl.text.toString()
            binding.formularioImagemImageview.tentaCarregarImagem(url)

        }

        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirmar") { _, _ ->
                val url = binding.formularioImagemUrl.text.toString()
                quandoImagemCarregada(url)

            }
            .setNegativeButton("Cancelar") { _, _ -> }
            .show()
    }
}