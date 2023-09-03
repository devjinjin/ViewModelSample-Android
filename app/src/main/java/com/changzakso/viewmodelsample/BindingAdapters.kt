package com.changzakso.viewmodelsample

import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

//[8] Databinding UI값 업데이트 처리

//@BindingAdapter("app:progressScaled")
//fun setProgress(progressBar: ProgressBar, counter:Int){
//    progressBar.progress = counter
//}

@BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
fun setProgress(progressBar: ProgressBar, counter:Int, max: Int){
    progressBar.progress = (counter * 2).coerceAtMost(max)
}