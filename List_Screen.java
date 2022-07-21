import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class List_Screen extends JFrame {
// the following lines show all the text panels where the appropriate data will be output
	private JPanel contentPane;
	private JTextField Name1;
	private JTextField Genre1;
	private JTextField Length1;
	private JTextField Age1;
	private JTextField textField_4;
	private JTextField Name2;
	private JTextField Genre2;
	private JTextField Length2;
	private JTextField Age2;
	private JTextField Name3;
	private JTextField Genre3;
	private JTextField Length3;
	private JTextField Age3;
	private JTextField Name4;
	private JTextField Genre4;
	private JTextField Length4;
	private JTextField Age4;
	private JTextField Name5;
	private JTextField Genre5;
	private JTextField Length5;
	private JTextField Age5;
	private JTextField Name6;
	private JTextField Genre6;
	private JTextField Length6;
	private JTextField Age6;
	private JTextField Name7;
	private JTextField Genre7;
	private JTextField Length7;
	private JTextField Age7;
	private JTextField Name8;
	private JTextField Genre8;
	private JTextField Length8;
	private JTextField Age8;
	private JTextField Name9;
	private JTextField Genre9;
	private JTextField Length9;
	private JTextField Age9;
	private JTextField Name10;
	private JTextField Genre10;
	private JTextField Length10;
	private JTextField Age10;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
    static Calendar c;
	/**
	 * Create the frame.
	 */
	
	public List_Screen() //output screen
	{
		c = Calendar.getInstance();//in built java class used to get the year the show came out on based on age input
		initComponents();
		try {
			// following code sets the appropriate outputs for 
			Name1.setText(IA_Screen.listToOutput.get(0).getName());
			Genre1.setText(IA_Screen.listToOutput.get(0).getGenre());
			Age1.setText(Integer.toString(c.get(Calendar.YEAR)-IA_Screen.listToOutput.get(0).getAge()));
			Length1.setText(Integer.toString(IA_Screen.listToOutput.get(0).getLength()));
			Name2.setText(IA_Screen.listToOutput.get(1).getName());
			Genre2.setText(IA_Screen.listToOutput.get(1).getGenre());
			Age2.setText(Integer.toString(c.get(Calendar.YEAR)-IA_Screen.listToOutput.get(1).getAge()));
			Length2.setText(Integer.toString(IA_Screen.listToOutput.get(1).getLength()));
			Name3.setText(IA_Screen.listToOutput.get(2).getName());
			Genre3.setText(IA_Screen.listToOutput.get(2).getGenre());
			Age3.setText(Integer.toString(c.get(Calendar.YEAR)-IA_Screen.listToOutput.get(2).getAge()));
			Length3.setText(Integer.toString(IA_Screen.listToOutput.get(2).getLength()));
			Name4.setText(IA_Screen.listToOutput.get(3).getName());
			Genre4.setText(IA_Screen.listToOutput.get(3).getGenre());
			Age4.setText(Integer.toString(c.get(Calendar.YEAR)-IA_Screen.listToOutput.get(3).getAge()));
			Length4.setText(Integer.toString(IA_Screen.listToOutput.get(3).getLength()));
			Name5.setText(IA_Screen.listToOutput.get(4).getName());
			Genre5.setText(IA_Screen.listToOutput.get(4).getGenre());
			Age5.setText(Integer.toString(c.get(Calendar.YEAR)-IA_Screen.listToOutput.get(4).getAge()));
			Length5.setText(Integer.toString(IA_Screen.listToOutput.get(4).getLength()));
			Name6.setText(IA_Screen.listToOutput.get(5).getName());
			Genre6.setText(IA_Screen.listToOutput.get(5).getGenre());
			Age6.setText(Integer.toString(c.get(Calendar.YEAR)-IA_Screen.listToOutput.get(5).getAge()));
			Length6.setText(Integer.toString(IA_Screen.listToOutput.get(5).getLength()));
			Name7.setText(IA_Screen.listToOutput.get(6).getName());
			Genre7.setText(IA_Screen.listToOutput.get(6).getGenre());
			Age7.setText(Integer.toString(c.get(Calendar.YEAR)-IA_Screen.listToOutput.get(6).getAge()));
			Length7.setText(Integer.toString(IA_Screen.listToOutput.get(6).getLength()));
			Name8.setText(IA_Screen.listToOutput.get(7).getName());
			Genre8.setText(IA_Screen.listToOutput.get(7).getGenre());
			Age8.setText(Integer.toString(c.get(Calendar.YEAR)-IA_Screen.listToOutput.get(7).getAge()));
			Length8.setText(Integer.toString(IA_Screen.listToOutput.get(7).getLength()));
			Name9.setText(IA_Screen.listToOutput.get(8).getName());
			Genre9.setText(IA_Screen.listToOutput.get(8).getGenre());
			Age9.setText(Integer.toString(c.get(Calendar.YEAR)-IA_Screen.listToOutput.get(8).getAge()));
			Length9.setText(Integer.toString(IA_Screen.listToOutput.get(8).getLength()));
			Name10.setText(IA_Screen.listToOutput.get(9).getName());
			Genre10.setText(IA_Screen.listToOutput.get(9).getGenre());
			Age10.setText(Integer.toString(c.get(Calendar.YEAR)-IA_Screen.listToOutput.get(9).getAge()));
			Length10.setText(Integer.toString(IA_Screen.listToOutput.get(9).getLength()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//The following labels(JLable) display the column name for the data
		JLabel lblNewLabel = new JLabel("Name");//for the user to know the column below displays the name of the shows
		lblNewLabel.setBounds(148, 50, 69, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Genre");//for the user to know the column below displays the genre of the shows
		lblNewLabel_1.setBounds(324, 50, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Length");//for the user to know the column below displays the length of the shows
		lblNewLabel_2.setBounds(421, 50, 69, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");//for the user to know the column below displays the age of the shows
		lblNewLabel_3.setBounds(505, 50, 69, 20);
		contentPane.add(lblNewLabel_3);
		//The following texts fields display the respective data for each show, this data being name, genre, length, age
		//the number after the text field name indicates the order of the show. for example Name1 indicates the name of the first show
		Name1 = new JTextField();
		Name1.setBounds(51, 75, 230, 26);
		contentPane.add(Name1);
		Name1.setColumns(10);
		
		Genre1 = new JTextField();
		Genre1.setBounds(283, 75, 126, 26);
		contentPane.add(Genre1);
		Genre1.setColumns(10);
		
		Length1 = new JTextField();
		Length1.setBounds(413, 75, 69, 26);
		contentPane.add(Length1);
		Length1.setColumns(10);
		
		Age1 = new JTextField();
		Age1.setBounds(487, 75, 59, 26);
		contentPane.add(Age1);
		Age1.setColumns(10);
		
		Name2 = new JTextField();
		Name2.setColumns(10);
		Name2.setBounds(51, 104, 230, 26);
		contentPane.add(Name2);
		
		Genre2 = new JTextField();
		Genre2.setColumns(10);
		Genre2.setBounds(283, 104, 126, 26);
		contentPane.add(Genre2);
		
		Length2 = new JTextField();
		Length2.setColumns(10);
		Length2.setBounds(413, 104, 69, 26);
		contentPane.add(Length2);
		
		Age2 = new JTextField();
		Age2.setColumns(10);
		Age2.setBounds(487, 104, 59, 26);
		contentPane.add(Age2);
		
		Name3 = new JTextField();
		Name3.setColumns(10);
		Name3.setBounds(51, 134, 230, 26);
		contentPane.add(Name3);
		
		Genre3 = new JTextField();
		Genre3.setColumns(10);
		Genre3.setBounds(283, 134, 126, 26);
		contentPane.add(Genre3);
		
		Length3 = new JTextField();
		Length3.setColumns(10);
		Length3.setBounds(413, 134, 69, 26);
		contentPane.add(Length3);
		
		Age3 = new JTextField();
		Age3.setColumns(10);
		Age3.setBounds(487, 134, 59, 26);
		contentPane.add(Age3);
		
		Name4 = new JTextField();
		Name4.setColumns(10);
		Name4.setBounds(51, 162, 230, 26);
		contentPane.add(Name4);
		
		Genre4 = new JTextField();
		Genre4.setColumns(10);
		Genre4.setBounds(283, 162, 126, 26);
		contentPane.add(Genre4);
		
		Length4 = new JTextField();
		Length4.setColumns(10);
		Length4.setBounds(413, 162, 69, 26);
		contentPane.add(Length4);
		
		Age4 = new JTextField();
		Age4.setColumns(10);
		Age4.setBounds(487, 162, 59, 26);
		contentPane.add(Age4);
		
		Name5 = new JTextField();
		Name5.setColumns(10);
		Name5.setBounds(51, 190, 230, 26);
		contentPane.add(Name5);
		
		Genre5 = new JTextField();
		Genre5.setColumns(10);
		Genre5.setBounds(283, 190, 126, 26);
		contentPane.add(Genre5);
		
		Length5 = new JTextField();
		Length5.setColumns(10);
		Length5.setBounds(413, 190, 69, 26);
		contentPane.add(Length5);
		
		Age5 = new JTextField();
		Age5.setColumns(10);
		Age5.setBounds(487, 190, 59, 26);
		contentPane.add(Age5);
		
		Name6 = new JTextField();
		Name6.setColumns(10);
		Name6.setBounds(51, 218, 230, 26);
		contentPane.add(Name6);
		
		Genre6 = new JTextField();
		Genre6.setColumns(10);
		Genre6.setBounds(283, 218, 126, 26);
		contentPane.add(Genre6);
		
		Length6 = new JTextField();
		Length6.setColumns(10);
		Length6.setBounds(413, 218, 69, 26);
		contentPane.add(Length6);
		
		Age6 = new JTextField();
		Age6.setColumns(10);
		Age6.setBounds(487, 218, 59, 26);
		contentPane.add(Age6);
		
		Name7 = new JTextField();
		Name7.setColumns(10);
		Name7.setBounds(51, 246, 230, 26);
		contentPane.add(Name7);
		
		Genre7 = new JTextField();
		Genre7.setColumns(10);
		Genre7.setBounds(283, 246, 126, 26);
		contentPane.add(Genre7);
		
		Length7 = new JTextField();
		Length7.setColumns(10);
		Length7.setBounds(413, 246, 69, 26);
		contentPane.add(Length7);
		
		Age7 = new JTextField();
		Age7.setColumns(10);
		Age7.setBounds(487, 246, 59, 26);
		contentPane.add(Age7);
		
		Name8 = new JTextField();
		Name8.setColumns(10);
		Name8.setBounds(51, 274, 230, 26);
		contentPane.add(Name8);
		
		Genre8 = new JTextField();
		Genre8.setColumns(10);
		Genre8.setBounds(283, 274, 126, 26);
		contentPane.add(Genre8);
		
		Length8 = new JTextField();
		Length8.setColumns(10);
		Length8.setBounds(413, 274, 69, 26);
		contentPane.add(Length8);
		
		Age8 = new JTextField();
		Age8.setColumns(10);
		Age8.setBounds(487, 274, 59, 26);
		contentPane.add(Age8);
		
		Name9 = new JTextField();
		Name9.setColumns(10);
		Name9.setBounds(51, 301, 230, 26);
		contentPane.add(Name9);
		
		Genre9 = new JTextField();
		Genre9.setColumns(10);
		Genre9.setBounds(283, 301, 126, 26);
		contentPane.add(Genre9);
		
		Length9 = new JTextField();
		Length9.setColumns(10);
		Length9.setBounds(413, 301, 69, 26);
		contentPane.add(Length9);
		
		Age9 = new JTextField();
		Age9.setColumns(10);
		Age9.setBounds(487, 301, 59, 26);
		contentPane.add(Age9);
		
		Name10 = new JTextField();
		Name10.setColumns(10);
		Name10.setBounds(51, 329, 230, 26);
		contentPane.add(Name10);
		
		Genre10 = new JTextField();
		Genre10.setColumns(10);
		Genre10.setBounds(283, 329, 126, 26);
		contentPane.add(Genre10);
		
		Length10 = new JTextField();
		Length10.setColumns(10);
		Length10.setBounds(413, 329, 69, 26);
		contentPane.add(Length10);
		
		Age10 = new JTextField();
		Age10.setColumns(10);
		Age10.setBounds(487, 329, 59, 26);
		contentPane.add(Age10);
		// The following indicate the row number for the data output, starting at 1
		//1 indicates the show most likely to be enjoyed, going till 10
		lblNewLabel_4 = new JLabel("1.");
		lblNewLabel_4.setBounds(32, 78, 19, 20);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("2.");
		lblNewLabel_5.setBounds(32, 107, 19, 20);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("3.");
		lblNewLabel_6.setBounds(32, 137, 19, 20);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("4.");
		lblNewLabel_7.setBounds(32, 165, 19, 20);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("5.");
		lblNewLabel_8.setBounds(32, 193, 19, 20);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("6.");
		lblNewLabel_9.setBounds(32, 221, 19, 20);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("7.");
		lblNewLabel_10.setBounds(32, 249, 19, 20);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("8.");
		lblNewLabel_11.setBounds(32, 277, 19, 20);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("9.");
		lblNewLabel_12.setBounds(32, 304, 19, 20);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("10.");
		lblNewLabel_13.setBounds(26, 332, 36, 20);
		contentPane.add(lblNewLabel_13);
		
		
	}
}
