package com.cnm.shw.preference

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PreferenceViewModel : ViewModel() {
    private var a: MutableLiveData<List<Int>> = MutableLiveData(listOf(0, 0, 0))

    fun getNum() = a
    fun updateNum(num: Int, index: Int): String {
        when (index) {
            1 -> {
                Log.e("1",a.value?.get(0).toString())
                a.value = listOf(num, a.value!![1], a.value!![2])
                return a.value?.get(0).toString()
            }
            2 -> {
                a.value = listOf(a.value!![0], num, a.value!![2])
                return a.value?.get(1).toString()
            }
            3 -> {
                a.value = listOf(a.value!![0], a.value!![1], num)
                return a.value?.get(2).toString()
            }
        }
        return "1"
    }
}