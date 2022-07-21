
public class Shows 
{
	// list of variables blow are the attributes of each show that will be compared with variable in predictions
	private int popularity;// show popularity determined by viewers
	private String genre;// genre of the show
	private int length;// length of the show, how many episodes does it have
	private int age;// how old the show is, what year did it come out
	private String name;// given name of the show
	// getters and setters for variables below
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Shows ()// empty constructor
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Shows(String name, int popularity, String genre, int length, int age) 
	{
		this.popularity= popularity;
		this.genre= genre;
		this.length= length;
		this.age = age;
		this.setName(name);
	}
	@Override
	public String toString() {
		return "Shows [popularity=" + popularity + ", genre=" + genre + ", length=" + length + ", age=" + age
				+ ", name=" + name + "]";
	}

}
