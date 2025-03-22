package unidad4.practica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JediDAO {
	
	/****************
	*FUNCIONES
	*****************/

    /**
     * Elimina un Jedi de la base de datos por su ID.
     *
     * @param id  El ID del Jedi a eliminar.
     * @param con La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
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

    /**
     * Inserta un nuevo Jedi en la base de datos.
     *
     * @param jedi El objeto JediDO con los datos del Jedi.
     * @param con  La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int insertar(JediDO jedi, Connection con) {
        String sql = "INSERT INTO Jedi (nombre, apodoGuerra, edad, altura, nivelSabiduria, energiaFuerza) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, jedi.getNombre());
            pstmt.setString(2, jedi.getApodoGuerra());
            pstmt.setInt(3, jedi.getEdad());
            pstmt.setInt(4, jedi.getAltura());
            pstmt.setInt(5, jedi.getNivelSabiduria());
            pstmt.setInt(6, jedi.getEnergiaFuerza());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Actualiza un Jedi existente en la base de datos.
     *
     * @param jedi El objeto JediDO con los datos actualizados.
     * @param con  La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int actualizar(JediDO jedi, Connection con) {
        String sql = "UPDATE Jedi SET nombre = ?, apodoGuerra = ?, edad = ?, altura = ?, nivelSabiduria = ?, energiaFuerza = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, jedi.getNombre());
            pstmt.setString(2, jedi.getApodoGuerra());
            pstmt.setInt(3, jedi.getEdad());
            pstmt.setInt(4, jedi.getAltura());
            pstmt.setInt(5, jedi.getNivelSabiduria());
            pstmt.setInt(6, jedi.getEnergiaFuerza());
            pstmt.setInt(7, jedi.getId());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Carga todos los Jedis de la base de datos.
     *
     * @param con La conexión a la base de datos.
     * @return Una lista de objetos JediDO con todos los Jedis.
     */
    public static ArrayList<JediDO> cargarTodo(Connection con) {
        ArrayList<JediDO> jedis = new ArrayList<>();
        String sql = "SELECT * FROM Jedi";
        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                JediDO jedi = new JediDO();
                jedi.setId(rs.getInt("id"));
                jedi.setNombre(rs.getString("nombre"));
                jedi.setApodoGuerra(rs.getString("apodoGuerra"));
                jedi.setEdad(rs.getInt("edad"));
                jedi.setAltura(rs.getInt("altura"));
                jedi.setNivelSabiduria(rs.getInt("nivelSabiduria"));
                jedi.setEnergiaFuerza(rs.getInt("energiaFuerza"));
                jedis.add(jedi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jedis;
    }

    /**
     * Carga un Jedi específico de la base de datos por su ID.
     *
     * @param con La conexión a la base de datos.
     * @param id  El ID del Jedi a cargar.
     * @return Un objeto JediDO con los datos del Jedi, o null si no se encontró.
     */
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
                    jedi.setApodoGuerra(rs.getString("apodoGuerra"));
                    jedi.setEdad(rs.getInt("edad"));
                    jedi.setAltura(rs.getInt("altura"));
                    jedi.setNivelSabiduria(rs.getInt("nivelSabiduria"));
                    jedi.setEnergiaFuerza(rs.getInt("energiaFuerza"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jedi;
    }

    /**
     * Carga una lista de todos los clones liderados por el Jedi con el ID especificado.
     *
     * @param idJedi El ID del Jedi que lidera los clones.
     * @param con    La conexión a la base de datos.
     * @return Una lista de objetos ClonDO con los clones liderados por el Jedi.
     */
    public static ArrayList<ClonDO> cargarClones(int idJedi, Connection con) {
        ArrayList<ClonDO> listaClones = new ArrayList<>();
        String sql = "SELECT * FROM Clon WHERE Jedi_id = ?";
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

    /**
     * Devuelve la cantidad total de armas bláster asignadas a los clones liderados por el Jedi con el ID especificado.
     *
     * @param idJedi El ID del Jedi.
     * @param con    La conexión a la base de datos.
     * @return La cantidad total de armas bláster.
     */
    public static int cantidadArmas(int idJedi, Connection con) {
        String sql = "SELECT COUNT(*) FROM ArmaBlaster WHERE id IN (SELECT id FROM Clon WHERE Jedi_id = ?)";
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

    /**
     * Devuelve la fuerza máxima de todos los clones liderados por el Jedi con el ID especificado.
     *
     * @param con    La conexión a la base de datos.
     * @param idJedi El ID del Jedi.
     * @return La fuerza máxima de los clones.
     */
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

    /**
     * Devuelve una lista de clones liderados por el Jedi con el ID especificado que tengan el refuerzo adrenalina activo.
     *
     * @param con    La conexión a la base de datos.
     * @param idJedi El ID del Jedi.
     * @return Una lista de objetos ClonDO con los clones que tienen el refuerzo adrenalina activo.
     */
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