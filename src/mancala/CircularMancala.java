package mancala;
import java.awt.geom.Ellipse2D;

/** This class will create a circular mancala shape object
 * @author Dung Pham
 * @author Huy Vu
 */
public class CircularMancala extends MancalaCompoundShape{

	private static final int X = 5;
	private static final int Y = 5;
	private static final int WIDTH = 90;
	private static final int HEIGHT = 250;
	
	/**================================= CircularMancala =================================
	 * Construct a circular mancala shape and add to the GeneralPath
	 */
	public CircularMancala()
	{
		Ellipse2D circularMancala = new Ellipse2D.Double(X, Y, WIDTH, HEIGHT);
		add(circularMancala);
	}//CircularMancala
		
}//CircularMancala

