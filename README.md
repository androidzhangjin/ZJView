# ZJView
不同方向的颜色渐变、圆角、边框

<img src="https://img-blog.csdnimg.cn/20210514114745247.jpg" width="350"/>

### 使用方法
在project 对应的build.gradle文件中添加
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io'}
    }
}
```

再添加依赖
```
implementation 'com.github.androidzhangjin:ZJView:v0.0.1'

```

布局示例：
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <com.zjview.library.ZJCenterTextView
        android:layout_width="80dp"
        android:layout_height="40dp"
        android:text="去完成"
        android:layout_marginTop="10dp"
        app:backgroundColor="#519B5F"
        app:radius="10dp"
        android:textColor="#ffffff"
        android:gravity="center"
        />

    <com.zjview.library.ZJCenterTextView
        android:layout_width="80dp"
        android:layout_height="40dp"
        android:text="待批改"
        android:layout_marginTop="10dp"
        app:backgroundColor="#B7D6BD"
        app:radius="10dp"
        android:gravity="center"
        />

    <com.zjview.library.ZJCenterTextView
        android:layout_width="80dp"
        android:layout_height="40dp"
        android:text="A+"
        android:layout_marginTop="10dp"
        app:radius="10dp"
        android:gravity="center"
        app:border="1dp"
        app:borderColor="#63A670"
        />

    <com.zjview.library.ZJCenterTextView
        android:layout_width="160dp"
        android:layout_height="40dp"
        android:text="水平渐变"
        android:layout_marginTop="10dp"
        app:radius="10dp"
        android:gravity="center"
        app:startBgColor="#3ACFC2"
        app:endBgColor="#91EFCB"
        />

    <com.zjview.library.ZJCenterTextView
        android:layout_width="140dp"
        android:layout_height="40dp"
        android:text="水平渐变"
        android:layout_marginTop="10dp"
        app:radius="20dp"
        android:gravity="center"
        app:startBgColor="#FFA900"
        app:endBgColor="#FFBA00"
        />

    <com.zjview.library.ZJRelativeLayout
        android:layout_width="200dp"
        android:layout_height="400dp"
        android:layout_marginTop="10dp"
        app:gradient_orientation="TOP_BOTTOM"
        android:gravity="center"
        app:startBgColor="#FCC673"
        app:endBgColor="#4857CF"
        />

</LinearLayout>
```
