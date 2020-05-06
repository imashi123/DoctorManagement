package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor { 
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertdoctor(String code, String nic, String name, String desc)
		 {
		 String output = "";
		 try
		 {
	 Connection con = connect();
	 if (con == null)
	 {
		 return "Error while connecting to the database for inserting."; 
	 }
	 
	 // create a prepared statement
	 String query = " insert into doctors(`doctorID`,`doctorCode`,`doctorNic`,`doctorName`,`doctorDesc`)" + " values (?, ?, ?, ?, ?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, code);
		 preparedStmt.setString(3, nic);
		 preparedStmt.setString(4, name);
		 preparedStmt.setString(5, desc);
		 
		// execute the statement
		 preparedStmt.execute();
	
		 String newdoctor = readDoctor();    
		 output = "{\"status\":\"success\", \"data\": \"" +  newdoctor + "\"}";
	 }
	 catch (Exception e)
	 {
		 output =  "{\"status\":\"error\", \"data\": \"Error while inserting the doctor.\"}"; 
		 System.err.println(e.getMessage());
	 }
	 return output;
	 }

	public String readDoctor()
	 {
	 String output = "";
	 try
	 {
		Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			// Prepare the html table to be displayed
			output = "<table border=\"1\" id='divdoctorsGrid'>"
					+ "<tr>"
					+ "<th>doctorCode</th>"
					+ "<th>doctorNic</th>"
					+ "<th>doctorName</th>"
					+ "<th>doctorDesc</th>"
					+ "<th>Update</th>"
					+ "<th>Remove</th>"
					+ "</tr>";
			String query = "select * from doctors";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next())
			{
				 String doctorID = Integer.toString(rs.getInt("doctorID"));
				 String doctorCode = rs.getString("doctorCode");
				 String doctorNic = rs.getString("doctorNic");
				 String doctorName = rs.getString("doctorName");
				 String doctorDesc = rs.getString("doctorDesc");
	 
	 // Add into the html table
	 output += "<tr>";
	 output += "<td><input id='hiddoctorIDUpdate' name='hiddoctorIDUpdate' type='hidden' value='" + doctorID + "'>" + doctorCode + "</td>";
	 output += "<td>" + doctorNic + "</td>";
	 output += "<td>" + doctorName + "</td>";
	 output += "<td>" + doctorDesc + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"+ 
			 "<td><input name='doctorID' type='button' value='Remove' class='btnRemove btn btn-danger' data-doctorid='" + doctorID + "'>" + "</td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
		 output = "Error while reading the doctors.";
		 System.err.println(e.getMessage());
	 }
	 	return output;
	 }
	
	public String updatedoctor(String ID, String code, String nic, String name, String desc)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
		 return "Error while connecting to the database for updating."; 
	 }
	 
	 // create a prepared statement
	 String query = "UPDATE doctors SET doctorCode=?,doctorNic=?,doctorName=?,doctorDesc=? WHERE doctorID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
		 preparedStmt.setString(1, code);
		 preparedStmt.setString(2, nic);
		 preparedStmt.setString(3, name);
		 preparedStmt.setString(4, desc);
		 preparedStmt.setInt(5, Integer.parseInt(ID));
		 
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 String newItems = readDoctor(); 
	 output =  "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";
	 }
	 catch (Exception e)
	 {
		 output = "{\"status\":\"error\", \"data\": \"Error while updating the doctor.\"}";
		 System.err.println(e.getMessage()); 
	 }
	 return output;
	 }
	
	public String deletedoctor(String doctorID)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 String query = "delete from doctors where doctorID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(doctorID));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 String newItems = readDoctor();
	 output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}";
	 }
	 catch (Exception e)
	 {
		 output = "{\"status\":\"error\", \"data\":\"Error while deleting the doctor.\"}"; 
		 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	
	public static void main(String[] args) {
		new Doctor().insertdoctor("sdf", "safsaf", "123.23", "sdfadsfsadf");
		//new Item().deletedoctor("1");
	}

}
