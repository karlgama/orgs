package alura.orgs.database.dao

import alura.orgs.model.Produto
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produto")
    fun buscaTodos(): List<Produto>;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(vararg produto: Produto);

    @Delete
    fun remove(produto: Produto)

    @Query("select * from Produto p where p.id = :id")
    fun buscaPorId(id: Long): Produto?

}