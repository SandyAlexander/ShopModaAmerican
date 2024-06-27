package com.example.tienda.productosporcategoria.presenter

import com.example.tienda.productosporcategoria.data.Producto
import com.example.tienda.productosporcategoria.data.ProductosPorCategoriaService

class ProductosPorCategoriaPresenter(private val view: ProductosPorCategoriaContract.View) : ProductosPorCategoriaContract.Presenter {

    private val productosService = ProductosPorCategoriaService()

    override fun loadProductosPorCategoria(categoriaId: Int) {
        try {
            val productos = productosService.fetchProductosPorCategoria(categoriaId)
            view.showProductos(productos)
        } catch (e: Exception) {
            view.showError("Error al cargar los productos")
        }
    }
}