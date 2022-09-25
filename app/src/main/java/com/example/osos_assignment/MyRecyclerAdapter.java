package com.example.osos_assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    Context context;
    List<MyModel> arrayList;

    public MyRecyclerAdapter(Context context, List<MyModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.username.setText(arrayList.get(position).getUsername());
        holder.email.setText(arrayList.get(position).getEmail());
        holder.street.setText(arrayList.get(position).getStreet());
        holder.city.setText(arrayList.get(position).getCity());
        holder.zipcode.setText(arrayList.get(position).getZipcode());
//        holder.lat.setText(arrayList.get(position).getLat());
//        holder.lon.setText(arrayList.get(position).getLng());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, username, email, street, city, zipcode, lat, lon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.TVName);
            username = itemView.findViewById(R.id.TVUsername);
            email = itemView.findViewById(R.id.TVEmail);
            street = itemView.findViewById(R.id.TVStreet);
            city = itemView.findViewById(R.id.TVCity);
            zipcode = itemView.findViewById(R.id.TVZipcode);
//            lat = itemView.findViewById(R.id.TVLat);
//            lon = itemView.findViewById(R.id.TVLon);

        }
    }
}
