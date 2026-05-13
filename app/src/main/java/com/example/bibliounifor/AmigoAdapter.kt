package com.example.bibliounifor

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Amigo(val id: Int, val nome: String, val email: String = "", val usuario: String = "", val bio: String = "")

class AmigoAdapter(
    private val lista: List<Amigo>,
    private val isBusca: Boolean = false,
    private val onClick: (Amigo) -> Unit
) : RecyclerView.Adapter<AmigoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgAmigo)
        val nome: TextView = view.findViewById(R.id.txtNomeAmigo)
        val btnMais: ImageView = view.findViewById(R.id.btnMaisAmigo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = if (isBusca) R.layout.item_amigo_busca else R.layout.item_amigo
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val amigo = lista[position]
        holder.nome.text = amigo.nome
        
        holder.itemView.setOnClickListener {
            onClick(amigo)
        }

        // Se for busca, o ícone pode ser um "+" em vez de "3 pontos"
        if (isBusca) {
            holder.btnMais.setImageResource(android.R.drawable.ic_input_add)
        }
    }

    override fun getItemCount() = lista.size
}
