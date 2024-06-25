package com.example.tienda.categorias.view


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda.R
import com.example.tienda.categorias.data.Categoria

class CategoriasAdapter(
    private val categorias: List<Categoria>,
    private val onClick: (Categoria) -> Unit
) : RecyclerView.Adapter<CategoriasAdapter.CategoriaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categoria, parent, false)
        return CategoriaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        holder.bind(categorias[position], onClick)
    }

    override fun getItemCount(): Int = categorias.size

    class CategoriaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)

        fun bind(categoria: Categoria, onClick: (Categoria) -> Unit) {
            nombreTextView.text = categoria.nombre
            itemView.setOnClickListener { onClick(categoria) }
        }
    }
}
