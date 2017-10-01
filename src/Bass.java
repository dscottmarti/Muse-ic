import java.util.*;

import javax.sound.midi.MidiChannel;
public class Bass implements Runnable {
	public int midichan;
	public Map<String, Integer> noteVals;
	public MidiChannel[] channels;
	public ArrayList<Note> score;
	private double subdiv;
	public Bass(int mc, MidiChannel[] chan, ArrayList<Note> s) {
		subdiv = 2.4;
		midichan = mc;
		channels = chan;
		score = s;
		noteVals = new HashMap<String, Integer>();
		initVals();
	}
	public void initVals() {
		noteVals.put("c1", 36);
		noteVals.put("d1", 38);
		noteVals.put("e1", 40);
		noteVals.put("f1", 41);
		noteVals.put("g1", 43);
		noteVals.put("a1", 45);
		noteVals.put("b1", 47);
		noteVals.put("c2", 48);
	}
	

	@Override
	public void run() {
		int index = 0;
		while(true)
		{
			play(score.get(index), channels);
			if(index == score.size()-1)
				index = 0;
			else
				index++;
		}
		
	}
	public void play(Note note, MidiChannel[] channels) {
		channels[midichan].noteOn(noteVals.get(note.value), 100);
		try {
			Thread.sleep((long) (1000*subdiv));
 		} catch(InterruptedException e) {}
		channels[midichan].noteOff(noteVals.get(note.value));
	}
	
}
