package com.cs4520.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var products: List<Product>
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        products = convertDataset()
        // Setup RecyclerView here
    }
    private fun convertDataset(): List<Product> {
        return listOf(
            listOf("Treadmill", "Equipment", null, 32),
            listOf("Banana", "Food", "2024-02-29", 29),
            listOf("Dumbbells", "Equipment", null, 45),
            listOf("Apple", "Food", "2024-03-10", 20),
            listOf("Stationary Bike", "Equipment", null, 50),
            listOf("Orange", "Food", "2024-03-05", 25),
            listOf("Yoga Mat", "Equipment", null, 15),
            listOf("Grapes", "Food", "2024-02-02", 18),
            listOf("Resistance Bands", "Equipment", null, 22),
            listOf("Kiwi", "Food", "2024-01-29", 30),
            listOf("Elliptical Machine", "Equipment", null, 55),
            listOf("Strawberries", "Food", "2024-03-08", 28),
            listOf("Weight Bench", "Equipment", null, 40),
            listOf("Watermelon", "Food", "2024-03-12", 15),
            listOf("Jump Rope", "Equipment", null, 10),
            listOf("Blueberries", "Food", "2024-04-05", 22),
            listOf("Kettlebell", "Equipment", null, 35),
            listOf("Mango", "Food", "2024-04-10", 33),
            listOf("Rowing Machine", "Equipment", null, 48),
            listOf("Pineapple", "Food", "2024-03-20", 26),
            listOf("Pull-Up Bar", "Equipment", null, 30),
            listOf("Peach", "Food", "2024-04-15", 23),
            listOf("Medicine Ball", "Equipment", null, 18),
            listOf("Cherry", "Food", "2024-04-08", 35),
            listOf("Foam Roller", "Equipment", null, 20),
            listOf("Papaya", "Food", "2024-04-18", 32),
            listOf("Balance Ball", "Equipment", null, 25),
            listOf("Pear", "Food", "2024-04-20", 27),
            listOf("Step Platform", "Equipment", null, 15),
            listOf("Plum", "Food", "2024-04-28", 19),
            listOf("Battle Ropes", "Equipment", null, 42),
            listOf("Apricot", "Food", "2024-04-25", 21),
            listOf("Trampoline", "Equipment", null, 38),
            listOf("Raspberry", "Food", "2024-05-02", 24),
            listOf("Gymnastic Rings", "Equipment", null, 50),
            listOf("Blackberry", "Food", "2024-05-08", 29)
        ).map {
            Product(it[0] as String, it[1] as String, it[2] as String?, it[3] as Int)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }
}