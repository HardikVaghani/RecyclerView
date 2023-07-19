package com.app.hardik.recyclerview;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> data;
    private OnItemClickListener itemClickListener;
    private OnItemLongClickListener itemLongClickListener;
    private OnItemChildClickListener itemChildClickListener;
    private OnItemChildLongClickListener itemChildLongClickListener;
    public MyAdapter(List<String> data) {
        this.data = data;
    }

    public MyAdapter() {
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.itemLongClickListener = listener;
    }

    public void setOnItemChildClickListener(OnItemChildClickListener listener) {
        this.itemChildClickListener = listener;
    }

    public void setOnItemChildLongClickListener(OnItemChildLongClickListener listener) {
        this.itemChildLongClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = data.get(position);
        holder.textView.setText(item);

        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(position);
//                CustomSnackbar.make(v, "This is a custom Snackbar!", Snackbar.LENGTH_SHORT).show();
                CustomToast.showToast(v.getContext(), item);
            }
        });

        holder.itemView.setOnLongClickListener(v -> {
            if (itemLongClickListener != null) {
                itemLongClickListener.onItemLongClick(position);
                CustomToast.showToast(v.getContext(), item);
//                CustomSnackbar.make(v, item, Snackbar.LENGTH_SHORT).show();
                return true; // Return true to consume the long click event
            }
            return false;
        });

       /*
        // If your item contains child views, handle their click events here
        holder.childView.setOnClickListener(v -> {
            if (itemChildClickListener != null) {
                itemChildClickListener.onItemChildClick(position, holder.childView);
            }
        });

        holder.childView.setOnLongClickListener(v -> {
            if (itemChildLongClickListener != null) {
                itemChildLongClickListener.onItemChildLongClick(position, holder.childView);
                return true; // Return true to consume the long click event
            }
            return false;
        });*/
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_recyclerView_item);
        }
    }
}
