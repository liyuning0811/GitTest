package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;
import javabean.Patient;

public class UserDao {
	private DbUtil dbUtil;
	
public List<Patient> getAllUser(){
	dbUtil=new DbUtil();
	List<Patient> list=new ArrayList<Patient>();
	String sql="select *from patient";
	ResultSet rs=dbUtil.excuteSql(sql);
	try {
		while (rs.next()) {
			int i=1;
			Patient userBean=new Patient();
			userBean.setUserid(rs.getInt(i++));
			userBean.setFullname(rs.getString(i++));
			userBean.setAge(rs.getInt(i++));
			userBean.setSex(rs.getString(i++));
			userBean.setMobile(rs.getString(i++));
			userBean.setBirth_date(rs.getString(i++));
			
			list.add(userBean);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		dbUtil.close();
	}
	return list;
}

public boolean insertUser(Patient patient) {
	dbUtil=new DbUtil();
	String sql="insert into patient(fullname,age,sex,birth_date,mobile) values(?,?,?,?,?,?)";
	int row=dbUtil.excute(sql,new Object[]{patient.getFullname(),patient.getAge(),patient.getSex(),patient.getBirth_date(),patient.getMobile()});
	if (row>0) {
		return true;
	}else {
		return false;
	}
	
}

public Patient selectOneUser(int id) {
	dbUtil=new DbUtil();
	Patient patient=new Patient();
	String sql="select*from patient where userid='"+id+"'";
	ResultSet rs=dbUtil.excuteSql(sql);
	try {
		if(rs.next()) {
			int i=1;
			
			patient.setFullname(rs.getString(i++));
			
			patient.setAge(rs.getInt(i++));
			patient.setSex(rs.getString(i++));
			patient.setBirth_date(rs.getString(i++));
			patient.setMobile(rs.getString(i++));
		}
		} catch (Exception e) {
		e.printStackTrace();
	}
	return patient;
	}
public boolean updateOneUser(Patient patient) {
	dbUtil=new DbUtil();
	String sql="update patient set fullname=?,age=?,sex=?,birth_date=?,mobile=? where userid=? ";
	int row=dbUtil.excute(sql, new Object[]{patient.getFullname(),patient.getAge(),patient.getSex(),patient.getBirth_date(),patient.getMobile()});
	if (row>0) {
		return true;
	}else {
		return false;	
	}
}
	public boolean deleteOneUser(int id) {
		dbUtil=new DbUtil();
		String sql="delete from patient where userid='"+id+"'";
		int row=dbUtil.excute(sql);
		if (row>0) {
			return true;
		}else {
			return false;
		}

}

}
