package com.example.binaryveda_test.profile

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.binaryveda_test.BR
import com.example.binaryveda_test.R
import com.example.binaryveda_test.base.BaseFragment
import com.example.binaryveda_test.databinding.FragmentUploadBinding


class UploadFragment :
    BaseFragment<FragmentUploadBinding, ProfileViewModel>() {
    @Transient
    public var mContext: Context? = null
    var position = 0;
    var isPause = false
    lateinit var fragmentUploadBinding: FragmentUploadBinding
    var gridLayoutManager: GridLayoutManager? = null
    var adapter: UploadImgAdapter? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentUploadBinding = viewDataBinding
        mContext = requireContext()
        performDependencyInjection()
        init()
    }

    companion object {
        const val ARG_POSITION = "position"
        fun getInstance(position: Int): Fragment {
            val doppelgangerFragment = UploadFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_POSITION, position)
            doppelgangerFragment.arguments = bundle
            return doppelgangerFragment
        }
    }

    override fun getBindingVariable(): Int {
        return BR.uploadViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_upload
    }

    override fun performDependencyInjection() {

        mViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)

    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun initObserver() {
        mViewModel.getViews()
        mViewModel.getListMutableLiveData()?.observe(viewLifecycleOwner, Observer {
            adapter = UploadImgAdapter(it, mContext)
            fragmentUploadBinding.rvLectureList.adapter = adapter
            adapter!!.notifyDataSetChanged()
        })
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun init() {
        gridLayoutManager = GridLayoutManager(mContext, 2)

        fragmentUploadBinding.rvLectureList.setLayoutManager(gridLayoutManager)
        fragmentUploadBinding.rvLectureList.getLayoutManager()?.setAutoMeasureEnabled(false)
        initObserver()
    }

    override fun onResume() {
        super.onResume()
        if (isPause) {
            isPause = false
        }
    }

    override fun onPause() {
        isPause = true
        super.onPause()
    }
}
