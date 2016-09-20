package GolfScoreApp;

import java.util.ArrayList;
import java.util.Arrays;

public class OldMill extends Course {
	private static int[] holes = { 4, 4, 3, 4, 5, 4, 3, 4, 4, 4, 4, 3, 5, 3, 5, 4, 4, 4 };
	private static String courseName = "Old Mill";

	public OldMill() {
		super(convert(), courseName);
	}
	
	public static ArrayList<Integer> convert() {
		ArrayList<Integer> playerHole = new ArrayList<Integer>(holes.length);
		for (int i = 0; i < holes.length; i++)
		  playerHole.add(Integer.valueOf(holes[i]));
		return playerHole;
	}
}