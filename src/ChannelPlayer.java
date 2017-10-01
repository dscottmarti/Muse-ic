import javax.sound.midi.*;
import java.util.*;
public class ChannelPlayer implements Runnable {

	public int midichan;
	public Map<String, Integer> noteVals;
	public MidiChannel[] channels;
	public ArrayList<Note> score;
	public double subdiv;
	public ChannelPlayer(int mc, MidiChannel[] chan, ArrayList<Note> s) {
		midichan = mc;
		channels = chan;
		score = s;
		noteVals = new HashMap<String, Integer>();
		subdiv = 0;
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
