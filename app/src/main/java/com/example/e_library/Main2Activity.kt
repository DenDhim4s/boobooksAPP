package com.example.e_library

import HomeFragment
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.e_library.databinding.ActivityMain2Binding
import com.example.e_library.databinding.ActivityMainBinding
import com.example.e_library.fragment.KoleksiFragment
import com.example.e_library.fragment.LeaderboardFragment
import com.example.e_library.fragment.ReportFragment
import com.example.e_library.helper.SharedPreference
import com.google.android.material.bottomnavigation.BottomNavigationView


class Main2Activity : AppCompatActivity() {

    val fragmentHome: Fragment = HomeFragment()
    val fragmentKoleksi: Fragment = KoleksiFragment()
    val fragmentLeaderboard: Fragment = LeaderboardFragment()
    val fragmentReport: Fragment = ReportFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome


    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var sPH: SharedPreference
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        sPH = SharedPreference(this)
        setContentView(binding.root)
        buttonNavigation()
    }

    private fun buttonNavigation(){
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentKoleksi).hide(fragmentKoleksi).commit()
        fm.beginTransaction().add(R.id.container, fragmentLeaderboard).hide(fragmentLeaderboard).commit()
        fm.beginTransaction().add(R.id.container, fragmentReport).hide(fragmentReport).commit()

        bottomNavigationView = binding.navView
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.home-> {
                    callFragment(0, fragmentHome)
                }
                R.id.koleksi-> {
                    callFragment(1, fragmentKoleksi)
                }
                R.id.leaderboard-> {
                    callFragment(2, fragmentLeaderboard)
                }
                R.id.report-> {
                    callFragment(3, fragmentReport)
                }
            }
            false
        }
    }




    private fun callFragment(index: Int, fragment: Fragment) {
        menuItem = menu.getItem(index)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}
