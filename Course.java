package GolfScoreApp;

import java.util.ArrayList;

public abstract class Course {
	private ArrayList<Integer> holes;
	private String courseName;

	public Course(ArrayList<Integer> h, String cName) {
			holes = h;
		courseName = cName;
	}

	public ArrayList<Integer> getHoles() {
		return holes;
	}

	public int getParValue(int holeNumber) {
		return holes.get(holeNumber);
	}

	public void setParValue(int parValue, int holeIndex) {
		holes.add(holeIndex, parValue);
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String cName) {
		courseName = cName;
	}
	
}