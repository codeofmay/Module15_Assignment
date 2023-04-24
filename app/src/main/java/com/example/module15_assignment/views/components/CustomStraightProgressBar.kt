package com.example.module15_assignment.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.example.module15_assignment.R

private var lineColor = 0
private var progressColor = 0
private var strokeWidth1 = 0f
private var progress = 0

private val linePaint = Paint()
private val progressPaint = Paint()

class CustomStraightProgressBar(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    init {
        context?.let {
            setUpVariables(context, attrs)
        }
    }

    private fun setUpVariables(context: Context, attrs: AttributeSet?) {

        lineColor = ContextCompat.getColor(context, R.color.colorCyanLight)
        progressColor = ContextCompat.getColor(context, R.color.colorCyan)
        strokeWidth1 = 20f

        linePaint.apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            strokeWidth = strokeWidth1
            color = lineColor

        }
        progressPaint.apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            strokeWidth = strokeWidth1
            color = progressColor
        }


        //Custom Attributes
        context.withStyledAttributes(attrs, R.styleable.CustomStraightProgressBar) {
            progress = getInt(R.styleable.CustomStraightProgressBar_straightProgress, progress)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        drawStraightProgressBar(canvas)
        super.onDraw(canvas)
    }

    private fun drawStraightProgressBar(canvas: Canvas?) {

        val startX = 0f
        val startY = 0f
        val stopX = (width - strokeWidth1 / 2f) * progress / 100
        val stopY = 0f

        //Draw bottom Line
        canvas?.drawLine(stopX, stopY, width - strokeWidth1 / 2f, stopY, linePaint)

        //Draw Progress Bar
        canvas?.drawLine(startX, startY, stopX, stopY, progressPaint)
    }

}