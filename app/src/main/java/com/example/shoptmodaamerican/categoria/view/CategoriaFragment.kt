package com.example.shoptmodaamerican.categoria.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoptmodaamerican.R
import com.example.shoptmodaamerican.categoria.data.CategoriasRepositoryImpl
import com.example.shoptmodaamerican.categoria.data.Categoria
import com.example.shoptmodaamerican.categoria.presenter.CategoriasContract
import com.example.shoptmodaamerican.categoria.presenter.CategoriasPresenter
import com.example.shoptmodaamerican.databinding.FragmentCategoriasBinding

class CategoriaFragment : Fragment(), CategoriasContract.View {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoriasAdapter
    private lateinit var presenter: CategoriasContract.Presenter

    private var _binding: FragmentCategoriasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriasBinding.inflate(inflater, container, false)
        val rootView = binding.root

        // Configurar RecyclerView
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = CategoriasAdapter(emptyList()) { categoria -> onItemClick(categoria) }
        recyclerView.adapter = adapter

        // Inicializar el Presenter
        presenter = CategoriasPresenter(this, CategoriasRepositoryImpl())
        presenter.cargarCategorias()

        return rootView
    }

    override fun mostrarCategorias(categorias: List<Categoria>) {
        adapter.actualizarCategorias(categorias)
    }

    override fun mostrarError(mensaje: String) {
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun onItemClick(categoria: Categoria) {
        // Obtener el NavController desde el fragmento actual
        val navController = findNavController()

        // Navegar al fragmento ProductosPorCategoriaFragment usando la acción definida en mobile_navigation.xml
        navController.navigate(R.id.action_navigation_home_to_productosPorCategoriaFragment)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

