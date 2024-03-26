package model;

import java.sql.*;

import utils.DataHelper;

public class User implements java.io.Serializable {
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean validate() {
		try {
			Connection conn = DataHelper.getConnection();
			String sql = "select * from user where email ='" + email + "'" ;
			Statement stmt = null;
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// Retrieve by column name
				String mail = rs.getString("email");
				String pw = rs.getString("password");
				if(this.email.equals(mail)&& this.password.equals(pw)) {
					return true;
				}
			}

			}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
		
	}
}