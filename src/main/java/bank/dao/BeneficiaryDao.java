package bank.dao;
import java.util.List;
import bank.model.Beneficiary;

public interface BeneficiaryDao {
	int CreateRecord(List<Beneficiary> lst);
	int DeleteRecord(Beneficiary b);
	List<Beneficiary> retriveRecord(int f_accno);
	List<Beneficiary> DisplayRecord();
}
