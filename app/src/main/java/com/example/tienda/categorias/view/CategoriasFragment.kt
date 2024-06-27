package com.example.tienda.categorias.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda.R
import com.example.tienda.categorias.data.Categoria
import com.example.tienda.categorias.data.CategoriasRepositoryImpl
import com.example.tienda.categorias.presenter.CategoriasContract
import com.example.tienda.categorias.presenter.CategoriasPresenter
import com.example.tienda.productosporcategoria.view.ProductosPorCategoriaFragment

class CategoriasFragment : Fragment(), CategoriasContract.View {

    private lateinit var presenter: CategoriasContract.Presenter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoriasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categorias, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        presenter = CategoriasPresenter(this, CategoriasRepositoryImpl())
        presenter.cargarCategorias()

        return view
    }

    override fun mostrarCategorias(categorias: List<Categoria>) {
        adapter = CategoriasAdapter(categorias) { categoria ->
            // Aquí manejas el click en una categoría
            Toast.makeText(context, "Categoría seleccionada: ${categoria.nombre}", Toast.LENGTH_SHORT).show()

            // Navegar a ProductosPorCategoriaFragment con el ID de la categoría seleccionada
            val fragment = ProductosPorCategoriaFragment.newInstance(categoria.id)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = adapter
    }

    override fun mostrarError(mensaje: String) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }
}
