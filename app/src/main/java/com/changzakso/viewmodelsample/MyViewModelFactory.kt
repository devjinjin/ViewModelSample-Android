package com.changzakso.viewmodelsample

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import java.lang.IllegalArgumentException

//[2][3][4]
//@Suppress("UNCHECKED_CAST")
//class MyViewModelFactory(private val counter:Int ) : ViewModelProvider.Factory{
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(MyViewModel::class.java)){
//            return MyViewModel(counter) as T
//        }
//        throw IllegalArgumentException("viewmdoel class not found")
//    }
//}
//


//[5] savedState 추가
@Suppress("UNCHECKED_CAST")
class MyViewModelFactory(
    private val counter:Int,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null,
) : AbstractSavedStateViewModelFactory(owner, defaultArgs){

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if(modelClass.isAssignableFrom(MyViewModel::class.java)){
            return MyViewModel(counter, handle) as T
        }
        throw IllegalArgumentException("viewmdoel class not found")
    }
}
