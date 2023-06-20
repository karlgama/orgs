package alura.orgs.model

import android.os.Parcelable
import java.math.BigDecimal
import kotlinx.parcelize.Parcelize

@Parcelize
data class Produto(
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
    val imagem: String?=null
): Parcelable
