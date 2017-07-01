package Excehandling;

//usser defined exception is created by extending Exception class
class BankATMException extends Exception{
	
	//method is used to print the excption
	public String toString(){
		return "BankATMException : Atm is out of cash";
		
	}
}


//bank atm class created used to keep watch on amount deducted by which atm and how much amount
class BankAtm{
	int atmId;
	String bankName;
	String location;;
	static double balance;
	
	//counstuctor to assign values to properties
	public BankAtm(int atmId, String bankName, String location) {
		
		this.atmId = atmId;
		this.bankName = bankName;
		this.location = location;
	}
	//withdraw method control the cash withdraw 
	public void withdraw(double amt) throws BankATMException{
		
			
			//condition if the balance is less than 10000 or amount wihtdrawn is greater than balance exception thrown 
			if(balance < 10000 || amt > balance){
				
				throw new BankATMException();
			}
			
			//else withdrawn success
			else {
				
				balance = balance - amt;
				System.out.println(" ATM ID :"+atmId+" | Withdraw :"+amt+" | balance :"+balance);
			}
		
		
		
	}
}

//class that contain the main method
public class AsignSixTwo {

	// main mrthod control enterance
	public static void main(String[] args) throws BankATMException {
		// TODO Auto-generated method stub
		
		//objects created 
		BankAtm Atm1 = new BankAtm(101,"SBI","krukamber");
		BankAtm Atm2 = new BankAtm(102,"SBI","Mutuswami");
		BankAtm Atm3 = new BankAtm(103,"SBI","SeshNAg");
		
		//setting up the balance limit
		BankAtm.balance=30000;
		
		//withdraws
		try{
			Atm1.withdraw(5000);
			Atm2.withdraw(10000);
			
			Atm3.withdraw(7000);
			Atm2.withdraw(5000);
		}
		//if excetption occuers 
		catch(BankATMException ex){
			System.out.println(ex);
		}
		
		
	}

}
