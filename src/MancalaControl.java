import mancala.MancalaShape;
import stone.StoneShape;

/** This Control class will receive all the control from GUI part
 * and send control to appropriate components of the game to update
 * the model or GUI part
 * @author Dung Pham
 * @author Huy Vu
 */
public class MancalaControl {

	private MancalaModel cModel;
	private MancalaView cView;

	/**=============================== MancalaControl ===============================
	 * Construct the control system for the game that interacts with model & view
	 * @param model - the mancala data system
	 * @param view - the mancala view GUI
	 */
	public MancalaControl(MancalaModel model, MancalaView view) {	

		cModel = model;
		cView = view;		
	}//MancalaControl

	/**================================== moveStone =================================
	 * Notify the model to update number of stones in each pit, then notify the 
	 * view to change the view
	 * @param pitIndex - the index of the pit that user chooses
	 * @param numStones - the number of stones in that selected pit
	 */
	public void moveStone(String pitIndex, int numStones){

		cView.setExtraTurnA(false);
		cView.setExtraTurnB(false);
		cView.playerAUndo.setEnabled(true);
		cView.playerBUndo.setEnabled(true);
		cView.setNumberUndoA(false);
		cView.setNumberUndoB(false);
		//reset numberUndo after each turn

		String player = pitIndex.substring(0, 1);		
		int pitLoc = Integer.parseInt(pitIndex.substring(1, 2));
		cModel.updateStones(player, pitLoc);

		if(player.equals("A")){
			cModel.setCurrentTurnA(true);
			cModel.setCurrentTurnB(false);

			cView.setPlayerAUndo(true);	
			cView.setPlayerBUndo(false);

			if(cModel.isBonusTurn() && cModel.isCurrentTurnA()){
				cView.setExtraTurnA(true);
				cView.setExtraTurnB(false);
			}
			cView.setNumberUndoA(true);

			if(cModel.isUndoB() == false){
				cView.playerAUndo.setEnabled(false);
				cView.updateNumberUndoA(cModel.getUndoTurnB());
			}

		}else if(player.equals("B")){
			cModel.setCurrentTurnA(false);
			cModel.setCurrentTurnB(true);

			cView.setPlayerBUndo(true);
			cView.setPlayerAUndo(false);	

			if(cModel.isBonusTurn() && cModel.isCurrentTurnB()){
				cView.setExtraTurnA(false);
				cView.setExtraTurnB(true);
			}	
			cView.setNumberUndoB(true);

			if(cModel.isUndoA() == false)
			{
				cView.playerBUndo.setEnabled(false);
				cView.updateNumberUndoB(cModel.getUndoTurnA());
			}
		}

		cModel.updateTurn();	
		cModel.setBonusTurn(false); //reset the bonus state
		cView.pitPanel.updatePitView();
		cView.mancalaPanelA.updateMancalaA();
		cView.mancalaPanelB.updateMancalaB();	
		
		if (cModel.getWinner() != null){
			cView.createWinnerMessage(cModel.getWinner());
			cModel.setWinner(null);
		}
	}//moveStone

	/**================================ changeNumStones ==============================
	 * Control to change the number of stones in in each pit during game
	 * @param num the new number to be set
	 */
	public void changeNumStones(int num){

		cModel.setNumStones(num);
		cView.pitPanel.updatePitView();		
	}//changeNumStones

	/**================================ changeStoneShape ==============================
	 * Change the style of the stone shape
	 * @param sPit one stone shape object for the pits
	 * @param sMan one stone shape object for the mancalas
	 */
	public void changeStoneShape(StoneShape sPit, StoneShape sMan){

		cView.pitPanel.updateStoneView(sPit);
		cView.mancalaPanelA.updateStoneView(sMan);
		cView.mancalaPanelB.updateStoneView(sMan);
	}//changeStoneShape

	/**================================ changeCircularPit ==============================
	 * Change the shape of the pit to circular according to the player choice
	 */
	public void changeCircularPit() {

		cView.pitPanel.updateCircularPit();
		cView.pitPanel.setVisible(true);
	}//changeCircularPit

	/**================================= changeSquarePit ===============================
	 * Change the shape of the pit to square according to the player choice
	 */
	public void changeSquarePit(){

		cView.pitPanel.updateSquarePit();
		cView.pitPanel.setVisible(true);
	}//changeSquarePit

	/**================================ changeMancalaShape ==============================
	 * Change the mancala shape style according to the player choice
	 * @param s the new shape style object
	 */
	public void changeMancalaShape(MancalaShape s){

		cView.mancalaPanelA.updateMancalaView(s);
		cView.mancalaPanelA.setVisible(true);
		cView.mancalaPanelB.updateMancalaView(s);
		cView.mancalaPanelB.setVisible(true);
	}//changeMancalaShape

	/**================================ closeWelcomeScreen ==============================
	 * Close the welcome frame or the setup screen prior to start the game play
	 */
	public void closeWelcomeScreen(){

		cView.startFrame.setVisible(false);
	}//closeWelcomeScreen

}//MancalaControl
