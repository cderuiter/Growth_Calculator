
	
	import java.awt.*;
	import java.awt.event.*;
	import java.text.DecimalFormat;
	import java.text.NumberFormat;
	import javax.swing.*;

	public class Window extends JFrame {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int x = 500;
	    private int y = 300;
	    
	    
	    JLabel box1, box2, box3, box4, amountBox;
	    JTextField balance, numYears, rate, deposit;
	    JButton compute, clear;
	    
/*
Window
	public Window(String Title)
	Builds a Graphical User Interface object from the Window Class
	Parameters: 
	Title – string data type representing the title of the GUI
	Precondition: None
	Postcondition: 
	A GUI with components used to calculate compound monthly interest on a given amount
	Throws: None
*/
	    
	    public Window(String Title) {
	        super(Title);
	        setSize(500, 300);
	        setLocation(x, y);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().setBackground(Color.GRAY);

	        setLayout(null);        
	        //Problem 1 code - creates GUI components
	        box1 = new JLabel("Enter Balance");
	        box2 = new JLabel("Enter Number of Years");
	        box3 = new JLabel("Enter Intrest Rate (%)");
	        box4 = new JLabel("Enter Monthly Deposit");
	        
	        balance = new JTextField();
	        numYears = new JTextField();
	        rate = new JTextField();
	        deposit = new JTextField();
	        compute = new JButton("Compute");
	        clear = new JButton("Clear");
	        amountBox = new JLabel("Amount is: ");

	        box1.setBounds(50, 10, 300, 30);
	        box1.setFont(new Font("Sherif", Font.BOLD, 12));
	        box2.setBounds(50, 40, 300, 30);
	        box2.setFont(new Font("Sherif", Font.BOLD, 12));
	        box3.setBounds(50, 70, 300, 30);
	        box3.setFont(new Font("Sherif", Font.BOLD, 12));
	        box4.setBounds(50, 100, 300, 30);
	        box4.setFont(new Font("Sherif", Font.BOLD, 12));
	        amountBox.setBounds(50, 130, 300, 30);
	        amountBox.setFont(new Font("Sherif", Font.BOLD, 15));
	        balance.setBounds(190, 10, 100, 30);
	        numYears.setBounds(190, 40, 100, 30);
	        rate.setBounds(190, 70, 100, 30);
	        deposit.setBounds(190, 100, 100, 30);
	        compute.setBounds(310, 30, 100, 30);
	        clear.setBounds(310, 70, 100, 30);

	        clear.addActionListener(new clearBoxes());
	        compute.addActionListener(new calculate());

	        add(box1);
	        add(box2);
	        add(box3);
	        add(box4);
	        add(balance);
	        add(numYears);
	        add(rate);
	        add(compute);
	        add(deposit);
	        add(clear);
	        add(amountBox);
	        
	        setVisible(true);

	    }
/*
actionPerformed
	public void actionPerformed(ActionEvent e)
	Handles events from JButton ‘compute’ in Window Class
	Parameter:
	e – ActionEvent type 
	Precondition: None
	Postcondition: 
	Calculates the account balance including monthly compound 
	interest based on four inputs from the GUI inputs fields
	(balance, interest rate, time in years, monthly deposit) 
	and implementation of the BankAccount Class  
	Throws: NumberFormatException
	Indicates a number was not inputed into a field and a 
	double value cannot be parsed
*/  
	    public class calculate implements ActionListener {
	    	public BankAccount b1 = new BankAccount(); 
	    	

	        public void actionPerformed(ActionEvent e) {
	            double Y;
	            NumberFormat nf = NumberFormat.getCurrencyInstance();
	            
	            try{
	            
	            b1.setBalance(Double.parseDouble(balance.getText()));
	            Y = Double.parseDouble(numYears.getText());
	            b1.setRate((Double.parseDouble(rate.getText()))/100);		            
	            b1.addInterest(Y, Double.parseDouble(deposit.getText()));         
	            amountBox.setText("Amount is: " + nf.format(b1.getBalance()));
	            }
	            catch (NumberFormatException z){
	                JOptionPane.showMessageDialog(rootPane, "Error on Input: Fill in every field with a number", "Error", JOptionPane.ERROR_MESSAGE);
	                
	            }           

	        }
	    }
	    

/*
 actionPerformed
	public void actionPerformed(ActionEvent e)
	Handles events from JButton ‘clear’ in Window Class
	Parameter:
	e – ActionEvent type 
	Precondition: None
	Postcondition: 
	Clears all GUI inputs fields  
	Throws: None
*/


	    public class clearBoxes implements ActionListener {

	        public void actionPerformed(ActionEvent e) {
	            balance.setText("");
	            numYears.setText("");
	            rate.setText("");
	            deposit.setText("");
	            amountBox.setText("Amount is: " + "");

	        }

	    }

	}

