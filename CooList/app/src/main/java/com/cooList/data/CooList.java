package com.cooList.data;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Random;

public class CooList {
	
	public CooList() {
		for (int i = 0; i < currentNumberOfElements; i++) {
			elements.add(new Pair(String.format("%d %s", i, getNextLyricsLine()),
				random.nextInt()));
		}
	}
	
	private ArrayList<Pair<String, Integer>> elements = new ArrayList<>();
	
	public ArrayList<Pair<String, Integer>> getElements() {
		return elements;
	}
	
	private final Random random = new Random();
	private int currentNumberOfElements = 100;
	
	private int currentLyric = 0;
	
	private final String[] lyrics = {
		"Welcome to my heart, bitch, didn't eat for days", "Feeling cold like the Arctic, nothing to embrace",
		"No, I cannot stop this, I cannot win this", "Life is a matrix, I can't decode it", "Feeling like my art shifts, I hate it anyways",
		"There's nothing to it, I chose the wrong way", "I miss the old me, all my friends told me",
		"\"Stop with the drugs, they fuck your head slowly\"", "And I didn't listen for shit", "That's what I got from it",
		"Steady urge to fucking dip", "I wish I could handle it", "No friend cares about my shit", "Making music for myself",
		"Rainy days have come to hell", "Depth Strida breaks out his shell"
	};
	
	private String getNextLyricsLine() {
		if (currentLyric == lyrics.length) {
			currentLyric = 0;
		}
		
		return lyrics[currentLyric++];
	}
	
	public void addElement() {
		elements.add(new Pair(String.format("%d %s", currentNumberOfElements++, getNextLyricsLine()), random.nextInt()));
	}
	
	public void deleteElement(final int position) {
		elements.remove(position);
	}
}
