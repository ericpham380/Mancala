/**
 * The main testing mancala game
 * @author Dung Pham
 * @author Huy Vu
 */

public class MancalaTest {
	public static void main(String[] args) {
		
		MancalaModel model = new MancalaModel();		
		MancalaView view  = new MancalaView(model);		
		MancalaControl control = new MancalaControl(model, view);		
		view.attach(control);				
	}//main
}//MancalaTest

