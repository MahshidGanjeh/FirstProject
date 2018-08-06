package com.example.yara.Retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yara.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<RetrofitUser> mUserList;
    private onUserClicked mListener;

    public void setmUserList(List<RetrofitUser> mUserList) {
        this.mUserList = mUserList;
    }

    public UserAdapter(onUserClicked listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent
                , false);
        MyViewHolder viewHolder = new MyViewHolder(result);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(mUserList.get(position));
        final RetrofitUser currentUser = mUserList.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.showPosts(currentUser);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

}

class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView email;

    public MyViewHolder(final View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        email = itemView.findViewById(R.id.email);
    }

    public void onBind(RetrofitUser user) {
        name.setText(user.getName());
        email.setText(user.getEmail());
    }
}

interface onUserClicked {
    public void showPosts(RetrofitUser user);
}