package me.projekt401.projkt.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import me.projekt401.projkt.R
import me.projekt401.projkt.databinding.ActivityMainBinding
import me.projekt401.projkt.databinding.NavHeaderBinding
import me.projekt401.projkt.ui.secondScreen.SecondScreenFragment

class MainActivity : AppCompatActivity(),
        SecondScreenFragment.SecondFragmentListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navHeader: NavHeaderBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawerLayout = binding.drawerLayout
        navController = findNavController(R.id.navHostFragment)
        navHeader = DataBindingUtil.inflate(layoutInflater, R.layout.nav_header, binding.navView, false)
        binding.navView.addHeaderView(navHeader.root)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }
}