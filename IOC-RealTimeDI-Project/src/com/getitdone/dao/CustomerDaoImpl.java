package com.getitdone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.getitdone.bo.CustomerBo;

public class CustomerDaoImpl implements ICustomerDao {
	
	private static final String REALTIMEDI_SQL_QUERY = "insert into customer(`cname`,`caddress`,`pamt`,`rate`,`time`,`intrestamount`) values(?,?,?,?,?,?);";
	private DataSource datasource;

	public CustomerDaoImpl(DataSource datasource) {
		this.datasource = datasource;
		System.out.println("CustomerDaoImpl.CustomerDaoImpl()--->"+datasource.getClass().getName());
	}
	Integer rowCount=0;

	@Override
	public String save(CustomerBo bo) throws Exception {
		try(Connection connection = datasource.getConnection();PreparedStatement pstmt=connection.prepareStatement(REALTIMEDI_SQL_QUERY);){
			pstmt.setString(1, bo.getCustomerName());
			pstmt.setString(2, bo.getCustomerAddress());
			pstmt.setFloat(3, bo.getPamt());
			pstmt.setFloat(4, bo.getRate());
			pstmt.setFloat(5, bo.getTime());
			pstmt.setFloat(6, bo.getIntrAmount());
		   rowCount = pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return rowCount==1?"success":"failure";
	}

	@Override
	public String toString() {
		return "CustomerDaoImpl [datasource=" + datasource + "]";
	}

}
