package unidad4.practica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClonDAO {

    /****************************
     * FUNCIONES
     ****************************/

    /**
     * Elimina un clon de la base de datos por su ID.
     * @param id El ID del clon a eliminar.
     * @param con La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
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

    /**
     * Inserta un nuevo clon en la base de datos.
     * @param clon El objeto ClonDO con los datos del clon.
     * @param con La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int insertar(ClonDO clon, Connection con) {
        String sql = "INSERT INTO Clon (apodoGuerra, modelo, fuerza, intelignecia, horasInactividad, tiempoRefuerzoAdrenalina, rolEnSpeeder, Speeder_id, Jedi_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, clon.getApodoGuerra());
            pstmt.setString(2, clon.getModelo());
            pstmt.setInt(3, clon.getFuerza());
            pstmt.setInt(4, clon.getIntelignecia());
            pstmt.setInt(5, clon.getHorasInactividad());
            pstmt.setInt(6, clon.getTiempoRefuerzoAdrenalina());
            pstmt.setInt(7, clon.getRolEnSpeeder());
            pstmt.setInt(8, clon.getSpeeder_id());
            pstmt.setInt(9, clon.getJedi_id());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Actualiza un clon existente en la base de datos.
     * @param clon El objeto ClonDO con los datos actualizados.
     * @param con La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int actualizar(ClonDO clon, Connection con) {
        String sql = "UPDATE Clon SET apodoGuerra = ?, modelo = ?, fuerza = ?, intelignecia = ?, horasInactividad = ?, tiempoRefuerzoAdrenalina = ?, rolEnSpeeder = ?, Speeder_id = ?, Jedi_id = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, clon.getApodoGuerra());
            pstmt.setString(2, clon.getModelo());
            pstmt.setInt(3, clon.getFuerza());
            pstmt.setInt(4, clon.getIntelignecia());
            pstmt.setInt(5, clon.getHorasInactividad());
            pstmt.setInt(6, clon.getTiempoRefuerzoAdrenalina());
            pstmt.setInt(7, clon.getRolEnSpeeder());
            pstmt.setInt(8, clon.getSpeeder_id());
            pstmt.setInt(9, clon.getJedi_id());
            pstmt.setInt(10, clon.getId());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Carga todos los clones de la base de datos.
     * @param con La conexión a la base de datos.
     * @return Una lista de objetos ClonDO con todos los clones.
     */
    public static ArrayList<ClonDO> cargarTodo(Connection con) {
        ArrayList<ClonDO> clones = new ArrayList<>();
        String sql = "SELECT * FROM Clon";
        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ClonDO clon = new ClonDO();
                clon.setId(rs.getInt("id"));
                clon.setApodoGuerra(rs.getString("apodoGuerra"));
                clon.setModelo(rs.getString("modelo"));
                clon.setFuerza(rs.getInt("fuerza"));
                clon.setIntelignecia(rs.getInt("intelignecia"));
                clon.setHorasInactividad(rs.getInt("horasInactividad"));
                clon.setTiempoRefuerzoAdrenalina(rs.getInt("tiempoRefuerzoAdrenalina"));
                clon.setRolEnSpeeder(rs.getInt("rolEnSpeeder"));
                clon.setSpeeder_id(rs.getInt("Speeder_id"));
                clon.setJedi_id(rs.getInt("Jedi_id"));
                clones.add(clon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clones;
    }

    /**
     * Carga un clon específico de la base de datos por su ID.
     * @param con La conexión a la base de datos.
     * @param id El ID del clon a cargar.
     * @return Un objeto ClonDO con los datos del clon, o null si no se encontró.
     */
    public static ClonDO cargar(Connection con, int id) {
        ClonDO clon = null;
        String sql = "SELECT * FROM Clon WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    clon = new ClonDO();
                    clon.setId(rs.getInt("id"));
                    clon.setApodoGuerra(rs.getString("apodoGuerra"));
                    clon.setModelo(rs.getString("modelo"));
                    clon.setFuerza(rs.getInt("fuerza"));
                    clon.setIntelignecia(rs.getInt("intelignecia"));
                    clon.setHorasInactividad(rs.getInt("horasInactividad"));
                    clon.setTiempoRefuerzoAdrenalina(rs.getInt("tiempoRefuerzoAdrenalina"));
                    clon.setRolEnSpeeder(rs.getInt("rolEnSpeeder"));
                    clon.setSpeeder_id(rs.getInt("Speeder_id"));
                    clon.setJedi_id(rs.getInt("Jedi_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clon;
    }

    /**
     * Carga una lista de clones paginada desde la base de datos.
     *
     * @param con     La conexión a la base de datos.
     * @param numElem El número de elementos por página.
     * @param numPag  El número de página a recuperar (comenzando desde 1).
     * @return Una lista de objetos ClonDO con los clones de la página solicitada.
     */
    public static ArrayList<ClonDO> cargarClonesPaginado(Connection con, int numElem, int numPag) {
        ArrayList<ClonDO> clones = new ArrayList<>();
        // Calcular el OFFSET basado en el número de página y elementos por página
        int offset = (numPag - 1) * numElem;
        String sql = "SELECT * FROM Clon LIMIT ? OFFSET ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, numElem);
            pstmt.setInt(2, offset);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ClonDO clon = new ClonDO();
                    clon.setId(rs.getInt("id"));
                    clon.setApodoGuerra(rs.getString("apodoGuerra"));
                    clon.setModelo(rs.getString("modelo"));
                    clon.setFuerza(rs.getInt("fuerza"));
                    clon.setIntelignecia(rs.getInt("intelignecia"));
                    clon.setHorasInactividad(rs.getInt("horasInactividad"));
                    clon.setTiempoRefuerzoAdrenalina(rs.getInt("tiempoRefuerzoAdrenalina"));
                    clon.setRolEnSpeeder(rs.getInt("rolEnSpeeder"));
                    clon.setSpeeder_id(rs.getInt("Speeder_id"));
                    clon.setJedi_id(rs.getInt("Jedi_id"));
                    clones.add(clon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clones;
    }

   
    }
