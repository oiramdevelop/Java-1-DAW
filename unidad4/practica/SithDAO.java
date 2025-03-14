package unidad4.practica;

public class SithDAO {
	 public static int eliminar(int id, Connection con) {
	        String sql = "DELETE FROM Sith WHERE id = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            return pstmt.executeUpdate() > 0 ? 0 : -1;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }

	    public static int insertar(SithDO sith, Connection con) {
	        String sql = "INSERT INTO Sith (nombre, energiaOscura) VALUES (?, ?)";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setString(1, sith.getNombre());
	            pstmt.setString(2, sith.getPoder());
	            return pstmt.executeUpdate() > 0 ? 0 : -1;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }
	    
	    public static int calcularTotalEnergiaOscuraSith(Connection con, int idSith) {
	        int totalEnergiaOscura = 0;

	        // Consulta SQL para obtener la energía oscura y el nivel de maldad de los Sith
	        String sql = "SELECT energiaOscura, nivelMaldad FROM sith WHERE nivelMaldad > 7";

	        try (PreparedStatement pstmt = con.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {

	            // Recorremos los resultados
	            while (rs.next()) {
	                int energiaOscura = rs.getInt("energiaOscura");
	                int maldad = rs.getInt("nivelMaldad");

	                // Solo sumamos si el nivel de maldad es mayor a 7
	                if (maldad > 7) {
	                    totalEnergiaOscura += energiaOscura;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Manejo de excepciones
	        }

	        return totalEnergiaOscura;
	    }
	    
	    
	    

	    public static int actualizar(SithDO sith, Connection con) {
	        String sql = "UPDATE Sith SET nombre = ?, energiaOscura = ? WHERE id = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setString(1, sith.getNombre());
	            pstmt.setString(2, sith.getPoder());
	            pstmt.setInt(3, sith.getId());
	            return pstmt.executeUpdate() > 0 ? 0 : -1;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }

	    public static ArrayList<SithDO> cargarTodo(Connection con) {
	        ArrayList<SithDO> siths = new ArrayList<>();
	        String sql = "SELECT * FROM Sith";
	        try (PreparedStatement pstmt = con.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                SithDO sith = new SithDO();
	                sith.setId(rs.getInt("id"));
	                sith.setNombre(rs.getString("nombre"));
	                sith.setPoder(rs.getString("poder"));
	                siths.add(sith);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return siths;
	    }

	    public static SithDO cargar(Connection con, int id) {
	        SithDO sith = null;
	        String sql = "SELECT * FROM Sith WHERE id = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    sith = new SithDO();
	                    sith.setId(rs.getInt("id"));
	                    sith.setNombre(rs.getString("nombre"));
	                    sith.setPoder(rs.getString("poder"));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return sith;
	    }
	    
	    
	
}


}
