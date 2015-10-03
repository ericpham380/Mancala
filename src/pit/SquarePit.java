package pit;
import java.awt.geom.Rectangle2D;

/** This class will create a square pit shape object
 * @author Dung Pham
 * @author Huy Vu
 */
public class SquarePit extends PitCompoundShape{

	private static final int X = 10;
	private static final int Y = 5;
	private static final int WIDTH = 120;
	private static final int HEIGHT = 120;

	/**================================= SquarePit =================================
	 * Construct a square pit shape and add to the GeneralPath
	 */
	public SquarePit() {		
		
		Rectangle2D.Double squarePit = new Rectangle2D.Double(X, Y, WIDTH, HEIGHT);	
		add(squarePit);
	}//SquarePit
	
}//SquarePit
