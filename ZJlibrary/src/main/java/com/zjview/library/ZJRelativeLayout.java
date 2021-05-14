package com.zjview.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

@SuppressLint("AppCompatCustomView")
public class ZJRelativeLayout extends RelativeLayout implements ZJView {


    public ZJViewRenderProxy getmSharpViewRenderProxy() {
        return mSharpViewRenderProxy;
    }

    private ZJViewRenderProxy mSharpViewRenderProxy;

    public ZJRelativeLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ZJRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ZJRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mSharpViewRenderProxy = new ZJViewRenderProxy(this, context, attrs, defStyleAttr);
    }

}
