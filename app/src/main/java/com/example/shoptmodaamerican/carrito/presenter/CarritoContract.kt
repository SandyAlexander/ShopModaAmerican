// CarritoContract.kt

package com.example.shoptmodaamerican.carrito.presenter

import com.example.shoptmodaamerican.carrito.data.ProductoCarrito


interface CarritoContract {
    interface View {
        fun mostrarProductosEnCarrito(productos: List<ProductoCarrito>)
        fun mostrarMensaje(mensaje: String)
    }

    interface Presenter {
        fun agregarProductoAlCarrito(producto: ProductoCarrito)
        fun eliminarProductoDelCarrito(producto: ProductoCarrito)
        fun obtenerProductosEnCarrito()
    }
}
