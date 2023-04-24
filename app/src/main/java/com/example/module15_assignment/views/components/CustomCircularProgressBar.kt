package com.example.module15_assignment.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.example.module15_assignment.R

private var borderColor = 0
private var backgroundColor = 0
private var progressColor = 0

private var borderWidth = 0f
private var size = 0
private var progress = 0

lateinit var backgroundPaint: Paint

lateinit var borderPaint: Paint

lateinit var progressIndicatorPaint: Paint

lateinit var progressTextPaint: Paint


class CustomCircularProgressBar(context: Context?, attrs: AttributeSet?) : View(context, attrs) {


    init {
        context?.let {
            setUpVariables(context, attrs)
        }
    }

    private fun setUpVariables(context: Context, attrs: AttributeSet?) {
        borderColor = ContextCompat.getColor(context, R.color.colorAccentLight)
        backgroundColor = ContextCompat.getColor(context, R.color.colorPrimary)
        progressColor = ContextCompat.getColor(context, R.color.colorAccent)

        borderWidth = 9f
        size = 64
        progress = 0

        backgroundPaint = Paint().apply {
            isAntiAlias = true
            style = Paint.Style.FILL
            color = backgroundColor

        }

        borderPaint = Paint().apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            strokeWidth = borderWidth
            color = borderColor
        }

        progressIndicatorPaint = Paint().apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            strokeWidth = borderWidth
            color = progressColor
            strokeCap = Paint.Cap.ROUND

        }

        progressTextPaint = Paint().apply {
            isAntiAlias = true
            color = progressColor
            textAlign = Paint.Align.CENTER
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
            textSize = 40f

        }

        //Custom Attribute
        context.withStyledAttributes(attrs, R.styleable.CustomCircularProgressBar) {
            progress = getInt(R.styleable.CustomCircularProgressBar_circularProgress, progress)
        }
    }

    override fun onDraw(canvas: Canvas?) {

        drawBackground(canvas)
        drawProgressIndicator(canvas)
        drawProgressText(canvas)

        super.onDraw(canvas)
    }

    private fun drawBackground(canvas: Canvas?) {

        val radius = size / 2f
        canvas?.drawCircle(size / 2f, size / 2f, radius, backgroundPaint)
    }


    private fun drawProgressIndicator(canvas: Canvas?) {

        val temp = size / 2f
        val radius = temp - borderWidth / 2f
        val x = width / 2f
        val y = height / 2f

        // Draw border
        canvas?.drawArc(
            x - radius, y - radius, x + radius, y + radius,
            0f, 360f, false, borderPaint
        )

        // Draw the progress
        canvas?.drawArc(
            x - radius, y - radius, x + radius, y + radius,
            -90f, 360f * progress / 100f, false, progressIndicatorPaint
        )

    }

    private fun drawProgressText(canvas: Canvas?) {

        val label = "$progress%"
        val y = size / 2 - (progressTextPaint.descent() + progressTextPaint.ascent()) / 2
        canvas?.drawText(label, size / 2f, y, progressTextPaint)
    }

    //Responsive
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size, size)
    }

}