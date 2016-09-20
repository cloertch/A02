package GolfScoreApp;


import java.util.ArrayList;
import java.util.Arrays;

public class MurrayParkway extends Course {
	private static int[] holes = { 4, 4, 5, 3, 5, 4, 3, 4, 4, 4, 4, 5, 3, 5, 4, 3, 4, 4 };
	private static String courseName = "Murray Parkway";

	public MurrayParkway() {
		super(convert(), courseName);
	}
	
	public static ArrayList<Integer> convert() {
		ArrayList<Integer> playerHole = new ArrayList<Integer>(holes.length);
		for (int i = 0; i < holes.length; i++)
		  playerHole.add(Integer.valueOf(holes[i]));
		return playerHole;
	}
}