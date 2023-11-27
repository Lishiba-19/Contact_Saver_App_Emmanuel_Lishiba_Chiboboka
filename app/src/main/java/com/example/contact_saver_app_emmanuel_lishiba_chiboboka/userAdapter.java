package com.example.contact_saver_app_emmanuel_lishiba_chiboboka;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<userAdapter.viewHolder> {
    private Context context;

    private ArrayList id;

    private ArrayList profile;
    private ArrayList name;
    private ArrayList dob;
    private ArrayList email;

    public userAdapter(Context context, ArrayList id, ArrayList profile, ArrayList name, ArrayList dob, ArrayList email) {
        this.context = context;
        this.id = id;
        this.profile = profile;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentries, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.idtxt.setText(String.valueOf(id.get(position)));
        holder.profiletxt.setText(String.valueOf(profile.get(position)));
        holder.nametxt.setText(String.valueOf(name.get(position)));
        holder.dobtxt.setText(String.valueOf(dob.get(position)));
        holder.emailtxt.setText(String.valueOf(email.get(position)));

    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView idtxt, profiletxt, nametxt, dobtxt, emailtxt;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            idtxt = itemView.findViewById(R.id.userIdText);
            profiletxt = itemView.findViewById(R.id.userProfText);
            nametxt = itemView.findViewById(R.id.userNameText);
            dobtxt = itemView.findViewById(R.id.userDobText);
            emailtxt = itemView.findViewById(R.id.userEmailText);
        }
    }
}
