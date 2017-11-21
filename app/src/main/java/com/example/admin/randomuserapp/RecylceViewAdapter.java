package com.example.admin.randomuserapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.randomuserapp.modal.RandomResponse;
import com.example.admin.randomuserapp.modal.Result;
import com.example.admin.randomuserapp.utils.NetUtils;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by  Admin on 11/20/2017.
 */

public class RecylceViewAdapter extends RecyclerView.Adapter<RecylceViewAdapter.ViewHolder>{

    private static final String TAG = "RecycleViewAdapter";
    private List<Result> randomUserList;
private Context context;
    private Retrofit retrofit;
    private RandomMeService randomMeService;
    private int listitemPos;
    private String firstName;
    private String email;

    public RecylceViewAdapter(List<Result> randomUserList, Context context) {
        this.randomUserList = randomUserList;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item_lay,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        firstName = randomUserList.get(position).getName().getFirst();
        email = randomUserList.get(position).getEmail();
            holder.tvRandomUser.setText(firstName);

            holder.tvRandomUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: "+position);
                    Intent intent = new Intent(context,RandomUserDetail.class);
                    intent.putExtra("username",randomUserList.get(position).getName().getFirst());
                    intent.putExtra("email", randomUserList.get(position).getEmail());
//                    bundle.pu("username",randomUserList.get(position).getName().getFirst());
//                    Log.d(TAG, "onClick: "+randomUserList.get(position).getName().getFirst());
//                    bundle.putString("email", randomUserList.get(position).getEmail());
                    context.startActivity(intent);
                }
            });

        listitemPos = position;

    }

    @Override
    public int getItemCount() {
        return randomUserList.size();
    }




    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRandomUser;
        public ViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            tvRandomUser = itemView.findViewById(R.id.tvRandomUserName);

        }
    }
}
