package com.example.bibliounifor

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bibliounifor.data.EntidadeLivro

class ListaDesejosAdapter(
    private var livros: List<EntidadeLivro>
) : RecyclerView.Adapter<ListaDesejosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgCapa: ImageView = view.findViewById(R.id.imgCapaLivro)
        val txtTitulo: TextView = view.findViewById(R.id.txtTituloLivro)
        val txtAutor: TextView = view.findViewById(R.id.txtAutorLivro)
        val txtData: TextView = view.findViewById(R.id.txtDataLivro)
        val btnMais: ImageView = view.findViewById(R.id.btnMais)
        val btnSuaLivraria: Button = view.findViewById(R.id.btnSuaLivraria)
        val btnAlugarLivro: Button = view.findViewById(R.id.btnAlugarLivro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val livro = livros[position]
        holder.txtTitulo.text = livro.title
        holder.txtAutor.text = livro.author
        // Mocking date since EntidadeLivro might not have it
        holder.txtData.text = "Publicado em 1882" 

        if (livro.coverResourceId != 0) {
            holder.imgCapa.setImageResource(livro.coverResourceId)
        } else {
            holder.imgCapa.setImageResource(R.drawable.o_alienista_capa)
        }

        // ISSUE 3 — 3 PONTINHOS (Navega para Detalhes/Ver Mais)
        holder.btnMais.setOnClickListener {
            val intent = Intent(holder.itemView.context, TelaRF13TelaDoLivro::class.java)
            intent.putExtra("LIVRO_ID", livro.id)
            holder.itemView.context.startActivity(intent)
        }

        // ISSUE 4 — BOTÃO SUA LIVRARIA
        holder.btnSuaLivraria.setOnClickListener {
            val intent = Intent(holder.itemView.context, TelaRF16MinhaLivrariaActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }

        // ISSUE 5 — BOTÃO ALUGAR LIVRO (Navega para Tela 15 Leitura)
        holder.btnAlugarLivro.setOnClickListener {
            val intent = Intent(holder.itemView.context, TelaRF15LeituraActivity::class.java)
            intent.putExtra("LIVRO_ID", livro.id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = livros.size
}
