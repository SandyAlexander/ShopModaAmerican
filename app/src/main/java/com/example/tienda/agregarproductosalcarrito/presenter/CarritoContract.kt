// CarritoContract.kt

package com.example.tienda.agregarproductosalcarrito.presenter

import com.example.tienda.agregarproductosalcarrito.data.ProductoCarrito

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
