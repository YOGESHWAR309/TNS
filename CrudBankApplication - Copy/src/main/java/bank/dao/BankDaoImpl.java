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

public class BankDaoImpl implements BankDao{
	private Connection con;
	private PreparedStatement pstate;
	private Statement state;
	@Override
	public int createRecodrd(List<Register> lst) {
		con = DBConnection.connectDb();
		Register reg = lst.get(0);
		int i = 0;
		try {
			pstate = con.prepareStatement("insert into ibank values(?,?,?,?)");
			pstate.setInt(1, reg.getAccNumber());
			pstate.setString(2, reg.getCustName());
			pstate.setFloat(3, reg.getAccBal());
			pstate.setString(4, reg.getPassWord());
			i = pstate.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteRecord(int accNumber) {
		con = DBConnection.connectDb();
		int i = 0;
		try {
			pstate = con.prepareStatement("delete from ibank where acc_num = ?");
			pstate.setInt(1, accNumber);
			i = pstate.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public int updateRecord(List<Register> lst) {
		con = DBConnection.connectDb();
		Register reg = lst.get(0);
		
		int i = 0;
		try {
			pstate = con.prepareStatement("update ibank set acc_bal=? where acc_num=?");
			pstate.setFloat(1, reg.getAccBal());
			pstate.setInt(2, reg.getAccNumber());
			i = pstate.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public List<Register> retriveRecord(int accNumber) {
		List<Register> lst = new ArrayList<Register>();
		ResultSet result = null;
		con = DBConnection.connectDb();
		
		try {
			pstate = con.prepareStatement("select * from ibank where acc_num = ?");
			pstate.setInt(1, accNumber);
			result = pstate.executeQuery();
			if(result.next()) {
				lst.add(new Register(result.getInt(1), result.getString(2), result.getFloat(3),result.getString(4)));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}

	@Override
	public List<Register> displayAll() {
		List<Register> lst = new LinkedList<Register>();
		ResultSet result = null;
		con = DBConnection.connectDb();
		
		try {
			state = con.createStatement();
			result = state.executeQuery("select * from ibank");
			while(result.next()) {
				lst.add(new Register(result.getInt(1), result.getString(2), result.getFloat(3), null));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}

}
