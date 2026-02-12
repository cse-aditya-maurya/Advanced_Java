
public class AccountService {
	public long depositeMoney(BankAccount bank,long depositeBalance) {
		if (depositeBalance <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }

        long updated = bank.getBankBalance() + depositeBalance;
        bank.setBankBalance(updated);
	    System.out.println("Bank Balance: "+bank.getBankBalance());

        return updated;
    }

	
	public boolean withDrawMoney(BankAccount bank,long withdrawAmount) {
		  if (withdrawAmount <= bank.getBankBalance()) {
	            bank.setBankBalance(bank.getBankBalance() - withdrawAmount);
	           
	     System.out.println("withdraw Amount: "+withdrawAmount+" Successfully");
	     System.out.println("Bank Balance: "+bank.getBankBalance());
	            return true;
	        }
	        return false;
	    }
		
		
     public boolean checkMinimumBalance(BankAccount bank) {
          return bank.getBankBalance() >= 1000;
}
	
	

}
