package com.example.tienda.productosporcategoria.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda.MainActivity
import com.example.tienda.agregarproductosalcarrito.data.ProductoCarrito
import com.example.tienda.productosporcategoria.data.Producto
import com.example.tienda.productosporcategoria.presenter.ProductosPorCategoriaContract
import com.example.tienda.productosporcategoria.presenter.ProductosPorCategoriaPresenter
import com.example.tienda.R

class ProductosPorCategoriaFragment : Fragment(), ProductosPorCategoriaContract.View {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductosPorCategoriaAdapter
    private lateinit var presenter: ProductosPorCategoriaContract.Presenter
    private lateinit var agregarProductoListener: AgregarProductoListener

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AgregarProductoListener) {
            agregarProductoListener = context
        } else {
            throw RuntimeException("$context must implement AgregarProductoListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_productos_por_categoria, container, false)

        // Configurar RecyclerView
        recyclerView = rootView.findViewById(R.id.recycler_view_productos_por_categoria)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ProductosPorCategoriaAdapter(requireContext(), mutableListOf(), object : ProductosPorCategoriaAdapter.OnAgregarCarritoClickListener {
            override fun onAgregarCarritoClick(producto: Producto) {
                agregarProductoListener.agregarProducto(producto)
                mostrarMensaje("Producto agregado al carrito")
            }
        })
        recyclerView.adapter = adapter

        // Obtener el ID de la categoría seleccionada
        val categoriaId = arguments?.getInt(ARG_CATEGORIA) ?: 0

        // Inicializar el Presenter
        presenter = ProductosPorCategoriaPresenter(this)

        // Cargar productos por categoría al iniciar el fragmento
        presenter.loadProductosPorCategoria(categoriaId)

        return rootView
    }

    override fun showProductos(productos: List<Producto>) {
        adapter.updateData(productos)
    }

    override fun showError(mensaje: String) {
        // Manejar el error, por ejemplo, mostrar un Snackbar o Toast
    }

    override fun mostrarMensaje(mensaje: String) {
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()
    }

    interface AgregarProductoListener {
        fun agregarProducto(producto: Producto)
    }
}
