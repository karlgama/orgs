package alura.orgs.database.dao

import alura.orgs.model.Produto
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produto")
    fun buscaTodos():List<Produto>;

    @Insert
    fun salva(vararg produto: Produto);
}