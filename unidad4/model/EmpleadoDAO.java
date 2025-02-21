package unidad4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpleadoDAO {

	/**
	 * La funcion deveuvle todos los empleados de la BD
	 * 
	 * @param con -> Conexion activa a la bd
	 * @return un ResulSet cargdo con los empleados
	 */
	public static ResultSet getEmpleados(Connection con) {

		try {
			// Con la conexcion ya activa (con) crea una sentencia para poder ejecutar
			// sentencias sql
			Statement stmt = con.createStatement();
			// Directamene ejecutamos la sentencia
			// Si es una sentencia tipo select se hace con executeQuery
			// Esta nos devuelve un objeto tipo ResulSet con los datos de la query
			ResultSet rs = stmt.executeQuery("select * from empleados");

			return rs;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	/**
	 * La funcion deveuvle todos los empleados de la BD
	 * 
	 * @param con -> Conexion activa a la bd
	 * @return un ResulSet cargdo con los empleados
	 */
	public static ResultSet getEmpleado(Connection con, int id) {

		try {
			// Para evitar la inyeccion sql los parametros de la query los metemos con?
			// Y se lo añadiremos despues de forma controlada utilizando preparedStatement
			String query = "select * from empleados where idempleados = ?";

			PreparedStatement pstmt = con.prepareStatement(query);

			// Asignamos el parametro id en la primera interrogacion (y la unica)
			pstmt.setInt(1, id);
			// Una vez asignados los valores ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			return rs;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	/**
	 * La funcion mata a un empleado de la BD
	 * 
	 * @param con -> Conexion activa a la bd
	 * @return un ResulSet si ha poddio borrar al empleado
	 */
	public static int deleteEmpleado(Connection con, int id) {

		try {
			// Para evitar la inyeccion sql los parametros de la query los metemos con?
			// Y se lo añadiremos despues de forma controlada utilizando preparedStatement
			String query = "delete  from empleados where idempleados = ?";

			PreparedStatement pstmt = con.prepareStatement(query);

			// Asignamos el parametro id en la primera interrogacion (y la unica)

			pstmt.setInt(1, id);
			// Una vez asignados los valores ejecutamos la query

			int resultado = pstmt.executeUpdate();

			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return -1;
	}
}
