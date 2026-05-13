package com.example.bibliounifor.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface LivroDao {
    @Query("SELECT * FROM livros")
    fun buscarTodosLivros(): Flow<List<EntidadeLivro>>

    @Query("SELECT * FROM livros WHERE id = :id")
    suspend fun buscarLivroPorId(id: Int): EntidadeLivro?

    @Query("SELECT * FROM livros WHERE title LIKE :query OR author LIKE :query")
    fun pesquisarLivros(query: String): Flow<List<EntidadeLivro>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(livro: EntidadeLivro)

    @Delete
    suspend fun deletar(livro: EntidadeLivro)
}
