package com.cs4520.assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment1.databinding.ItemProductBinding

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.apply {
            when (val product = products[position]) {
                is Product.Food -> {
                    textViewName.text = product.name
                    textViewPrice.text = "$${product.price}"
                    // set or hide the expirary date
                    if (product.expiryDate.isNullOrEmpty()) {
                        textViewExpiryDate.visibility = View.GONE
                    } else {
                        textViewExpiryDate.visibility = View.VISIBLE
                        textViewExpiryDate.text = product.expiryDate
                    }
                    // set background color to light_yellow from the colors.xml
                    itemProduct.setBackgroundResource(R.color.light_yellow)
                    imageViewProduct.setImageResource(R.drawable.food)
                }
                is Product.Equipment -> {
                    textViewName.text = product.name
                    textViewPrice.text = "$${product.price}"
                    textViewExpiryDate.visibility = View.GONE
                    // set background color to light_red from the colors.xml
                    itemProduct.setBackgroundResource(R.color.light_red)
                    imageViewProduct.setImageResource(R.drawable.equipment)
                }
            }
            imageViewProduct.post {
                val width = imageViewProduct.width
                imageViewProduct.layoutParams.height = width
            }
        }


    }
    override fun getItemCount(): Int {
        return products.size
    }
}