package com.example.androidtutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MembersAdapter  // Constructor
  constructor(private var ChildItemList: ArrayList<Members>) :
    RecyclerView.Adapter<MembersAdapter.ChildViewHolder>() {
    private var childList: ArrayList<Members> = ArrayList()
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ChildViewHolder {

        // Here we inflate the corresponding
        // layout of the child item
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.child_data1,
                viewGroup, false
            )
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(
        childViewHolder: ChildViewHolder,
        position: Int
    ) {

        // Create an instance of the ChildItem
        // class for the given position
        val childItem = ChildItemList[position]

        // For the created instance, set title.
        // No need to set the image for
        // the ImageViews because we have
        // provided the source for the images
        // in the layout file itself
        childViewHolder.textjersy.text = childItem.name
        childViewHolder.textfname.text = childItem.first_name
        childViewHolder.textlname.text = childItem.last_name
    }

    override fun getItemCount(): Int {

        // This method returns the number
        // of items we have added
        // in the ChildItemList
        // i.e. the number of instances
        // of the ChildItemList
        // that have been created
        return ChildItemList.size
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    inner class ChildViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textjersy: TextView
        var textfname:TextView
        var textlname:TextView

        init {
            textjersy = itemView.findViewById(
                R.id.child_item_jersy
            )
            textfname=itemView.findViewById(R.id.child_item_fname)
            textlname=itemView.findViewById(R.id.child_item_lname)
        }
    }
    init {
        this.ChildItemList = childList
     }
}
