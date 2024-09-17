package bank.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import bank.model.Transaction;

public class TransactionDaoImpl implements TransactionDao{
	DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private Connection con = null;
	private PreparedStatement pstate = null;
	private Statement state = null;
	private List<Transaction> lst = null;
	private ResultSet result = null;
	
	
	public int createRecord(List<Transaction> lst) {
		int i = 0;
		con = DBConnection.myConnection();
		Transaction r = lst.get(0);
		r.setDate(formatter.format(new Date()));
		try {
			pstate = con.prepareStatement("insert into transaction values(tran_seq.nextval,?,?,?,?,?)");
			
			pstate.setInt(1, r.getFaccNo());
			pstate.setString(2, r.getTaccNo());
			pstate.setString(3, r.getDate());
			pstate.setString(4, r.getService());
			pstate.setFloat(5, r.getAmount());
			i = pstate.executeUpdate();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
	}
		
	public List<Transaction> retrieveRecords(int accNumber) {
		con = DBConnection.myConnection();
		lst = new ArrayList<Transaction>();
		try {
			pstate = con.prepareStatement("select * from transaction where f_accno=? or t_accno=?");
			pstate.setInt(1, accNumber);
			pstate.setString(2, Integer.toString(accNumber));
			result = pstate.executeQuery();
			while(result.next()) {
				lst.add(new Transaction(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5),result.getFloat(6)));
			}
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lst;
	}

	
	public List<Transaction> displayAll() {
		lst = null;
		con = DBConnection.myConnection();
		try {
			state = con.createStatement();
			result = state.executeQuery("select * from transaction");
			while(result.next()) {
				lst.add(new Transaction(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5),result.getFloat(6)));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public int retriveId(int facc, String tacc) {
		int tId = 0;
		List<Integer> tlst = new ArrayList<Integer>();
		
		con = DBConnection.myConnection();
		
		try {
			pstate = con.prepareStatement("select t_id from transaction where f_accno=? and t_accno = ?");
			pstate.setInt(1, facc);
			pstate.setString(2, tacc);
			result = pstate.executeQuery();
			while(result.next()) {
				tlst.add(result.getInt(1));
			}
			tId = Collections.max(tlst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tId;
	}

}
