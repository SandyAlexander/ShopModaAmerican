package com.example.tienda.productosporcategoria.data

class ProductosPorCategoriaService {

    fun fetchProductosPorCategoria(categoriaId: Int): List<Producto> {
        val repository = ProductosPorCategoriaRepository()
        return repository.getProductosPorCategoria(categoriaId)
    }
}