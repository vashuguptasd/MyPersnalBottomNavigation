package com.example.mypersnalbottomnavigation

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mypersnalbottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.launching_fragment)
        setupActionBarWithNavController(navController)

        setUpSmoothBottomBar()


    }

    private fun setUpSmoothBottomBar() {
        val popupMenu = PopupMenu(this,null)
        popupMenu.inflate(R.menu.smooth_bar_menu)

        val menu = popupMenu.menu
        binding.bottomBar.setupWithNavController(menu,navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()||super.onSupportNavigateUp()
    }
}