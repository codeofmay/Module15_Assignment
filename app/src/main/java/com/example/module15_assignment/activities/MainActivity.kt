package com.example.module15_assignment.activities

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.module15_assignment.R
import com.example.module15_assignment.views.components.CircularOutlineProvider
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import kotlinx.android.synthetic.main.activity_create_task.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnBack
import kotlinx.android.synthetic.main.activity_main.btnCreateTask
import kotlinx.android.synthetic.main.activity_main.ivPerson1
import kotlinx.android.synthetic.main.activity_main.ivPerson2
import kotlinx.android.synthetic.main.bottom_sheet_profile.*
import kotlinx.android.synthetic.main.bottom_sheet_profile.btnClose


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    //Profile bottom sheet
    var bottomSheetProfile = BottomSheetBehavior<View>()
    private val profileTabList = listOf("Project Tasks", "Contacts", "About You")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()
        setUpBottomSheet()
        setUpListener()
        setUpTapLayout()
    }


    private fun setUpBottomSheet() {
        bottomSheetProfile = BottomSheetBehavior.from(bsProfile)
    }

    private fun setUpView() {

        //Set profile imageview shadow
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivPerson1.outlineProvider = CircularOutlineProvider()
            ivPerson2.outlineProvider = CircularOutlineProvider()
            ivPerson3.outlineProvider = CircularOutlineProvider()
        }
    }

    private fun setUpListener() {

        //Show profile bottom sheet
        ivPerson1.setOnClickListener {
            bottomSheetProfile.state = BottomSheetBehavior.STATE_EXPANDED
            vDimOverlay.visibility = View.VISIBLE
        }

        ivPerson2.setOnClickListener {
            bottomSheetProfile.state = BottomSheetBehavior.STATE_EXPANDED
            vDimOverlay.visibility = View.VISIBLE
        }

        ivPerson3.setOnClickListener {
            bottomSheetProfile.state = BottomSheetBehavior.STATE_EXPANDED
            vDimOverlay.visibility = View.VISIBLE
        }

        //Close profile bottom sheet
        btnClose.setOnClickListener {
            bottomSheetProfile.state = BottomSheetBehavior.STATE_COLLAPSED
            vDimOverlay.visibility = View.INVISIBLE
        }

        //Go to create task activity
        btnCreateTask.setOnClickListener {
            startActivity(CreateTaskActivity.newIntent(this))
        }

        //Back button listener
        btnBack.setOnClickListener {
            super.onBackPressed()
        }

        //Profile bottom sheet on state changed listener
        bottomSheetProfile.setBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    vDimOverlay.visibility = View.INVISIBLE
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })
        bottomSheetProfile.peekHeight = 0

    }

    //Setup profile tap layout inside profile bottom sheet
    private fun setUpTapLayout() {

        profileTabList.forEach {
            tabLayoutProfile.newTab().apply {
                text = it
                tabLayoutProfile.addTab(this)
            }
        }
    }
}