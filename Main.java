import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main 
{
	
	static ArrayList<Predictions> storagelist = new ArrayList<Predictions>();
	static ArrayList<Predictions> ageSortedList = new ArrayList<Predictions>();//sorted by age
	static ArrayList<Shows> Toplist = new ArrayList<Shows>();//list of all the shows gathered from the csv file given by user
	static ArrayList<Predictions> Predicted = new ArrayList<Predictions>();
	static Scanner in = new Scanner(System.in);
	// code below 
	public static int findshow(ArrayList<Shows> list, String name)
	{
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getName().equals(name))
			{
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) 
	{
//		importShows();
//		sortByGenre("Action");
//		for(int i=0; i<Toplist.size(); i++)
//		{
//			System.out.println(Toplist.get(i));
//		}
//		System.out.println("sorted by action");
//		for(int i=0; i<Predicted.size(); i++)
//		{
//			System.out.println(Predicted.get(i));
//		}

	}
	// code below retrieves list of shows from a csv file and uses the data to create the "shows object"
	// file path used for testing:C:\Users\nesen\Desktop\Computer_Science_IA\Comp_Sci_IA_anime_titles.csv
	public static boolean importShows(String path) 
	{
		Calendar c = Calendar.getInstance();
		//System.out.println("Enter file path for the shows");// client will have the ability to import their own list so that it can be sorted
		//String path = in.next();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			br.readLine();// reads first line without getting data because first row only consists of column names
			while(br.ready()) { // reads lines while there are more populated lines
				String line = br.readLine();// converts the entire line to a string
				String [] values = line.split(",");// data from each column is split using commas, components from the individual columns is stored in an array 
				String name = values[0];// first column has the name of each show
				int popularity = Integer.parseInt(values[1]);// second column has popularity, this is given by a number with 1 being the best. This value is converted to an integer
				String genre = values[2];//third column has the genre 
				int length = Integer.parseInt(values[3]);// fourth column has the length of the series in number of episodes across all seasons
				int age = c.get(Calendar.YEAR)-Integer.parseInt(values[4]);//how old the show is
				Shows temp = new Shows(name,popularity,genre,length,age);// uses the attributes extracted from the csv file to create the object
				Toplist.add(temp);// adds the shows to the array list, this will then be sorted based on user inputs
			}
		} catch (FileNotFoundException e) 
		{
			return false;
			// TODO Auto-generated catch block
		} catch (IOException e) 
		{ 
			return false;
			// TODO Auto-generated catch block
		}
		return true;
	}
	
	public static void sortByGenre(String genre) //sorts the main list with all the shows according to all the genres
	{
		ArrayList<Shows> temp= Toplist;
		Collections.sort(Toplist, new Comparator<Shows>() 
		{
			public int compare(Shows temp, Shows temp2) 
			{
				int sort1=0;
				int sort2=0;
				
				if(temp.getGenre().equalsIgnoreCase(genre)) 
				{
					sort1=100;
				}if(temp2.getGenre().equalsIgnoreCase(genre))
				{
					sort2=100;
				}
				return sort2-sort1;
				
			}
			
		});
		
		ArrayList<Predictions> predictedShows = new ArrayList<Predictions>();
		for(int i = 0; i < temp.size(); i++) {
			Predictions tempP = new Predictions(temp.get(i).getGenre(), temp.get(i).getLength(), temp.get(i).getAge());
			predictedShows.add(tempP);
		}
		Predicted = predictedShows;
	}
	
	public static void sortByAge(int age)// method to check if the age inputed by the user matches the age inputed 
	{
		Collections.sort(Toplist, new Comparator<Shows>()// method called from collections class inbuilt in java
		{
			public int compare(Shows temp, Shows temp2) //creating a new comparator
			{
				int age1=0;// variable used to sort
				int age2=0;// variable used to sort
				if (temp.getAge() <= age) //compares the age and checks if it is less than
				{
					age1=100;//if so, makes age1 =100
				} 
				if(temp2.getAge()<=age)
				{
					age2=100;//if so, makes age2 =100
				}
				return age2-age1;
			}
		});
	}
	public static void sortByLength(int length) 
	{
		Collections.sort(Toplist, new Comparator<Shows>()
		{
			public int compare(Shows temp, Shows temp2) 
			{
				int length1=0;
				int length2=0;
				if (temp.getLength() <= length) 
				{
					length1=100;
				} 
				if(temp2.getLength()<=length)
				{
					length2=100;
				}
				return length2-length1;
			}
		});
	}
	
	

	

}
