package com.zjview.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;



public class ZJTextViewRenderProxy {
    public static final int TOP_BOTTOM = 0;
    public static final int TR_BL = 1;
    public static final int RIGHT_LEFT = 2;
    public static final int BR_TL = 3;
    public static final int BOTTOM_TOP = 4;
    public static final int BL_TR = 5;
    public static final int LEFT_RIGHT = 6;
    public static final int TL_BR = 7;
    private View mView;
    private int textGravity;
    private ZJTextView textView;

    public int getGradientOrientation() {
        return gradientOrientation;
    }

    public void setGradientOrientation(int gradientOrientation) {
        this.gradientOrientation = gradientOrientation;
    }

    private int gradientOrientation;


    public float getRadius() {
        return mRadius;
    }

    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    public float getRelativePosition() {
        return mRelativePosition;
    }

    public float getSharpSize() {
        return mSharpSize;
    }

    public float getBorder() {
        return mBorder;
    }

    public int getBorderColor() {
        return mBorderColor;
    }

    public int[] getBgColors() {
        return mBgColors;
    }

    public float[] getCornerRadii() {
        return mCornerRadii;
    }

    public ZJView.ArrowDirection getArrowDirection() {
        return mArrowDirection;
    }

    private float mRadius;

    private int mBackgroundColor;

    private float mRelativePosition;

    private float mSharpSize;

    private float mBorder;

    private int mBorderColor;

    public void setBgColor(int[] bgColor) {
        mBgColors = bgColor;
        refreshView();
    }

    private int[] mBgColors;

    public void setCornerRadii(float leftTop, float rightTop, float rightBottom, float leftBottom) {
        mCornerRadii[0] = leftTop;
        mCornerRadii[1] = leftTop;
        mCornerRadii[2] = rightTop;
        mCornerRadii[3] = rightTop;
        mCornerRadii[4] = rightBottom;
        mCornerRadii[5] = rightBottom;
        mCornerRadii[6] = leftBottom;
        mCornerRadii[7] = leftBottom;

    }

    private float[] mCornerRadii = new float[8];

    private ZJView.ArrowDirection mArrowDirection = ZJView.ArrowDirection.LEFT;

    public void setBorder(float border) {
        mBorder = border;
        refreshView();
    }

    public void setBorderColor(int borderColor) {
        mBorderColor = borderColor;
        refreshView();
    }

    ZJTextViewRenderProxy(View view, Context context, AttributeSet attrs, int defStyleAttr) {
        mView = view;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ZJTextView, defStyleAttr, 0);
        mRadius = typedArray.getDimension(R.styleable.ZJTextView_radius, 0);
        mCornerRadii[0] = mCornerRadii[1] = typedArray.getDimension(R.styleable.ZJTextView_left_top_radius, 0);
        mCornerRadii[2] = mCornerRadii[3] = typedArray.getDimension(R.styleable.ZJTextView_right_top_radius, 0);
        mCornerRadii[4] = mCornerRadii[5] = typedArray.getDimension(R.styleable.ZJTextView_right_bottom_radius, 0);
        mCornerRadii[6] = mCornerRadii[7] = typedArray.getDimension(R.styleable.ZJTextView_left_bottom_radius, 0);
        mBorder = typedArray.getDimension(R.styleable.ZJTextView_border, 0);
        mBackgroundColor = typedArray.getColor(R.styleable.ZJTextView_backgroundColor, 0);
        mBorderColor = typedArray.getColor(R.styleable.ZJTextView_borderColor, 0);
        int direction = typedArray.getInt(R.styleable.ZJTextView_arrowDirection, 3);
        mRelativePosition = typedArray.getFraction(R.styleable.ZJTextView_relativePosition, 1, 1, 0.5f);
        mSharpSize = typedArray.getDimension(R.styleable.ZJTextView_sharpSize, 0);
        textGravity = typedArray.getInt(R.styleable.ZJTextView_android_gravity, Gravity.CENTER);

        gradientOrientation = typedArray.getInt(R.styleable.ZJTextView_gradient_orientation, 6);
        switch (direction) {
            case 1:
                mArrowDirection = ZJView.ArrowDirection.LEFT;
                break;
            case 2:
                mArrowDirection = ZJView.ArrowDirection.TOP;
                break;
            case 3:
                mArrowDirection = ZJView.ArrowDirection.RIGHT;
                break;
            case 4:
                mArrowDirection = ZJView.ArrowDirection.BOTTOM;
                break;
        }
        int start = typedArray.getColor(R.styleable.ZJTextView_startBgColor, -1);
        int middle = typedArray.getColor(R.styleable.ZJTextView_middleBgColor, -1);
        int end = typedArray.getColor(R.styleable.ZJTextView_endBgColor, -1);
        if (start != -1 && end != -1) {
            if (middle != -1) {
                mBgColors = new int[]{start, middle, end};
            } else {
                mBgColors = new int[]{start, end};
            }
        }
        typedArray.recycle();
        refreshView();
    }

    ZJDrawable mSharpDrawable;

    private void refreshView() {
        ZJDrawable bd = new ZJDrawable(GradientDrawable.Orientation.LEFT_RIGHT, null);
        mSharpDrawable = bd;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            bd.setColors(mBgColors);
            switch (gradientOrientation) {
                case TOP_BOTTOM:
                    bd.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                    break;
                case TR_BL:
                    bd.setOrientation(GradientDrawable.Orientation.TR_BL);
                    break;
                case RIGHT_LEFT:
                    bd.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
                    break;
                case BR_TL:
                    bd.setOrientation(GradientDrawable.Orientation.BR_TL);
                    break;
                case BOTTOM_TOP:
                    bd.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                    break;
                case BL_TR:
                    bd.setOrientation(GradientDrawable.Orientation.BL_TR);
                    break;
                case LEFT_RIGHT:
                    bd.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    break;
                case TL_BR:
                    bd.setOrientation(GradientDrawable.Orientation.TL_BR);
                    break;
            }
        } else {
            bd.setColor(mBgColors[0]);
        }

        if (mBgColors != null) {
            bd.setColors(mBgColors);
        } else {
            bd.setBgColor(mBackgroundColor);
        }
        bd.setSharpSize(mSharpSize);
        bd.setArrowDirection(mArrowDirection);
        bd.setCornerRadius(mRadius);
        bd.setBorder(mBorder);
        bd.setBorderColor(mBorderColor);
        bd.setRelativePosition(mRelativePosition);
        if (mRadius == 0) {
            bd.setCornerRadii(mCornerRadii);
        }

        mView.setBackground(bd);
       textView = (ZJTextView) mView;
        textView.setGravity(textGravity);
    }

    public void setRadius(float radius) {
        mRadius = radius;
        refreshView();
    }

    public void setBackgroundColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
        mBgColors = null;
        refreshView();
    }

    public void setRelativePosition(float relativePosition) {
        mRelativePosition = relativePosition;
        refreshView();
    }

    public void setSharpSize(float sharpSize) {
        mSharpSize = sharpSize;
        refreshView();
    }

    public void setArrowDirection(ZJView.ArrowDirection arrowDirection) {
        mArrowDirection = arrowDirection;
        refreshView();
    }


}
