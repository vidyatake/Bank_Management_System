package bank.model;

public class Register {
	private int aNo;
	private String cName;
	private String mNo;
	private float aBal;
	private String Pass;
	public Register() {
		
	}
	public Register(int aNo, String cName, String mNo, float aBal, String pass) {
		super();
		this.aNo = aNo;
		this.cName = cName;
		this.mNo = mNo;
		this.aBal = aBal;
		this.Pass = pass;
	}
	public int getaNo() {
		return aNo;
	}
	public void setaNo(int aNo) {
		this.aNo = aNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getmNo() {
		return mNo;
	}
	public void setmNo(String mNo) {
		this.mNo = mNo;
	}
	public float getaBal() {
		return aBal;
	}
	public void setaBal(float aBal) {
		this.aBal = aBal;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		this.Pass = pass;
	}
	
}

