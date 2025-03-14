package unidad4.practica;

public class JediDAO {
public static ResultSet getJedi(Connection con) {
		
		try {
			
			Statement stmt = con.createStatement();
			
			ResultSet rs =stmt.executeQuery("select * from jedi");
			
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	 public static int eliminar(int id, Connection con) {
	        String sql = "DELETE FROM Jedi WHERE id = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            return pstmt.executeUpdate() > 0 ? 0 : -1;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }

	    public static int insertar(JediDO jedi, Connection con) {
	        String sql = "INSERT INTO Jedi (nombre, rango) VALUES (?, ?)";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setString(1, jedi.getNombre());
	            pstmt.setString(2, jedi.getRango());
	            return pstmt.executeUpdate() > 0 ? 0 : -1;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }

	    public static int actualizar(JediDO jedi, Connection con) {
	        String sql = "UPDATE Jedi SET nombre = ?, rango = ? WHERE id = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setString(1, jedi.getNombre());
	            pstmt.setString(2, jedi.getRango());
	            pstmt.setInt(3, jedi.getId());
	            return pstmt.executeUpdate() > 0 ? 0 : -1;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }

	    public static ArrayList<JediDO> cargarTodo(Connection con) {
	        ArrayList<JediDO> jedis = new ArrayList<>();
	        String sql = "SELECT * FROM Jedi";
	        try (PreparedStatement pstmt = con.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	        	            while (rs.next()) {
	        	                JediDO jedi = new JediDO();
	        	                jedi.setId(rs.getInt("id"));
	        	                jedi.setNombre(rs.getString("nombre"));
	        	                jedi.setRango(rs.getString("rango"));
	        	                jedis.add(jedi);
	        	            }
	        	        } catch (SQLException e) {
	        	            e.printStackTrace();
	        	        }
	        	        return jedis;
	        	    }

	        	    public static JediDO cargar(Connection con, int id) {
	        	        JediDO jedi = null;
	        	        String sql = "SELECT * FROM Jedi WHERE id = ?";
	        	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        	            pstmt.setInt(1, id);
	        	            try (ResultSet rs = pstmt.executeQuery()) {
	        	                if (rs.next()) {
	        	                    jedi = new JediDO();
	        	                    jedi.setId(rs.getInt("id"));
	        	                    jedi.setNombre(rs.getString("nombre"));
	        	                    jedi.setRango(rs.getString("rango"));
	        	                }
	        	            }
	        	        } catch (SQLException e) {
	        	            e.printStackTrace();
	        	        }
	        	        return jedi;
	        	    }
	        	    public static ArrayList<ClonDO> cargarClones(int idJedi, Connection con) {
	        	        ArrayList<ClonDO> listaClones = new ArrayList<>();
	        	        String sql = "SELECT * FROM Clon WHERE id = ?";
	        	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        	            pstmt.setInt(1, idJedi);
	        	            ResultSet rs = pstmt.executeQuery();
	        	            while (rs.next()) {
	        	                ClonDO clon = new ClonDO();
	        	                clon.setId(rs.getInt("id"));
	        	                clon.setNombre(rs.getString("nombre"));
	        	                clon.setFuerza(rs.getInt("fuerza"));
	        	                clon.setTiempoRefuerzoAdrenalina(rs.getInt("tiempoRefuerzoAdrenalina"));
	        	                // Asignar otros campos según la estructura de ClonDO
	        	                listaClones.add(clon);
	        	            }
	        	        } catch (SQLException e) {
	        	            e.printStackTrace();
	        	        }
	        	        return listaClones;
	        	    }

	        	    public static int cantidadArmas(int idJedi, Connection con) {
	        	        String sql = "SELECT COUNT(*) FROM ArmaBlaster WHERE id IN (SELECT id FROM Clon WHERE id = ?)";
	        	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        	            pstmt.setInt(1, idJedi);
	        	            ResultSet rs = pstmt.executeQuery();
	        	            if (rs.next()) {
	        	                return rs.getInt(1);
	        	            }
	        	        } catch (SQLException e) {
	        	            e.printStackTrace();
	        	        }
	        	        return 0;
	        	    }

	        	    public static double calcularMaximaFuerzaClones(Connection con, int idJedi) {
	        	        double maxFuerza = Double.MIN_VALUE;
	        	        ArrayList<ClonDO> clones = cargarClones(idJedi, con);
	        	        for (ClonDO clon : clones) {
	        	            if (clon.getFuerza() > maxFuerza) {
	        	                maxFuerza = clon.getFuerza();
	        	            }
	        	        }
	        	        return maxFuerza == Double.MIN_VALUE ? 0 : maxFuerza; // Retorna 0 si no hay clones
	        	    }

	        	    public static ArrayList<ClonDO> cargarClonesConRefuerzoAdrenalina(Connection con, int idJedi) {
	        	        ArrayList<ClonDO> listaClonesConRefuerzo = new ArrayList<>();
	        	        ArrayList<ClonDO> clones = cargarClones(idJedi, con);
	        	        for (ClonDO clon : clones) {
	        	            if (clon.getTiempoRefuerzoAdrenalina() > 0) {
	        	                listaClonesConRefuerzo.add(clon);
	        	            }
	        	        }
	        	        return listaClonesConRefuerzo;
	        	    }
	        	    
	        	    
	
}

}
