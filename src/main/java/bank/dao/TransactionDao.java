package bank.dao;

import java.util.List;
import bank.model.Transaction;

public interface TransactionDao {
	int createRecord(List<Transaction> lst);
	List<Transaction> retrieveRecords(int accNumber);
	List<Transaction> displayAll();
	int retriveId(int facc,String tacc);
}
