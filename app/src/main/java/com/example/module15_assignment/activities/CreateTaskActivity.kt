package com.example.module15_assignment.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.module15_assignment.R
import com.example.module15_assignment.views.components.CircularOutlineProvider
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_create_task.*
import kotlinx.android.synthetic.main.activity_create_task.ivPerson1
import kotlinx.android.synthetic.main.activity_create_task.ivPerson2


class CreateTaskActivity : AppCompatActivity(R.layout.activity_create_task) {

    //For client spinner
    private val clientList = listOf("Awsmd Team", "Team 2")

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, CreateTaskActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpView()
        setUpAdapter()
        setUpListener()
    }

    private fun setUpListener() {
        btnBack.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun setUpView() {

        //Set profile imageview shadow
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivPerson1.outlineProvider = CircularOutlineProvider()
            ivPerson2.outlineProvider = CircularOutlineProvider()
        }
    }

    //Set up client spinner adapter
    private fun setUpAdapter() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, clientList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerClients.adapter = adapter
    }
}