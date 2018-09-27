/*
This class tracks a bank account balance 
and includes methods for common bank account
functionality (Deposits, Withdrawals, Interest)
 */
public class BankAccount {
	private double balance;
	private double rate;
/*
BankAccount 
	Public BankAccount()
	Constructs an object of BankAccount initializing the balance and interest rate to zero
	Parameter: None
	Precondition: None
	Postcondition:
	An object of the BankAccount class with balance and interest rate equal to zero
	Throws: None
*/

	public BankAccount() {
		balance = 0;
		rate = 0;
	}
/*
BankAccount 
	Public BankAccount(double balance, double rate)
	Constructs an object of BankAccount initializing the balance and interest rate to the corresponding parameters
	Parameter: 
	balance – double value representing the balance of BankAccount object
	rate – double value representing the interest rate of BankAccount object 
	Precondition:
	balance >= 0
	rate >= 0
	Postcondition:
	An object of the BankAccount class with balance and interest rate equal to the corresponding parameters
	Throws: IllegalArgmentException 
	Indicates interest rate or balance is less than 0
 */

	public BankAccount(double balance, double rate) {
		if (balance < 0) {
			throw new IllegalArgumentException("Error: Balance is less than zero");
		} else if (rate < 0) {
			throw new IllegalArgumentException("Error: Rate is less than zero");
		} else {
			this.balance = balance;
			this.rate = rate;
		}
	}
	
/*
setBalance 
	Public void setBalance(double balance)
	Sets the balance of the bank account
	Parameter: 
	balance – double value representing the balance of the BankAccount object
	Precondition:
	balance >= 0
	Postcondition:
	Balance of BankAccount set to the given parameter value
	Throws: IllegalArgumentException
	Indicates balance is less than 0
*/
	
	public void setBalance(double balance) {
		if (balance < 0) {
			throw new IllegalArgumentException("Error: Balance is less than zero");
		} else {
				this.balance = balance;
			}
			
			}
	
/*
getBalance
	public double getBalance()
	return the balance of BankAccount
	Parameters: None
	Precondition: None
	Postcondition: 
	Returns the value of balance
	Throws: None
*/
	
	public double getBalance() {
		return balance;
	}
	
/*
setRate 
	Public void setRate(double Rate)
	Sets the interest rate of the bank account
	Parameter: 
	rate – double value representing the interest rate of the bank account
	Precondition:
	rate >= 0
	Postcondition:
	Interest rate of BankAccount set to the given parameter value
	Throws: IllegalArgumentException
	Indicates rate is less than 0
*/
	
	public void setRate(double rate) {
		if (rate < 0) {
			throw new IllegalArgumentException("Error: Intrest Rate is less than zero");
		} else {
				this.rate = rate;
			}
			
			}
/*
getRate
	public double getRate()
	return the current interest rate of BankAccount
	Parameters: None
	Precondition: None
	Postcondition: 
	Returns the value of rate
	Throws: None
*/
	public double getRate(){
		return rate;	
	}
	
/*
Deposit
	public void Deposit(double amount)
	adds given amount to the current bank account balance
	Parameters: 
	amount – double value representing the amount to be added to current balance
	Precondition: 
	amount >= 0
	Postcondition: 
	Balance of bank account is set to balance plus amount
	Throws: IllegalArguementException
	Indicates amount is not a positive value
*/
	
	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Error: Deposit Amount is less than zero");		
		} else {
			balance += amount;
		}
	}
	
/*
 Withdrawal
	public void Withdrawal(double amount)
	subtracts given amount from the current bank account balance
	Parameters: 
	amount – double value representing the amount to be subtracted to current balance
	Precondition: 
	amount >= 0
	Postcondition: 
	Balance of bank account is set to balance minus amount
	Throws: IllegalArguementException
	Indicates amount is not a positive value
*/
	
	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Error: Withdrawal Amount is less than zero");		
		} else {
			balance -= amount;
		}
	}
/*
addInterest
	public void addIntrest(double years)
	adds the accumulated interest over a given amount of time in years to the bank account balance
	Parameters: 
	years – double value representing the amount time, in years, of interest accumulation to be added to  the current balance
	monthyDep - double value representing the amount deposited every month
	Precondition: 
	years >= 0
	Postcondition: 
	Balance of bank account is set to balance plus interest accumulated over the given amount of time plus monthly deposits
	Throws: IllegalArguementException
	Indicates years is less than 0
*/
	
	public void addInterest(double years, double monthlyDep) {
		if (years < 0) {
			throw new IllegalArgumentException("Error: Years is less than zero");		
		}
		balance = (balance * (Math.pow((1 + (rate/12)),(12 * years)))) //compound monthly interest
		+ (monthlyDep * (((Math.pow((1 + (rate/12)),(12 * years))) - 1) / (rate/12))); //monthly deposit
	
		}
		
	}


