package com.example.module15_assignment.views.viewholder

import android.os.Build
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.module15_assignment.views.components.CircularOutlineProvider
import kotlinx.android.synthetic.main.view_holder_task.view.*

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData() {
        //Set profile imageview shadow
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            itemView.ivProfile.outlineProvider = CircularOutlineProvider()
        }
    }
}