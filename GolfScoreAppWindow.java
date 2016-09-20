package GolfScoreApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GolfScoreAppWindow {

	private JFrame frame;
	private JPanel optionPanel;
	private JPanel scorePanel;
	private JPanel fPanel;
	private JTextField name1;
	private JTextField name2;
	private JButton course1;
	private JButton course2;
	private JButton course3;
	private JButton next;
	private JButton pre;
	private JLabel p1Score;
	private JLabel p2Score;
	private JLabel player1Name;
	private JLabel player2Name;
	private Player player1;
	private Player player2;
	// temp score values for demo
	private int holeNum = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GolfScoreAppWindow window = new GolfScoreAppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GolfScoreAppWindow() {
		initialize();
	}

	void initialize() {
		frame = new JFrame("Golf Score Card");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		optionPanel = optionPanel();
		frame.getContentPane().add(optionPanel, "name_63734418890208");
		optionPanel.setVisible(true);

	}

	private JPanel optionPanel() {
		JPanel optionPanel = new JPanel();
		optionPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		optionPanel.setLayout(new BorderLayout(0, 0));
		optionPanel.setBackground(new Color(70,30,30));

		JPanel nameInput = nameInput();
		optionPanel.add(nameInput, BorderLayout.CENTER);

		JPanel courseButtons = courseButtons();
		optionPanel.add(courseButtons, BorderLayout.EAST);

		JLabel guide = new JLabel("Select a course and enter player names");
		guide.setPreferredSize(new Dimension(450, 50));
		guide.setForeground(Color.WHITE);
		guide.setFont(new Font("Tahoma", Font.PLAIN, 20));
		guide.setHorizontalAlignment(SwingConstants.CENTER);
		optionPanel.add(guide, BorderLayout.NORTH);
		return optionPanel;
	}

	private JPanel nameInput() {
		JPanel nameInput = new JPanel();
		nameInput.setBorder(new EmptyBorder(100, 10, 0, 0));
		nameInput.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		nameInput.setBackground(new Color(60,200,100));
		nameInput.setOpaque(true);

		name1 = new JTextField();
		nameInput.add(name1);
		name1.setColumns(10);

		name2 = new JTextField();
		nameInput.add(name2);
		name2.setColumns(10);

		return nameInput;
	}

	private JPanel courseButtons() {
		JPanel courseButtons = new JPanel();
		courseButtons.setBorder(new EmptyBorder(100, 0, 0, 100));
		courseButtons.setLayout(new BoxLayout(courseButtons, BoxLayout.Y_AXIS));
		courseButtons.setBackground(new Color(60,200,100));


		course1 = new JButton("Pebble Broke");
		course1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PebbleBrook pebbleBroke = new PebbleBrook();
				player1 = new Player(name1.getText(), pebbleBroke.convert());
				player2 = new Player(name2.getText(), pebbleBroke.convert());
				firstPanelChange();
			}
		});
		courseButtons.add(course1);

		course2 = new JButton("Old Mill");
		course2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OldMill oldMill = new OldMill();
				player1 = new Player(name1.getText(), oldMill.convert());
				player2 = new Player(name2.getText(), oldMill.convert());
				firstPanelChange();
			}
		});
		courseButtons.add(course2);

		course3 = new JButton("Murray Parkway");
		course3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MurrayParkway murryParkway = new MurrayParkway();
				player1 = new Player(name1.getText(), murryParkway.convert());
				player2 = new Player(name2.getText(), murryParkway.convert());
				firstPanelChange();
			}
		});
		courseButtons.add(course3);

		return courseButtons;
	}

	private void firstPanelChange() {
		optionPanel.setVisible(false);
		scorePanel = scorePanel();
		frame.getContentPane().add(scorePanel, "name_63734418890208");
		scorePanel.setVisible(true);
	}

	private JPanel scorePanel() {
		JPanel sPanel = new JPanel();
		sPanel.setLayout(new BorderLayout(0, 0));

		JLabel hole = new JLabel("Hole " + (holeNum + 1));
		hole.setBackground(new Color(60,200,100));
		hole.setOpaque(true);
		hole.setHorizontalAlignment(SwingConstants.CENTER);
		sPanel.add(hole, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		sPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 4, 0, 0));

		player1Name = new JLabel(name1.getText());
		player1Name.setHorizontalAlignment(SwingConstants.CENTER);
		player1Name.setForeground(Color.WHITE);
		player1Name.setBackground(new Color(70, 30,30));
		player1Name.setOpaque(true);
		panel.add(player1Name);

		JButton subP1 = new JButton("Subtract 1");
		subP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player1.subtractScore(holeNum);
				System.out.println(""+player1.getHoleScore(holeNum));
				System.out.println(""+player2.getHoleScore(holeNum));
				p1Score.setText("" + player1.getHoleScore(holeNum));

			}
		});
		panel.add(subP1);

		p1Score = new JLabel("" + player1.getHoleScore(holeNum));
		p1Score.setHorizontalAlignment(SwingConstants.CENTER);
		p1Score.setForeground(Color.WHITE);
		p1Score.setBackground(new Color(70, 30,30));
		p1Score.setOpaque(true);
		p1Score.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(p1Score);

		JButton addP1 = new JButton("Add 1");
		addP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player1.addScore(holeNum);
				System.out.println(""+player1.getHoleScore(holeNum));
				System.out.println(""+player2.getHoleScore(holeNum));
				p1Score.setText("" + player1.getHoleScore(holeNum));
			}
		});
		panel.add(addP1);

		player2Name = new JLabel(name2.getText());
		player2Name.setHorizontalAlignment(SwingConstants.CENTER);
		player2Name.setForeground(Color.WHITE);
		player2Name.setBackground(new Color(70, 30,30));
		player2Name.setOpaque(true);
		panel.add(player2Name);

		JButton subP2 = new JButton("Subtract 1");
		subP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player2.subtractScore(holeNum);
				System.out.println(""+player1.getHoleScore(holeNum));
				System.out.println(""+player2.getHoleScore(holeNum));
				p2Score.setText("" + player2.getHoleScore(holeNum));
			}
		});
		panel.add(subP2);

		p2Score = new JLabel("" + player2.getHoleScore(holeNum));
		p2Score.setHorizontalAlignment(SwingConstants.CENTER);
		p2Score.setForeground(Color.WHITE);
		p2Score.setFont(new Font("Tahoma", Font.PLAIN, 18));
		p2Score.setBackground(new Color(70, 30,30));
		p2Score.setOpaque(true);
		panel.add(p2Score);

		JButton addP2 = new JButton("Add 1");
		addP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player2.addScore(holeNum);
				System.out.println(""+player1.getHoleScore(holeNum));
				System.out.println(""+player2.getHoleScore(holeNum));
				p2Score.setText("" + player2.getHoleScore(holeNum));
			}
		});
		panel.add(addP2);
		
		JPanel botNav = new JPanel();
		botNav.setBackground(new Color(60,200,100));
		botNav.setOpaque(true);
		sPanel.add(botNav, BorderLayout.SOUTH);
		
		pre = new JButton("Previous Hole");
		pre.hide();
		pre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(holeNum == 1){
					pre.hide();
				}
				else if(holeNum == 17){
					next.setText("Next Hole");
					
				}
				holeNum -= 1;
				p1Score.setText("" + player1.getHoleScore(holeNum));
				p2Score.setText("" + player2.getHoleScore(holeNum));
				hole.setText("Hole " + (holeNum + 1));
				System.out.println("" + holeNum);
			}
		});
		botNav.add(pre);
		
		next = new JButton("Next Hole");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(holeNum == 0){
					pre.show();
				}
				else if(holeNum == 16){
					next.setText("Show Score");
					
				}
				else if(holeNum == 17){
					scorePanel.setVisible(false);
					fPanel = fPanel();
					frame.getContentPane().add(fPanel, "name_63734418890208");
					fPanel.setVisible(true);
					return;
				}
				holeNum += 1;
				p2Score.setText("" + player2.getScore().get(holeNum));
				p1Score.setText("" + player1.getScore().get(holeNum));
				hole.setText("Hole " + (holeNum + 1));
				System.out.println("" + holeNum);
				
			}
		});
		botNav.add(next);

		return sPanel;
	}
	private JPanel fPanel() {
		JPanel fPanel = new JPanel();
		fPanel.setBackground(new Color(60,200,100));
		fPanel.setLayout(new BoxLayout(fPanel, BoxLayout.Y_AXIS));
		
		JLabel winner = new JLabel();
		winner.setAlignmentX(Component.CENTER_ALIGNMENT);
		winner.setBackground(new Color(60,200,100));
		winner.setOpaque(true);
		winner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		winner.setBorder(new EmptyBorder(5, 0, 8, 0));
		if(player1.totalScore() > player2.totalScore()){
			winner.setText(name2.getText() + " Wins!!");
		}
		else if(player1.totalScore() < player2.totalScore()){
			winner.setText(name1.getText() + " Wins!!");
		}
		else {
			winner.setText("Its a Tie with a score of " + player1.totalScore());
		}
		fPanel.add(winner);
		
		JLabel P1finalScores = new JLabel(name1.getText() + "'s total score was " + player1.totalScore());
		P1finalScores.setAlignmentX(Component.CENTER_ALIGNMENT);
		P1finalScores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		P1finalScores.setBorder(new EmptyBorder(8, 0, 8, 0));
		fPanel.add(P1finalScores);
		
		JLabel P2finalScores = new JLabel(name2.getText() + "'s total score was " + player2.totalScore());
		P2finalScores.setAlignmentX(Component.CENTER_ALIGNMENT);
		P2finalScores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		P2finalScores.setBorder(new EmptyBorder(8, 0, 8, 0));
		fPanel.add(P2finalScores);
				
		JLabel p1Scores = new JLabel();
		p1Scores.setAlignmentX(Component.CENTER_ALIGNMENT);
		p1Scores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		p1Scores.setBorder(new EmptyBorder(8, 0, 8, 0));
		StringBuilder p1string = new StringBuilder();
		for (Integer i : player1.getScore()) {
		    p1string.append(i.toString());
		    p1string.append(" ");
		}
		p1Scores.setText(p1string.toString());
		fPanel.add(p1Scores);
		
		JLabel p2Scores = new JLabel();
		p2Scores.setAlignmentX(Component.CENTER_ALIGNMENT);
		p2Scores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		p2Scores.setBorder(new EmptyBorder(8, 0, 8, 0));
		StringBuilder p2string = new StringBuilder();
		for (Integer i : player2.getScore()) {
		    p2string.append(i.toString());
		    p2string.append(" ");
		}
		p2Scores.setText(p2string.toString());
		fPanel.add(p2Scores);
		
		return fPanel;

	}

}
