package com.example.shoptmodaamerican.categoria.presenter

import com.example.shoptmodaamerican.categoria.presenter.CategoriasContract
import com.example.shoptmodaamerican.categoria.data.CategoriasRepository

class CategoriasPresenter(
    private val view: CategoriasContract.View,
    private val repository: CategoriasRepository
) : CategoriasContract.Presenter {

    override fun cargarCategorias() {
        val categorias = repository.obtenerCategorias()
        if (categorias.isNotEmpty()) {
            view.mostrarCategorias(categorias)
        } else {
            view.mostrarError("No se encontraron categorías.")
        }
    }
}
