package alura.orgs.database

import alura.orgs.database.converter.Converters
import alura.orgs.database.dao.ProdutoDao
import alura.orgs.model.Produto
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Produto::class],version=1)
@TypeConverters(Converters::class)
abstract class AppDatabase:RoomDatabase() {
    abstract fun produtoDao(): ProdutoDao

    companion object {
        fun instancia(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "orgs.db"
            ).allowMainThreadQueries()
                .build()
        }
    }
}