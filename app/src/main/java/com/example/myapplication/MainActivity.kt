package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : FruitActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configurePage(R.id.main)
        androidx.core.view.ViewCompat.setAccessibilityHeading(findViewById(R.id.home_title), true)

        findViewById<TextView>(R.id.fruit_count).text = getString(R.string.fruit_count, Fruits.all.size)
        val fruitList = findViewById<ListView>(R.id.fruit_list)
        fruitList.adapter = object : ArrayAdapter<Fruit>(this, R.layout.item_fruit, Fruits.all) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val row = convertView ?: layoutInflater.inflate(R.layout.item_fruit, parent, false)
                val fruit = getItem(position)!!
                row.findViewById<TextView>(R.id.item_name).setText(fruit.nameRes)
                row.findViewById<TextView>(R.id.item_letter).text = fruit.letter
                row.findViewById<ImageView>(R.id.item_image).setImageResource(fruit.imageRes)
                return row
            }
        }
        // Show a hint only when the list actually extends beyond the viewport.
        val scrollHint = findViewById<TextView>(R.id.scroll_hint)
        fun updateScrollHint() {
            val scrollable = fruitList.canScrollVertically(1) || fruitList.canScrollVertically(-1)
            val visibility = if (scrollable) View.VISIBLE else View.GONE
            if (scrollHint.visibility != visibility) scrollHint.visibility = visibility
        }
        fruitList.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) = Unit
            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                updateScrollHint()
            }
        })
        fruitList.post { updateScrollHint() }
        // The image and name are part of the same clickable ListView row.
        fruitList.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, FruitDetailActivity::class.java)
            intent.putExtra(FruitDetailActivity.EXTRA_FRUIT_ID, Fruits.all[position].id)
            startActivity(intent)
        }
    }
}
