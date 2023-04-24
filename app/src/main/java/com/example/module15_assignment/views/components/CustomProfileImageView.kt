package com.example.module15_assignment.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.example.module15_assignment.R

class CustomProfileImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

    private var cornerRadius = 0f
    private val path = Path()

    private val borderColor = Color.WHITE
    private val borderWidth = 10f
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        context.withStyledAttributes(attrs, R.styleable.CustomProfileImageView) {
            cornerRadius =
                getDimension(R.styleable.CustomProfileImageView_cornerRadius, cornerRadius)
            setLayerType(LAYER_TYPE_SOFTWARE, null)

        }
    }

    override fun onDraw(canvas: Canvas?) {

        //Draw Circle Image View
        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())
        path.addRoundRect(rectangle, cornerRadius, cornerRadius, Path.Direction.CCW)
        canvas?.clipPath(path)
        super.onDraw(canvas)

        //Draw border
        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
        paint.isAntiAlias = true

        val radius = (width / 2f) - (borderWidth / 2f)
        canvas?.drawCircle(width / 2f, height / 2f, radius + 0.8f, paint)
    }
}