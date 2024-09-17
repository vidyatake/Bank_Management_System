package bank.model;

public class Beneficiary {
	private int f_accno;
	private String t_accno;
	private String Name;
	private String Mobileno;
	public Beneficiary(int f_accno, String t_accno, String name, String mobileno) {
		super();
		this.f_accno = f_accno;
		this.t_accno = t_accno;
		Name = name;
		Mobileno = mobileno;
	}
	public Beneficiary() {
		
	}
	public int getF_accno() {
		return f_accno;
	}
	public void setF_accno(int f_accno) {
		this.f_accno = f_accno;
	}
	public String getT_accno() {
		return t_accno;
	}
	public void setT_accno(String t_accno) {
		this.t_accno = t_accno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMobileno() {
		return Mobileno;
	}
	public void setMobileno(String mobileno) {
		Mobileno = mobileno;
	}
}
