import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import stone.CircularStone;
import stone.StoneShape;
import mancala.MancalaShape;

/** Create a mancala component, and draw the number of stones in each mancala
 * according to each turn of the player
 * @author Dung Pham
 * @author Huy Vu
 */
public class MancalaComponent extends JComponent {

	private MancalaShape mancalaShape;
	private int numStones;
	private StoneShape stone;

	/**============================= MancalaComponent =============================
	 * Construct a mancala component for each player
	 * @param mancala shape of the mancala
	 */
	public MancalaComponent(MancalaShape mancala) {

		this.mancalaShape = mancala;

		stone = new CircularStone(numStones);
		stone.setMaxHeight(24);			
	}//MancalaComponent

	/**=============================== paintComponent =============================
	 * Override the paintComponent to draw the mancala shape and included stones
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		mancalaShape.draw(g2);
		g2.translate(30, 30);
		stone.setNumOfStones(this.numStones);
		stone.draw(g2);		
	}//paintComponent

	/**=============================== getNumStones ===============================
	 * Get the number of stones from this particular mancala component
	 * @return stone number of the pit
	 */
	public int getNumStones() {
		return numStones;
	}//getNumStones

	/**=============================== setNumStones ===============================
	 * Set the number of stones of a particular mancala component
	 * @param number - the number to be set
	 */
	public void setNumStones(int numStones) {
		this.numStones = numStones;
	}

	/**================================= setStone =================================
	 * Set the stone shape style to be drawn in mancala
	 * @param stone the stone shape object
	 */
	public void setStone(StoneShape stone) {
		this.stone = stone;
		stone.setMaxHeight(24);
	}//setStone

	/**============================ setMancalaShape ===============================
	 * Set the mancala shape style of the game
	 * @param mancalaShape the mancala shape object
	 */
	public void setMancalaShape(MancalaShape mancalaShape) {
		this.mancalaShape = mancalaShape;
	}//setMancalaShape

}//MancalaComponent

