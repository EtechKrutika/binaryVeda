package com.example.binaryveda_test.register

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.binaryveda_test.R
import java.util.ArrayList

class RegisterViewModel(
    mcontext: Context?
) : ViewModel() {
    private var listMutableLiveData: MutableLiveData<List<DataModel>>? = null
    private var context: Context? = null

    init {
        listMutableLiveData = MutableLiveData()
        context = mcontext
    }

    fun getListMutableLiveData(): MutableLiveData<List<DataModel>>? {
        return listMutableLiveData
    }


    fun getViews() {
        val dataList: ArrayList<DataModel> = ArrayList<DataModel>()

        val iconlist: ArrayList<Int> = ArrayList<Int>()
        iconlist.add(R.drawable.ic_group)
        iconlist.add(R.drawable.ic_group2)
        iconlist.add(R.drawable.ic_group4)
        iconlist.add(R.drawable.ic_group14copy2)
        iconlist.add(R.drawable.ic_group7)
        iconlist.add(R.drawable.ic_bookmark)
        iconlist.add(R.drawable.ic_group14)
        iconlist.add(R.drawable.ic_group15)

        for (i in iconlist.indices) {
            val data = DataModel()
            data.images = iconlist[i]
            data.title = "lorem ipsum\nis used"
            data.subtitle = context?.getString(R.string.subtitle).toString()
            dataList.add(data)
        }

        listMutableLiveData?.setValue(dataList)
    }

}