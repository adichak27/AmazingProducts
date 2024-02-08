package com.cs4520.assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewProduct)
        val nameTextView: TextView = view.findViewById(R.id.textViewName)
        val expiryDateTextView: TextView = view.findViewById(R.id.textViewExpiryDate)
        val priceTextView: TextView = view.findViewById(R.id.textViewPrice)
        val background: ConstraintLayout = view as ConstraintLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        when (val product = products[position]) {
            is Product.Food -> {
                holder.nameTextView.text = product.name
                holder.priceTextView.text = "${product.price}"
                // set or hide the expirary date
                if (product.expiryDate.isNullOrEmpty()) {
                    holder.expiryDateTextView.visibility = View.GONE
                } else {
                    holder.expiryDateTextView.visibility = View.VISIBLE
                    holder.expiryDateTextView.text = product.expiryDate
                }
                // set background color to light_yellow from the colors.xml
                holder.background.setBackgroundResource(R.color.light_yellow)
                holder.imageView.setImageResource(R.drawable.tomatoes)
            }
            is Product.Equipment -> {
                holder.nameTextView.text = product.name
                holder.priceTextView.text = "${product.price}"
                holder.expiryDateTextView.visibility = View.GONE
                // set background color to light_red from the colors.xml
                holder.background.setBackgroundResource(R.color.light_red)
                holder.imageView.setImageResource(R.drawable.equipment)
            }
        }
    }
    override fun getItemCount(): Int {
        return products.size
    }
}