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

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    List<Post> mPostList;

    public PostAdapter(Context context, List<Post> dataList) {
        mPostList = dataList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        PostViewHolder viewHolder = new PostViewHolder(result);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.onBind(mPostList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }
}

class PostViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView body;

    public PostViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        body = itemView.findViewById(R.id.body);
    }

    public void onBind(Post post) {
        title.setText("Title is : \n" + post.getTitle());
        body.setText("Body is : \n " + post.getBody());
    }
}