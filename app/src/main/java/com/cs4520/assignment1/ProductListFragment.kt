package com.cs4520.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {

    private lateinit var products: List<Product>
    private lateinit var adapter: ProductAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        return view
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
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }
}