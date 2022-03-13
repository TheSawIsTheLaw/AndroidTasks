package com.cooList;

import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cooList.data.CooList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CooListAdapter extends RecyclerView.Adapter<CooListAdapter.CooListElementViewHolder> {
	
	public static class CooListElementViewHolder extends RecyclerView.ViewHolder {
		
		TextView tvName;
		Button elementDeleteButton;
		CardView card;
		
		public CooListElementViewHolder(@NonNull final View itemView) {
			super(itemView);
			tvName = itemView.findViewById(R.id.elementTV);
			elementDeleteButton = itemView.findViewById(R.id.deleteButton);
			card = itemView.findViewById(R.id.card);
		}
	}
	
	CooList cooList;
	
	public void setElements(final CooList listToSet) {
		cooList = listToSet;
	}
	
	public void deleteElement(final int position) {
		cooList.deleteElement(position);
		notifyDataSetChanged();
	}
	
	public void addElement() {
		cooList.addElement();
		notifyDataSetChanged();
	}
	
	@NonNull
	@Override
	public CooListElementViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
		final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coolistitem, parent, false);
		
		return new CooListElementViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(@NonNull final CooListElementViewHolder holder, final int position) {
		final Pair<String, Integer> element;
		try {
			element = cooList.getElement(position);
		} catch (Exception e) {
			return;
		}
		
		holder.tvName.setText(element.first);
		holder.card.setCardBackgroundColor(element.second);
		holder.elementDeleteButton.setOnClickListener(v -> {
			deleteElement(position);
		});
	}
	
	@Override
	public int getItemCount() {
		return cooList.getCurrentNumberOfElements();
	}
}
