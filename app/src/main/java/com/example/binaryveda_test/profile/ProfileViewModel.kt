package com.example.binaryveda_test.profile

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.binaryveda_test.R
import com.example.binaryveda_test.register.DataModel
import java.util.ArrayList

class ProfileViewModel(
    mcontext: Context?
) : ViewModel() {
    private var listMutableLiveData: MutableLiveData<List<String>>? = null
    private var context: Context? = null

    init {
        listMutableLiveData = MutableLiveData()
        context = mcontext
    }

    fun getListMutableLiveData(): MutableLiveData<List<String>>? {
        return listMutableLiveData
    }


    fun getViews() {
        val dataList: ArrayList<String> = ArrayList<String>()

        dataList.add("https://i.pinimg.com/236x/02/6b/ed/026beda75b25187e55a9244fba97d80d--lavandula-lavender.jpg")
        dataList.add("https://i.pinimg.com/originals/06/b9/36/06b93675904b7919d423fb4d06922eb7.jpg")
        dataList.add("https://i.pinimg.com/originals/06/b9/36/06b93675904b7919d423fb4d06922eb7.jpg")
        dataList.add("https://i.pinimg.com/236x/02/6b/ed/026beda75b25187e55a9244fba97d80d--lavandula-lavender.jpg")

        listMutableLiveData?.setValue(dataList)
    }

}