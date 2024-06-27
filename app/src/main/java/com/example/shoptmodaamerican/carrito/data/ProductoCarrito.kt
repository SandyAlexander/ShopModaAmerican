// ProductoCarrito.kt

package com.example.shoptmodaamerican.carrito.data

data class ProductoCarrito(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val imageUrl: String,
    var cantidad: Int = 1 // Cantidad por defecto es 1 al agregar al carrito
)
