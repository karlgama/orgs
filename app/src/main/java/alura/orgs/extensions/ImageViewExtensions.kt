package alura.orgs.extensions

import alura.orgs.R
import android.widget.ImageView
import coil.load

fun ImageView.tentaCarregarImagem(url: String? = null){
    load(url) {
        fallback(R.drawable.imagem_padrao)
        error(R.drawable.imagem_padrao)
        placeholder(R.drawable.placeholder)
    }
}
