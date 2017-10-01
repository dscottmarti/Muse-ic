
public class Range {
	private int high;
	private int low;
	
	public Range(int l, int h) {
		high = h;
		low = l;
	}
	public boolean contains(double val) {
		return val<=high && val>=low;
	}
}
