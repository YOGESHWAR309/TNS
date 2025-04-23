package bank.model;

public class Register {
	private int accNumber;
	private String custName;
	private Float accBal;
	private String passWord;
	
	public Register(int accNumber, String custName, Float accBal, String passWord) {
		super();
		this.accNumber = accNumber;
		this.custName = custName;
		this.accBal = accBal;
		this.passWord = passWord;
	}
	
	public Register() {
		super();
	}

	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Float getAccBal() {
		return accBal;
	}
	public void setAccBal(Float accBal) {
		this.accBal = accBal;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
