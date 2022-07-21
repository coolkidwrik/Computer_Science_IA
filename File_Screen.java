import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class File_Screen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField filePathText;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					File_Screen frame = new File_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public File_Screen() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel filePathLabel = new JLabel("Enter File Path:");
		filePathLabel.setBounds(5, 5, 167, 20);
		contentPane.add(filePathLabel);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(5, 59, 211, 29);
		enterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				enterButtonPress();
			}
			
		});
		contentPane.add(enterButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(5, 25, 418, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
	}
	public void enterButtonPress()
	{
		boolean k = Main.importShows(textField_1.getText());// checks if the shows could be imported 
		if(!k)//outputs error message if file path is not found
		{
			Error_Screen e = new Error_Screen();
			e.setErrorMessage("Error! File not found");
			e.setVisible(true);
			return;
			
		}
		IA_Screen iascreen = new IA_Screen();//calls the input screen
		iascreen.setVisible(true);
	}

}
