import java.util.ArrayList;

/** This Model class maintains all the data of the game including the start
 * number of stones, number of stones in each pit, the player turn, 
 * and keeping track of undo times
 * 
 * @author Dung Pham
 * @author Huy Vu
 */
public class MancalaModel {

	//0-5: pits of Player A // 6 : mancala A
	//7-12: pits of Player B// 13 : mancala B
	private ArrayList<Integer> pitStones; 
	private ArrayList<Integer> undoStones;
	private int numStones;
	private int undoTurnA;
	private int undoTurnB;
	private String winner;

	private boolean turnA;
	private boolean bonusTurn;	
	private boolean currentTurnA;
	private boolean currentTurnB;
	private boolean undoA;
	private boolean undoB;

	/**=============================== MancalaModel ===============================
	 * Construct a model or system that holds data of the mancala game
	 */
	public MancalaModel() {

		this.pitStones = new ArrayList<Integer>();
		this.undoStones = new ArrayList<Integer>();
		this.numStones = 0;
		this.winner = null;
		this.undoTurnA = 3;
		this.undoTurnB = 3;

		this.turnA = true;
		this.bonusTurn = false;
		this.currentTurnA = false;
		this.currentTurnB = false;
		this.undoA = false;
		this.undoB = false;

		//Initialize the number of stones to begin the game
		for(int i = 0; i < 6; i++){
			pitStones.add(numStones);			
		}	
		pitStones.add(0); 	//Initialize Mancala A

		for(int i = 0; i < 6; i++){
			pitStones.add(numStones);			
		}
		pitStones.add(0);	//Initialize Mancala B

	}//MancalaModel


	/**=============================== setNumStones ===============================
	 * Set the number of stones that will be stored in each pit before the game
	 */
	public void setNumStones(int numStones) {
		this.numStones = numStones;

		for(int i = 0; i <= 5; i++){
			pitStones.set(i, numStones);			
		}	
		pitStones.set(6, 0); 	//Initialize Mancala A

		for(int i = 7; i <= 12; i++){
			pitStones.set(i, numStones);			
		}
		pitStones.set(13, 0);	//Initialize Mancala B

		//Set the backup stones
		for(int i  = 0; i < pitStones.size(); i++){
			undoStones.add(pitStones.get(i));
		}
	}//setNumStones

	/**=============================== getNumStones ===============================
	 * Return the number of stones set before the game
	 */
	public int getNumStones() {
		return numStones;
	}//getNumStones

	/**=============================== getPitStones ===============================
	 * Return the list of pits. Each pit contains stones
	 */
	public ArrayList<Integer> getPitStones() {
		return pitStones;
	}//getPitStones

	/**=============================== updateStones ===============================
	 * Update the number of stones in each pit
	 */
	public void updateStones(String player, int pitLoc){
		int currentLoc = 0;
		int currentStones = 0;
		int index = 0;

		for(int i  = 0; i < pitStones.size(); i++){
			undoStones.set(i, pitStones.get(i));
		}

		if(player.equals("A")){
			currentLoc = pitLoc - 1;
			turnA = true;
		}else if(player.equals("B")){
			currentLoc = pitLoc + 7 - 1;
			turnA = false;
		}
		currentStones = pitStones.get(currentLoc);		
		pitStones.set(currentLoc, 0);	//Reset the current pit to 0

		//Traverse through pit list and change the number of stones in each pit (First Round)
		for(int i = currentLoc; i < (pitStones.size()-1) && currentStones != 0; i++){

			index = i+1;			
			pitStones.set(index, pitStones.get(i+1) + 1);
			currentStones--;
			//If it is player A, do not place the stone in Mancala B (index 13)
			if(player.equals("A") && index == 13){
				pitStones.set(index, pitStones.get(index) - 1);
				currentStones++;
			}
			//Free turn implementation
			if(currentStones == 0 && index == 6){
				bonusTurn = true;
			}else if(currentStones == 0 && index == 13){
				bonusTurn = true; 
			}
			//Capture stones implementation
			if(player.equals("A") && index >= 0 && index <= 5 && currentStones == 0){
				if(pitStones.get(index) == 1){					
					pitStones.set(6, pitStones.get(6) + pitStones.get(index) + pitStones.get(12-index));
					pitStones.set(index, 0);
					pitStones.set(12-index, 0);
				}
			}else if(player.equals("B") && index >= 7 && index <= 12 && currentStones == 0)
				if(pitStones.get(index) == 1){					
					pitStones.set(13,  pitStones.get(13) + pitStones.get(index) + pitStones.get(12-index));
					pitStones.set(index, 0);
					pitStones.set(12-index, 0);
				}		
		}

		//Traverse through pit list and change the number of stones in each pit 
		// (Do Until currentStones = 0)
		do{
			if(currentStones != 0){

				for(int j = 0; j < pitStones.size() && currentStones != 0; j++){
					pitStones.set(j, pitStones.get(j) + 1);
					currentStones--;
					//If it is player A, do not place the stone in Mancala B (index 13)
					if(player.equals("A") && j == 13){
						pitStones.set(j, pitStones.get(j) - 1);
						currentStones++;
					}
					//If it is player B, do not place the stone in Mancala B (index 6)
					if(player.equals("B") && j == 6){
						pitStones.set(j, pitStones.get(j) - 1);
						currentStones++;
					}	
					//Free turn implementation
					if(currentStones == 0 && j == 6){
						bonusTurn = true;
					}else if(currentStones == 0 && j == 13){
						bonusTurn = true;
					}

					//Capture stones implementation
					if(player.equals("A") && j >= 0 && j <= 5 && currentStones == 0){
						if(pitStones.get(j) == 1){					
							pitStones.set(6, pitStones.get(6) + pitStones.get(j) + pitStones.get(12-j));
							pitStones.set(j, 0);
							pitStones.set(12-j, 0);
						}
					}else if(player.equals("B") && j >= 7 && j <= 12 && currentStones == 0)
						if(pitStones.get(j) == 1){					
							pitStones.set(13,  pitStones.get(13) + pitStones.get(j) + pitStones.get(12-j));
							pitStones.set(j, 0);
							pitStones.set(12-j, 0);
						}
				}
			}
		}while(currentStones != 0);
		checkGameOver();
	}//updateStones

	/**=============================== checkGameOver ===============================
	 * Check the pits to see if the game is over
	 */
	public void checkGameOver(){

		int totalStonesA = 0;
		int totalStonesB = 0;

		for(int index = 0; index <= 5; index++){
			totalStonesA += pitStones.get(index);			
		}		

		for(int index = 7; index <= 12; index++){
			totalStonesB += pitStones.get(index);			
		}

		if(totalStonesA == 0){
			System.out.println("Game Over A");
			pitStones.set(13, pitStones.get(13)+totalStonesB);
			for(int index = 7; index <= 12; index++){
				pitStones.set(index, 0);			
			}
			
			setWinner(pitStones.get(6), pitStones.get(13));
		}

		if(totalStonesB == 0){
			System.out.println("Game Over B");
			pitStones.set(6, pitStones.get(6)+totalStonesA);
			for(int index = 0; index <= 5; index++){
				pitStones.set(index, 0);			
			}
			setWinner(pitStones.get(6), pitStones.get(13));
		}
	}//checkGameOver
	
	/**=============================== setWinner ===============================
	 * Calculate the total scores and set the winner of the game
	 * @param totalA total stones in mancala A
	 * @param totalB total stones in mancala B
	 */
	public void setWinner(int totalA, int totalB){
		if(totalA > totalB){
			this.winner = "Player A";
		}else if(totalA < totalB){
			this.winner = "Player B";
		}else if(totalA == totalB){
			this.winner = "No Winner";
		}
	}//setWinner

	/**==================================== undo ====================================
	 * Restore the previous state of the game
	 */
	public void undo(){

		if(currentTurnA){
			undoTurnA--;
			undoA = false;
		}
		else if(currentTurnB){
			undoTurnB--;
			undoB = false;
		}

		for(int i = 0; i < pitStones.size(); i++)
			pitStones.set(i, undoStones.get(i));
	}//undo

	/**================================= updateTurn =================================
	 * Update the turn for each player
	 */
	public void updateTurn(){

		if(currentTurnA == true && bonusTurn == false){
			currentTurnA = false;
			currentTurnB = true;
		}
		else if(currentTurnB == true && bonusTurn == false){
			currentTurnA = true;
			currentTurnB = false;
		}

		if(undoTurnA != 0)
			undoA = true;
		if(undoTurnB != 0)
			undoB = true;		
	}//updateTurn

	//================================ Getters & Setters ============================
	public boolean isTurnA() {
		return turnA;
	}

	public boolean isBonusTurn() {
		return bonusTurn;
	}

	public void setBonusTurn(boolean bonusTurn) {
		this.bonusTurn = bonusTurn;
	}

	public boolean isCurrentTurnA() {
		return currentTurnA;
	}

	public void setCurrentTurnA(boolean currentTurnA) {
		this.currentTurnA = currentTurnA;
	}

	public boolean isCurrentTurnB() {
		return currentTurnB;
	}

	public void setCurrentTurnB(boolean currentTurnB) {
		this.currentTurnB = currentTurnB;
	}

	public boolean isUndoA() {
		return undoA;
	}

	public boolean isUndoB() {
		return undoB;
	}

	public int getUndoTurnA() {
		return undoTurnA;
	}

	public int getUndoTurnB() {
		return undoTurnB;
	}


	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
}//MancalaModel
