package pit;
import java.awt.*;
import java.awt.geom.*;

/** This class contains methods to manage different shapes of the pits
 * @author Dung Pham
 * @author Huy Vu
 */
public class PitCompoundShape implements PitShape {
	
	private GeneralPath path;

	public PitCompoundShape()
	{
		path = new GeneralPath();
	}

	protected void add(Shape s)
	{
		path.append(s, false);
	}

	public void draw(Graphics2D g2)
	{
		g2.draw(path);
	}

	public boolean contains(Point2D aPoint)
	{
		return path.contains(aPoint);
	}
}
