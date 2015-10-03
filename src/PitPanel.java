import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JPanel;

import pit.CircularPit;
import pit.SquarePit;
import stone.StoneShape;

/** Create panel to store all the pits for each player
 * @author Dung Pham
 * @author Huy Vu
 */
public class PitPanel extends JPanel{
	private ArrayList<Integer> pitStones;
	
	private ArrayList<PitComponent> pitSetA;
	private ArrayList<PitComponent> pitSetB;

	private MancalaModel pModel;
	
	/**=============================== MancalaControl ===============================
	 * Construct the panel containing 6 pits
	 * @param model - mancala data system
	 */
	public PitPanel(MancalaModel model) {
		
		this.pModel = model;
		setPreferredSize(new Dimension(720,240));
		setLayout(new GridLayout(2,1));	
		
		//Create a 2 lists, each has 6 pit components
		pitSetA = new ArrayList<PitComponent>();
		pitSetB = new ArrayList<PitComponent>();
		
		for(int i = 0; i < 6; i++){
			//Initialize pit objects for player A
			PitComponent pitA = new PitComponent(new CircularPit(),
					"A".concat(Integer.toString(i+1)));
			pitA.setNumStones(pModel.getNumStones());
			pitSetA.add(pitA);
			//Initialize pit objects for player B
			PitComponent pitB = new PitComponent(new CircularPit(), 
					"B".concat(Integer.toString(i+1)));
			pitB.setNumStones(pModel.getNumStones());
			pitSetB.add(pitB);
		}
		
		//Player A on the BOTTOM
		JPanel pitPanelA = new JPanel();	
		pitPanelA.setLayout(new GridLayout(1,6));
		for(int i = 0; i < 6; i++){
			pitPanelA.add(pitSetA.get(i));
		}

		//Player B on the TOP
		JPanel pitPanelB = new JPanel();
		pitPanelB.setLayout(new GridLayout(1,6));

		ListIterator<PitComponent> iter = pitSetB.listIterator(pitSetB.size());
		while(iter.hasPrevious()){
			pitPanelB.add(iter.previous());
		}

		add(pitPanelB);
		add(pitPanelA);
	}//PitPanel

	/**================================== attach ==================================
	 * Attach 'control' to PitPanel view, and for each pit in the lists
	 * @param control - MVC - Control object
	 */
	public void attach(MancalaControl control){
		
		for(PitComponent p : pitSetA){
			p.attach(control);
		}

		for(PitComponent p : pitSetB){
			p.attach(control);
		}		
	}//attach
	
	/**=============================== updatePitView ===============================
	 * Get the latest data from mancala model and update the view accordingly
	 */
	public void updatePitView(){
		
		int count = 0;
		this.pitStones = pModel.getPitStones();
		
		for(int i = 0; i < 6; i++){
			pitSetA.get(i).setNumStones(pitStones.get(i));			
			pitSetA.get(i).repaint();
		}
			
		for(int j = 7; j < 13; j++){			
			pitSetB.get(count).setNumStones(pitStones.get(j));
			pitSetB.get(count).repaint();
			count++;
		}		
		
		//Setting the player' turn
		if(pModel.isCurrentTurnA() == true){
			ListIterator<PitComponent> iter1 = pitSetA.listIterator();
			while(iter1.hasNext()){
				iter1.next().setEnabled(true);
			}
			ListIterator<PitComponent> iter2 = pitSetB.listIterator();
			while(iter2.hasNext()){
				iter2.next().setEnabled(false);
			}
		}
		else if(pModel.isCurrentTurnB() == true){
			ListIterator<PitComponent> iter1 = pitSetA.listIterator();
			while(iter1.hasNext()){
				iter1.next().setEnabled(false);
			}
			ListIterator<PitComponent> iter2 = pitSetB.listIterator();
			while(iter2.hasNext()){
				iter2.next().setEnabled(true);
			}
		}		
	}//updatePitView
	
	/**=============================== updateStoneView ===============================
	 * Update the stone view inside the pit
	 */
	public void updateStoneView(StoneShape shape){
		
		int count = 0;		
		for(int i = 0; i < 6; i++){
			pitSetA.get(i).setStone(shape);		
			pitSetA.get(i).repaint();
		}
			
		for(int j = 7; j < 13; j++){			
			pitSetB.get(count).setStone(shape);		
			pitSetB.get(count).repaint();
			count++;
		}		
	}//updateStoneView
	
	/**=============================== updateCircularPit ===============================
	 * Update the pit view to circular shape style
	 */
	public void updateCircularPit(){
		
		for(int i = 0; i < 6; i++){		
			pitSetA.get(i).setNumStones(pModel.getNumStones());
			pitSetA.get(i).setPitShape(new CircularPit());	
			pitSetA.get(i).setPitColor(Color.DARK_GRAY);
			pitSetA.get(i).repaint();
			
			pitSetB.get(i).setNumStones(pModel.getNumStones());
			pitSetB.get(i).setPitShape(new CircularPit());
			pitSetB.get(i).setPitColor(Color.DARK_GRAY);
			pitSetB.get(i).repaint();
		}		
	}//updateCircularPit
	
	/**=============================== updateSquarePit ===============================
	 * Update the pit view to square pit
	 */
	public void updateSquarePit(){
		
		for(int i = 0; i < 6; i++){		
			pitSetA.get(i).setNumStones(pModel.getNumStones());
			pitSetA.get(i).setPitShape(new SquarePit());
			pitSetA.get(i).setPitColor(Color.RED);
			pitSetA.get(i).repaint();
			
			pitSetB.get(i).setNumStones(pModel.getNumStones());
			pitSetB.get(i).setPitShape(new SquarePit());
			pitSetB.get(i).setPitColor(Color.RED);
			pitSetB.get(i).repaint();
		}	
	}//updateSquarePit
		
}//PitPanel
