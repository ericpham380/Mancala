package stone;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/** This class creates the circular stones and draw them according to the number 
 *  set in each pit and mancala
 * @author Dung Pham
 * @author Huy Vu
 */
public class CircularStone implements StoneShape{

	private static final int RADIUS = 8;
	private int maxHeight;
	private int numOfStones;

	/**============================= CircularStone =============================
	 * Construct the circular stone object
	 * @param amount the amount stones to be drawn
	 */
	public CircularStone(int amount)
	{
		this.numOfStones = amount;
	}//CircularStone

	/**============================= setNumOfStones =============================
	 * Set the new number of stones to be drawn
	 */
	public void setNumOfStones(int newAmount)
	{
		this.numOfStones = newAmount;
	}//setNumOfStones
	
	/**============================== setMaxHeight ==============================
	 * Set the maximum height inside the pit, so stones wont be drawn outside
	 * of bound
	 */
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}//setMaxHeight

	/**================================= draw ===================================
	 * Draw the circular stones based on the number given
	 */
	public void draw(Graphics2D g2)
	{
		int x = 0;
		int y = 0;
		for(int i = 0; i < numOfStones; i++)
		{
			if(y > maxHeight)
			{
				y = 0;
				x += 2;
			}
			g2.setColor(Color.DARK_GRAY);
			Ellipse2D.Double stone = new Ellipse2D.Double(x*RADIUS, y*RADIUS, RADIUS, RADIUS);
			g2.draw(stone);
			g2.fill(stone);			
			y += 2;
		}
	}//draw

}//CirculaStone
