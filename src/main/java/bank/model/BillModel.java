package bank.model;

public class BillModel {
	private Register r;
	private Transaction t;
	public BillModel() {
		
	}
	
	public BillModel(Register r, Transaction t) {
		super();
		this.r = r;
		this.t = t;
	}

	public Register getR() {
		return r;
	}
	public Transaction getT() {
		return t;
	}
	
	
}
