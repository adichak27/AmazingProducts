package com.cs4520.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment1.databinding.FragmentProductListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {

    private lateinit var products: List<Product>
    private lateinit var adapter: ProductAdapter
    private lateinit var binding: FragmentProductListBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        products = productsDataset.map {
            when (it[1]) {
                "Food" -> Product.Food(it[0] as String, it[2] as String?, it[3] as Int)
                "Equipment" -> Product.Equipment(it[0] as String, it[3] as Int)
                else -> throw IllegalArgumentException("Invalid product type")
            }
        }
        // Setup RecyclerView here
        adapter = ProductAdapter(products);
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }
}