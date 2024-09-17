 package bank.dao;

import java.util.List;
import bank.model.Register;

public interface RegisterDao {
	
	int createRecord(List<Register> lst);
	int deleteRecord(int accNumber);
	int updateRecord(List<Register> lst);
	int updatePassword(List<Register> lst);
	List<Register> retrieveRecord(int accNumber);
	List<Register> displayAll();
	
}