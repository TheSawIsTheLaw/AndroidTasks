package com.cooList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cooList.data.CooList;

public class MainActivity extends AppCompatActivity {
	
	CooListAdapter adapter;
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setupRecyclerView();
		
		findViewById(R.id.addItemActionButton).setOnClickListener(v -> {
			adapter.addElement();
		});
		
		adapter.setElements(new CooList());
	}
	
	private void setupRecyclerView() {
		final RecyclerView rvCooList = findViewById(R.id.recycler);
		adapter = new CooListAdapter();
		rvCooList.setAdapter(adapter);
	}
}