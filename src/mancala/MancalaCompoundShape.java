package mancala;
import java.awt.*;
import java.awt.geom.*;

/** This class contains methods to manage different shapes of mancala
 * @author Dung Pham
 * @author Huy Vu
 */
public class MancalaCompoundShape implements MancalaShape {
	
	private GeneralPath path;

	public MancalaCompoundShape()
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
