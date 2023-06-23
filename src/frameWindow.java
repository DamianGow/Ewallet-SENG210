import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class frameWindow extends JFrame implements ActionListener{

	//Global variables, to work with action listener
private static JButton addIncome = new JButton();	
private static JButton addExpense = new JButton();	
private static JButton viewSummary = new JButton();	
private static JButton currencyConv = new JButton();
private static JButton homeButton = new JButton();
private static JTextField convertText = new JTextField();
private static JButton convertButton = new JButton();
private static JComboBox currSelectOne;
private static JComboBox currSelectTwo;
private static JLabel currResultLabel;



private static JPanel conPanel;
private static JPanel startPanel;

	frameWindow() {
		

//start panel
startPanel = new JPanel();
startPanel.setBackground(Color.black);
startPanel.setBounds(0, 0, 455, 600);
startPanel.setLayout(null);
startPanel.setVisible(true);
//Start Page Labels			
		
JLabel titleLabel = new JLabel();
titleLabel.setText("E-Wallet");
titleLabel.setBounds(165, 30, 150, 25);
titleLabel.setFont(new Font("Arial", Font.PLAIN, 25));
titleLabel.setForeground(Color.white);
titleLabel.setVisible(true);

JLabel chooseLabel = new JLabel();
chooseLabel.setText("What would you like to do?");
chooseLabel.setBounds(65, 250, 400, 25);
chooseLabel.setFont(new Font("Arial", Font.PLAIN, 25));
chooseLabel.setForeground(Color.white);
chooseLabel.setVisible(true);
		
//Start Page Buttons
addIncome = new JButton("Add an income");
addIncome.setBounds(30, 330, 165, 70);
addIncome.setFocusable(false);
addIncome.addActionListener(this);
addIncome.setVisible(true);

addExpense = new JButton("Add an expense");
addExpense.setBounds(250, 330, 165, 70);
addExpense.setFocusable(false);
addExpense.addActionListener(this);
addExpense.setVisible(true);

viewSummary = new JButton("View a Summary");
viewSummary.setBounds(30, 450, 165, 70);
viewSummary.setFocusable(false);
viewSummary.addActionListener(this);
viewSummary.setVisible(true);

currencyConv = new JButton("Currency Conversion");
currencyConv.setBounds(250, 450, 165, 70);
currencyConv.setFocusable(false);
currencyConv.addActionListener(this);
currencyConv.setVisible(true);









//currency Conversion window

//you can re-use the home button for other screens as long as you don't move it, if you want to move it, copy, rename, and change the position.
homeButton = new JButton("Home");
homeButton.setBounds(170, 30, 120, 70);
homeButton.setFocusable(false);
homeButton.addActionListener(this);
homeButton.setVisible(true);


JLabel convertLabel = new JLabel();
convertLabel.setText("Please enter your balance to convert");
convertLabel.setBounds(85, 350, 600, 25);
convertLabel.setFont(new Font("Arial", Font.PLAIN, 17));
convertLabel.setForeground(Color.white);
convertLabel.setVisible(true);

JLabel convertToLabel = new JLabel();
convertToLabel.setText("To");
convertToLabel.setBounds(275, 390, 20, 25);
convertToLabel.setFont(new Font("Arial", Font.PLAIN, 17));
convertToLabel.setForeground(Color.white);
convertToLabel.setVisible(true);

currResultLabel = new JLabel();
currResultLabel.setText("");
currResultLabel.setBounds(175, 470, 200, 25);
currResultLabel.setFont(new Font("Arial", Font.PLAIN, 17));
currResultLabel.setForeground(Color.white);
currResultLabel.setVisible(true);


convertText.setPreferredSize(new Dimension(20, 30));
convertText.setCaretColor(Color.black); //cursor color
convertText.setText("100.00"); //starting text
convertText.setEditable(true);
convertText.setBounds(185, 390, 80, 25);
convertText.setVisible(true);

String[] currencyList = {"USD", "EUR", "CAD",};
currSelectOne = new JComboBox(currencyList);
currSelectOne.setBounds(115, 390, 60, 25);
currSelectOne.setVisible(true);


currSelectTwo = new JComboBox(currencyList);
currSelectTwo.setBounds(305, 390, 60, 25);
currSelectTwo.setVisible(true);
currSelectTwo.setSelectedIndex(1); 

convertButton = new JButton("Convert!");
convertButton.setBounds(175, 430, 100, 30);
convertButton.setFocusable(false);
convertButton.addActionListener(this);
convertButton.setVisible(true);


conPanel = new JPanel();
conPanel.setBackground(Color.black);
conPanel.setBounds(0, 0, 455, 600);
conPanel.setLayout(null);
conPanel.setVisible(false);

//add to window
this.add(startPanel);
this.add(conPanel);
conPanel.add(convertButton);
conPanel.add(currSelectOne);
conPanel.add(convertText);
conPanel.add(convertLabel);
conPanel.add(convertToLabel);
conPanel.add(currSelectTwo);
conPanel.add(currResultLabel);
conPanel.add(homeButton);
startPanel.add(viewSummary);
startPanel.add(currencyConv);
startPanel.add(addExpense);
startPanel.add(addIncome);
startPanel.add(titleLabel);
startPanel.add(chooseLabel);







//define start window
this.setSize(455, 600); 
this.setTitle("E-Wallet"); 
this.setLayout(new BorderLayout(10, 10));
this.setResizable(false); 
this.getContentPane().setBackground(Color.black);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
this.setVisible(true);
	
	
	}
	

	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//Controls the buttons when pressed
		if(e.getSource()==addExpense) { 
		System.out.println("you hit the expense button");
		}
		if(e.getSource()==addIncome) { 
			System.out.println("you hit the income button");
			}
		if(e.getSource()==currencyConv) { 
			System.out.println("you hit the currency button");
			try {
				convertWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		if(e.getSource()==viewSummary) { 
			System.out.println("you hit the summary button");
			}
		if(e.getSource()==convertButton) { //converts currency
			
			Object selectedConversionOne = currSelectOne.getSelectedItem(); //getting the selected option
			String currOne = selectedConversionOne.toString(); //converting to a string to pass variable
			Object selectedConversionTwo = currSelectTwo.getSelectedItem();
			String currTwo = selectedConversionTwo.toString();
			
			String ammountToConvert = convertText.getText();
			double convertAmmount = Double.parseDouble(ammountToConvert);
			double converResults = Expenser.convertForeignCurrency(currOne, currTwo, convertAmmount);
			currResultLabel.setText(currTwo + ": " + converResults);
			currResultLabel.setVisible(true);
			
			}
		if(e.getSource()==homeButton) { //resets to home screen
				try {
					screenReset();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	
	
	
	//function to reset screen to base window, anytime you add a button on another window, set it to false here so when we add a back to home button, it makes it invisible.
	public static void screenReset() throws IOException {
		startPanel.setVisible(true);
		conPanel.setVisible(false);
	}
	
	public static void convertWindow() throws IOException {
		//hiding original screen
		startPanel.setVisible(false);

		//making conversion screen
		conPanel.setVisible(true);
		
		
	}
}

