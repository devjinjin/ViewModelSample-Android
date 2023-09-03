package com.changzakso.viewmodelsample

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

//[2][3][4] 초기화 위임을 통한 처리 까지
//class MyViewModel(initCounter : Int) : ViewModel() {
//    var counter : Int = initCounter
//}

//[5] savedState 추가
class MyViewModel(
    initCounter : Int,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var counter : Int = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: initCounter

    fun saveState(){
        savedStateHandle[SAVE_STATE_KEY] = counter
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
    }
}