package unidad4.practica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DroidekaDAO {
	public class DroidekaDAO {
		public static int eliminar(int id, Connection con) {
			String sql = "DELETE FROM Droideka WHERE id = ?";
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				return pstmt.executeUpdate() > 0 ? 0 : -1;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}

		public static int insertar(DroidekaDO droideka, Connection con) {
			String sql = "INSERT INTO Droideka (modelo, armamento) VALUES (?, ?)";
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, droideka.getModelo());
				pstmt.setString(2, droideka.getArmamento());
				return pstmt.executeUpdate() > 0 ? 0 : -1;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}

		public static int actualizar(DroidekaDO droideka, Connection con) {
			String sql = "UPDATE Droideka SET modelo = ?, armamento = ? WHERE id = ?";
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, droideka.getModelo());
				pstmt.setString(2, droideka.getArmamento());
				pstmt.setInt(3, droideka.getId());
				return pstmt.executeUpdate() > 0 ? 0 : -1;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}

		public static ArrayList<DroidekaDO> cargarTodo(Connection con) {
			ArrayList<DroidekaDO> droidekas = new ArrayList<>();
			String sql = "SELECT * FROM Droideka";
			try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					DroidekaDO droideka = new DroidekaDO();
					droideka.setId(rs.getInt("id"));
					droideka.setModelo(rs.getString("modelo"));
					droideka.setArmamento(rs.getString("armamento"));
					droidekas.add(droideka);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return droidekas;
		}

		public static DroidekaDO cargar(Connection con, int id) {
			DroidekaDO droideka = null;
			String sql = "SELECT * FROM Droideka WHERE id = ?";
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						droideka = new DroidekaDO();
						droideka.setId(rs.getInt("id"));
						droideka.setModelo(rs.getString("modelo"));
						droideka.setArmamento(rs.getString("armamento"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return droideka;
		}
	}

}
