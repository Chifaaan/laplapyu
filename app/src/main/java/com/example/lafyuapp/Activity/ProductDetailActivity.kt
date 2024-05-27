package com.example.lafyuapp.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lafyuapp.Adapter.ProductAdapter
import com.example.lafyuapp.Adapter.ReviewAdapter
import com.example.lafyuapp.Data.Product
import com.example.lafyuapp.Data.Review
import com.example.lafyuapp.R

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = intent.getParcelableExtra<Product>("PRODUCT")

        if (product != null) {
            findViewById<ImageView>(R.id.productImageView).setImageResource(product.imageResId)
            findViewById<TextView>(R.id.productNameTextView).text = product.name
            findViewById<TextView>(R.id.productPriceTextView).text = product.price

            // Update size options
//            val sizesTextView = findViewById<TextView>(R.id.selectSizeTextView)
//            sizesTextView.text = product.sizes.joinToString(", ")
//
//            // Update color options
//            val colorsTextView = findViewById<TextView>(R.id.selectColorTextView)
//            colorsTextView.text = product.colors.joinToString(", ") { getString(it) }

            // Update reviews
            val reviewsRecyclerView: RecyclerView = findViewById(R.id.reviewsRecyclerView)
            reviewsRecyclerView.layoutManager = LinearLayoutManager(this)
            reviewsRecyclerView.adapter = ReviewAdapter(product.reviews)
        }

        // Back Button click listener
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }

        // Set up "You Might Also Like" RecyclerView
        val recyclerViewYouMightAlsoLike: RecyclerView = findViewById(R.id.recyclerViewYouMightAlsoLike)
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
                "Nike Air Max 270 React ENG", "$299.43", R.drawable.nike_air_max_270_react_eng,
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

        recyclerViewYouMightAlsoLike.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewYouMightAlsoLike.adapter = ProductAdapter(products) { product ->
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("PRODUCT", product)
            startActivity(intent)
        }

        // Handle Add to Cart button click
        findViewById<Button>(R.id.addToCartButton).setOnClickListener {
            // Logic for adding to cart
        }
    }
}