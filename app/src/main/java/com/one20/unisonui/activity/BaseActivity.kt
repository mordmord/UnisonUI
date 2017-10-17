package com.one20.one20ui.activity

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.one20.one20ui.R
import com.one20.one20ui.fragment.*


open class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    // Toolbar items
    lateinit var mToolbar: Toolbar
    lateinit var mDrawerLayout: DrawerLayout
    lateinit var mDrawerToggle: ActionBarDrawerToggle
    lateinit var mNavigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)

        mDrawerLayout = findViewById(R.id.drawer_layout)
        mDrawerToggle = ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        mDrawerLayout.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()

        mNavigationView = findViewById(R.id.nav_view)
        mNavigationView.setNavigationItemSelectedListener(this)

        launchFragment(FragmentButtons.newInstance())

    }



    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        when(id) {
            R.id.fragment_button -> launchFragment(FragmentButtons.newInstance())
            R.id.fragment_switches_sliders -> launchFragment(FragmentSwitchesSliders.newInstance())
            R.id.fragment_textviews -> launchFragment(FragmentTextFields.newInstance())
            R.id.fragment_snackbar -> launchFragment(FragmentSnackbar.newInstance())
            R.id.fragment_dialogs   -> launchFragment(FragmentDialogs.newInstance())
            R.id.fragment_bars  ->  launchFragment(FragmentBars.newInstance())
            R.id.fragment_pickers ->  launchFragment(FragmentPickers.newInstance())
            R.id.fragment_lists->  launchFragment(FragmentLists.newInstance())
            R.id.fragment_splatter_textview -> launchFragment(FragmentSplatterTextView.newInstance())
            R.id.fragment_progress  ->  launchFragment(FragmentProgress.newInstance())
        }

        mDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }





    fun launchFragment(frag: Fragment) {
        fragmentManager.beginTransaction().replace(R.id.fragment_container, frag)
                .addToBackStack(null)
                .commit()
    }

}
