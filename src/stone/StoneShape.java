package stone;
import java.awt.Graphics2D;

/** Stone shape interface
 * @author Dung Pham
 * @author Huy Vu
 */
public interface StoneShape {

	public void draw(Graphics2D g2);
	public void setNumOfStones(int amount);
	public void setMaxHeight(int maxHeight);
}
