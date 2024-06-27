package com.example.shoptmodaamerican.productosporcategoria.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoptmodaamerican.R
import com.example.shoptmodaamerican.productosporcategoria.data.Producto
import com.example.shoptmodaamerican.productosporcategoria.presenter.ProductosPorCategoriaContract
import com.example.shoptmodaamerican.productosporcategoria.presenter.ProductosPorCategoriaPresenter

class ProductosPorCategoriaFragment : Fragment(), ProductosPorCategoriaContract.View {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductosPorCategoriaAdapter
    private lateinit var presenter: ProductosPorCategoriaContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_producto_por_categoria, container, false)

        recyclerView = rootView.findViewById(R.id.recycler_view_productos_por_categoria)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ProductosPorCategoriaAdapter(requireContext(), mutableListOf(), object : ProductosPorCategoriaAdapter.OnAgregarCarritoClickListener {
            override fun onAgregarCarritoClick(producto: Producto) {
                mostrarMensaje("Agregado al carrito: ${producto.nombre}")
            }
        })
        recyclerView.adapter = adapter

        val categoriaId = arguments?.getInt(ARG_CATEGORIA) ?: -1
        Log.d("Fragment", "Category ID received: $categoriaId")
        presenter = ProductosPorCategoriaPresenter(this)
        presenter.loadProductosPorCategoria(categoriaId)

        return rootView
    }

    override fun showProductos(productos: List<Producto>) {
        Log.d("ProductosPorCategoria", "Productos recibidos: ${productos.size}")
        adapter.updateData(productos)
    }

    override fun showError(mensaje: String) {
        Log.e("ProductosPorCategoria", mensaje)
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun mostrarMensaje(mensaje: String) {
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val ARG_CATEGORIA = "categoria"

        fun newInstance(categoriaId: Int): ProductosPorCategoriaFragment {
            val fragment = ProductosPorCategoriaFragment()
            val args = Bundle()
            args.putInt(ARG_CATEGORIA, categoriaId)
            fragment.arguments = args
            return fragment
        }
    }
}