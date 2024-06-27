package com.example.shoptmodaamerican.productosporcategoria.presenter

import com.example.shoptmodaamerican.productosporcategoria.data.Producto

interface ProductosPorCategoriaContract {
    interface View {
        fun showProductos(productos: List<Producto>)
        fun showError(mensaje: String)
        fun mostrarMensaje(mensaje: String)
    }

    interface Presenter {
        fun loadProductosPorCategoria(categoriaId: Int)
    }
}
