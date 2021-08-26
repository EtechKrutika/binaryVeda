package com.example.binaryveda_test.register

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.util.Supplier
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.binaryveda_test.BR
import com.example.binaryveda_test.R
import com.example.binaryveda_test.ViewModelProviderFactory
import com.example.binaryveda_test.base.BaseActivity
import com.example.binaryveda_test.databinding.ActivityMainBinding
import com.example.binaryveda_test.profile.ProfileActivity

class MainActivity : BaseActivity<ActivityMainBinding, RegisterViewModel>() {
    lateinit var binding: ActivityMainBinding
    var mContext: Context? = null
    var mActivity: Activity? = null
    var adapter: RegisterOptionAdapter? = null


    fun init() {
        performDependencyInjection()
        mViewModel.getViews()
        initObserver()
        initListener()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = viewDataBinding
        mContext = this
        mActivity = this
        init()
    }

    fun initObserver() {
        mViewModel.getListMutableLiveData()?.observe(this, Observer {
            adapter = RegisterOptionAdapter(it, mContext)
            binding.rvData.adapter = adapter
        })
    }


    override fun getBindingVariable(): Int {
        return BR.registerviewmodel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main;
    }

    override fun performDependencyInjection() {
        val supplier =
            Supplier { RegisterViewModel(this) }
        val factory = ViewModelProviderFactory(
            RegisterViewModel::class.java, supplier
        )
        mViewModel = ViewModelProvider(this, factory).get(
            RegisterViewModel::class.java
        )
    }

    fun initListener() {
        binding.llRegister.setOnClickListener(View.OnClickListener {

            val gotoProfile = Intent(mContext, ProfileActivity::class.java)
            startActivity(gotoProfile)

        })
    }
}


