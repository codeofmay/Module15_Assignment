package com.example.module15_assignment.views.viewpods

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module15_assignment.adapters.TaskAdapter
import com.example.module15_assignment.views.components.CircularOutlineProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_holder_task.view.*
import kotlinx.android.synthetic.main.view_pod_task_list.view.*

class TaskListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    lateinit var mTaskAdapter: TaskAdapter
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpRecyclerView()
    }

    //Task List Recyclerview
    private fun setUpRecyclerView() {
        mTaskAdapter = TaskAdapter()
        rvTasks.adapter = mTaskAdapter
        rvTasks.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}