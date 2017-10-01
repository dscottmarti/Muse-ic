import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TrackControl implements ActionListener{

    private JButton L0;
    private JButton L1;
    private JButton L2;
    private JButton L3;
    private JButton R0;
    private JButton R1;
    private JButton R2;
    private JButton R3;

    //TrackControl grabs all the buttons from TrackGUI
    public TrackControl(JButton L0, JButton L1, JButton L2, JButton L3, JButton R0, JButton R1, JButton R2, JButton R3) {
        this.L0 = L0;
        this.L1 = L1;
        this.L2 = L2;
        this.L3 = L3;
        this.R0 = R0;
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
    }

    public void actionPerformed(ActionEvent e) {
    	String[] parts = new String[] {"High 1", "High 2", "  Mid  ", "  Bass  "};
    	if (e.getSource() == L0) {
    		
    	}
    	else if (e.getSource() == L1)  {
    		System.out.println("Here too");
    	}
    	else if (e.getSource() == L2)  {
    		System.out.println("Here too");
    	}
    	else if (e.getSource() == L3)  {
    		System.out.println("Here too");
    	}
    	else if (e.getSource() == R0)  {
    		System.out.println("Here too");
    	}
    	else if (e.getSource() == R1)  {
    		System.out.println("Here too");
    	}
    	else if (e.getSource() == R2)  {
    		System.out.println("Here too");
    	}
    	else if (e.getSource() == R3)  {
    		System.out.println("Here too");
    	}
    }
	
}
