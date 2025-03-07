import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 100;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4;
	private static final int EYE_X = HEAD_DIMENSION/4;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/3;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 10;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 10;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/4;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * 2;
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * 3;
	
	// whiskers are about 1/4 the size of the head
		private static final int WHISKER_LENGTH = HEAD_DIMENSION/4;
		private static final int WHISKER_SLANT = 5;
		private static final int NUM_WHISKERS = 3;
	
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		// Draw the head
		g2.setColor(Color.black);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
		// Draw the eyes
		g2.setColor(Color.green);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		// Draw the mouth
		g2.setColor(Color.pink);
		x = catX + MOUTH_X;
		y = catY + MOUTH_Y;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		g2.setColor(Color.black);
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		g2.drawString("Meow", catX, catY+HEAD_DIMENSION+10);	
		// Draw whiskers
		g2.setColor(Color.white);
		// Draw whiskers on the left of face
		// -2 draws whisker just to left of mouth
		x = catX + MOUTH_X - 2;
		// x2 is the other endpoint, depends on length of whisker 
		int x2 = x - WHISKER_LENGTH;
		// whiskers all start at the same "height" as the mouth, centered
		y = catY + MOUTH_Y + MOUTH_HEIGHT/2;
		// -5 gives a slight slant
		int y2 = y - WHISKER_SLANT;
		for (int i=0; i<NUM_WHISKERS; i++)
		{
			g2.drawLine(x, y, x2, y2);
			y2 += WHISKER_SLANT; 			
		}
		// Draw whiskers on the right of face, y stays the same
		x = catX + MOUTH_X + MOUTH_WIDTH + 2;
		x2 = x + WHISKER_LENGTH; 
		y2 = y - WHISKER_SLANT;
		for (int i=0; i<NUM_WHISKERS; i++)
		{
			g2.drawLine(x, y, x2, y2);
			y2 += WHISKER_SLANT; 			
		}
	}
}
