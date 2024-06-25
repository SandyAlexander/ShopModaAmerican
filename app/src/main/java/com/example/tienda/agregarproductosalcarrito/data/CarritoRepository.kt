// CarritoRepository.kt

package com.example.tienda.agregarproductosalcarrito.data

import com.example.tienda.agregarproductosalcarrito.data.ProductoCarrito

interface CarritoRepository {
    fun agregarProductoAlCarrito(producto: ProductoCarrito)
    fun eliminarProductoDelCarrito(producto: ProductoCarrito)
    fun obtenerProductosEnCarrito(): List<ProductoCarrito>
    fun limpiarCarrito()
}
