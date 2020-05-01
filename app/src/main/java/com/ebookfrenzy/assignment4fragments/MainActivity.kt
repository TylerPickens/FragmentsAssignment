package com.ebookfrenzy.assignment4fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TempFragment = TempFragment()
        val MassFragment = MassFragment()
        val LengthFragment = LengthFragment()

        setCurrentFragment(TempFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_FC -> setCurrentFragment(TempFragment)
                R.id.nav_KGP -> setCurrentFragment(MassFragment)
                R.id.nav_FM -> setCurrentFragment(LengthFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }


}
