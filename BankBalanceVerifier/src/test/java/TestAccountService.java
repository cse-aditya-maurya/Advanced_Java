import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAccountService {
	BankAccount bankAccount;
	AccountService accountService;
      
//	@BeforeEach
	 @BeforeAll
	
	void setup() {
		accountService=new AccountService();
		bankAccount=new BankAccount(3245339634l,"Mayank Singh Bora",50000);
	}
	@Test
	void testDepositMoney() {
		long updatedBalance=accountService.depositeMoney(bankAccount, 10000);
		assertEquals(60000,updatedBalance);
	}
	@Test
	void testWithDrawMoney() {
		boolean updatedBalance1=accountService.withDrawMoney(bankAccount, 10000);
		assertTrue(updatedBalance1);
		assertEquals(40000,bankAccount.getBankBalance());
	}
	
    @Test
    void testWithdrawMoreThanBalance() {
        boolean result = accountService.withDrawMoney(bankAccount, 100000);
        assertFalse(result);
            
    }
    
    
    @Test
    void testMinimumBalance() {
        boolean result = accountService.checkMinimumBalance(bankAccount);
        assertTrue(result);
    }
    
}
