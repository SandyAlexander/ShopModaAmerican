package com.example.tienda

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.tienda.agregarproductosalcarrito.view.CarritoFragment
import com.example.tienda.categorias.view.CategoriasFragment
import com.example.tienda.productosporcategoria.data.Producto
import com.example.tienda.productosporcategoria.view.ProductosPorCategoriaFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), ProductosPorCategoriaFragment.AgregarProductoListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            navigateTo(menuItem)
            true
        }

        // Cargar el fragmento de categorías al iniciar la actividad
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CategoriasFragment())
                .commit()
            navigationView.setCheckedItem(R.id.nav_categorias)
        }
    }

    override fun agregarProducto(producto: Producto) {
        mostrarCarrito()
    }

    private fun mostrarCarrito() {
        // Navegar al CarritoFragment
        val carritoFragment = CarritoFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, carritoFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun navigateTo(menuItem: MenuItem) {
        // Manejar la navegación según el item seleccionado en el NavigationView
        var fragment: Fragment? = null
        when (menuItem.itemId) {
            R.id.nav_categorias -> {
                fragment = CategoriasFragment()
            }
            // Aquí puedes agregar más cases para otros fragmentos si es necesario
        }

        fragment?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, it)
                .commit()
        }

        drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        // Cerrar el Drawer al presionar el botón de retroceso si está abierto
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
