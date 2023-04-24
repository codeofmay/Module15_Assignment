package com.example.module15_assignment.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.example.module15_assignment.R

class CustomCircleImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

    private var cornerRadius = 0f
    private val path = Path()

    init {
        context.withStyledAttributes(attrs, R.styleable.CustomCircleImageView) {
            cornerRadius =
                getDimension(R.styleable.CustomCircleImageView_cornerRadius1, cornerRadius)

        }
    }

    override fun onDraw(canvas: Canvas?) {

        //Draw Circle Image View
        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())
        path.addRoundRect(rectangle, cornerRadius, cornerRadius, Path.Direction.CCW)
        canvas?.clipPath(path)
        super.onDraw(canvas)
    }
}