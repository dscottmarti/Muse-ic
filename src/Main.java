import java.awt.EventQueue;
import java.util.*;
import javax.sound.midi.*;
import javax.swing.*;
public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartingGUI window = new StartingGUI();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		MindReader reader = new MindReader("recording.csv",.6);
		ArrayList<ArrayList<Note>> notes = reader.engine();
		for(int i = 0; i<notes.size(); i++) {
			for(int j = 0; j<notes.get(i).size(); j++) {
				System.out.println(notes.get(i).get(j).value);
			}
				
		}
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		try{
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();
			Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
			MidiChannel[] channels = synth.getChannels();
			synth.loadInstrument(instr[0]);
			Runnable bass = new Bass(0, channels, notes.get(0));
			Runnable mid = new Mid(1, channels, notes.get(1));
			Runnable hi1 = new Hi1(2, channels, notes.get(2));
			Runnable hi2 = new Hi2(3, channels, notes.get(3));
			threads.add(new Thread(bass));
			threads.add(new Thread(mid));
			threads.add(new Thread(hi1));
			threads.add(new Thread(hi2));
			
			startThreads(threads);	
		} catch (MidiUnavailableException e) {}

//		

//		
//		
	
	}
	
	public static void startThreads(ArrayList<Thread> threads) {
		for(int i = 0; i<threads.size(); i++)
			threads.get(i).start();
	}
	
	public static void stopThreads(ArrayList<Thread> threads) {
		for(int i = 0; i < threads.size(); i++)
			threads.get(i).interrupt();
	}
	
}
