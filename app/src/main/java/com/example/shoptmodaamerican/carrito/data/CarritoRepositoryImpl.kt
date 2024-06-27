// CarritoRepositoryImpl.kt

package com.example.shoptmodaamerican.carrito.data

class CarritoRepositoryImpl : CarritoRepository {

    private val carrito: MutableList<ProductoCarrito> = mutableListOf()

    override fun agregarProductoAlCarrito(producto: ProductoCarrito) {
        carrito.add(producto)
    }

    override fun eliminarProductoDelCarrito(producto: ProductoCarrito) {
        carrito.remove(producto)
    }

    override fun obtenerProductosEnCarrito(): List<ProductoCarrito> {
        return carrito.toList()
    }

    override fun limpiarCarrito() {
        carrito.clear()
    }
}
