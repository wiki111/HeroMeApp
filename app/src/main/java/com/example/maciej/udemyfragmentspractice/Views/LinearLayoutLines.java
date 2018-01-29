package com.example.maciej.udemyfragmentspractice.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.maciej.udemyfragmentspractice.R;

/**
 * TODO: document your custom view class.
 */
public class LinearLayoutLines extends LinearLayout {

    private Paint mCirclePaint;
    private Paint mLinePaint;
    private Path mPath;

    public LinearLayoutLines(Context context) {
        super(context);
        initPaint();
        //init(null, 0);
    }

    public LinearLayoutLines(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        //init(attrs, 0);
    }

    public LinearLayoutLines(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
        //init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes

       /* final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.LinearLayoutLines, defStyle, 0);

        mExampleString = a.getString(
                R.styleable.LinearLayoutLines_exampleString);
        mExampleColor = a.getColor(
                R.styleable.LinearLayoutLines_exampleColor,
                mExampleColor);
        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
        // values that should fall on pixel boundaries.
        mExampleDimension = a.getDimension(
                R.styleable.LinearLayoutLines_exampleDimension,
                mExampleDimension);

        if (a.hasValue(R.styleable.LinearLayoutLines_exampleDrawable)) {
            mExampleDrawable = a.getDrawable(
                    R.styleable.LinearLayoutLines_exampleDrawable);
            mExampleDrawable.setCallback(this);
        }

        a.recycle();

        // Set up a default TextPaint object
        mTextPaint = new TextPaint();
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextAlign(Paint.Align.LEFT);

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
        */
    }

    private void invalidateTextPaintAndMeasurements() {

      /*  mTextPaint.setTextSize(mExampleDimension);
        mTextPaint.setColor(mExampleColor);
        mTextWidth = mTextPaint.measureText(mExampleString);

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        mTextHeight = fontMetrics.bottom;*/

    }

    private void initPaint(){
        Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setColor(getResources().getColor(R.color.whiteDraw));
        circlePaint.setStrokeWidth(getResources().getDimensionPixelSize(R.dimen.circle_stroke_width));
        mCirclePaint = circlePaint;

        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(getResources().getColor(R.color.whiteDraw));
        linePaint.setStrokeWidth(getResources().getDimensionPixelSize(R.dimen.circle_stroke_width));
        linePaint.setStrokeJoin(Paint.Join.ROUND);
        linePaint.setPathEffect(new CornerPathEffect(
                getResources().getDimensionPixelSize(R.dimen.line_connect_radius)
        ));
        mLinePaint = linePaint;



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(
                getResources().getDimensionPixelSize(R.dimen.circle_left_space),
                getResources().getDimensionPixelSize(R.dimen.circle_top_space),
                getResources().getDimensionPixelSize(R.dimen.circle_radius),
                mCirclePaint);

        int[] firstItemGroupPosition = new int[2];
        this.findViewById(R.id.firstItemGroup).getLocationInWindow(firstItemGroupPosition);
        int firstItemGroupWidth = this.findViewById(R.id.firstItemGroup).getWidth();
        int firstItemGroupHeight = this.findViewById(R.id.firstItemGroup).getHeight();

        int[] secondItemGroupPosition = new int[2];
        this.findViewById(R.id.secondItemGroup).getLocationInWindow(secondItemGroupPosition);
        int secondItemGroupWidth = this.findViewById(R.id.secondItemGroup).getWidth();
        int secondItemGroupHeight = this.findViewById(R.id.secondItemGroup).getHeight();

        int[] thirdItemGroupPosition = new int[2];
        this.findViewById(R.id.thirdItemGroup).getLocationInWindow(thirdItemGroupPosition);
        int thirdItemGroupHeight = this.findViewById(R.id.thirdItemGroup).getHeight();

        int secondLevel = getResources().getDimensionPixelSize(R.dimen.first_line_start_y)
                + firstItemGroupHeight
                + getResources().getDimensionPixelSize(R.dimen.second_level_margin);

        int thirdLevel = secondLevel
                + secondItemGroupHeight
                + getResources().getDimensionPixelSize(R.dimen.second_level_margin)
                + getResources().getDimensionPixelSize(R.dimen.third_level_margin);

        int fourthLevel = thirdLevel
                + thirdItemGroupHeight
                + getResources().getDimensionPixelSize(R.dimen.third_level_margin)
                + getResources().getDimensionPixelSize(R.dimen.third_level_margin);

        Path linePath = new Path();
        linePath.moveTo(
                getResources().getDimensionPixelSize(R.dimen.first_line_start_x),
                getResources().getDimensionPixelSize(R.dimen.first_line_start_y)
        );
        linePath.lineTo(
                getResources().getDimensionPixelSize(R.dimen.first_line_start_x) + firstItemGroupWidth - 2 * getResources().getDimensionPixelSize(R.dimen.line_margin),
                getResources().getDimensionPixelSize(R.dimen.first_line_start_y)
        );
        linePath.lineTo(
                getResources().getDimensionPixelSize(R.dimen.first_line_start_x) + firstItemGroupWidth - 2 * getResources().getDimensionPixelSize(R.dimen.line_margin),
                secondLevel
        );
        linePath.lineTo(
                getResources().getDimensionPixelSize(R.dimen.first_line_start_x) - getResources().getDimensionPixelSize(R.dimen.line_margin),
                secondLevel
        );
        linePath.lineTo(
                getResources().getDimensionPixelSize(R.dimen.first_line_start_x) - getResources().getDimensionPixelSize(R.dimen.line_margin),
                thirdLevel
        );
        linePath.lineTo(
                getResources().getDimensionPixelSize(R.dimen.first_line_start_x) + firstItemGroupWidth - 2 * getResources().getDimensionPixelSize(R.dimen.line_margin) ,
                thirdLevel
        );
        linePath.lineTo(
                getResources().getDimensionPixelSize(R.dimen.first_line_start_x) + firstItemGroupWidth - 2 * getResources().getDimensionPixelSize(R.dimen.line_margin) ,
                fourthLevel
        );
        linePath.lineTo(
                getResources().getDimensionPixelSize(R.dimen.first_line_start_x),
                fourthLevel
        );

        canvas.drawPath(linePath, mLinePaint);

/*
        canvas.drawLine(
                getResources().getDimensionPixelSize(R.dimen.first_line_start_x),
                getResources().getDimensionPixelSize(R.dimen.first_line_start_y),
                firstItemGroupPosition[0] + firstItemGroupWidth + getResources().getDimensionPixelSize(R.dimen.line_margin),
                getResources().getDimensionPixelSize(R.dimen.first_line_start_y),
                mLinePaint
        );*/



        canvas.drawCircle(
                getResources().getDimensionPixelSize(R.dimen.circle_left_space),
                fourthLevel,
                getResources().getDimensionPixelSize(R.dimen.circle_radius),
                mCirclePaint
        );

        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
/*
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        // Draw the text.
        canvas.drawText(mExampleString,
                paddingLeft + (contentWidth - mTextWidth) / 2,
                paddingTop + (contentHeight + mTextHeight) / 2,
                mTextPaint);

        // Draw the example drawable on top of the text.
        if (mExampleDrawable != null) {
            mExampleDrawable.setBounds(paddingLeft, paddingTop,
                    paddingLeft + contentWidth, paddingTop + contentHeight);
            mExampleDrawable.draw(canvas);
        }
*/
    }

    /**
     * Gets the example string attribute value.
     *
     * @return The example string attribute value.
     */
   /* public String getExampleString() {
        return mExampleString;
    } */

    /**
     * Sets the view's example string attribute value. In the example view, this string
     * is the text to draw.
     *
     * @param exampleString The example string attribute value to use.
     */
   /* public void setExampleString(String exampleString) {
        mExampleString = exampleString;
        invalidateTextPaintAndMeasurements();
    }*/

    /**
     * Gets the example color attribute value.
     *
     * @return The example color attribute value.
     */
    /*public int getExampleColor() {
        return mExampleColor;
    }*/

    /**
     * Sets the view's example color attribute value. In the example view, this color
     * is the font color.
     *
     * @param exampleColor The example color attribute value to use.
     */
   /* public void setExampleColor(int exampleColor) {
        mExampleColor = exampleColor;
        invalidateTextPaintAndMeasurements();
    }*/

    /**
     * Gets the example dimension attribute value.
     *
     * @return The example dimension attribute value.
     */
    /*public float getExampleDimension() {
        return mExampleDimension;
    }*/

    /**
     * Sets the view's example dimension attribute value. In the example view, this dimension
     * is the font size.
     *
     * @param exampleDimension The example dimension attribute value to use.
     */
    /*public void setExampleDimension(float exampleDimension) {
        mExampleDimension = exampleDimension;
        invalidateTextPaintAndMeasurements();
    }*/

    /**
     * Gets the example drawable attribute value.
     *
     * @return The example drawable attribute value.
     */
   /* public Drawable getExampleDrawable() {
        return mExampleDrawable;
    }*/

    /**
     * Sets the view's example drawable attribute value. In the example view, this drawable is
     * drawn above the text.
     *
     * @param exampleDrawable The example drawable attribute value to use.
     */
   /* public void setExampleDrawable(Drawable exampleDrawable) {
        mExampleDrawable = exampleDrawable;
    }*/
}
