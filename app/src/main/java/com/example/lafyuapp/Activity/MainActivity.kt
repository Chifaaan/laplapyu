package com.example.lafyuapp.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lafyuapp.Adapter.ProductAdapter
import com.example.lafyuapp.Data.Product
import com.example.lafyuapp.Data.Review
import com.example.lafyuapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewFlashSale: RecyclerView = findViewById(R.id.recyclerViewFlashSale)
        val recyclerViewMegaSale: RecyclerView = findViewById(R.id.recyclerViewMegaSale)
        val recyclerViewRecommended: RecyclerView = findViewById(R.id.recyclerViewRecommended)

        val products = listOf(
            Product(
                "Nike Air Max 270", "$299.43", R.drawable.nike_air_max_270,
                sizes = listOf("6", "6.5", "7", "7.5", "8.5"),
                colors = listOf(R.color.yellow, R.color.blue, R.color.green, R.color.red, R.color.purple),
                reviews = listOf(
                    Review("James Lawson", 4.5f, "Great product, very comfortable."),
                    Review("Sarah Johnson", 4.0f, "Stylish and comfy!")
                )
            ),
            Product(
                "Melvill & Monn BAG", "$299.43", R.drawable.nike_air_max_270_react_eng,
                sizes = listOf("7", "7.5", "8", "8.5", "9"),
                colors = listOf(R.color.blue, R.color.green, R.color.red, R.color.purple),
                reviews = listOf(
                    Review("Michael Brown", 5.0f, "Absolutely love these shoes!"),
                    Review("Jessica Lee", 4.8f, "Very comfy and nice design.")
                )
            ),
            Product(
                "QUILTED MINI BAG", "$534.33", R.drawable.quilted_mini_bag,
                sizes = emptyList(),
                colors = listOf(R.color.black, R.color.white),
                reviews = listOf(
                    Review("Emily Davis", 4.2f, "Very cute bag!"),
                    Review("Sophia Martinez", 4.5f, "Perfect size for daily use.")
                )
            )
            // Tambahkan produk lainnya
        )

        val adapter = ProductAdapter(products) { product ->
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("PRODUCT", product)
            startActivity(intent)
        }

        recyclerViewFlashSale.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewFlashSale.adapter = adapter

        recyclerViewMegaSale.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewMegaSale.adapter = adapter

        recyclerViewRecommended.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewRecommended.adapter = adapter

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Handle Home click
                    true
                }
                R.id.nav_explore -> {
                    // Handle Explore click
                    true
                }
                R.id.nav_cart -> {
                    // Handle Cart click
                    true
                }
                R.id.nav_offer -> {
                    // Handle Offer click
                    true
                }
                R.id.nav_account -> {
                    // Handle Account click
                    true
                }
                else -> false
            }
        }
    }
}