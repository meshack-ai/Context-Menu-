package com.example.contextmenu

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var relativeLayout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Link objects with their respective IDs from the XML layout
        textView = findViewById(R.id.textView)
        relativeLayout = findViewById(R.id.relLayout)

        // Register the TextView for the context menu
        registerForContextMenu(textView)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        // Set the header title for the context menu
        menu.setHeaderTitle("Choose a color")
        // Add menu items
        menu.add(0, v.id, 0, "Yellow")
        menu.add(0, v.id, 0, "Gray")
        menu.add(0, v.id, 0, "Cyan")
    }

    // Handle context menu item selection
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.title.toString()) {
            "Yellow" -> relativeLayout.setBackgroundColor(Color.YELLOW)
            "Gray" -> relativeLayout.setBackgroundColor(Color.GRAY)
            "Cyan" -> relativeLayout.setBackgroundColor(Color.CYAN)
        }
        return super.onContextItemSelected(item)
    }
}
