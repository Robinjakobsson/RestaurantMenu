package com.example.wildwest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wildwest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dishAdapter: DishAdapter
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val starters = listOf(
            Dish("Mac&Cheese", "Maccaronies with mozzarella cheese", R.drawable.mac_cheese),
            Dish("Garlic bread","Basket of garlic bread",R.drawable.garlic_bread),
            Dish("Cowboysoup","This cowboy soup with beef, lots of vegetables, and a tomato base, is a hearty stick-to-your-ribs kind of meal. Leftovers are even better the next day and it freezes well, too.",R.drawable.cowboy_soup)
        )

        val mainCourses = listOf(
            Dish("Cowboy burger","Good burgir", R.drawable.burger),
            Dish("Cowboy steak","only for big boys", R.drawable.plankstek),
            Dish("Cowboy ribs","Rock n roll ribs", R.drawable.ribs)
        )

        val desserts = listOf(
            Dish("Pannacotta","Chrushed Digestive kex and good cream",R.drawable.pannacotta),
            Dish("Apple pie","Sliced apples with a side of vanilla sauce",R.drawable.applepie),
            Dish("Snus","Holy Swedish Snus",R.drawable.snus),
        )

        dishAdapter = DishAdapter(starters)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = dishAdapter

        binding.startersButton.setOnClickListener { updateMenu(starters) }
        binding.mainCourseButton.setOnClickListener { updateMenu((mainCourses)) }
        binding.dessertsButton.setOnClickListener { updateMenu(desserts) }
    }

    private fun updateMenu(dishes: List<Dish>) {
        dishAdapter.updateDishes(dishes)
    }
}