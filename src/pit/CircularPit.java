package pit;
import java.awt.geom.Ellipse2D;

/** This class will create a circular pit shape object
 * @author Dung Pham
 * @author Huy Vu
 */
public class CircularPit extends PitCompoundShape{
	
	private static final int X = 10;
	private static final int Y = 5;
	private static final int WIDTH = 120;
	private static final int HEIGHT = 120;

	/**================================= CircularPit =================================
	 * Construct a circular mancala shape and add to the GeneralPath
	 */
	public CircularPit() {
		
		Ellipse2D ovalPit = new Ellipse2D.Double(X, Y, WIDTH, HEIGHT);		
		add(ovalPit);
	}//CircularPit
	
}//CircularPit
