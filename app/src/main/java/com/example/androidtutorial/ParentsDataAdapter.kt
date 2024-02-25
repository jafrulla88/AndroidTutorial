package com.example.androidtutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool

class ParentsDataAdapter(
    parentList: ArrayList<ParentData>?,
     sampleActivity: SampleActivity
) :
    RecyclerView.Adapter<ParentsDataAdapter.ParentViewHolder>() {
    // An object of RecyclerView.RecycledViewPool
    // is created to share the Views
    // between the child and
    // the parent RecyclerViews
    private val viewPool = RecycledViewPool()
    private val itemList: List<ParentItem>? = null
    private var itemList1: ArrayList<ParentData> = ArrayList()
     private var context :Context?=null

    /*ParentItemAdapter(List<ParentItem> itemList)
    {
        this.itemList = itemList;
    }
*/
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ParentViewHolder {

        // Here we inflate the corresponding
        // layout of the parent item
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.parent_data,
                viewGroup, false
            )
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(
        parentViewHolder: ParentViewHolder,
        position: Int
    ) {

        // Create an instance of the ParentItem
        // class for the given position
        val parentItem = itemList1!![position]
      //  val childItem =childList!![position]

        // For the created instance,
        // get the title and set it
        // as the text for the TextView
        parentViewHolder.ParentItemTitle.text = parentItem.position

        // Create a layout manager
        // to assign a layout
        // to the RecyclerView.

        // Here we have assigned the layout
        // as LinearLayout with vertical orientation
        val layoutManager = LinearLayoutManager(
            parentViewHolder.ChildRecyclerView.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        // Since this is a nested layout, so
        // to define how many child items
        // should be prefetched when the
        // child RecyclerView is nested
        // inside the parent RecyclerView,
        // we use the following method



        layoutManager.initialPrefetchItemCount = parentItem.memberslist.size

        // Create an instance of the child
        // item view adapter and set its
        // adapter, layout manager and RecyclerViewPool
        val membersAdapter = MembersAdapter(parentItem.memberslist,context)
        parentViewHolder.ChildRecyclerView.layoutManager = layoutManager
        parentViewHolder.ChildRecyclerView.adapter = membersAdapter
        parentViewHolder.ChildRecyclerView.setRecycledViewPool(viewPool)
    }

    // This method returns the number
    // of items we have added in the
    // ParentItemList i.e. the number
    // of instances we have created
    // of the ParentItemList
    override fun getItemCount(): Int {
        return itemList1!!.size
    }

    // This class is to initialize
    // the Views present in
    // the parent RecyclerView
    inner class ParentViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val ParentItemTitle: TextView
      //  val slug:TextView
        val ChildRecyclerView: RecyclerView

        init {
            ParentItemTitle = itemView
                .findViewById(
                    R.id.parent_item_title
                )
            //slug=itemView.findViewById(R.id.parent_item_slug)

            ChildRecyclerView = itemView
                .findViewById(
                    R.id.child_recyclerview
                )
        }
    }

    init {
        this.itemList1 = parentList!!
         this.context=sampleActivity
    }
}
