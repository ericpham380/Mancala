package mancala;
import java.awt.*;
import java.awt.geom.*;

/** Mancala shape interface 
 * @author Dung Pham
 * @author Huy Vu
 */
public interface MancalaShape {

	void draw(Graphics2D g2);
	boolean contains(Point2D p);
}//MancalaShape
