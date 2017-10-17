package com.one20.one20ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.*
import android.widget.Toast
import com.one20.one20ui.R
import com.one20.one20ui.activity.BaseActivity
import com.one20.one20uilib.bars.UnisonBottomBar
import com.one20.one20uilib.bars.UnisonBottomBarItem
import com.one20.one20uilib.bars.UnisonSearchNavBar

/**
 * Created by ryanmord on 9/19/17.
 */
class FragmentBars: Fragment(), UnisonSearchNavBar.Companion.IBarListener {

    lateinit var mActivity: BaseActivity

    lateinit var mBottomBar: UnisonBottomBar
    lateinit var mTopBar: UnisonSearchNavBar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v = inflater!!.inflate(R.layout.fragment_bars, container, false)

        mBottomBar = v.findViewById(R.id.bottom_bar)
        mTopBar = v.findViewById(R.id.search_nav)

        var bottomBarItems = ArrayList<UnisonBottomBarItem>()

        for(i in 0..4) {
            val item = UnisonBottomBarItem(activity, "Item $i", R.drawable.ic_menu_share)

            bottomBarItems.add(item)
        }

        mBottomBar.setBarItems(bottomBarItems)
        mBottomBar.setItemClickNotifier(this::itemClick)

        mBottomBar.setSelectedIndex(0)

        mTopBar.setBarListener(this)

        return v
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        mActivity.supportActionBar!!.title = "Bars"
    }

    override fun onStart() {
        super.onStart()

        mActivity = activity as BaseActivity
    }


    fun itemClick(index: Int) {
        Toast.makeText(activity, index.toString(), Toast.LENGTH_SHORT).show()
    }


    override fun menuClicked() {
        Toast.makeText(activity, "Menu click", Toast.LENGTH_SHORT).show()
    }

    override fun searchTextChanged(text: CharSequence) {
    }

    override fun searchButtonClicked() {
        Toast.makeText(activity, "Search click", Toast.LENGTH_SHORT).show()
    }

    override fun navButtonClicked() {
        Toast.makeText(activity, "Nav click", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): FragmentBars {
            return FragmentBars()
        }
    }

}