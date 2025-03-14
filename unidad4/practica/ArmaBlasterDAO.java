package unidad4.practica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArmaBlasterDAO {

	public static int eliminar(int id, Connection con) {
		String sql = "DELETE FROM ArmaBlaster WHERE id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate() > 0 ? 0 : -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int insertar(ArmaBlasterDO elementoDO, Connection con) {
		String sql = "INSERT INTO ArmaBlaster (modelo, potencia) VALUES (?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, elementoDO.getNombre());
			pstmt.setInt(2, elementoDO.getPuntosRecarga());
			return pstmt.executeUpdate() > 0 ? 0 : -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int actualizar(ArmaBlasterDO elementoDO, Connection con) {
		String sql = "UPDATE ArmaBlaster SET modelo = ?, potencia = ? WHERE id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, elementoDO.getNombre());
			pstmt.setInt(2, elementoDO.getPuntosRecarga());
			pstmt.setInt(3, elementoDO.getId());
			return pstmt.executeUpdate() > 0 ? 0 : -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static ArrayList<ArmaBlasterDO> cargarTodo(Connection con) {
		ArrayList<ArmaBlasterDO> lista = new ArrayList<>();
		String sql = "SELECT * FROM ArmaBlaster";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				ArmaBlasterDO armaBlaster = new ArmaBlasterDO();
				armaBlaster.setId(rs.getInt("id"));
				armaBlaster.setModelo(rs.getString("modelo"));
				armaBlaster.setPotencia(rs.getInt("potencia"));
				lista.add(armaBlaster);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static ArmaBlasterDO cargar(Connection con, int id) {
		ArmaBlasterDO armaBlaster = null;
		String sql = "SELECT * FROM ArmaBlaster WHERE id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				armaBlaster = new ArmaBlasterDO();
				armaBlaster.setId(rs.getInt("id"));
				armaBlaster.setModelo(rs.getString("modelo"));
				armaBlaster.setPotencia(rs.getInt("potencia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return armaBlaster;
	}
}
