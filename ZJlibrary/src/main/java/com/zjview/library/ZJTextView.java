package com.zjview.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;


@SuppressLint("AppCompatCustomView")
public class ZJTextView extends TextView implements ZJView {


    private ZJTextViewRenderProxy mSharpViewRenderProxy;

    public ZJTextView(Context context) {
        this(context, null);
    }

    public ZJTextView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ZJTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mSharpViewRenderProxy = new ZJTextViewRenderProxy(this, context, attrs, defStyleAttr);
    }


    public ZJTextViewRenderProxy getmSharpViewRenderProxy() {
        return mSharpViewRenderProxy;
    }
}
