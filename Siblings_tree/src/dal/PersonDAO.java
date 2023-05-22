package dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.Person;

public class PersonDAO implements Idal{
	private Connection con;

	public PersonDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/22fallfinal?useSSL=false";
		String user = "root";
		String password = "";
		con = DriverManager.getConnection(url, user, password);
	}

	public PersonDAO(Connection con) {
		this.con = con;
	}
	
////---> handle exception method 1
//	public Person getPerson(int cnic) throws SQLException  {
//		PreparedStatement st= con.prepareStatement("SELECT * FROM `citizen` WHERE `cnic`=?");
//		return null;
//	}

	// ---> handle exception method 2
	public Person getPerson(int cnic) {
		Person p = new Person();
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM `citizen` WHERE `cnic`=?");
			st.setInt(1, cnic);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				p.setCnic(rs.getInt("cnic"));
				p.setName(rs.getString("name"));
				p.setFatherCnic(rs.getInt("father"));
				p.setMotherCnic(rs.getInt("mother"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	// ---> handle exception method 2
	public Person getDetails(String name) {
		Person p = new Person();
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM `citizen` WHERE `name`=?");
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				p.setCnic(rs.getInt("cnic"));
				p.setName(rs.getString("name"));
				p.setFatherCnic(rs.getInt("father"));
				p.setMotherCnic(rs.getInt("mother"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
