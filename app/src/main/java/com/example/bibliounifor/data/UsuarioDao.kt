package com.example.bibliounifor.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuarios WHERE email = :email LIMIT 1")
    suspend fun buscarPorEmail(email: String): Usuario?

    @Query("SELECT * FROM usuarios WHERE email = :email AND senha = :senha LIMIT 1")
    suspend fun autenticar(email: String, senha: String): Usuario?

    @Query("SELECT * FROM usuarios WHERE nome LIKE '%' || :query || '%' OR usuario LIKE '%' || :query || '%'")
    suspend fun buscarUsuarios(query: String): List<Usuario>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(usuario: Usuario)
}
