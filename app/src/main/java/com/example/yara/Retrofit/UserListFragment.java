package com.example.yara.Retrofit;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yara.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListFragment extends Fragment
        implements onUserClicked {

    UserAdapter adapter;
    handler h ;

    public UserListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_user_list, container, false);

        final RecyclerView recyclerView = result.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        adapter = new UserAdapter(this);

        //retrofit
        GetDataService service = RetrofitClient.getClient().create(GetDataService.class);
        Call<List<RetrofitUser>> call = service.getAllUsers();

        call.enqueue(new Callback<List<RetrofitUser>>() {
            @Override
            public void onResponse(Call<List<RetrofitUser>> call, Response<List<RetrofitUser>> response) {
                adapter.setmUserList(response.body());
                recyclerView.setAdapter(adapter);
                Log.d("response", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<RetrofitUser>> call, Throwable t) {
                Toast.makeText(getContext(),
                        "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
        return result;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        h = (handler) context;
    }

    @Override
    public void showPosts(RetrofitUser user) {
        h.goToPost(user);
    }
}

interface handler {
    public void goToPost(RetrofitUser user);
}
