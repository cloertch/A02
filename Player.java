package GolfScoreApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private ArrayList<Integer> score = new ArrayList<>();
	private String name = null;

	public Player(String n, ArrayList<Integer> s) {
		score = s;
		name = n;
	}

	public ArrayList<Integer> getScore() {
		return score;
	}

	public int getHoleScore(int index) {
		return score.get(index);
	}

	public void subtractScore(int index) {
		this.score.set(index, (score.get(index)) - 1);
	}

	public void addScore(int index) {
		this.score.set(index, (score.get(index)) + 1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int totalScore(){
		int totalScore = 0;
		for (Integer i : score) {
			totalScore = totalScore + i;	
		}
		return totalScore;
	}

}
