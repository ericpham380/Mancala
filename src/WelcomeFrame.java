import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mancala.CircularMancala;
import mancala.SquareMancala;
import stone.CircularStone;
import stone.SquareStone;

/** This class create all the components for the setup frame, taking user's
 * choices for pits, stones, and mancalas
 * @author Dung Pham
 * @author Huy Vu
 */
public class WelcomeFrame extends JFrame{

	private int numStones;
	private MancalaModel wModel;
	private MancalaControl wControl;

	/**============================= WelcomeFrame ===================================
	 * Construct the welcome frame that will take player choice for the game play
	 * @param model the model of mancala
	 */
	public WelcomeFrame(MancalaModel model) {

		setSize(500,300);
		setLocationRelativeTo(null);
		setTitle("Mancala Setup");
		setLayout(new FlowLayout());

		this.wModel = model;

		//============================= Stone Panel ===================================
		JPanel stoneNumber = new JPanel();
		stoneNumber.setLayout(new FlowLayout());
		stoneNumber.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		stoneNumber.setPreferredSize(new Dimension(450,60));
		JLabel stoneNumberLabel = new JLabel("Choose the number of stones in each pit: ");
		stoneNumberLabel.setHorizontalAlignment(JLabel.LEFT);

		final JButton button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {   
			@Override
			public void actionPerformed(ActionEvent e) {
				numStones = Integer.parseInt(button3.getText());
				wControl.changeNumStones(numStones);
			}
		});
		final JButton button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numStones = Integer.parseInt(button4.getText());
				wControl.changeNumStones(numStones);
			}
		});
		//============================= Stone Style Panel ===================================
		JPanel stoneStyle = new JPanel();
		stoneStyle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		stoneStyle.setPreferredSize(new Dimension(450,50));
		JLabel stoneStyleLabel = new JLabel("Stone Style: ");
		stoneStyleLabel.setHorizontalAlignment(JLabel.LEFT);
		
		JComponent circularStone = new JComponent(){			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D)g;
				Ellipse2D.Double stone = new Ellipse2D.Double(0, 0, 25, 25);
				g2.setColor(Color.DARK_GRAY);
				g2.draw(stone);
				g2.fill(stone);				
			}								
		};	
		circularStone.setPreferredSize(new Dimension(40, 30));
		circularStone.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				wControl.changeStoneShape(new CircularStone(wModel.getNumStones()),
													new CircularStone(wModel.getNumStones()));
			}
			
		});
		
		JComponent squareStone = new JComponent(){			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D)g;
				Rectangle2D.Double stone = new Rectangle2D.Double(0, 0, 25, 25);
				g2.setColor(Color.RED);
				g2.draw(stone);
				g2.fill(stone);				
			}								
		};	
		squareStone.setPreferredSize(new Dimension(40, 30));
		squareStone.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				wControl.changeStoneShape(new SquareStone(wModel.getNumStones()), 
												new SquareStone(wModel.getNumStones()));
			}		
		});
		
		//============================= Pit Style Panel ===================================
		JPanel pitStyle = new JPanel();
		pitStyle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

		pitStyle.setPreferredSize(new Dimension(450,50));
		JLabel pitStyleLabel = new JLabel("Pit Style: ");
		pitStyleLabel.setHorizontalAlignment(JLabel.LEFT);
		
		JComponent circularPit = new JComponent(){			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D)g;
				Ellipse2D.Double pit = new Ellipse2D.Double(0, 0, 25, 25);
				g2.setColor(Color.DARK_GRAY);
				g2.draw(pit);
			}								
		};	
		circularPit.setPreferredSize(new Dimension(40, 30));
		circularPit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				wControl.changeCircularPit();
			}
			
		});
		
		JComponent squarePit = new JComponent(){			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D)g;
				Rectangle2D.Double pit = new Rectangle2D.Double(0, 0, 25, 25);
				g2.setColor(Color.RED);
				g2.draw(pit);
			}								
		};	
		squarePit.setPreferredSize(new Dimension(40, 30));
		squarePit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				wControl.changeSquarePit();
			}			
		});
		
		//============================= Mancala Style Panel ===================================
		JPanel mancalaStyle = new JPanel();
		mancalaStyle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

		mancalaStyle.setPreferredSize(new Dimension(500,50));
		JLabel mancalaStyleLabel = new JLabel("Mancala Style: ");
		mancalaStyleLabel.setHorizontalAlignment(JLabel.LEFT);
		
		JComponent circularMancala = new JComponent(){			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D)g;
				Ellipse2D.Double mancala = new Ellipse2D.Double(0, 0, 15, 25);
				g2.setColor(Color.DARK_GRAY);
				g2.draw(mancala);
			}								
		};	
		circularMancala.setPreferredSize(new Dimension(40, 30));
		circularMancala.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				wControl.changeMancalaShape(new CircularMancala());
			}
			
		});
		
		JComponent squareMancala = new JComponent(){			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D)g;
				Rectangle2D.Double mancala = new Rectangle2D.Double(0, 0, 15, 25);
				g2.draw(mancala);
			}								
		};	
		squareMancala.setPreferredSize(new Dimension(40, 30));
		squareMancala.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				wControl.changeMancalaShape(new SquareMancala());
			}
			
		});
		
		//============================= Done Button ===================================
		JButton doneButton = new JButton("DONE");
		doneButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				wControl.closeWelcomeScreen();
				
			}
		});
		
		stoneNumber.add(stoneNumberLabel);
		stoneNumber.add(button3);
		stoneNumber.add(button4);
		
		stoneStyle.add(stoneStyleLabel);	
		stoneStyle.add(circularStone);
		stoneStyle.add(squareStone);
		
		pitStyle.add(pitStyleLabel);
		pitStyle.add(circularPit);
		pitStyle.add(squarePit);
		
		mancalaStyle.add(mancalaStyleLabel);
		mancalaStyle.add(circularMancala);
		mancalaStyle.add(squareMancala);

		add(stoneNumber);		
		add(pitStyle);
		add(stoneStyle);
		add(mancalaStyle);
		add(doneButton);
		setVisible(true);

	}
	
	/**=============================== attach ===============================
	 * Attach 'control' to main Welcome view
	 * @param control - MVC - Control object
	 */
	public void attach(MancalaControl control){
		
		this.wControl = control;		
	}//attach
	
}//WelcomeFrame
