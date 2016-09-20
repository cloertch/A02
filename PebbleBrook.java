package GolfScoreApp;

import java.util.ArrayList;
import java.util.Arrays;

public class PebbleBrook extends Course {
	private static int[] holes = { 4, 4, 3, 3, 3, 5, 4, 4, 4, 4, 4, 3, 4, 4, 3, 3, 5, 4 };
	private static String courseName = "Pebble Brook";

	public PebbleBrook() {
		super(convert(), courseName);
	}
	
	public static ArrayList<Integer> convert() {
		ArrayList<Integer> playerHole = new ArrayList<Integer>(holes.length);
		for (int i = 0; i < holes.length; i++)
		  playerHole.add(Integer.valueOf(holes[i]));
		return playerHole;
	}
}