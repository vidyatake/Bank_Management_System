package bank.model;



public class Transaction {
	
	private int Id;
	private int faccNo;
	private String taccNo;
	private String date;
	private String service;
	private float amount;
	
	
	public Transaction() {
		
	}
	
	public Transaction(int Id,int faccNo, String taccNo, String date, String service,float amount) {
		super();
		this.Id = Id;
		this.faccNo = faccNo;
		this.taccNo = taccNo;
		this.date = date;
		this.service = service;
		this.amount = amount;
	}
	public int getFaccNo() {
		return faccNo;
	}
	public void setFaccNo(int faccNo) {
		this.faccNo = faccNo;
	}
	public String getTaccNo() {
		return taccNo;
	}
	public void setTaccNo(String taccNo) {
		this.taccNo = taccNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	
}
