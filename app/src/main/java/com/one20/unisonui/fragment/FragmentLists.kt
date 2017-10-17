package com.one20.one20ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.one20.one20ui.R
import com.one20.one20uilib.recycler.adapter.UnisonMultiLineRecyclerAdapter
import com.one20.one20uilib.recycler.adapter.UnisonSingleLineRecyclerAdapter
import com.one20.unisonui.recycler.ItemClickListener
import com.one20.unisonui.recycler.decorator.UnisonSimpleRecyclerDivider
import com.one20.unisonui.recycler.model.UnisonRecyclerItemModel

/**
 * Created by ryanmord on 10/2/17.
 */
class FragmentLists: Fragment(), ItemClickListener {

    private lateinit var singleList: RecyclerView
    private lateinit var doubleList: RecyclerView
    private lateinit var tripleList: RecyclerView


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater!!.inflate(R.layout.fragment_lists, container, false)

        singleList = v.findViewById(R.id.single_line_view)
        doubleList = v.findViewById(R.id.dual_line_item)
        tripleList = v.findViewById(R.id.single_image_view)


        //FIRST RECYCLER
        val singleAdapter = UnisonSingleLineRecyclerAdapter(activity, arrayListOf(
                UnisonRecyclerItemModel("Single-line Item"),
                UnisonRecyclerItemModel("Single-line Item", R.drawable.launch_splash),
                UnisonRecyclerItemModel("Single-line Item"),
                UnisonRecyclerItemModel("Single-line Item", R.drawable.launch_splash),
                UnisonRecyclerItemModel("Single-line Item"),
                UnisonRecyclerItemModel("Single-line Item", R.drawable.launch_splash),
                UnisonRecyclerItemModel("Single-line Item"),
                UnisonRecyclerItemModel("Single-line Item", R.drawable.launch_splash))
        )

        singleAdapter.setItemClickListener(this)
        singleList.adapter = singleAdapter

        singleList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        singleList.addItemDecoration(UnisonSimpleRecyclerDivider(activity))


        //SECOND RECYCLER
        val twoLineAdapter = UnisonMultiLineRecyclerAdapter(activity, arrayListOf(
                UnisonRecyclerItemModel("Two-line item", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
                UnisonRecyclerItemModel("Two-line item", "Secondary line text."),
                UnisonRecyclerItemModel("Two-line item", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
                UnisonRecyclerItemModel("Two-line item", "Secondary line text."),
                UnisonRecyclerItemModel("Two-line item", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
                UnisonRecyclerItemModel("Two-line item", "Secondary line text."))
        )

        twoLineAdapter.setItemClickListener(this)
        doubleList.adapter = twoLineAdapter

        doubleList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        doubleList.addItemDecoration(UnisonSimpleRecyclerDivider(activity))



        //THIRD RECYCLER
        val thirdLineAdapter = UnisonMultiLineRecyclerAdapter(activity, arrayListOf(
                UnisonRecyclerItemModel("This is a header string", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.launch_splash),
                UnisonRecyclerItemModel("This is a header string", "Secondary text to see how things fit", R.drawable.launch_splash),
                UnisonRecyclerItemModel("This is a header string", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.launch_splash),
                UnisonRecyclerItemModel("This is a header string", "Secondary text to see how things fit", R.drawable.launch_splash),
                UnisonRecyclerItemModel("This is a header string", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.launch_splash),
                UnisonRecyclerItemModel("This is a header string", "Secondary text to see how things fit", R.drawable.launch_splash),
                UnisonRecyclerItemModel("This is a header string", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.launch_splash),
                UnisonRecyclerItemModel("This is a header string", "Secondary text to see how things fit", R.drawable.launch_splash))
        )

        thirdLineAdapter.setItemClickListener(this)
        tripleList.adapter = thirdLineAdapter

        tripleList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        tripleList.addItemDecoration(UnisonSimpleRecyclerDivider(activity))

        return v
    }


    override fun itemClicked(index: Int) {
        Toast.makeText(activity, index.toString(), Toast.LENGTH_SHORT).show()
    }



    companion object {
        fun newInstance(): FragmentLists {
            return FragmentLists()
        }
    }

}