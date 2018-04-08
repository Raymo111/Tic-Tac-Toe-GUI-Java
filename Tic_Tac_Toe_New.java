/*
 * Author: Raymond Li
 * Date of revision: 2018-04-08
 * Description: Tic Tac Toe program with GUI (PVP only)
 * 				New version uses 2D arrays instead of lots of JButtons:) 
 */

//Import java GUI classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Main class with JFrame and ActionListener enabled
public class Tic_Tac_Toe_New extends JFrame implements ActionListener {

	private static final long serialVersionUID = 7148354192453031633L;

	// Add panels
	JPanel gamePanel = new JPanel();
	JPanel controlPanel = new JPanel();

	// Add buttons
	JButton[][] gameButtons = new JButton[3][3];
	JButton newP = new JButton("New PVP");

	// Declare class variables
	private static int count = 0;
	private static boolean[][] c = new boolean[3][3];
	private static char[] aMoves = new char[10];
	private static boolean check = true;

	// Constructor
	public Tic_Tac_Toe_New() {

		// Set title, size, layout (grid [2x1]), and location of GUI window
		setTitle("Tic Tac Toe");
		setSize(360, 720);
		getContentPane().setLayout(new GridLayout(2, 1));
		setLocationRelativeTo(null);

		// Create 2 different layouts
		GridLayout grid1 = new GridLayout(3, 3);
		GridLayout grid2 = new GridLayout(1, 3);

		// Assign layouts to each JPanel
		gamePanel.setLayout(grid1);
		controlPanel.setLayout(grid2);

		// Add ActionListeners and fonts to gamePanel buttons
		for (int i = 0; i < gameButtons.length; i++) {
			for (int j = 0; j < gameButtons[i].length; j++) {
				gameButtons[i][j] = new JButton();
				gameButtons[i][j].setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
				gameButtons[i][j].addActionListener(this);
			}
		}

		// Initialize checks
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = true;
			}
		}

		// Add ActionListeners, tooltip texts and fonts to controlPanel buttons
		newP.addActionListener(this);
		newP.setToolTipText("New game against another player");
		newP.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

		// Add buttons to panels
		for (int i = 0; i < gameButtons.length; i++) {
			for (int j = 0; j < gameButtons.length; j++) {
				gamePanel.add(gameButtons[i][j]);
			}
		}

		controlPanel.add(newP);

		// Add panels
		getContentPane().add(gamePanel);
		getContentPane().add(controlPanel);

		// Set GUI window to visible and disable resizing
		setVisible(true);
		setResizable(false);

	}

	// Main method
	public static void main(String[] args) {

		// Creates 'Tic Tac Toe' window
		new Tic_Tac_Toe_New();

	}

	// Event-handling method
	public void actionPerformed(ActionEvent event) {

		// Handle control clicks
		if (newP == event.getSource()) {

			// Reset buttons' texts
			for (int i = 0; i < gameButtons.length; i++) {
				for (int j = 0; j < gameButtons.length; j++) {
					gameButtons[i][j].setText("");
				}
			}

			// Reset clicked checks
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[i].length; j++) {
					c[i][j] = true;
				}
			}

			// Reset moves
			for (int i = 1; i <= 9; i++)
				aMoves[i] = '\u0000';

			// Reset check
			check = true;

			// Reset counter - Comment out the next line if it is desired for X and O to
			// take turns starting each game.
			count = 0;

		}

		// Handle game clicks
		if (count % 2 == 0) {
			for (int i = 0; i < gameButtons.length; i++) {
				for (int j = 0; j < gameButtons.length; j++) {
					if (gameButtons[i][j] == event.getSource() && c[i][j]) {
						gameButtons[i][j].setText("X");
						c[i][j] = false;
						aMoves[3 * i + j + 1] = 'X';
						count++;
					}
				}
			}
		}

		else if (count % 2 == 1) {

			for (int i = 0; i < gameButtons.length; i++) {
				for (int j = 0; j < gameButtons.length; j++) {
					JButton button1 = (JButton) event.getSource();
					if (gameButtons[i][j] == button1 && c[i][j]) {
						gameButtons[i][j].setText("O");
						c[i][j] = false;
						aMoves[3 * i + j + 1] = 'O';
						count++;
					}
				}
			}
		}

		// Check for whether wins have been checked
		if (check) {

			// Check for whether player X wins
			if (

			// Horizontal checks
			(aMoves[1] == aMoves[2] && aMoves[1] == aMoves[3] && aMoves[1] == 'X')
					|| (aMoves[4] == aMoves[5] && aMoves[4] == aMoves[6] && aMoves[4] == 'X')
					|| (aMoves[7] == aMoves[8] && aMoves[7] == aMoves[9] && aMoves[7] == 'X') ||

					// Vertical checks
					(aMoves[1] == aMoves[4] && aMoves[1] == aMoves[7] && aMoves[1] == 'X')
					|| (aMoves[2] == aMoves[5] && aMoves[2] == aMoves[8] && aMoves[2] == 'X')
					|| (aMoves[3] == aMoves[6] && aMoves[3] == aMoves[9] && aMoves[3] == 'X') ||

					// Diagonal checks
					(aMoves[1] == aMoves[5] && aMoves[1] == aMoves[9] && aMoves[1] == 'X')
					|| (aMoves[3] == aMoves[5] && aMoves[3] == aMoves[7] && aMoves[3] == 'X')) {

				// Show Message dialog that player X wins
				JOptionPane.showMessageDialog(rootPane,
						new JLabel("<html><div style='text-align: center;'>" + "Congratulations!<br>Player X wins!"
								+ "</div></html>", JLabel.CENTER),
						(new String(new char[] { 71, 97, 109, 101, 32, 99, 114, 101, 97, 116, 101, 100, 32, 98, 121 })
								+ new String(new char[] { 32, 82, 97, 121, 109, 111, 110, 100, 32, 76, 105 })),
						JOptionPane.PLAIN_MESSAGE);

				// Set false to stop rechecking
				check = false;

				// Stop further clicks on game buttons
				for (int i = 0; i < c.length; i++) {
					for (int j = 0; j < c[i].length; j++) {
						c[i][j] = false;
					}
				}
			}

			// Check for whether player O wins
			else if (

			// Horizontal checks
			(aMoves[1] == aMoves[2] && aMoves[1] == aMoves[3] && aMoves[1] == 'O')
					|| (aMoves[4] == aMoves[5] && aMoves[4] == aMoves[6] && aMoves[4] == 'O')
					|| (aMoves[7] == aMoves[8] && aMoves[7] == aMoves[9] && aMoves[7] == 'O') ||

					// Vertical checks
					(aMoves[1] == aMoves[4] && aMoves[1] == aMoves[7] && aMoves[1] == 'O')
					|| (aMoves[2] == aMoves[5] && aMoves[2] == aMoves[8] && aMoves[2] == 'O')
					|| (aMoves[3] == aMoves[6] && aMoves[3] == aMoves[9] && aMoves[3] == 'O') ||

					// Diagonal checks
					(aMoves[1] == aMoves[5] && aMoves[1] == aMoves[9] && aMoves[1] == 'O')
					|| (aMoves[3] == aMoves[5] && aMoves[3] == aMoves[7] && aMoves[3] == 'O')) {

				// Show Message dialog that player O wins
				JOptionPane.showMessageDialog(rootPane,
						new JLabel("<html><div style='text-align: center;'>" + "Congratulations!<br>Player O wins!"
								+ "</div></html>", JLabel.CENTER),
						(new String(new char[] { 71, 97, 109, 101, 32, 99, 114, 101, 97, 116, 101, 100, 32, 98, 121 })
								+ new String(new char[] { 32, 82, 97, 121, 109, 111, 110, 100, 32, 76, 105 })),
						JOptionPane.PLAIN_MESSAGE);

				// Set false to stop rechecking
				check = false;

				// Stop further clicks on game buttons
				for (int i = 0; i < c.length; i++) {
					for (int j = 0; j < c[i].length; j++) {
						c[i][j] = false;
					}
				}
			}

			// Case of tie
			else if ((c[0][0] || c[0][1] || c[0][2] || c[1][0] || c[1][1] || c[1][2] || c[2][0] || c[2][1]
					|| c[2][2]) == false) {

				// Show Message dialog that the game is a tie
				JOptionPane.showMessageDialog(rootPane,
						new JLabel("<html><div style='text-align: center;'>" + "Congratulations!<br>The game is a tie!"
								+ "</div></html>", JLabel.CENTER),
						(new String(new char[] { 71, 97, 109, 101, 32, 99, 114, 101, 97, 116, 101, 100, 32, 98, 121 })
								+ new String(new char[] { 32, 82, 97, 121, 109, 111, 110, 100, 32, 76, 105 })),
						JOptionPane.PLAIN_MESSAGE);

				// Set false to stop rechecking
				check = false;

				// Stop further clicks on game buttons
				for (int i = 0; i < c.length; i++) {
					for (int j = 0; j < c[i].length; j++) {
						c[i][j] = false;
					}
				}

			}
		}
	}

}