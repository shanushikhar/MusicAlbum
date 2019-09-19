package com.bang.musicalbum;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.View_Holder> {

    private Context mContext;
    private ArrayList<Model> mResults;

    public Adapter(Context context, ArrayList<Model> results) {
        mContext = context;
        mResults = results;
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);


        return new View_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {

        Model result = mResults.get(position);

        holder.t1.setText(result.getTitle());
        holder.t2.setText(result.getArtist());


        Glide.with(mContext)
                .load(result.getThumbnailImage())
                .into(holder.img1);

        Glide.with(mContext)
                .load(result.getImage())
                .into(holder.img2);

    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public class View_Holder extends RecyclerView.ViewHolder {

        ImageView img1, img2;

        TextView t1, t2;

        public View_Holder(View itemView) {
            super(itemView);

            t1 = itemView.findViewById(R.id.text_1);
            t2 = itemView.findViewById(R.id.text_2);


            img1 = itemView.findViewById(R.id.image_1);
            img2 = itemView.findViewById(R.id.image_2);

        }
    }
}
