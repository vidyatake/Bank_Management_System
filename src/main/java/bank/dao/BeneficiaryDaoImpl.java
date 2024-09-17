package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import bank.model.Beneficiary;


public class BeneficiaryDaoImpl implements BeneficiaryDao{

	@Override
	public int CreateRecord(List<Beneficiary> lst) {
		int i=0;
		Connection con=DBConnection.myConnection();
		PreparedStatement pstate;
		Beneficiary reg=lst.get(0);
		List<Beneficiary> blst = retriveRecord(reg.getF_accno());
		
		if(blst != null) {
			for(Beneficiary b:blst) {
				if(b.getT_accno().equals(reg.getT_accno())) {
					return i;
				}
			}
		} //Logic To Avoid Insertion Of Duplicate Records
		
		try {
			pstate=con.prepareStatement("insert into btable values(?,?,?,?)");
			pstate.setInt(1, reg.getF_accno());
			pstate.setString(2, reg.getT_accno());
			pstate.setString(3, reg.getName());
			pstate.setString(4, reg.getMobileno());	
			i=pstate.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int DeleteRecord(Beneficiary b) {
		Connection con=DBConnection.myConnection();
		PreparedStatement pstate;
		int i = 0;
		try {
			pstate = con.prepareStatement("delete from btable where f_accno = ? and t_accno = ?");
			pstate.setInt(1, b.getF_accno());
			pstate.setString(2, b.getT_accno());
			i = pstate.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	
	@Override
	public List<Beneficiary> retriveRecord(int f_accno) {
		List<Beneficiary> lst = new LinkedList<Beneficiary>();
		boolean flag = true;
		ResultSet result = null;
		PreparedStatement pstate;
		Connection con=DBConnection.myConnection();
		try {
			pstate = con.prepareStatement("select * from btable where f_accno = ?");
			pstate.setInt(1, f_accno);
			result = pstate.executeQuery();
			while(result.next()) {
				flag = false;
				lst.add(new Beneficiary(result.getInt(1), result.getString(2), result.getString(3),result.getString(4)));
			}
			if(flag) {
				return null;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public List<Beneficiary> DisplayRecord() {
		List<Beneficiary> lst = new LinkedList<Beneficiary>();
		ResultSet result = null;
		Connection con=DBConnection.myConnection();
		Statement state;
		try {
			state = con.createStatement();
			result = state.executeQuery("select * from btable");
			while(result.next()) {
				lst.add(new Beneficiary(result.getInt(1), result.getString(2), result.getString(3), result.getString(4)));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

}
