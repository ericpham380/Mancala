import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import pit.PitShape;
import stone.CircularStone;
import stone.StoneShape;

/** This class create a pit component with mouse listener to listen
 *  to user's action when pressing on the each pit
 * 
 * @author Dung Pham
 * @author Huy Vu
 */
public class PitComponent extends JComponent{

	private MancalaControl pitControl;

	private PitShape pitShape;
	private Point mousePoint;
	private String pitLocation;
	private int numStones;
	private StoneShape stone;
	private Color pitColor;

	/**================================== PitComponent ==================================
	 * Construct a pit component & add mouse listener to this component
	 * @param pit - PitShape object
	 */
	public PitComponent(final PitShape pit, final String pitIndex) {

		this.pitShape = pit;
		this.pitLocation = pitIndex;
		
		//Create a stone object, passing down the number of stones to be drawn & radius
		this.stone = new CircularStone(numStones);
		this.stone.setMaxHeight(8);
		this.pitColor = Color.DARK_GRAY;

		//Attach MouseListener to each pit component
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event){
				if(isEnabled())
				{
					mousePoint = event.getPoint();				
					if(pit.contains(mousePoint)){
						pitControl.moveStone(pitLocation,numStones);
				}}
			}			
		});	
	}//PitComponent

	/**================================= paintComponent =================================
	 * Paint this component by calling draw method in OvalShape or EllipseShape
	 * @param g - Graphics component
	 */
	@Override
	public void paintComponent(Graphics g){
				
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(pitColor);
		pitShape.draw(g2);
		g2.translate(40, 30);
		stone.setNumOfStones(this.numStones);
		stone.draw(g2);
	}//paintComponent

	/**=============================== attach ===============================
	 * Attach 'control' to each PitComponent view
	 * @param control - MVC - Control object
	 */
	public void attach(MancalaControl control){
		this.pitControl = control;
	}

	/**=============================== getNumStones ===============================
	 * Get the number of stones from this particular pit component
	 * @return stone number of the pit
	 */
	public int getNumStones() {
		return numStones;
	}//getNumStones

	/**=============================== setNumStones ===============================
	 * Set the number of stones of a particular pit component
	 * @param number - the number to be set
	 */
	public void setNumStones(int number) {
		this.numStones = number;
	}//setNumStones

	/**================================= setStone =================================
	 * Set the stone style of the pit according to the players
	 * @param stone the stone style object
	 */
	public void setStone(StoneShape stone) {
		this.stone = stone;
		stone.setMaxHeight(8);
	}//setStone

	/**=============================== setPitShape ===============================
	 * Set the shape of the pit according to the players
	 * @param pitShape the pit style
	 */
	public void setPitShape(PitShape pitShape) {
		this.pitShape = pitShape;
	}//setPitShape

	/**=============================== setPitColor ===============================
	 * Set the color of the pit
	 * @param pitColor a color
	 */
	public void setPitColor(Color pitColor) {
		this.pitColor = pitColor;
	}//setPitColor

}//PitComponent
