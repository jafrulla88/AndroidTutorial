package com.example.androidtutorial

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MembersAdapter  // Constructor
    (private var ChildItemList: ArrayList<Members>, context: Context?) :
    RecyclerView.Adapter<MembersAdapter.ChildViewHolder>() {
    private var childList: ArrayList<Members> = ArrayList()
    private var context:Context?=null

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
        childViewHolder.textfname.text = childItem.first_name
        childViewHolder.textlname.text = childItem!!.last_name
        childViewHolder.textjersy.text = childItem.jersey_number
         /*var options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher_round);
        Glide.with(context!!).load(childItem.headshot!!.original).apply(options)
            .into(childViewHolder.imageview)*/

    }

    override fun getItemCount(): Int {

        // This method returns the number
        // of items we have added
        // in the ChildItemList
        // i.e. the number of instances
        // of the ChildItemList
        // that have been created
        return childList.size
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    inner class ChildViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textjersy: TextView
        var textfname:TextView
        var textlname:TextView
        var imageview:ImageView

        init {
            textjersy = itemView.findViewById(R.id.child_item_jersy)
            textfname=itemView.findViewById(R.id.child_item_fname)
            textlname=itemView.findViewById(R.id.child_item_lname)
            imageview=itemView.findViewById(R.id.img_child_item)
        }
    }
    init {
        this.childList = ChildItemList
        this.context=context
     }
}
