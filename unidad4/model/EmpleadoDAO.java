package unidad4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpleadoDAO {

	/**
	 * La función devuelve todos los empleados de la bd
	 * 
	 * @param con Conexion activa a la bd
	 * @return un ResultSet cargado con los empleados
	 */
	public static ResultSet getEmpleados(Connection con) {

		try {
			// Con la conexion ya activa (con) crea una sentencia para poder ejecutar
			// sentencias sql
			Statement stmt = con.createStatement();

			// Directamente ejecutamos la sentencia
			// Si es una sentenci tipo select se hace con executeQuery
			// Esta nos devuelve un objeto de tipo ResultSet con los datos de la query
			ResultSet rs = stmt.executeQuery("select * from empleados");

			return rs;

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return null;
	}

	/**
	 * La función devuelve el empleado asociado a la id que introducimos
	 * 
	 * @param con Conexion activa a la bd
	 * @return un ResultSet cargado con el empleado
	 */
	public static ResultSet getEmpleado(Connection con, int id) {

		try {

			// Para evitar la inyeccion sql los parametros de la query los metemos con ?
			// Y se los añadiremos despues de forma controlada utilizando preparedStatement
			String query = "select * from empleados where idempleados = ?";

			PreparedStatement pstmt = con.prepareStatement(query);

			// Asignamos el parametro id en la primera interrogacion ( y la unica)
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
	 * La función elimina el empleado asociado a la id que introducimos
	 * 
	 * @param con Conexion activa a la bd
	 * @return 1 si ha podido borrar al empleado
	 */
	public static int deleteEmpleado(Connection con, int id) {

		try {

			// Para evitar la inyeccion sql los parametros de la query los metemos con ?
			// Y se los añadiremos despues de forma controlada utilizando preparedStatement
			String query = "delete from empleados where idempleados = ?";

			PreparedStatement pstmt = con.prepareStatement(query);

			// Asignamos el parametro id en la primera interrogacion ( y la unica)
			pstmt.setInt(1, id);

			// Una vez asignados los valores ejecutamos la query
			// update me devuelve la cantidad de registros afectados por la query
			int resultado = pstmt.executeUpdate();

			return resultado;

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return -1;
	}

	/**
	 * Funcion que recibe una conexion y los dates del empleado con un empleadoDO
	 * 
	 * @param con      COnexion a la BD
	 * @param empleado Objeto de la clase EmpleadoDO con los datos a insertar
	 * @return -1 si falla o no hay datos y 1 si ha podido insertar el regitro en BD
	 */
	public static int insertEmpleado(Connection con, EmpleadoDO empleado) {

		if (empleado == null) {
			return -1;
		}
		try {

			// Para evitar la inyeccion sql los parametros de la query los metemos con ?
			// Y se los añadiremos despues de forma controlada utilizando preparedStatement
			String query = "INSERT INTO `empleados` (`idempleados`,`nombre`,`apellidos`,`edad`,`sueldo`,`puesto`)"
					+ "VALUES (?,?,?,?,?";

			PreparedStatement pstmt = con.prepareStatement(query);

			// Asignamos el parametro id en la primera interrogacion ( y la unica)
			pstmt.setString(1, empleado.getNombre());
			pstmt.setString(2, empleado.getApellidos());
			pstmt.setInt(3, empleado.getEdad());
			pstmt.setDouble(4, empleado.getSueldo());
			pstmt.setInt(5, empleado.getPuesto());

			// Una vez asignados los valores ejecutamos la query
			// update me devuelve la cantidad de registros afectados por la query
			int resultado = pstmt.executeUpdate();

			return resultado;

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return -1;
	}

}
