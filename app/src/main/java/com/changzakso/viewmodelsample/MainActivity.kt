package com.changzakso.viewmodelsample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.changzakso.viewmodelsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
// [1] 뷰모델 없이
//        var count = 100
//        binding.textView.text = count.toString()
//        binding.button.setOnClickListener {
//            count += 1
//            binding.textView.text = count.toString()
//        }

// [2] 뷰모델 초기화 없이 (onCreate가 호출 될때마다 초기값이 변경하기때문에 최초값 유지 필요)
//        val myViewModel : MyViewModel = ViewModelProvider(this)[MyViewModel::class.java]
//        myViewModel.counter = 100
//        binding.textView.text =  myViewModel.counter.toString()
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//        }
//

// [3] View모델 Factory를 통한 초기화 작업
// ViewModel 위한 Dependency
//        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
//
//        val factory = MyViewModelFactory(counter = 100)
//        val myViewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]
//        binding.textView.text =  myViewModel.counter.toString()
//
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//        }

        //[4] 초기화 위임을 통한 처리
        //    implementation("androidx.activity:activity-ktx:1.7.2")
        //    implementation("androidx.fragment:fragment-ktx:1.6.1") 필요

//        val factory = MyViewModelFactory(counter = 100)
//        val myViewModel : MyViewModel by viewModels<MyViewModel>(){
//            factory
//        }
//
//        binding.textView.text =  myViewModel.counter.toString()
//
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//        }


        //[5] savedState
        // 테스트 : adb shell am kill com.changzakso.viewmodelsample
//        val factory = MyViewModelFactory(counter = 100, this)
//        val myViewModel : MyViewModel by viewModels<MyViewModel>(){
//            factory
//        }
//
//        binding.textView.text =  myViewModel.counter.toString()
//
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//            myViewModel.saveState()
//        }

        //[6] live data 사용
//        val factory = MyViewModelFactory(counter = 100, this)
//        val myViewModel : MyViewModel by viewModels<MyViewModel>(){
//            factory
//        }
//
//        binding.textView.text =  myViewModel.counter.toString()
//
//        binding.button.setOnClickListener {
//            //값만 변경
//            myViewModel.liveCounter.value = myViewModel.liveCounter.value?.plus(1)
//        }
//
//        myViewModel.liveCounter.observe(this){count ->
//            //실제 화면 업데이트
//            //값 변경 감지
//            binding.textView.text = count.toString()
//        }

//[7]
        val factory = MyViewModelFactory(counter = 100, this)
        val myViewModel : MyViewModel by viewModels<MyViewModel>(){
            factory
        }

        binding.textView.text =  myViewModel.counter.toString()

        binding.button.setOnClickListener {
            //값만 변경
            myViewModel.liveCounter.value = myViewModel.liveCounter.value?.plus(1)
            myViewModel.saveState()
        }

        myViewModel.modifiedCounter.observe(this){count ->
            //실제 화면 업데이트
            //값 변경 감지
            binding.textView.text = count.toString()
        }
    }
}