package com.example.shoptmodaamerican.productosporcategoria.data
import android.util.Log

class ProductosPorCategoriaRepository {

    fun getProductosPorCategoria(categoriaId: Int): List<Producto> {
        Log.d("ProductosPorCategoriaRepository", "Obteniendo productos para la categoría ID: $categoriaId")
        val productos = when (categoriaId) {
            1 -> listOf(
                Producto(1, "Camiseta deportiva", 9.99, "Camiseta deportiva para niños de 10 años", "https://www.ubuy.ec/productimg/?image=aHR0cHM6Ly9pLmViYXlpbWcuY29tL2ltYWdlcy9nLzhBRUFBT1N3eTN0aVZxT1cvcy1sNTAwLmpwZw.jpg"),
                Producto(2, "Pantalón MAC", 15.00, "Pantalón MAC 2024", "https://images-eu.ssl-images-amazon.com/images/I/61JjpI1jDsL._AC_UL330_SR330,330_.jpg"),
                Producto(3, "Traje", 34.99, "Traje de marinero para niños de 5 años", "https://m.media-amazon.com/images/I/61Jrt6lw9GL.jpg"),
                Producto(4, "Camiseta de caricaturas", 39.99, "Camiseta de caricaturas", "https://m.media-amazon.com/images/I/A13usaonutL._CLa%7C2140%2C2000%7C810XrIClDRL.png%7C0%2C0%2C2140%2C2000%2B0.0%2C0.0%2C2140.0%2C2000.0_AC_UY1000_.png"),
                Producto(5, "Chaqueta de cuero", 79.99, "Chaqueta de cuero genuino para niños", "https://m.media-amazon.com/images/I/61s2NTxVlCL._AC_UY1000_.jpg"),
                Producto(6, "Zapatos deportivos", 59.99, "Zapatos deportivos para correr", "https://img.kwcdn.com/product/Fancyalgo/VirtualModelMatting/b258dd20d34c6b323ba5bd3b08860380.jpg?imageMogr2/auto-orient%7CimageView2/2/w/800/q/70/format/webp")
            )
            2 -> listOf(
                Producto(7, "Vestido de princesa", 29.99, "Vestido de princesa con detalles brillantes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWCzVtPuNHbbf0_hvlFx3NqFU5Ql88G5XrGQ&s"),
                Producto(8, "Conjunto de camiseta y pantalón", 19.99, "Conjunto de camiseta y pantalón para niñas", "https://img.kwcdn.com/product/Fancyalgo/VirtualModelMatting/9c1478927a4d0467336ca4eeba692185.jpg?imageView2/2/w/375/q/50/format/webp"),
                Producto(9, "Zapatos de ballet", 24.99, "Zapatos de ballet para niñas", "https://i.ebayimg.com/thumbs/images/g/~W4AAOSwWvBk6Cie/s-l1200.jpg"),
                Producto(10, "Pijama de unicornio", 14.99, "Pijama de unicornio suave y cómodo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROWDIrh8lFDSyNl4EIRI9JtxnXGeMzkDNheg&s"),
                Producto(11, "Falda de tutú", 19.99, "Falda de tutú con varias capas", "https://m.media-amazon.com/images/I/41804B3w-1L._AC_SY580_.jpg"),
                Producto(12, "Chaqueta con capucha", 34.99, "Chaqueta con capucha para niñas", "https://micco.vtexassets.com/arquivos/ids/191118/93118966-abrigos-y-chaquetas-ni%C3%B1a-mic-chaqueta-1.jpg?v=638247723672000000")
            )
            3 -> listOf(
                Producto(13, "Camisa casual", 39.99, "Camisa casual de manga larga para hombres", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzJYL1dm9FZsQcm2_38BjHP_Yrm3UHl0ZDhQ&s"),
                Producto(14, "Jeans de mezclilla", 49.99, "Jeans de mezclilla de corte recto", "https://m.media-amazon.com/images/I/51DC-yvbV1L.jpg"),
                Producto(15, "Zapatos de vestir", 79.99, "Zapatos de vestir de cuero para hombres", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSs2wl6vxI0KKSla4HtZ6rrd05RZsijkLYM_g&s"),
                Producto(16, "Chaqueta de cuero", 129.99, "Chaqueta de cuero genuino para hombres", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJRG7y9iHfmSxm5tr5-Wkggng8Ymlj_RvS0w&s"),
                Producto(17, "Traje formal", 199.99, "Traje formal de dos piezas para hombres", "https://m.media-amazon.com/images/I/614lQV+HBWL._AC_UY1000_.jpg"),
                Producto(18, "Pantalón cargo", 59.99, "Pantalón cargo con múltiples bolsillos", "https://i.pinimg.com/736x/52/1c/1e/521c1e43f8eadb6e2f1add79bf6de1d0.jpg")
            )
            4 -> listOf(
                Producto(19, "Vestido de fiesta", 79.99, "Elegante vestido de fiesta para mujeres", "https://ae01.alicdn.com/kf/S1e1c3584774f4f678abab1af781a9edd4.jpg_640x640Q90.jpg_.webp"),
                Producto(20, "Blusa de seda", 49.99, "Blusa de seda con estampado floral", "imagen_url"),
                Producto(21, "Pantalón de mezclilla", 59.99, "Pantalón de mezclilla ajustado para mujeres", "imagen_url"),
                Producto(22, "Zapatos de tacón", 89.99, "Zapatos de tacón alto con diseño elegante", "imagen_url"),
                Producto(23, "Abrigo de invierno", 149.99, "Abrigo de invierno acolchado y cálido", "imagen_url"),
                Producto(24, "Falda plisada", 39.99, "Falda plisada de estilo vintage", "imagen_url")
            )
            5 -> listOf(
                Producto(25, "Conjunto de body y pantalón", 29.99, "Conjunto de body y pantalón para bebé", "imagen_url"),
                Producto(26, "Zapatos para bebé", 19.99, "Zapatos cómodos para bebé", "imagen_url"),
                Producto(27, "Manta de algodón", 14.99, "Manta suave de algodón para bebé", "imagen_url"),
                Producto(28, "Juguetes de estimulación", 9.99, "Juguetes educativos para bebé", "imagen_url"),
                Producto(29, "Babero de silicona", 6.99, "Babero fácil de limpiar para bebé", "imagen_url"),
                Producto(30, "Gorro de algodón", 7.99, "Gorro de algodón para bebé", "imagen_url")
            )
            else -> emptyList()
        }
        Log.d("ProductosPorCategoriaRepository", "Productos devueltos: ${productos.size}")
        return productos
    }
}