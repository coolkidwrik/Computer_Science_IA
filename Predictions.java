
public class Predictions 
{
	// list of variables below are inputs by the user to make predictions
	private String g;// genre of the show
	private int l;// length of the show, how many episodes does it have
	private int a;// how old the show is, what year did it come out
	private String n;// name of the show
	public Predictions()// empty constructor
	{
		
	}
	public String getG() {
		return g;
	}
	@Override
	public String toString() {
		return "Predictions [g=" + g + ", l=" + l + ", a=" + a + ", n=" + n + "]";
	}
	public void setG(String g) {
		this.g = g;
	}
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	
	public Predictions(String g, int l, int a)
	{
		this.setG(g);
		this.setL(l);
		this.setA(a);
	}
	public String getS() {
		return n;
	}
	public void setS(String s) {
		this.n = n;
	}
	
	
}
