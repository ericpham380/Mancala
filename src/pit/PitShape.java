package pit;
import java.awt.*;
import java.awt.geom.*;

/** Pit shape interface 
 * @author Dung Pham
 * @author Huy Vu
 */
public interface PitShape {

	void draw(Graphics2D g2);
	boolean contains(Point2D p);
}
