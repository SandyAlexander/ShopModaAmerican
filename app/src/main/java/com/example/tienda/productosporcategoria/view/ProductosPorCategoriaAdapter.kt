package com.example.tienda.productosporcategoria.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tienda.productosporcategoria.data.Producto
import com.example.tienda.R

class ProductosPorCategoriaAdapter(
    private val context: Context,
    private var productos: MutableList<Producto>,
    private val onAgregarCarritoClickListener: OnAgregarCarritoClickListener
) : RecyclerView.Adapter<ProductosPorCategoriaAdapter.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_producto_por_categoria, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.bind(producto)
        holder.btnAgregarCarrito.setOnClickListener {
            onAgregarCarritoClickListener.onAgregarCarritoClick(producto)
        }
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    fun updateData(newProductos: List<Producto>) {
        productos.clear()
        productos.addAll(newProductos)
        notifyDataSetChanged()
    }

    inner class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.text_view_nombre_producto)
        private val precioTextView: TextView = itemView.findViewById(R.id.text_view_precio_producto)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.text_descripcion_producto)
        private val imagenProducto: ImageView = itemView.findViewById(R.id.image_producto)
        val btnAgregarCarrito: Button = itemView.findViewById(R.id.btn_agregar_carrito)

        fun bind(producto: Producto) {
            nombreTextView.text = producto.nombre
            precioTextView.text = "$ ${producto.precio}"
            descripcionTextView.text = producto.descripcion

            // Cargar imagen del producto utilizando Glide u otra biblioteca de carga de imágenes
            Glide.with(itemView)
                .load(producto.imagenUrl) // La URL de la imagen del producto
                .placeholder(R.drawable.placeholder_image) // Imagen de placeholder mientras carga
                .error(R.drawable.error_image) // Imagen de error si la carga falla
                .into(imagenProducto)
        }
    }

    interface OnAgregarCarritoClickListener {
        fun onAgregarCarritoClick(producto: Producto)
    }
}
