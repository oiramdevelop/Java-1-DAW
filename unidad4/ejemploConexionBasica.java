package unidad4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ejemploConexionBasica {

	public static void main(String args[]) {
		try {
			// Comprueba que tengamos el driver para conectarnos a la bd mysql
			// Antes de conectarnos en si , si no esta no pasa nada
			Class.forName("com.mysql.cj.jdbc.Driver");

			/*
			 * Para conectarnos necesitamos 5 parametros Ip o nombre del host, en nuestro
			 * caso localHost puerto por el que nos conectamos , en mysql 3306 usuario y
			 * contraseña nombre del esquema de la bd en nuestro caso como dijo mario
			 * frigopie
			 */
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/frigopie", "root", "daw2024");

			// Con la conexcion ya activa (con) crea una sentencia para poder ejecutar
			// sentencias sql
			Statement stmt = con.createStatement();
			// Directamene ejecutamos la sentencia
			// Si es una sentencia tipo select se hace con executeQuery
			// Esta nos devuelve un objeto tipo ResulSet con los datos de la query
			ResultSet rs = stmt.executeQuery("select * from empleados");

			// teniendo el resultset relleno de registros , lo recorremos utilizando la
			// funcion next
			// POr defecto el resultset no apunta a ninfun registro
			// Es decir si no ejectuo next() ninguna vez y intento acceder a los datos va a
			// fallar

			while (rs.next())
				// Para sacar los datos utilizamos funciones get con el tipo de dato y el numero
				// de la columna
				// o el nombre del campo
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + " \n Edad -> "
						+ rs.getInt("edad"));
			con.close();
		} catch (Exception e) {
			// El prinsttacktrace muestra el error de la excepcion si ocurre el error
			System.out.println(e);
		}
	}
}