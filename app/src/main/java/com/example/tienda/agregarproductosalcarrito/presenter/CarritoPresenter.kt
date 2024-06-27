// CarritoPresenter.kt

package com.example.tienda.agregarproductosalcarrito.presenter

import com.example.tienda.agregarproductosalcarrito.data.CarritoRepository
import com.example.tienda.agregarproductosalcarrito.data.ProductoCarrito

class CarritoPresenter(
    private val view: CarritoContract.View,
    private val carritoRepository: CarritoRepository
) : CarritoContract.Presenter {

    override fun agregarProductoAlCarrito(producto: ProductoCarrito) {
        carritoRepository.agregarProductoAlCarrito(producto)
        view.mostrarMensaje("Producto agregado al carrito")
    }

    override fun eliminarProductoDelCarrito(producto: ProductoCarrito) {
        carritoRepository.eliminarProductoDelCarrito(producto)
        view.mostrarMensaje("Producto eliminado del carrito")
    }

    override fun obtenerProductosEnCarrito() {
        val productosEnCarrito = carritoRepository.obtenerProductosEnCarrito()
        view.mostrarProductosEnCarrito(productosEnCarrito)
    }
}
