// CarritoRepository.kt

package com.example.shoptmodaamerican.carrito.data



interface CarritoRepository {
    fun agregarProductoAlCarrito(producto: ProductoCarrito)
    fun eliminarProductoDelCarrito(producto: ProductoCarrito)
    fun obtenerProductosEnCarrito(): List<ProductoCarrito>
    fun limpiarCarrito()
}
