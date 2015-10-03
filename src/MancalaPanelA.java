import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import stone.StoneShape;
import mancala.CircularMancala;
import mancala.MancalaShape;

/** This class creates a panel A to store mancala shape and maintain the
 * 	number of stones in each mancala A
 * @author Dung Pham
 * @author Huy Vu
 */
public class MancalaPanelA extends JPanel{
	
	private MancalaModel manAModel;	
	private ArrayList<Integer> pitStones;
	private MancalaComponent mancalaCompA;

	/**=============================== MancalaPanelA ===============================
	 * Construct the mancala A for player A
	 * @param model - mancala data system
	 */
	public MancalaPanelA(MancalaModel model) {
		
		this.manAModel = model;
		setPreferredSize(new Dimension(100,200));
		setLayout(new GridLayout(1,1));     
		
		this.mancalaCompA = new MancalaComponent(new CircularMancala());
		this.mancalaCompA.setNumStones(0);	  
		add(mancalaCompA);
	}//MancalaPanelA
	
	/**=============================== updateMancalaA ===============================
	 * Update the view of Mancala A whenever number of stones is changed
	 */
	public void updateMancalaA(){
		
		this.pitStones = manAModel.getPitStones();
		mancalaCompA.setNumStones(pitStones.get(6));
		mancalaCompA.repaint();
	}//updateMancalaA
	
	/**=============================== updateStoneView ===============================
	 * Update the stone shape in mancala A
	 * @param shape the stone style inside the mancala
	 */
	public void updateStoneView(StoneShape shape){	
		
		mancalaCompA.setStone(shape);
		mancalaCompA.repaint();	
	}//updateStoneView
	
	/**============================== updateMancalaView ==============================
	 * Update the mancala view when the macala shape style is changed 
	 * @param shape the new mancala shape style
	 */
	public void updateMancalaView(MancalaShape shape){
		
		mancalaCompA.setMancalaShape(shape);
		mancalaCompA.repaint();
	}//updateMancalaView
	
}//MancalaPanelA
