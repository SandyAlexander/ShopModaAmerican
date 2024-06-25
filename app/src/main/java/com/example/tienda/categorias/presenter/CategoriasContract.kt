package com.example.tienda.categorias.presenter

import com.example.tienda.categorias.data.Categoria

interface CategoriasContract {
    interface View {
        fun mostrarCategorias(categorias: List<Categoria>)
        fun mostrarError(mensaje: String)
    }

    interface Presenter {
        fun cargarCategorias()
    }
}