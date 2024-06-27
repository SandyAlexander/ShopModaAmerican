package com.example.shoptmodaamerican.carrito.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoptmodaamerican.R
import com.example.shoptmodaamerican.carrito.data.CarritoRepositoryImpl
import com.example.shoptmodaamerican.carrito.data.ProductoCarrito
import com.example.shoptmodaamerican.carrito.presenter.CarritoContract
import com.example.shoptmodaamerican.carrito.presenter.CarritoPresenter


class CarritoFragment : Fragment(), CarritoContract.View {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CarritoAdapter
    private lateinit var presenter: CarritoContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_carrito, container, false)

        // Configurar RecyclerView
        recyclerView = rootView.findViewById(R.id.recycler_view_carrito)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = CarritoAdapter(requireContext(), mutableListOf())
        recyclerView.adapter = adapter

        // Inicializar el Presenter
        presenter = CarritoPresenter(this, CarritoRepositoryImpl())

        // Obtener y mostrar productos en el carrito al iniciar el fragmento
        presenter.obtenerProductosEnCarrito()

        return rootView
    }

    override fun mostrarProductosEnCarrito(productos: List<ProductoCarrito>) {
        adapter.updateData(productos)
    }

    override fun mostrarMensaje(mensaje: String) {
        // Puedes implementar lógica adicional aquí para mostrar mensajes al usuario si es necesario
    }
}
