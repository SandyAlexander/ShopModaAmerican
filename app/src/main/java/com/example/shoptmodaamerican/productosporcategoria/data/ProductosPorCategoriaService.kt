package com.example.shoptmodaamerican.productosporcategoria.data

class ProductosPorCategoriaService {

    fun fetchProductosPorCategoria(categoriaId: Int): List<Producto> {
        val repository = ProductosPorCategoriaRepository()
        return repository.getProductosPorCategoria(categoriaId)
    }
}