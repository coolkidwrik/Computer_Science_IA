import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IA_Screen extends JFrame {

	private JPanel contentPane;
	private JComboBox genreComboBox;
	private JComboBox ageComboBox;
	private JComboBox lengthComboBox;
	private JComboBox PriorityComboBox;
	private JComboBox showSuggestions = new JComboBox();
	private String g;
	private String a;
	private int ag;
	private String l;
	private int le;
	private String s;// user input for the the priority of search(The most important thing about the show the user wants)
	private JTextField showSuggestionTextField;
	private JLabel lblNewLabel_5;
	private JTextField pathTextField;
	private String n;
	private String [] showNames= new String[Main.Toplist.size()];
	static ArrayList<Shows> listToOutput= new ArrayList<Shows>();
	//private String path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IA_Screen frame = new IA_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public IA_Screen(int index) // constructor for the input screen
	{
		Predictions k = Main.storagelist.get(index);
		genreComboBox.setSelectedItem(k.getG());
		ageComboBox.setSelectedItem(k.getA());
		lengthComboBox.setSelectedItem(k.getL());
		PriorityComboBox.setSelectedItem(k.getS());
	}
	public void searchBtnactionPerformed() 
	{
		
		try {
			g = genreComboBox.getSelectedItem().toString();//gets genre from appropriate dropdown
			a = ageComboBox.getSelectedItem().toString();//gets age from appropriate dropdown
			l = lengthComboBox.getSelectedItem().toString();//gets length from appropriate dropdown
			s = PriorityComboBox.getSelectedItem().toString();//gets priority search from appropriate dropdown
			if(s.equalsIgnoreCase(""))
			{
				Error_Screen e= new Error_Screen();
				e.setErrorMessage("Error! Please select priority of sort");// if s is not inputed, will redirect the user to Error Screen where it will display the error message
				e.setVisible(true);
				return;
			}
			
			if(a.equals("> 30"))// gets specific integer for this one case
			{
				ag= 40;// variable replaces String user input that will be used for sorting
			}else 
			{
				a= a.replace('<', ' ');//replaces less than with a space
				a= a.trim();// removes any unwanted spaces
				ag=Integer.parseInt(a);//gets the integer from the string and stores it
			}
			if(l.equals("> 100"))// gets specific integer for this one case
			{
				le= 1500;// variable replaces String user input that will be used for sorting
			}else 
			{
				l=l.replace('=', ' ');//replaces equals to with a space
				l=l.replace('<', ' ');//replaces less than with a space
				l=l.trim();// removes any unwanted spaces
				le=Integer.parseInt(l);//gets the integer from the string and stores it
			}
			if(s.equalsIgnoreCase("genre"))//checks if the priority is inputed by user is genre
			{
				Main.sortByGenre(g);//sorts the ArrayList by genre
				for(int i=0; i<Main.Toplist.size(); i++)
				{
					if(Main.Toplist.get(i).getGenre().equalsIgnoreCase(g)==false)// gets all the shows that meet the same genre
					{
						break;
					}
					if(Main.Toplist.get(i).getAge()<=ag && Main.Toplist.get(i).getLength()<=le)// gets shows that match length and age description and stores it in another array
					{
						listToOutput.add(Main.Toplist.get(i));
					}
				}
				
			}
			if(s.equalsIgnoreCase("length"))//checks if the priority is inputed by user is length
			{
				Main.sortByLength(le);//sorts the ArrayList by length
				for(int i=0; i<Main.Toplist.size(); i++)
				{
					if(Main.Toplist.get(i).getLength()>le)// gets all the shows that meet the same genre
					{
						break;
					}
					if(Main.Toplist.get(i).getAge()<=ag && Main.Toplist.get(i).getGenre().equalsIgnoreCase(g))// gets shows that match length and age description and stores it in another array
					{
						listToOutput.add(Main.Toplist.get(i));
					}
				}
			}
			if(s.equalsIgnoreCase("age"))//checks if the priority is inputed by user is age
			{
				Main.sortByAge(ag);//sorts the ArrayList by age
				for(int i=0; i<Main.Toplist.size(); i++)
				{
					if(Main.Toplist.get(i).getAge()>ag)// gets all the shows that meet the same genre
					{
						break;
					}
					if(Main.Toplist.get(i).getLength()<=le && Main.Toplist.get(i).getGenre().equalsIgnoreCase(g))// gets shows that match length and age description and stores it in another array
					{
						listToOutput.add(Main.Toplist.get(i));
					}
				}
			}
			
			List_Screen ls = new List_Screen();//calls the output screen
			ls.setVisible(true);
			
			while(ageBinarySearch(Main.Predicted, ag))
			{
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Error_Screen b = new Error_Screen();
			b.setErrorMessage("Error! Please select for all fields");// try-catch block here helps validate if all text fields have been entered, else redirected to error screen
			b.setVisible(true);
		}	
	}
	
	public int partition(ArrayList<Predictions> arr, int low, int high)
	{
		Predictions pivot = arr.get(high);
		int i =(low-1);
		for(int j= low; j<high; j++)
		{
			if(arr.get(j).getA()< pivot.getA())// if current element is smaller than pivot
			{
				i++;
				//swap arr.get(i) and arr.get(j)
				Predictions temp =arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
			}
		}
		// the following code swaps arr.get(i+1) and arr.get(high)
		Predictions temp =arr.get(i+1);
		arr.set(i+1,arr.get(high));
		arr.set(high, temp);
		
		return i+1;
	}
	public void quickSort(ArrayList<Predictions> arr, int low, int high) 
	{ // sorting the benList array
		if (low >= high) 
		{
			return; // base case
		}
		if (low < high) 
		{
			/*
			 * pi is partitioning index, arr.get(pi) is now at right place
			 */
			int pi = partition(arr, low, high);
			// Recursively sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	    Main.Predicted = arr;
	}
	public boolean ageBinarySearch(ArrayList<Predictions> benList, int age) {


        int index = -1;
        int low = 0;
        int high = benList.size() - 1;
        while (low <= high && index == -1) {
            int mid = (low + high) / 2;
            if (benList.get(mid).getA() == age) {
                index = mid;
            } else if (benList.get(mid).getA() > age) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (index >= 0) 
        {
        	Main.ageSortedList.add(benList.get(index));
          return true;
        } else 
        {
        	
        	return false;
         
        }

    }
	
	public boolean lengthBinarySearch(ArrayList<Predictions> benList, int length) {


        int index = -1;
        int low = 0;
        int high = benList.size() - 1;
        while (low <= high && index == -1) {
            int mid = (low + high) / 2;
            if (benList.get(mid).getA() == length) {
                index = mid;
            } else if (benList.get(mid).getA() > length) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (index >= 0) 
        {
        	Main.ageSortedList.add(benList.get(index));
          return true;
        } else 
        {
        	
        	return false;
         
        }

    }
	
	public int searchByName(String name)// searches through the ArrayList to find the selected name
	{
		int i=0;
		while(Main.Toplist.get(i).getName().equalsIgnoreCase(name)==false)
		{
			i++;
		}
		return i;
	}
	public void searchButtonPressed()// one showSuggestions button is pressed, it finds show within the ArrayList and gets it's attributes to fill in the user input fields with
	{
		int index= searchByName(showSuggestions.getSelectedItem().toString());
		genreComboBox.setSelectedItem(Main.Toplist.get(index).getGenre());// sets the genre combobox to the appropriate input in the dropdown based on attributes of show searched
		int length = Main.Toplist.get(index).getLength();
		if(length ==1)
		{
			lengthComboBox.setSelectedIndex(1);
		}else if(length <=13 )
		{
			lengthComboBox.setSelectedIndex(2);
		}else if(length <=25 )
		{
			lengthComboBox.setSelectedIndex(3);
		}else if(length <=50 )
		{
			lengthComboBox.setSelectedIndex(4);
		}else if(length <=75 )
		{
			lengthComboBox.setSelectedIndex(5);
		}else if(length <=100 )
		{
			lengthComboBox.setSelectedIndex(6);
		}else
		{
			lengthComboBox.setSelectedIndex(7);
		}
		
		int age = Main.Toplist.get(index).getAge();
		if(age > 30)
		{
			ageComboBox.setSelectedIndex(1);
		}else if(age <= 5)
		{
			ageComboBox.setSelectedIndex(5);
		}else if(age <=10 )
		{
			ageComboBox.setSelectedIndex(4);
		}else if(age <=20 )
		{
			ageComboBox.setSelectedIndex(3);
		}else 
		{
			ageComboBox.setSelectedIndex(2);
		}
		
	}
	public int genreSearch(String genre)//test method, searches for genre and gives its position in the dropdown
	{
		String[] allGenres = new String[] {"", "Action", "Adventure", "Comedy", "Drama", "Fantasy", "Romance", "Sci-fi"};
		int i=0;
		while(allGenres[i].equalsIgnoreCase(genre)== false)
		{
			i++;
		}
		return i;
	}
	
	/**
	 * Create the frame.
	 */
	public IA_Screen() 
	{
		for(int i=0; i<showNames.length; i++)
		{
			showNames[i]= Main.Toplist.get(i).getName();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 498);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input preferred genre");
		lblNewLabel.setBounds(5, 5, 161, 20);
		contentPane.add(lblNewLabel);
		
		genreComboBox = new JComboBox();
		genreComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Action", "Adventure", "Comedy", "Drama", "Fantasy", "Romance", "Sci-fi"}));
		genreComboBox.setBounds(5, 41, 161, 26);
		contentPane.add(genreComboBox);
		
		JButton searchBtn = new JButton("Generate list");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchBtnactionPerformed();
			}
		});
		searchBtn.setBounds(287, 343, 145, 29);
		contentPane.add(searchBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Input preferred length ");
		lblNewLabel_1.setBounds(181, 5, 172, 20);
		contentPane.add(lblNewLabel_1);
		
		lengthComboBox = new JComboBox();
		lengthComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "= 1", "< 13", "< 25", "< 50", "< 75", "< 100", "> 100"}));
		lengthComboBox.setBounds(181, 41, 161, 26);
		contentPane.add(lengthComboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Input preferred age");
		lblNewLabel_2.setBounds(354, 5, 145, 20);
		contentPane.add(lblNewLabel_2);
		
		ageComboBox = new JComboBox();
		ageComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "> 30", "< 30", "< 20", "< 10", "< 5"}));
		ageComboBox.setBounds(357, 41, 145, 26);
		contentPane.add(ageComboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Input priority search");
		lblNewLabel_3.setBounds(514, 5, 156, 20);
		contentPane.add(lblNewLabel_3);
		
		PriorityComboBox = new JComboBox();
		PriorityComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "genre", "length", "age"}));
		PriorityComboBox.setBounds(517, 41, 156, 26);
		contentPane.add(PriorityComboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Input a show for similar suggestions");
		lblNewLabel_4.setBounds(211, 156, 318, 20);
		contentPane.add(lblNewLabel_4);
		
		
		showSuggestions.setModel(new DefaultComboBoxModel(showNames));
		showSuggestions.setBounds(153, 186, 384, 26);
		contentPane.add(showSuggestions);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				searchButtonPressed();
			}
		});
		searchButton.setBounds(545, 185, 145, 29);
		contentPane.add(searchButton);
		
		
		
	}
}
