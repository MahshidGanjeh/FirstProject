package com.example.yara.Retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yara.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<RetrofitUser> mUserList;
    LayoutInflater inflater;

    public UserAdapter(Context context, List<RetrofitUser> dataList) {
        mUserList = dataList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(result);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(mUserList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView email;

    public MyViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        email = itemView.findViewById(R.id.email);
    }
    public void onBind(RetrofitUser user){
        name.setText(user.getName());
        email.setText(user.getEmail());
    }
}