package com.example.singhnicershop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.singhnicershop.model.CardViewDesc;

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
        holder.titleView.setText(cardData.getTitle());
        holder.priceView.setText(cardData.getPrice());
        holder.descView.setText(cardData.getDescription());
        holder.imageView.setImageResource(cardData.getImage());
        holder.quantityView.setText(cardData.getQuantity());
        holder.subtotalView.setText(cardData.getSubtotal());
    }

    @Override
    public int getItemCount() {
        return mCardViewList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        final ProductAdapter mAdapter;
        TextView titleView;
        TextView priceView;
        TextView descView;
        ImageView imageView;
        TextView quantityView;
        TextView subtotalView;
        Button addButton;
        Button minusButton;

        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            this.mAdapter = adapter;

            cardView = itemView.findViewById(R.id.cardview_template);
            titleView = itemView.findViewById(R.id.textview_title);
            priceView = itemView.findViewById(R.id.textview_price);
            descView = itemView.findViewById(R.id.textview_desc);
            imageView = itemView.findViewById(R.id.imageview_picture);
            quantityView = itemView.findViewById(R.id.textview_quantity);
            subtotalView = itemView.findViewById(R.id.textview_subtotal);
            addButton = itemView.findViewById(R.id.button_add);
            minusButton = itemView.findViewById(R.id.button_minus);
            addButton.setOnClickListener(this);
            minusButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            CardViewDesc sample = mCardViewList.get(pos);
            int quantity = Integer.parseInt(sample.getQuantity());
            double price = Double.parseDouble(sample.getPrice());

            switch (v.getId()) {
                case R.id.button_add:
                    quantity++;
                    break;
                case R.id.button_minus:
                     if (quantity > 0)
                        quantity--;
                     break;
            }

            double subtotal = quantity * price;

            sample.setQuantity("" + quantity);
            sample.setSubtotal(String.format("%.2f", subtotal));
//            mCardViewList.set(setSubtotal(subtotal));
            mAdapter.notifyDataSetChanged();
        }
    }
}
