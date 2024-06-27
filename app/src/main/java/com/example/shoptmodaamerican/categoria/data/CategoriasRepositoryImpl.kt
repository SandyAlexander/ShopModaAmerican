package com.example.shoptmodaamerican.categoria.data

class CategoriasRepositoryImpl : CategoriasRepository {

    override fun obtenerCategorias(): List<Categoria> {
        // Aquí se pueden agregar categorías estáticas o cargar desde una fuente de datos
        return listOf(
            Categoria(1, "Niños"),
            Categoria(2, "Niñas"),
            Categoria(3, "Hombres"),
            Categoria(4, "Mujeres"),
            Categoria(5, "Bebés")
        )
    }
}
