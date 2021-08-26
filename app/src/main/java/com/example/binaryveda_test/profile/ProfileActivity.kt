package com.example.binaryveda_test.profile

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.util.Supplier
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.binaryveda_test.BR
import com.example.binaryveda_test.R
import com.example.binaryveda_test.ViewModelProviderFactory
import com.example.binaryveda_test.base.BaseActivity
import com.example.binaryveda_test.databinding.ActivityProfileBinding
import java.util.ArrayList
import android.view.LayoutInflater

import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import android.graphics.PorterDuff
import android.widget.LinearLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.textview.MaterialTextView


class ProfileActivity : BaseActivity<ActivityProfileBinding, ProfileViewModel>() {
    lateinit var binding: ActivityProfileBinding
    var mContext: Context? = null
    var mActivity: Activity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = viewDataBinding
        mContext = this
        mActivity = this
        init()
    }

    override fun getBindingVariable(): Int {
        return BR.profilemodel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_profile;
    }

    override fun performDependencyInjection() {
        val supplier =
            Supplier { ProfileViewModel(this) }
        val factory = ViewModelProviderFactory(
            ProfileViewModel::class.java, supplier
        )
        mViewModel = ViewModelProvider(this, factory).get(
            ProfileViewModel::class.java
        )
    }

    fun init() {
        performDependencyInjection()
        binding.tab.setupWithViewPager(binding.vpTab);
        setupViewPager(binding.vpTab)
        setupTabIcons();
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(UploadFragment(), "Uploads")
        adapter.addFrag(UploadFragment(), "Exhibitions")
        adapter.addFrag(UploadFragment(), "Revenue")
        viewPager.adapter = adapter
    }

    internal class ViewPagerAdapter(manager: FragmentManager?) :
        FragmentPagerAdapter(manager!!) {
        private val mFragmentList: MutableList<Fragment> = ArrayList<Fragment>()
        private val mFragmentTitleList: MutableList<String> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFrag(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }

    private fun setupTabIcons() {


        val tabsTitles = arrayOf(
            "Uploads",
            "Exhibitions",
            "Revenue"
        )

        val tabsIcons = intArrayOf(
            R.drawable.ic_tab_upload,
            R.drawable.ic_tab_exhibition,
            R.drawable.ic_tab_revenue
        )

        for (i in 0 until binding.tab.getTabCount()) {
            val customTab = LayoutInflater.from(this)
                .inflate(R.layout.custom_tab, null) as LinearLayout
            val tab_text = customTab.findViewById<TextView>(R.id.tab)
            tab_text.text = tabsTitles[i].toString()
            tab_text.setCompoundDrawablesWithIntrinsicBounds(0, tabsIcons[i], 0, 0)
            binding.tab.getTabAt(i)?.setCustomView(customTab)
        }
    }
}