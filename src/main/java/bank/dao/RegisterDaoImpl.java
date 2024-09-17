package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import bank.model.Register;


public class RegisterDaoImpl implements RegisterDao{

	@Override
	public int createRecord(List<Register> lst) {
		int i=0;
		Connection con = DBConnection.myConnection();
		Register rmodel = lst.get(0);
		try {
			PreparedStatement pstate=con.prepareStatement("insert into Register values(?,?,?,?,?)");
			pstate.setInt(1, rmodel.getaNo());
			pstate.setString(2, rmodel.getcName());
			pstate.setString(3, rmodel.getmNo());
			pstate.setFloat(4, rmodel.getaBal());
			pstate.setString(5, rmodel.getPass());
			i=pstate.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


		return i;
	} //done

	@Override
	public List<Register> retrieveRecord(int accNumber) {
		Connection con = DBConnection.myConnection();

		List<Register> lstrecord = new ArrayList<Register>();

		try {
			PreparedStatement pstate = con.prepareStatement("select * from Register where acc_No=?");
			pstate.setInt(1, accNumber);
			ResultSet result = pstate.executeQuery();

			if(result.next()) {
				lstrecord.add(new Register(result.getInt(1), result.getString(2), result.getString(3), result.getFloat(4), result.getString(5)));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lstrecord;
	} //done

	@Override
	public List<Register> displayAll() {
		Connection con = DBConnection.myConnection();

		ResultSet result = null;

		List< Register> lstallrecords = new LinkedList<Register>();


		try {
			Statement state = con.createStatement();
			result = state.executeQuery("select * from Register");
			while(result.next()) {
				lstallrecords.add(new Register(result.getInt(1), result.getString(2), result.getString(3), result.getFloat(4), result.getString(5)));
			} 
			con.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}


		return lstallrecords;
	}//done

	@Override
	public int deleteRecord(int accNumber) {
		Connection con = DBConnection.myConnection();
		int i=0;

		try {
			PreparedStatement pstate = con.prepareStatement("delete from Register where acc_No=?");
			pstate.setInt(1, accNumber);
			i = pstate.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}	//done

	@Override
	public int updateRecord(List<Register> lst) {
		Connection con = DBConnection.myConnection();
		int i=0;
		Register rmodel = lst.get(0);

		try {
			PreparedStatement pstate = con.prepareStatement("update Register set acc_Bal=? where acc_No=?");
			pstate.setFloat(1,rmodel.getaBal());
			pstate.setInt(2, rmodel.getaNo());
			i=pstate.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	} //done

	@Override
	public int updatePassword(List<Register> lst) {
		int i = 0;
		Connection con = DBConnection.myConnection();
		Register rmodel = lst.get(0);
		
		try {
			PreparedStatement pstate = con.prepareStatement("update Register set acc_pass=? where acc_No=?");
			pstate.setString(1,rmodel.getPass());
			pstate.setInt(2, rmodel.getaNo());
			i=pstate.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

}

