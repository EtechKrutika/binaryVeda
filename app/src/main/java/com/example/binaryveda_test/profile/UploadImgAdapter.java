package com.example.binaryveda_test.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.binaryveda_test.R;
import com.example.binaryveda_test.base.BaseViewHolder;
import com.example.binaryveda_test.databinding.CommonitemRegistrationBinding;
import com.example.binaryveda_test.databinding.CommonitemUploadBinding;
import com.example.binaryveda_test.register.DataModel;

import java.util.List;

public class UploadImgAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private List<String> datamodels;
    Context mContext;

    public UploadImgAdapter(List<String> dataModelList, Context mContext) {
        this.datamodels = dataModelList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        CommonitemUploadBinding binding = CommonitemUploadBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new Uploadvh(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return datamodels.size();
    }


    class Uploadvh extends BaseViewHolder {

        CommonitemUploadBinding binding;

        public Uploadvh(CommonitemUploadBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        @Override
        public void onBind(int position) {
            String img = datamodels.get(position);
            Glide
                    .with(mContext)
                    .load(img)
                    .into(binding.ivImage);

        }

    }


}
