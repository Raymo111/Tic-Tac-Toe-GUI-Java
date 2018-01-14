/*
 * Author: Raymond Li
 * Date: 2018-01-24
 * Description: Tic Tac Toe program with GUI (PVP only) 
 */

//Import java GUI classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//SuppressWarnings unused and serial
@SuppressWarnings({"unused", "serial"})

//Main class with JFrame and ActionListener enabled
public class Tic_Tac_Toe extends JFrame implements ActionListener {

	//Add panels
	JPanel gamePanel = new JPanel();
	JPanel controlPanel = new JPanel();

	//Add control buttons
	//(Old version)//JButton newP = new JButton("<html><div style='text-align: center;'>New Game against<br>Another Player (PVP)</div><html>");
	JButton newP = new JButton("New PVP"); //(New Version, simpler)

	//For Future Development (PVC)
	//JButton newX = new JButton("New game as X");
	//JButton newO = new JButton("New game as O");

	//Add game buttons
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JButton b5 = new JButton();
	JButton b6 = new JButton();
	JButton b7 = new JButton();
	JButton b8 = new JButton();
	JButton b9 = new JButton();

	//Declare class variables
	private static int count = 0;
	private static boolean c1 = true, c2 = true, c3 = true, c4 = true, c5 = true, c6 = true, c7 = true, c8 = true, c9 = true;
	private static char[] aMoves = new char[10];
	private static boolean check = true;

	//For Future Development (PVC)
	//private static boolean Xwin = false, Owin = false;

	//Constructor
	public Tic_Tac_Toe() {

		//Set title, size, layout (grid [2x1]), and location of GUI window
		setTitle("Tic Tac Toe");
		setSize(360, 720);
		getContentPane().setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);

		//Create 2 different layouts
		GridLayout grid1 = new GridLayout(3,3);
		GridLayout grid2 = new GridLayout(1,3);

		//Assign layouts to each JPanel
		gamePanel.setLayout(grid1);
		controlPanel.setLayout(grid2);

		//Add ActionListeners and fonts to gamePanel buttons
		b1.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		b1.addActionListener(this);
		b2.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		b2.addActionListener(this);
		b3.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		b3.addActionListener(this);
		b4.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		b4.addActionListener(this);
		b5.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		b5.addActionListener(this);
		b6.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		b6.addActionListener(this);
		b7.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		b7.addActionListener(this);
		b8.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		b8.addActionListener(this);
		b9.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		b9.addActionListener(this);

		//Add ActionListeners, tooltip texts and fonts to controlPanel buttons
		newP.addActionListener(this);
		newP.setToolTipText("New game against another player");
		newP.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

		//For future development (PVC)
		//newX.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		//newX.addActionListener(this);
		//newX.setToolTipText("New game against the computer as X");

		//newO.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		//newO.addActionListener(this);
		//newO.setToolTipText("New game against the computer as O");

		//Add buttons to panels
		gamePanel.add(b1);
		gamePanel.add(b2);
		gamePanel.add(b3);
		gamePanel.add(b4);
		gamePanel.add(b5);
		gamePanel.add(b6);
		gamePanel.add(b7);
		gamePanel.add(b8);
		gamePanel.add(b9);

		controlPanel.add(newP);

		//For Future Development (PVC)
		//controlPanel.add(newX);
		//controlPanel.add(newO);

		//Add panels
		getContentPane().add(gamePanel);
		getContentPane().add(controlPanel);

		//Set GUI window to visible and disable resizing
		setVisible(true);
		setResizable(false);

	}

	//Main method
	public static void main(String[] args) {

		//Creates 'Tic Tac Toe' window
		new Tic_Tac_Toe();

	}

	//Event-handling method
	public void actionPerformed(ActionEvent event) {

		//Handle control clicks
		if (newP == event.getSource()) {

			//Reset button text
			b1.setText("");
			b2.setText("");
			b3.setText("");
			b4.setText("");
			b5.setText("");
			b6.setText("");
			b7.setText("");
			b8.setText("");
			b9.setText("");

			//Reset clicked checks
			c1 = true;
			c2 = true;
			c3 = true;
			c4 = true;
			c5 = true;
			c6 = true;
			c7 = true;
			c8 = true;
			c9 = true;

			//Reset moves
			for (int i = 1; i <= 9; i++)
				aMoves[i] = '\u0000';

			//For Future Development (PVC)
			//Reset wins
			//Xwin = false;
			//Owin = false;

			//Reset check
			check = true;

			//Reset counter - Simply comment the next line out if it is desired for X and O to take turns starting each game.
			count = 0;

		}

		//Handle game clicks
		if (count % 2 == 0) {

			if (b1 == event.getSource() && c1) {
				b1.setText("X");
				c1 = false;
				aMoves[1] = 'X';
				count++;
			}

			if (b2 == event.getSource() && c2) {
				b2.setText("X");
				c2 = false;
				aMoves[2] = 'X';
				count++;
			}

			if (b3 == event.getSource() && c3) {
				b3.setText("X");
				c3 = false;
				aMoves[3] = 'X';
				count++;
			}

			if (b4 == event.getSource() && c4) {
				b4.setText("X");
				c4 = false;
				aMoves[4] = 'X';
				count++;
			}

			if (b5 == event.getSource() && c5) {
				b5.setText("X");
				c5 = false;
				aMoves[5] = 'X';
				count++;
			}

			if (b6 == event.getSource() && c6) {
				b6.setText("X");
				c6 = false;
				aMoves[6] = 'X';
				count++;
			}

			if (b7 == event.getSource() && c7) {
				b7.setText("X");
				c7 = false;
				aMoves[7] = 'X';
				count++;
			}

			if (b8 == event.getSource() && c8) {
				b8.setText("X");
				c8 = false;
				aMoves[8] = 'X';
				count++;
			}

			if (b9 == event.getSource() && c9) {
				b9.setText("X");
				c9 = false;
				aMoves[9] = 'X';
				count++;
			}

		}

		else {

			if (b1 == event.getSource() && c1) {
				b1.setText("O");
				c1 = false;
				aMoves[1] = 'O';
				count++;
			}

			if (b2 == event.getSource() && c2) {
				b2.setText("O");
				c2 = false;
				aMoves[2] = 'O';
				count++;
			}

			if (b3 == event.getSource() && c3) {
				b3.setText("O");
				c3 = false;
				aMoves[3] = 'O';
				count++;
			}

			if (b4 == event.getSource() && c4) {
				b4.setText("O");
				c4 = false;
				aMoves[4] = 'O';
				count++;
			}

			if (b5 == event.getSource() && c5) {
				b5.setText("O");
				c5 = false;
				aMoves[5] = 'O';
				count++;
			}

			if (b6 == event.getSource() && c6) {
				b6.setText("O");
				c6 = false;
				aMoves[6] = 'O';
				count++;
			}

			if (b7 == event.getSource() && c7) {
				b7.setText("O");
				c7 = false;
				aMoves[7] = 'O';
				count++;
			}

			if (b8 == event.getSource() && c8) {
				b8.setText("O");
				c8 = false;
				aMoves[8] = 'O';
				count++;
			}

			if (b9 == event.getSource() && c9) {
				b9.setText("O");
				c9 = false;
				aMoves[9] = 'O';
				count++;
			}

		}

		//Check for whether wins have been checked
		if (check) {

			//Check for whether player X wins
			if (
					//Horizontal checks
					(aMoves[1] == aMoves[2] && aMoves[1] == aMoves[3] && aMoves[1] == 'X') ||
					(aMoves[4] == aMoves[5] && aMoves[4] == aMoves[6] && aMoves[4] == 'X') ||
					(aMoves[7] == aMoves[8] && aMoves[7] == aMoves[9] && aMoves[7] == 'X') ||

					//Vertical checks
					(aMoves[1] == aMoves[4] && aMoves[1] == aMoves[7] && aMoves[1] == 'X') ||
					(aMoves[2] == aMoves[5] && aMoves[2] == aMoves[8] && aMoves[2] == 'X') ||
					(aMoves[3] == aMoves[6] && aMoves[3] == aMoves[9] && aMoves[3] == 'X') ||

					//Diagonal checks
					(aMoves[1] == aMoves[5] && aMoves[1] == aMoves[9] && aMoves[1] == 'X') ||
					(aMoves[3] == aMoves[5] && aMoves[3] == aMoves[7] && aMoves[3] == 'X')
					) {

				//For Future Development (PVC)
				//Set as player X won
				//Xwin = true;

				//Set false to stop rechecking
				check = false;

				//Show Message dialog that player X wins
				JOptionPane.showMessageDialog(rootPane, new JLabel("<html><div style='text-align: center;'>" + "Congratulations!<br>Player X wins!" +
						"</div></html>", JLabel.CENTER), (new String(new char[] {71, 97, 109, 101, 32, 99, 114, 101, 97, 116, 101, 100, 32, 98, 121}) +
								new String(new char[] {32, 82, 97, 121, 109, 111, 110, 100, 32, 76, 105})), JOptionPane.PLAIN_MESSAGE);

				//Stop further clicks on game buttons
				c1 = false;
				c2 = false;
				c3 = false;
				c4 = false;
				c5 = false;
				c6 = false;
				c7 = false;
				c8 = false;
				c9 = false;

			}

			//Check for whether player O wins
			else if (
					//Horizontal checks
					(aMoves[1] == aMoves[2] && aMoves[1] == aMoves[3] && aMoves[1] == 'O') ||
					(aMoves[4] == aMoves[5] && aMoves[4] == aMoves[6] && aMoves[4] == 'O') ||
					(aMoves[7] == aMoves[8] && aMoves[7] == aMoves[9] && aMoves[7] == 'O') ||

					//Vertical checks
					(aMoves[1] == aMoves[4] && aMoves[1] == aMoves[7] && aMoves[1] == 'O') ||
					(aMoves[2] == aMoves[5] && aMoves[2] == aMoves[8] && aMoves[2] == 'O') ||
					(aMoves[3] == aMoves[6] && aMoves[3] == aMoves[9] && aMoves[3] == 'O') ||

					//Diagonal checks
					(aMoves[1] == aMoves[5] && aMoves[1] == aMoves[9] && aMoves[1] == 'O') ||
					(aMoves[3] == aMoves[5] && aMoves[3] == aMoves[7] && aMoves[3] == 'O')
					) {

				//For Future Development (PVC)
				//Set as player O won
				//Owin = true;

				//Set false to stop rechecking
				check = false;

				//Show Message dialog that player O wins
				JOptionPane.showMessageDialog(rootPane, new JLabel("<html><div style='text-align: center;'>" + "Congratulations!<br>Player O wins!" +
						"</div></html>", JLabel.CENTER), (new String(new char[] {71, 97, 109, 101, 32, 99, 114, 101, 97, 116, 101, 100, 32, 98, 121}) +
								new String(new char[] {32, 82, 97, 121, 109, 111, 110, 100, 32, 76, 105})), JOptionPane.PLAIN_MESSAGE);

				//Stop further clicks on game buttons
				c1 = false;
				c2 = false;
				c3 = false;
				c4 = false;
				c5 = false;
				c6 = false;
				c7 = false;
				c8 = false;
				c9 = false;

			}

			//Case of tie
			else if ((c1 || c2 || c3 || c4 || c5 || c6 || c7 || c8 || c9) == false) {

				//Set false to stop rechecking
				check = false;

				//Show Message dialog that the game is a tie
				JOptionPane.showMessageDialog(rootPane, new JLabel("<html><div style='text-align: center;'>" + "Congratulations!<br>The game is a tie!" +
						"</div></html>", JLabel.CENTER), (new String(new char[] {71, 97, 109, 101, 32, 99, 114, 101, 97, 116, 101, 100, 32, 98, 121}) +
								new String(new char[] {32, 82, 97, 121, 109, 111, 110, 100, 32, 76, 105})), JOptionPane.PLAIN_MESSAGE);

			}

		}

	}

}