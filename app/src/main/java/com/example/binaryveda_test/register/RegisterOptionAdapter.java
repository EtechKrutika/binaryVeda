package com.example.binaryveda_test.register;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.binaryveda_test.R;
import com.example.binaryveda_test.base.BaseViewHolder;
import com.example.binaryveda_test.databinding.CommonitemRegistrationBinding;
import com.example.binaryveda_test.profile.ProfileActivity;
import com.gustavofao.materialtabs.SlidingFragmentPagerAdapter;


import java.util.ArrayList;
import java.util.List;

public class RegisterOptionAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private List<DataModel> datamodels;
    Context mContext;

    public RegisterOptionAdapter(List<DataModel> dataModelList, Context mContext) {
        this.datamodels = dataModelList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        CommonitemRegistrationBinding binding = CommonitemRegistrationBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new Registervh(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return datamodels.size();
    }


    class Registervh extends BaseViewHolder {

        CommonitemRegistrationBinding binding;

        public Registervh(CommonitemRegistrationBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        @Override
        public void onBind(int position) {
            DataModel dataModel = datamodels.get(position);
            binding.ivIcon.setImageDrawable(mContext.getDrawable(dataModel.getImages()));
            binding.tvTitle.setText(dataModel.getTitle());
            binding.tvSubtitle.setText(dataModel.getSubtitle());

        }

    }



}
