import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import stone.StoneShape;
import mancala.CircularMancala;
import mancala.MancalaShape;

/** This class creates a panel B to store mancala shape and maintain the
 * 	number of stones in each mancala B
 * @author Dung Pham
 * @author Huy Vu
 */
public class MancalaPanelB extends JPanel{
	
	private MancalaModel manBModel;	
	private ArrayList<Integer> pitStones;
	private MancalaComponent mancalaCompB;

	/**=============================== MancalaPanelB ===============================
	 * Construct the mancala B for player B
	 * @param model - mancala data system
	 */
	public MancalaPanelB(MancalaModel model) {
		
		setPreferredSize(new Dimension(100,200));
		setLayout(new GridLayout(1,1));    
		
		this.manBModel = model;
		
		mancalaCompB = new MancalaComponent(new CircularMancala());
		mancalaCompB.setNumStones(0);	   
		add(mancalaCompB);
	}//MancalaPanelB
	
	/**=============================== updateMancalaB ===============================
	 * Update the view of Mancala B whenever number of stones is changed
	 */
	public void updateMancalaB(){
		
		this.pitStones = manBModel.getPitStones();
		mancalaCompB.setNumStones(pitStones.get(13));
		mancalaCompB.repaint();
	}//updateMancalaB
	
	/**=============================== updateStoneView ===============================
	 * Update the stone shape in mancala A
	 */
	public void updateStoneView(StoneShape shape){	
		mancalaCompB.setStone(shape);
		mancalaCompB.repaint();
	
	}//updateStoneView
	
	/**============================== updateMancalaView ==============================
	 * Update the mancala view when the macala shape style is changed 
	 * @param shape the new mancala shape style
	 */
	public void updateMancalaView(MancalaShape shape){
		mancalaCompB.setMancalaShape(shape);
		mancalaCompB.repaint();
	}//updateMancalaView
	
}//MancalaPanelB
