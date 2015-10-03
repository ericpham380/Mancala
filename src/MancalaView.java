import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/** Create components and panels for the overall mancala view such as
 *  pits, mancalas, and setup screen
 * @author Dung Pham
 * @author Huy Vu
 */
public class MancalaView {

	public static final int FRAME_WIDTH = 1070;  //1050
	public static final int FRAME_HEIGHT = 379;	//362
	private MancalaModel vModel;
	JFrame mancalaFrame;
	WelcomeFrame startFrame;
	PitPanel pitPanel;
	MancalaPanelA mancalaPanelA;
	MancalaPanelB mancalaPanelB;

	JLabel playerA;
	JPanel mancalaWordA;
	JLabel extraTurnA;
	JButton playerAUndo;
	JLabel numberUndoA;

	JLabel playerB;
	JPanel mancalaWordB;
	JLabel extraTurnB;
	JButton playerBUndo;	
	JLabel numberUndoB;

	/**=============================== MancalaView ===============================
	 * Construct the GUI of mancala game containing the 3 main components pit,
	 * mancala A, and mancala B panels.
	 * @param model - the system of the game
	 */
	public MancalaView(MancalaModel model) {

		this.vModel = model;

		this.pitPanel = new PitPanel(model);	
		this.mancalaPanelA = new MancalaPanelA(model);
		this.mancalaPanelB = new MancalaPanelB(model);

		this.pitPanel.setVisible(false);
		this.mancalaPanelA.setVisible(false);
		this.mancalaPanelB.setVisible(false);

		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new BorderLayout());

		boardPanel.add(mancalaPanelA, BorderLayout.EAST);
		boardPanel.add(mancalaPanelB, BorderLayout.WEST);
		boardPanel.add(pitPanel,BorderLayout.CENTER);

		mancalaFrame = new JFrame("Mancala Game");
		mancalaFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		mancalaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//=========================== TOP PANEL - PLAYER B ===========================
		JPanel top = new JPanel();
		top.setPreferredSize(new Dimension(1050,40));
		top.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		mancalaWordB = new JPanel();
		mancalaWordB.setPreferredSize(new Dimension(25,250));
		mancalaWordB.setLayout(new GridLayout(9,1));
		String manB = "MANCALA B";

		for (int i = 0; i < manB.length(); i++)
		{
			final String label = manB.substring(i, i + 1);
			JLabel charLabel = new JLabel(label);
			charLabel.setFont(new Font("Arial", Font.BOLD, 17));
			charLabel.setHorizontalAlignment(JLabel.CENTER);
			mancalaWordB.add(charLabel);	        
		}

		playerB = new JLabel("Player B");
		playerB.setFont(new Font("Arial", Font.BOLD, 16));

		numberUndoB = new JLabel("Number of undos: 3");
		numberUndoB.setFont(new Font("Arial", Font.BOLD, 16));

		extraTurnB = new JLabel("***You have one extra turn!***");
		extraTurnB.setFont(new Font("Arial", Font.BOLD, 16));

		playerBUndo = new JButton("Undo");
		playerBUndo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				vModel.undo();
				numberUndoB.setText("Number of undos: " + vModel.getUndoTurnA());
				vModel.setCurrentTurnB(true); 
				vModel.setCurrentTurnA(false);

				if(vModel.isBonusTurn()){				
					vModel.setBonusTurn(false);
				}

				pitPanel.updatePitView();
				mancalaPanelA.updateMancalaA();
				mancalaPanelB.updateMancalaB();

			}
		});

		playerBUndo.setVisible(false);
		extraTurnB.setVisible(false);
		numberUndoB.setVisible(false);

		top.add(numberUndoB);
		top.add(playerBUndo);
		top.add(playerB);	
		top.add(extraTurnB);

		//=========================== BOT PANEL - PLAYER A ===========================
		JPanel bot = new JPanel();
		bot.setPreferredSize(new Dimension(1050,40));
		bot.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		mancalaWordA = new JPanel();
		mancalaWordA.setPreferredSize(new Dimension(25,250));
		mancalaWordA.setLayout(new GridLayout(9,1));
		String manA = "MANCALA A";

		for (int i = 0; i < manA.length(); i++)
		{
			final String label = manA.substring(i, i + 1);
			JLabel charLabel = new JLabel(label);
			charLabel.setFont(new Font("Arial", Font.BOLD, 17));
			charLabel.setHorizontalAlignment(JLabel.CENTER);
			mancalaWordA.add(charLabel);	        
		}

		playerA = new JLabel("Player A");
		playerA.setFont(new Font("Arial", Font.BOLD, 16));

		numberUndoA = new JLabel("Number of undos: 3");
		numberUndoA.setFont(new Font("Arial", Font.BOLD, 16));

		extraTurnA = new JLabel("***You have one extra turn!***");
		extraTurnA.setFont(new Font("Arial", Font.BOLD, 16));

		playerAUndo = new JButton("Undo");	
		playerAUndo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				vModel.undo();
				numberUndoA.setText("Number of undos: " + vModel.getUndoTurnB());
				vModel.setCurrentTurnA(true);
				vModel.setCurrentTurnB(false);
				if(vModel.isBonusTurn())
					vModel.setBonusTurn(false);

				pitPanel.updatePitView();
				mancalaPanelA.updateMancalaA();
				mancalaPanelB.updateMancalaB();
			}
		});

		playerAUndo.setVisible(false);
		extraTurnA.setVisible(false);
		numberUndoA.setVisible(false);

		bot.add(numberUndoA);
		bot.add(playerAUndo);
		bot.add(playerA);
		bot.add(extraTurnA);

		mancalaFrame.add(top, BorderLayout.NORTH);
		mancalaFrame.add(bot, BorderLayout.SOUTH);
		mancalaFrame.add(mancalaWordA, BorderLayout.EAST);
		mancalaFrame.add(mancalaWordB, BorderLayout.WEST);

		mancalaFrame.add(boardPanel, BorderLayout.CENTER);
		mancalaFrame.setVisible(true);

		startFrame = new WelcomeFrame(model);
	}//MancalaView


	/**================================= attach =================================
	 * Attach 'control' to main Mancala board view
	 * @param control - MVC - Control object
	 */
	public void attach(MancalaControl control){
		startFrame.attach(control);
		pitPanel.attach(control);
	}//attach

	//======================== Getters & Setters==================================
	
	public void setPlayerAUndo(boolean b) {
		this.playerAUndo.setVisible(b);
	}

	public void setPlayerAColor(Color c) {
		this.playerA.setForeground(c);
	}

	public void setNumberUndoA(boolean b){
		this.numberUndoA.setVisible(b);
	}

	public void updateNumberUndoA(int n){
		numberUndoA.setText("Number of undos: " + vModel.getUndoTurnB());
	}

	public void setPlayerBColor(Color c) {
		this.playerB.setForeground(c);
	}

	public void setPlayerBUndo(boolean b) {
		this.playerBUndo.setVisible(b);
	}

	public void setExtraTurnA(boolean b) {
		this.extraTurnA.setVisible(b);
	}

	public void setExtraTurnB(boolean b) {
		this.extraTurnB.setVisible(b);
	}

	public void setNumberUndoB(boolean b){
		this.numberUndoB.setVisible(b);
	}

	public void updateNumberUndoB(int n){
		numberUndoB.setText("Number of undos: " + vModel.getUndoTurnA());
	}
	
	/**================================= createConflictMessage =================================
	 * Open the window prompting time conflict when creating an event
	 */
	public void createWinnerMessage(String message){
		JOptionPane.showMessageDialog(this.mancalaFrame, "Congraturations, " + message + "!" , null, JOptionPane.INFORMATION_MESSAGE);
	}//createConflictMessage


}//BoardView
