package com.zjview.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;


@SuppressLint("AppCompatCustomView")
public class ZJCenterTextView extends TextView implements ZJView {


    private ZJCenterTextViewRenderProxy mSharpViewRenderProxy;

    public ZJCenterTextView(Context context) {
        this(context, null);
    }

    public ZJCenterTextView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ZJCenterTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mSharpViewRenderProxy = new ZJCenterTextViewRenderProxy(this, context, attrs, defStyleAttr);
        setGravity(Gravity.CENTER);
    }


    public ZJCenterTextViewRenderProxy getmSharpViewRenderProxy() {
        return mSharpViewRenderProxy;
    }
}
