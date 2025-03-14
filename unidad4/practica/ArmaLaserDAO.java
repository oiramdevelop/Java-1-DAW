package unidad4.practica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ArmaLaserDAO {
	

	
		public static int eliminar(int id, Connection con) {
	        String sql = "DELETE FROM ArmaLaser WHERE id = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            return pstmt.executeUpdate() > 0 ? 0 : -1;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }

	    public static int insertar(ArmaLaserDO elementoDO, Connection con) {
	        String sql = "INSERT INTO ArmaLaser (tipo,danio) VALUES (?, ?)";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setString(1, elementoDO.getModelo());
	            pstmt.setInt(2, elementoDO.getPotencia());
	            return pstmt.executeUpdate() > 0 ? 0 : -1;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }

	    public static int actualizar(ArmaLaserDO elementoDO, Connection con) {
	        String sql = "UPDATE ArmaLaser SET tipo = ?, danio = ? WHERE id = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setString(1, elementoDO.getModelo());
	            pstmt.setInt(2, elementoDO.getPotencia());
	            pstmt.setInt(3, elementoDO.getId());
	            return pstmt.executeUpdate() > 0 ? 0 : -1;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }

	    public static ArrayList<ArmaLaserDO> cargarTodo(Connection con) {
	        ArrayList<ArmaLaserDO> lista = new ArrayList<>();
	        String sql = "SELECT * FROM ArmaLaser";
	        try (PreparedStatement pstmt = con.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                ArmaLaserDO armaLaser = new ArmaLaserDO();
	                armaLaser.setId(rs.getInt("id"));
	                armaLaser.setModelo(rs.getString("modelo"));
	                armaLaser.setPotencia(rs.getInt("potencia"));
	                lista.add(armaLaser);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return lista;
	    }

	    public static ArmaLaserDO cargar(Connection con, int id) {
	        ArmaLaserDO armaLaser = null;
	        String sql = "SELECT * FROM ArmaLaser WHERE id = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                armaLaser = new ArmaLaserDO();
	                armaLaser.setId(rs.getInt("id"));
	                armaLaser.setModelo(rs.getString("modelo"));
	                armaLaser.setPotencia(rs.getInt("potencia"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return armaLaser;
	    }
	}


}
