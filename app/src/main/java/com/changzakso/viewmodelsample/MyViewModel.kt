package com.changzakso.viewmodelsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

//[2][3][4] 초기화 위임을 통한 처리 까지
//class MyViewModel(initCounter : Int) : ViewModel() {
//    var counter : Int = initCounter
//}

//[5] savedState 추가
//class MyViewModel(
//    initCounter : Int,
//    private val savedStateHandle: SavedStateHandle
//) : ViewModel() {
//    var counter : Int = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: initCounter
//
//    fun saveState(){
//        savedStateHandle[SAVE_STATE_KEY] = counter
//    }
//
//    companion object {
//        private const val SAVE_STATE_KEY = "counter"
//    }
//}

//[6] livedata 추가
//class MyViewModel(
//    initCounter : Int,
//    private val savedStateHandle: SavedStateHandle
//) : ViewModel() {
//
//    var liveCounter : MutableLiveData<Int> = MutableLiveData(initCounter)
//
//    var counter : Int = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: initCounter
//
//
//    fun saveState(){
//        savedStateHandle[SAVE_STATE_KEY] = counter
//    }
//
//    companion object {
//        private const val SAVE_STATE_KEY = "counter"
//    }
//}

//[7]
class MyViewModel(
    initCounter : Int,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val liveCounter : MutableLiveData<Int> = MutableLiveData(initCounter)

    //Transformations (2.6.0 부터는 사용못함)
    val modifiedCounter : LiveData<String> = liveCounter.map { counter ->
        "$counter 입니다"
    }
    var counter : Int = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: initCounter

    //[9] two way data binding
    val hasChecked : MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)

    fun saveState(){
        savedStateHandle[SAVE_STATE_KEY] = counter
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
    }
}