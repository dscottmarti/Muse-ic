import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.MidiChannel;

public class Mid implements Runnable{
	public int midichan;
	public Map<String, Integer> noteVals;
	public MidiChannel[] channels;
	public ArrayList<Note> score;
	public double subdiv;
	public Mid(int mc, MidiChannel[] chan, ArrayList<Note> s) {
		midichan = mc;
		channels = chan;
		score = s;
		noteVals = new HashMap<String, Integer>();
		subdiv = 1.2;
		initVals();
	}
	public void initVals() {
		noteVals.put("c1", 48);
		noteVals.put("d1", 50);
		noteVals.put("e1", 52);
		noteVals.put("f1", 53);
		noteVals.put("g1", 55);
		noteVals.put("a1", 57);
		noteVals.put("b1", 59);
		noteVals.put("c2", 60);
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
