
import javax.sound.midi.*;
import java.util.*;
public class NoteTest implements Runnable {

	public void run() {
		
	}
	public static void main(String[] args){
		String root = "C";
		boolean isMinor = false;
		try {
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();
			Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
			MidiChannel[] channels = synth.getChannels();
			synth.loadInstrument(instr[instr.length-1]);
			
			ArrayList<Note> song = new ArrayList<Note>();
			song.add(new Note(60, ));
			//song.add(new Note(64,.6));
			//song.add(new Note(67,.6));
			//song.add(new Note(72,1.2));
			ArrayList<Note> song2 = new ArrayList<Note>();
			song2.add(new Note(64, .6));
			song2.add(new Note(67,.6));
			song2.add(new Note(72,.6));
			song2.add(new Note(76,1.2));
			ChannelPlayer part1 = new ChannelPlayer(0, channels, song);
			ChannelPlayer part2 = new ChannelPlayer(1, channels, song2);
			Runnable r1 = part1;
			Runnable r2 = part2;
			new Thread(r1).start();
			try{
				Thread.sleep(250);
			} catch(InterruptedException e) {}
			//new Thread(r2).start();
				
		}
		catch(MidiUnavailableException e) {}
	}
	public static void play(Note note, MidiChannel[] channels) {
		channels[0].noteOn(note.value, 100);
		try {
			Thread.sleep((long) (1000*note.duration));
		} catch(InterruptedException e) {}
		channels[0].noteOff(note.value);
	}
}
