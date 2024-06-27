// CarritoAdapter.kt

package com.example.shoptmodaamerican.carrito.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoptmodaamerican.R
import com.example.shoptmodaamerican.carrito.data.ProductoCarrito


class CarritoAdapter(
    private val context: Context,
    private var productos: MutableList<ProductoCarrito>
) : RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_producto_carrito, parent, false)
        return CarritoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        val producto = productos[position]
        holder.bind(producto)
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    fun updateData(newProductos: List<ProductoCarrito>) {
        productos.clear()
        productos.addAll(newProductos)
        notifyDataSetChanged()
    }

    inner class CarritoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.text_view_nombre_producto_carrito)
        private val precioTextView: TextView = itemView.findViewById(R.id.text_view_precio_producto_carrito)

        fun bind(producto: ProductoCarrito) {
            nombreTextView.text = producto.nombre
            precioTextView.text = "$ ${producto.precio}"
        }
    }
}
