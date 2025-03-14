package unidad4.practica;

public class ClonDAO {
	public static int eliminar(int id, Connection con) {
        String sql = "DELETE FROM Clon WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int insertar(ClonDO clon, Connection con) {
        String sql = "INSERT INTO Clon (nombre, modelo) VALUES (?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, clon.getNombre());
            pstmt.setString(2, clon.getRango());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int actualizar(ClonDO clon, Connection con) {
        String sql = "UPDATE Clon SET nombre = ?, modelo = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, clon.getNombre());
            pstmt.setString(2, clon.getRango());
            pstmt.setInt(3, clon.getId());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static ArrayList<ClonDO> cargarTodo(Connection con) {
        ArrayList<ClonDO> clones = new ArrayList<>();
        String sql = "SELECT * FROM Clon";
        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ClonDO clon = new ClonDO();
                clon.setId(rs.getInt("id"));
                clon.setNombre(rs.getString("nombre"));
                clon.setRango(rs.getString("rango"));
                clones.add(clon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clones;
    }

    public static ClonDO cargar(Connection con, int id) {
        ClonDO clon = null;
        String sql = "SELECT * FROM Clon WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    clon = new ClonDO();
                    clon.setId(rs.getInt("id"));
                    clon.setNombre(rs.getString("nombre"));
                    clon.setRango(rs.getString("rango"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clon;
    }
}


}
