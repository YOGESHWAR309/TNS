package bank.dao;

import java.util.List;

import bank.model.*;

public interface BankDao {
	
	int createRecodrd(List<Register> lst);
	int deleteRecord(int accNumber);
	int updateRecord(List<Register> lst);
	List<Register> retriveRecord(int accNumber);
	List<Register> displayAll();
	
}
