package com.example.shoptmodaamerican.categoria.presenter

import com.example.shoptmodaamerican.categoria.data.CategoriasRepository
import com.example.shoptmodaamerican.categoria.data.Categoria

interface CategoriasContract {
    interface View {
        fun mostrarCategorias(categorias: List<Categoria>)
        fun mostrarError(mensaje: String)
    }

    interface Presenter {
        fun cargarCategorias()
    }
}

