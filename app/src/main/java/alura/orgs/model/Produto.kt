package alura.orgs.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
@Entity
data class Produto(
    @PrimaryKey(autoGenerate = true)
    val uid: Long=0L,
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
    val imagem: String? = null
) : Parcelable
