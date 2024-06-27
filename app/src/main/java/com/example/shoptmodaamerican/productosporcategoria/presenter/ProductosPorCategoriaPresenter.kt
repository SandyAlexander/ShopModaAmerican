package com.example.shoptmodaamerican.productosporcategoria.presenter

import android.util.Log
import com.example.shoptmodaamerican.productosporcategoria.data.ProductosPorCategoriaRepository
import com.example.shoptmodaamerican.productosporcategoria.data.Producto

class ProductosPorCategoriaPresenter(private val view: ProductosPorCategoriaContract.View) : ProductosPorCategoriaContract.Presenter {

    private val repository = ProductosPorCategoriaRepository()

    override fun loadProductosPorCategoria(categoriaId: Int) {
        Log.d("ProductosPorCategoriaPresenter", "Cargando productos para la categoría ID: $categoriaId")
        val productos = repository.getProductosPorCategoria(categoriaId)
        if (productos.isEmpty()) {
            view.mostrarMensaje("No se encontraron productos para esta categoría")
        } else {
            view.showProductos(productos)
        }
    }
}
