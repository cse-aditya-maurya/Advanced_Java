
public class BankAccount {
    private long accountNumber;
    private String holderName;
    private long bankBalance;

	/**
	 * @param accountNumber
	 * @param holderName
	 * @param bankBalance
	 */
	public BankAccount(long accountNumber, String holderName, long bankBalance) {
		super();
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.bankBalance = bankBalance;
	}
	public final long getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public final void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the holderName
	 */
	public final String getHolderName() {
		return holderName;
	}
	/**
	 * @param holderName the holderName to set
	 */
	public final void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	/**
	 * @return the bankBalance
	 */
	public final long getBankBalance() {
		return bankBalance;
	}
	/**
	 * @param bankBalance the bankBalance to set
	 */
	public final void setBankBalance(long bankBalance) {
		this.bankBalance = bankBalance;
	}
}
