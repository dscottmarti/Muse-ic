import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.JButton;

public class TrackGUI implements ActionListener{

	private JFrame frame;
	public final static String CMD_L0 = "CMD_L0";
	public final static String CMD_L1 = "CMD_L1";
	public final static String CMD_L2 = "CMD_L2";
	public final static String CMD_L3 = "CMD_L3";
	public final static String CMD_R0 = "CMD_R0";
	public final static String CMD_R1 = "CMD_R1";
	public final static String CMD_R2 = "CMD_R2";
	public final static String CMD_R3 = "CMD_R3";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrackGUI window = new TrackGUI();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TrackGUI() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(121)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
					.addGap(96))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addGap(61))
		);
		panel.setLayout(new BorderLayout(0, 0));
		

		ImageIcon arrowL = new ImageIcon("ArrowL.png");
		ImageIcon arrowR = new ImageIcon("ArrowR.png");
		
		JPanel TopEeg = new JPanel();
		panel.add(TopEeg, BorderLayout.NORTH);
		TopEeg.setLayout(new BorderLayout(0, 0));
		
		JPanel Eeg0 = new JPanel();
		Eeg0.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TopEeg.add(Eeg0, BorderLayout.NORTH);
	
		JLabel lblEeg0 = new JLabel("Eeg 0:");
		lblEeg0.setFont(new Font("Serif", Font.BOLD, 24));
		Eeg0.add(lblEeg0);
		
		JButton btnLeft0 = new JButton(arrowL);
		btnLeft0.setBorder(null);
		btnLeft0.setOpaque(false);
		btnLeft0.setContentAreaFilled(false);
		btnLeft0.setBorderPainted(false);
		Eeg0.add(btnLeft0);
		
		JLabel lblPart0 = new JLabel("High 1");
		lblPart0.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		Eeg0.add(lblPart0);
		
		JButton btnRight0 = new JButton(arrowR);
		btnRight0.setBorder(null);
		btnRight0.setOpaque(false);
		btnRight0.setContentAreaFilled(false);
		btnRight0.setBorderPainted(false);
		Eeg0.add(btnRight0);
		
		JPanel Eeg1 = new JPanel();
		Eeg1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TopEeg.add(Eeg1, BorderLayout.CENTER);
	
		JLabel lblEeg1 = new JLabel("Eeg 1:");
		lblEeg1.setFont(new Font("Serif", Font.BOLD, 24));
		Eeg1.add(lblEeg1);
		
		JButton btnLeft1 = new JButton(arrowL);
		btnLeft1.setBorder(null);
		btnLeft1.setOpaque(false);
		btnLeft1.setContentAreaFilled(false);
		btnLeft1.setBorderPainted(false);
		Eeg1.add(btnLeft1);
		
		JLabel lblPart1 = new JLabel("High 2");
		lblPart1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		Eeg1.add(lblPart1);
		
		JButton btnRight1 = new JButton(arrowR);
		btnRight1.setBorder(null);
		btnRight1.setOpaque(false);
		btnRight1.setContentAreaFilled(false);
		btnRight1.setBorderPainted(false);
		Eeg1.add(btnRight1);
		
		JPanel BotEeg = new JPanel();
		panel.add(BotEeg, BorderLayout.CENTER);
		BotEeg.setLayout(new BorderLayout(0, 0));
		
		JPanel Eeg2 = new JPanel();
		Eeg2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		BotEeg.add(Eeg2, BorderLayout.NORTH);
	
		JLabel lblEeg2 = new JLabel("Eeg 2:");
		lblEeg2.setFont(new Font("Serif", Font.BOLD, 24));
		Eeg2.add(lblEeg2);
		
		JButton btnLeft2 = new JButton(arrowL);
		btnLeft2.setBorder(null);
		btnLeft2.setOpaque(false);
		btnLeft2.setContentAreaFilled(false);
		btnLeft2.setBorderPainted(false);
		Eeg2.add(btnLeft2);
		
		JLabel lblPart2 = new JLabel("  Mid  ");
		lblPart2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		Eeg2.add(lblPart2);
		
		JButton btnRight2 = new JButton(arrowR);
		btnRight2.setBorder(null);
		btnRight2.setOpaque(false);
		btnRight2.setContentAreaFilled(false);
		btnRight2.setBorderPainted(false);
		Eeg2.add(btnRight2);
		
		JPanel Eeg3 = new JPanel();
		Eeg3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		BotEeg.add(Eeg3, BorderLayout.CENTER);
	
		JLabel lblEeg3 = new JLabel("Eeg 3:");
		lblEeg3.setFont(new Font("Serif", Font.BOLD, 24));
		Eeg3.add(lblEeg3);
		
		JButton btnLeft3 = new JButton(arrowL);
		btnLeft3.setBorder(null);
		btnLeft3.setOpaque(false);
		btnLeft3.setContentAreaFilled(false);
		btnLeft3.setBorderPainted(false);
		Eeg3.add(btnLeft3);
		
		JLabel lblPart3 = new JLabel("  Bass  ");
		lblPart3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		Eeg3.add(lblPart3);
		
		JButton btnRight3 = new JButton(arrowR);
		btnRight3.setBorder(null);
		btnRight3.setOpaque(false);
		btnRight3.setContentAreaFilled(false);
		btnRight3.setBorderPainted(false);
		Eeg3.add(btnRight3);
		
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 700, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add all the actionlisteners
		ActionListener aL = new TrackControl(btnLeft0, btnLeft1, btnLeft2, btnLeft3, btnRight0, btnRight1, btnRight2, btnRight3);
		btnLeft0.addActionListener(aL);
		btnLeft1.addActionListener(aL);
		btnLeft2.addActionListener(aL);
		btnLeft3.addActionListener(aL);
		btnRight0.addActionListener(aL);
		btnRight1.addActionListener(aL);
		btnRight2.addActionListener(aL);
		btnRight3.addActionListener(aL);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
