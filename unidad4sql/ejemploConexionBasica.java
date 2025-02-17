package unidad4sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ejemploConexionBasica {

	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/frigopie", "root", "daw2024");

//here sonoo is database name, root is username and password  
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from emp");

			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			// El prinsttacktrace muestra el error de la excepcion si ocurre el error
			System.out.println(e);
		}
	}
}