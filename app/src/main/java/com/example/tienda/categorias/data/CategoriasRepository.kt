package com.example.tienda.categorias.data

interface CategoriasRepository {
    fun obtenerCategorias(): List<Categoria>
}