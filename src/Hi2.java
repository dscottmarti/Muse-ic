import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.MidiChannel;

public class Hi2 implements Runnable{
	public int midichan;
	public Map<String, Integer> noteVals;
	public MidiChannel[] channels;
	public ArrayList<Note> score;
	public double subdiv;
	public Hi2(int mc, MidiChannel[] chan, ArrayList<Note> s) {
		midichan = mc;
		channels = chan;
		score = s;
		noteVals = new HashMap<String, Integer>();
		subdiv = .3;
		initVals();
	}
	public void initVals() {
		noteVals.put("c1", 72);
		noteVals.put("d1", 74);
		noteVals.put("e1", 76);
		noteVals.put("f1", 77);
		noteVals.put("g1", 79);
		noteVals.put("a1", 81);
		noteVals.put("b1", 83);
		noteVals.put("c2", 84);
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