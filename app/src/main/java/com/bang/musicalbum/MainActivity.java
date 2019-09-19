package com.bang.musicalbum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bang.musicalbum.Api.Api_Instance;
import com.bang.musicalbum.Api.Api_interface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Model> mResults;


    private RecyclerView recyclerView;

    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
    }

    private void getData() {

        Api_interface api_interface = Api_Instance.getAPi();
        Call<Model> call = api_interface.getAll();

        call.enqueue(new Callback<Model>() {

            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                Model main = response.body();

                if (main != null) {


                    getOnRecyclerView();
                }

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    private void getOnRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);

        mAdapter = new Adapter(this, mResults);

        recyclerView.setAdapter(mAdapter);

        recyclerView.setLayoutManager(manager);

        mAdapter.notifyDataSetChanged();
    }
}
