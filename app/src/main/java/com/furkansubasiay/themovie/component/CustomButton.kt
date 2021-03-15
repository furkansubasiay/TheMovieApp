package com.furkansubasiay.themovie.component

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import com.furkansubasiay.themovie.R

/**
 * Created by FURKAN SUBAŞIAY on 14.03.2021.
 */
class CustomButton constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    AppCompatButton(context, attrs, defStyleAttr) {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        init(context, attrs)
    }

    private val paint = Paint()

    private var buttonWidth = 0
    private var buttonHeight = 0

    private var buttonTextColor = 0
    private var buttonBackgroundColor = 0
    private var buttonPressedColor = ContextCompat.getColor(context, R.color.button_press)
    private var buttonBorderColor = 0
    private var buttonCornerRadius: Float =16f
    private var buttonIconStart: Drawable? = null

    private lateinit var gradientDrawable: GradientDrawable


    private fun init(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomButton)
        buttonTextColor = typedArray.getColor(
            R.styleable.CustomButton_fillTextColor,
            ContextCompat.getColor(context, R.color.green)
        )

        buttonBackgroundColor = typedArray.getColor(
            R.styleable.CustomButton_fillBackgroundColor,
            ContextCompat.getColor(context, R.color.bg_button)
        )

        buttonBorderColor = typedArray.getColor(
            R.styleable.CustomButton_fillBorderColor,
            ContextCompat.getColor(context, R.color.button_border)
        )
        buttonCornerRadius = typedArray.getFloat(R.styleable.CustomButton_fillCornerRadius, 16f)

        typedArray.recycle()

        this.isClickable = true
        this.setTextColor(buttonTextColor)
        this.textSize=16.0f
        this.gravity = Gravity.CENTER
        this.setPadding(32)
        initPaint()
        initDrawable()
    }


    private fun initPaint() {
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = buttonBackgroundColor
        paint.isAntiAlias = true
    }

    private fun initDrawable() {
        gradientDrawable = GradientDrawable()
        gradientDrawable.shape = GradientDrawable.RECTANGLE
        gradientDrawable.cornerRadius =buttonCornerRadius
        updateButtonColor()
    }

    private fun updateButtonColor(pressed: Boolean = false) {
        gradientDrawable.apply {
            when {
                pressed -> {
                    setColor(buttonPressedColor)
                    setStroke(3, buttonBorderColor, 20.0f, 20.0f)
                }
                else -> {
                    setColor(buttonBackgroundColor)
                    setStroke(3, buttonBorderColor, 20.0f, 20.0f)
                }
            }
        }
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        buttonWidth = width
        buttonHeight = height
        this.background = gradientDrawable

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        super.onTouchEvent(event)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                updateButtonColor(true)
                return true
            }

            MotionEvent.ACTION_UP -> {
                updateButtonColor()
                return true
            }
        }

        return false
    }
}
