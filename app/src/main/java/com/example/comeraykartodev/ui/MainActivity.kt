package com.example.comeraykartodev.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.comeraykartodev.R
import com.example.comeraykartodev.data.repository.MainRepository
import com.example.comeraykartodev.ui.base.MainViewModelProviderFactory
import com.example.comeraykartodev.ui.vm.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        navController = Navigation.findNavController(this, R.id.ac_ma_nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        val mainRepository = MainRepository()
        val viewModelProviderFactory = MainViewModelProviderFactory(application, mainRepository)
        mainViewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(MainViewModel::class.java)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.ac_ma_nav_host_fragment)
            .navigateUp() || super.onSupportNavigateUp()
    }

    fun showLoading() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
        ac_main_pb.visibility = View.VISIBLE
    }

    fun hideLoading() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        ac_main_pb.visibility = View.GONE
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == R.id.menuitem) {
            val i = Intent(applicationContext, AboutActivity::class.java)
            startActivity(i)
        }
        return super.onOptionsItemSelected(menuItem)
    }
}



