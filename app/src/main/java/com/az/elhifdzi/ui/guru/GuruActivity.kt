package com.az.elhifdzi.ui.guru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.az.elhifdzi.R
import com.az.elhifdzi.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class GuruActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guru)

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.santri_bottom_nav)

        val navGraphIds = listOf(R.navigation.guru_home_nav, R.navigation.guru_profile_nav)

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.guru_nav_host_container,
            intent = intent
        )
        // Whenever the selected controller changes, setup the action bar.
        controller.observe(this, Observer { navController ->
            setupActionBarWithNavController(navController)
            navController.addOnDestinationChangedListener { _, destination, _ ->
                //do something when nav change
                if(destination.id == R.id.guruHomeFragment ||  destination.id == R.id.guruProfileFragment){
                    bottomNavigationView.visibility = View.VISIBLE
                }else{
                    bottomNavigationView.visibility = View.GONE
                }
            }
        })
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}