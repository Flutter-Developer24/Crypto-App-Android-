package com.example.crypto.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crypto.Apis.Result;
import com.example.crypto.Crypto_Details;
import com.example.crypto.R;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    Context context;
    List<Result> cryptolist;


    public AdapterClass(Context applicationContext, List<Result> data) {
        this.cryptolist = data;
    }

    public void setCryptolist(List<Result> cryptolist) {
        this.cryptolist = cryptolist;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.crypto_design, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Result result = cryptolist.get(position);


        holder.symbol.setText(cryptolist.get(position).getSymbol());
        holder.quoteAsset.setText(cryptolist.get(position).getQuoteAsset());
        holder.volume.setText(cryptolist.get(position).getVolume());
        holder.highprice.setText(cryptolist.get(position).getHighPrice());
        holder.lowprice.setText(cryptolist.get(position).getLowPrice());
        holder.lastprice.setText(cryptolist.get(position).getLastPrice());


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Crypto_Details.class);
                Log.d("position..", "is.." + view);

                intent.putExtra("crypto",cryptolist.get(position).getSymbol());
                intent.putExtra("crypto1",cryptolist.get(position).getQuoteAsset());
                intent.putExtra("crypto2",cryptolist.get(position).getVolume());
                intent.putExtra("crypto3",cryptolist.get(position).getHighPrice());
                intent.putExtra("crypto4",cryptolist.get(position).getLowPrice());
                intent.putExtra("crypto5",cryptolist.get(position).getLastPrice());
                intent.putExtra("crypto6",cryptolist.get(position).getBaseAsset());
                intent.putExtra("crypto7",cryptolist.get(position).getOpenPrice());


                view.getContext().startActivity(intent);






                Log.d("position..", "is.." + position);

            }
        });


    }

    @Override
    public int getItemCount() {
        return cryptolist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView symbol, quoteAsset, volume, highprice, lowprice, lastprice;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            symbol = itemView.findViewById(R.id.txt_symbol);
            quoteAsset = itemView.findViewById(R.id.txt_quoteasset);
            volume = itemView.findViewById(R.id.txt_volume);
            highprice = itemView.findViewById(R.id.txt_highprice);
            lowprice = itemView.findViewById(R.id.txt_lowprice);
            lastprice = itemView.findViewById(R.id.txt_lastprice);

            layout = itemView.findViewById(R.id.linear_layout);


        }


    }


}
