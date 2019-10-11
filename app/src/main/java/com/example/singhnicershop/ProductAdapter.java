package com.example.singhnicershop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.singhnicershop.model.CardViewDesc;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<CardViewDesc> mCardViewList;

    public ProductAdapter(Context context, LinkedList<CardViewDesc> cardViewList) {
        this.mInflater = LayoutInflater.from(context);
        this.mCardViewList= cardViewList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mProductView = mInflater.inflate(R.layout.card1_content, parent, false);
        return new ProductViewHolder(mProductView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        CardViewDesc cardData = mCardViewList.get(position);
        holder.title_view.setText(cardData.getTitle());
        holder.price_view.setText(cardData.getPrice());
        holder.desc_view.setText(cardData.getDescription());
        holder.image_view.setImageResource(cardData.getImage());
        holder.quantity_view.setText(cardData.getQuantity());
    }

    @Override
    public int getItemCount() {
        return mCardViewList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        final ProductAdapter mAdapter;
        TextView title_view;
        TextView price_view;
        TextView desc_view;
        ImageView image_view;
        TextView quantity_view;


        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            this.mAdapter = adapter;

            cardView = itemView.findViewById(R.id.cardview_template);
            title_view = itemView.findViewById(R.id.textview_title);
            price_view = itemView.findViewById(R.id.textview_price);
            desc_view = itemView.findViewById(R.id.textview_desc);
            image_view = itemView.findViewById(R.id.imageview_picture);
            quantity_view = itemView.findViewById(R.id.textview_quantity);
        }
    }
}
