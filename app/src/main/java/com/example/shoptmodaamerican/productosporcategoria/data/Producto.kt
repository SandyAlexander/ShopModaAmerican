package com.example.shoptmodaamerican.productosporcategoria.data

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val imagenUrl: String
)