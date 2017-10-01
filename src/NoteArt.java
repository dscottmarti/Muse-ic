import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class NoteArt extends JPanel implements ActionListener{
    int[] xPixel = new int[50];
    int[] yPixel = new int[50]; 
    int[] size = new int[50];
    int[] increment = new int[50];
    Image[] musicNote = new Image[50];
    Timer t = new Timer(5,this);
    
    public NoteArt(){
    	String[] images = new String[]{"Green75.png", "Green50.png", "Orange75.png", "Orange50.png", "Pink75.png", "Pink50.png", "Blue75.png", "Blue50.png"};
		int index;
		
		//Set the arrays to random values
		for (int i=0; i<50; i++) {
			xPixel[i] = (int) (Math.random() * 1000) - 1100;
			yPixel[i] = (int) (Math.random() * 350);
			size[i] = (int) ((Math.random() * 50) + 10);
			increment[i] = (int) ((Math.random() * 3) + 1); 
			index = (int) (Math.random() * (images.length - 1));
			musicNote[i] = Toolkit.getDefaultToolkit().getImage(images[index]);
		}
   }
   
   @Override
   public void paintComponent(Graphics g){
	   super.paintComponent(g);
	   for (int i=0; i<50; i++) {
		   g.drawImage(musicNote[i], xPixel[i], yPixel[i], size[i], size[i], this);
		   t.start();
	   }
   } 
   

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	for (int i=0; i<50; i++) {
		xPixel[i] = xPixel[i] + increment[i];
		if (xPixel[i] > 750) {
			xPixel[i] = (int) (Math.random() * 1000) - 1100;
		}	
	}
	repaint();
	}
}