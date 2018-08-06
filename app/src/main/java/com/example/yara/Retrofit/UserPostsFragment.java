package com.example.yara.Retrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yara.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPostsFragment extends Fragment {

    private RecyclerView recyclerView;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;

    public UserPostsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_user_posts, container, false);
        recyclerView = result.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        return result;
    }

    public static UserPostsFragment newInstance(int userId) {

        Bundle args = new Bundle();
        args.putInt("id",userId);
        UserPostsFragment fragment = new UserPostsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GetDataService service = RetrofitClient.getClient().create(GetDataService.class);
        Call<List<Post>> call = service.getPosts(this.getArguments().getInt("id"));

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                PostAdapter adapter = new PostAdapter(getContext(), response.body());
                recyclerView.setAdapter(adapter);
                Log.d("responsepost", response.body().get(0).getTitle());
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getContext(),
                        "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
