package mancala;
import java.awt.geom.Rectangle2D;

/** This class will create a square mancala shape object
 * @author Dung Pham
 * @author Huy Vu
 */
public class SquareMancala extends MancalaCompoundShape{

	private static final int X = 5;
	private static final int Y = 5;
	private static final int WIDTH = 90;
	private static final int HEIGHT = 250;
	
	/**================================= SquareMancala =================================
	 * Construct a square mancala shape and add to the GeneralPath
	 */
	public SquareMancala()
	{
		Rectangle2D.Double squareMancala = new Rectangle2D.Double(X, Y, WIDTH, HEIGHT);
		add(squareMancala);
	}//SquareMancala
	
}//SquareMancala
