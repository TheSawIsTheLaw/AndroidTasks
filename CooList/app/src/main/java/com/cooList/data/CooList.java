package com.cooList.data;

import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.String.format;

public class CooList {
	private static final int FIRST_LOAD_SIZE = 100;
	
	public static final int START_NUMBER_OF_ELEMENTS = 1000000;
	
	private final Random random = new Random();
	private ArrayList<Pair<String, Integer>> elements = new ArrayList<>();
	
	private final String[] lyrics = {
		"Welcome to my heart, bitch, didn't eat for days", "Feeling cold like the Arctic, nothing to embrace",
		"No, I cannot stop this, I cannot win this", "Life is a matrix, I can't decode it", "Feeling like my art shifts, I hate it anyways",
		"There's nothing to it, I chose the wrong way", "I miss the old me, all my friends told me",
		"\"Stop with the drugs, they fuck your head slowly\"", "And I didn't listen for shit", "That's what I got from it",
		"Steady urge to fucking dip", "I wish I could handle it", "No friend cares about my shit", "Making music for myself",
		"Rainy days have come to hell", "Depth Strida breaks out his shell"
	};
	
	private int currentLyric = 0;
	
	private String getNextLyricsLine() {
		if (currentLyric == lyrics.length) {
			currentLyric = 0;
		}
		
		return lyrics[currentLyric++];
	}
	
	public CooList() {
		// TODO: factory for an element. I'm just too lazy
		for (int i = 0; i < FIRST_LOAD_SIZE; i++) {
			elements.add(new Pair(
				format("%d %s", i, getNextLyricsLine()),
				random.nextInt()));
		}
	}
	
	private int currentNumberOfElements = START_NUMBER_OF_ELEMENTS;
	public int getCurrentNumberOfElements() {
		return currentNumberOfElements;
	}
	
	private void addExistingElement() {
		elements.add(new Pair(format("%d %s", elements.size(), getNextLyricsLine()), random.nextInt()));
	}
	
	public void addElement() {
		addExistingElement();
		currentNumberOfElements++;
	}
	
	public Pair<String, Integer> getElement(int position) throws Exception {
		if (elements.size() <= position || position >= currentNumberOfElements) {
			throw new Exception("I'm too lazy to create my own exceptions, you know");
		}
		
		for (int i = elements.size(); i <= position + 20 && i < currentNumberOfElements; i++) {
			addExistingElement();
		}
		
		return elements.get(position);
	}
	
	public void deleteElement(final int position) {
		Log.v("owo", format("%d", elements.size()));
		elements.remove(position);
		Log.v("uwu", format("%d", elements.size()));
		currentNumberOfElements--;
	}
}
