import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class TrackControl implements ActionListener{

    private JButton L0;
    private JButton L1;
    private JButton L2;
    private JButton L3;
    private JButton R0;
    private JButton R1;
    private JButton R2;
    private JButton R3;
    private JButton start;
    private JButton stop;
    private JButton load;
    private JLabel lbl0;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private int index0 = 0;
    private int index1 = 1;
    private int index2 = 2;
    private int	index3 = 3;

    //TrackControl grabs all the buttons from TrackGUI
    public TrackControl(JButton L0, JButton L1, JButton L2, JButton L3, JButton R0, JButton R1, JButton R2, JButton R3,
    						JLabel lbl0, JLabel lbl1, JLabel lbl2, JLabel lbl3, JButton start, JButton stop, JButton load) {
        this.L0 = L0;
        this.L1 = L1;
        this.L2 = L2;
        this.L3 = L3;
        this.R0 = R0;
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
        this.lbl0 = lbl0;
        this.lbl1 = lbl1;
        this.lbl2 = lbl2;
        this.lbl3 = lbl3;
        this.start = start;
        this.stop = stop;
        this.load = load;
    }

    public void partConflict() {
    	//Set all the labels to black
    	lbl0.setForeground(Color.BLACK);
    	lbl1.setForeground(Color.BLACK);
    	lbl2.setForeground(Color.BLACK);
    	lbl3.setForeground(Color.BLACK);
    	start.setEnabled(true);
    	
    	if (index0 == index1) {
			lbl0.setForeground(Color.GRAY);
			lbl1.setForeground(Color.GRAY);
			start.setEnabled(false);
		}
    	if (index0 == index2) {
			lbl0.setForeground(Color.GRAY);
			lbl2.setForeground(Color.GRAY);
			start.setEnabled(false);
		}
    	if (index0 == index3) {
			lbl0.setForeground(Color.GRAY);
			lbl3.setForeground(Color.GRAY);
			start.setEnabled(false);
		}
    	if (index1 == index2) {
			lbl1.setForeground(Color.GRAY);
			lbl2.setForeground(Color.GRAY);
			start.setEnabled(false);
		}
    	if (index1 == index3) {
			lbl1.setForeground(Color.GRAY);
			lbl3.setForeground(Color.GRAY);
			start.setEnabled(false);
		}
    	if (index2 == index3) {
			lbl2.setForeground(Color.GRAY);
			lbl3.setForeground(Color.GRAY);
			start.setEnabled(false);
		}
    }
    
    public void actionPerformed(ActionEvent e) {
    	String[] parts = new String[] {"High 1", "High 2", " Mid  ", " Bass "};
    	if (e.getSource() == L0) {
    		if (index0 > 0)
    			index0--;
    		else
    			index0 = 3;
    		lbl0.setText(parts[index0]);
    		partConflict();

    	}
    	else if (e.getSource() == L1)  {
    		if (index1 > 0)
    			index1--;
    		else
    			index1 = 3;
    		lbl1.setText(parts[index1]);
    		partConflict();
    	}
    	else if (e.getSource() == L2)  {
    		if (index2 > 0)
    			index2--;
    		else
    			index2 = 3;
    		lbl2.setText(parts[index2]);
    		partConflict();

    	}
    	else if (e.getSource() == L3)  {
    		if (index3 > 0)
    			index3--;
    		else
    			index3 = 3;
    		lbl3.setText(parts[index3]);
    		partConflict();
    	}
    	
    	else if (e.getSource() == R0)  {
    		if (index0 < 3)
    			index0++;
    		else
    			index0 = 0;
    		lbl0.setText(parts[index0]);
    		partConflict();
    	}
    	else if (e.getSource() == R1)  {
    		if (index1 < 3)
    			index1++;
    		else
    			index1 = 0;
    		lbl1.setText(parts[index1]);
    		partConflict();
    	}
    	else if (e.getSource() == R2)  {
    		if (index2 < 3)
    			index2++;
    		else
    			index2 = 0;
    		lbl2.setText(parts[index2]);
    		partConflict();
    	}
    	else if (e.getSource() == R3)  {
    		if (index3 < 3)
    			index3++;
    		else
    			index3 = 0;
    		lbl3.setText(parts[index3]);
    		partConflict();
    	}
    	else if (e.getSource() == start) {
    		//START STUFF GOES HERE
    	}
    	else if (e.getSource() == stop) {
    		//STOP STUFF GOES HERE
    	}
    	else if (e.getSource() == load) {
    		//LOAD STUFF GOES HERE
    	}
    }
	
}
