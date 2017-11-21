package com.example.admin.randomuserapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.randomuserapp.modal.Name;
import com.example.admin.randomuserapp.modal.RandomResponse;
import com.example.admin.randomuserapp.modal.Result;
import com.example.admin.randomuserapp.utils.NetUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.admin.randomuserapp.utils.Constrants.BASE_URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RandomMeService randomMeService;
    private Retrofit retrofit;
    private TextView getUser;
    private List<Result> newResponse;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = NetUtils.retrofitConfig();

        randomMeService = retrofit.create(RandomMeService.class);
        recyclerView = findViewById(R.id.recViewRandomUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

getMagic();


        }
        public void getMagic(){
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading");
            progressDialog.show();

            randomMeService.getRandomUser().enqueue(new Callback<RandomResponse>() {
                @Override
                public void onResponse(Call<RandomResponse> call, Response<RandomResponse> response) {
                    newResponse = response.body().getResults();
                    RecylceViewAdapter recylceViewAdapter = new RecylceViewAdapter(newResponse,getApplicationContext());
                    recyclerView.setAdapter(recylceViewAdapter);
                    progressDialog.dismiss();
                    Log.d(TAG, "onResponse: ");

                }

                @Override
                public void onFailure(Call<RandomResponse> call, Throwable t) {
                    Log.d(TAG, "onFailure: error");
                    progressDialog.dismiss();
                }
            });
        }
    }

