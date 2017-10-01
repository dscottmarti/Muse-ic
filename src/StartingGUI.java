import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLayeredPane;

public class StartingGUI extends JPanel{

	public JFrame frame;
	public JButton btnLoadBrainwaves;
	static Image musicNote;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public StartingGUI() {
		initialize();
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 700, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
	
		ImageIcon title = new ImageIcon("TitleBlue.png");
		//-0ImageIcon title = new ImageIcon("TitleGreenBrain.png");
		//JLabel lblMuseic = new JLabel("Muse-ic");
		JLabel lblMuseic = new JLabel(title);
		lblMuseic.setForeground(new Color(255, 0, 51));
		lblMuseic.setHorizontalAlignment(SwingConstants.CENTER);
		lblMuseic.setFont(new Font("Sitka Subheading", Font.BOLD, 40));
		frame.getContentPane().add(lblMuseic, BorderLayout.NORTH);
		
		JPanel panel = new NoteArt();
		panel.setOpaque(false);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		ImageIcon button = new ImageIcon("BrainButton.png");
		btnLoadBrainwaves = new JButton(button);
		//JButton btnLoadBrainwaves = new JButton("Upload Brainwaves");
		btnLoadBrainwaves.setBorder(null);
		btnLoadBrainwaves.setOpaque(false);
		btnLoadBrainwaves.setContentAreaFilled(false);
		btnLoadBrainwaves.setBorderPainted(false);
		btnLoadBrainwaves.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(208)
					.addComponent(btnLoadBrainwaves, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addGap(243))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(94)
					.addComponent(btnLoadBrainwaves, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(205, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
