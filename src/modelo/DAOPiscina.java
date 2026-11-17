package modelo;

import java.sql.*;
import java.util.ArrayList;

public class DAOPiscina {
    private static final String URL ="jdbc:mysql://localhost:3306/piscina";
    private static final String USER = "Desarrollador";
    private static final String PASSWORD = "root";

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public ArrayList<Socio> selectSocios(){
        ArrayList<Socio> socios = new ArrayList<>();
        try (Connection connection = connect()) {
            String query = "select id_socio, nombre, apellido, dni, fecha_alta from socios order by nombre ASC;";
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_socio");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String dni = resultSet.getString("dni");
                String fechaAlta = resultSet.getString("fecha_alta");
                Socio socio = new  Socio(id, nombre, apellido, dni, fechaAlta);
                socios.add(socio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return socios;
    }

    public ArrayList<Actividad> selectActividades(){
        ArrayList<Actividad> actividades = new ArrayList<>();
        try (Connection connection = connect()) {
            String query ="select id_actividad, nombre_actividad, precio_mensual from actividades order by nombre_actividad asc;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_actividad");
                String nombre = resultSet.getString("nombre_actividad");
                double precio = resultSet.getDouble("precio_mensual");
                Actividad actividad = new  Actividad(id, nombre, precio);
                actividades.add(actividad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return actividades;
    }

    public ArrayList<Inscripcion> selectInscripciones(){
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        try (Connection connection = connect()) {
            String query = "select s.nombre, s.apellido, a.nombre_actividad, i.pago_al_dia FROM inscripciones i " +
                    "join socios s on i.id_socio = s.id_socio join actividades a on i.id_actividad = a.id_actividad " +
                    "order by s.nombre asc;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombreSocio =resultSet.getString("nombre") + " " + resultSet.getString("apellido");
                String nombreActividad = resultSet.getString("nombre_actividad");
                boolean pagoAlDia = resultSet.getBoolean("pago_al_dia");
                Inscripcion inscripcion = new Inscripcion(nombreSocio, nombreActividad, pagoAlDia);
                inscripciones.add(inscripcion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return inscripciones;
    }

    public boolean insertarSocio(Socio socio){
        try (Connection connection = connect()) {
            String query ="insert into socios (nombre, apellido, dni, fecha_alta) values (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, socio.getNombre());
            preparedStatement.setString(2, socio.getApellido());
            preparedStatement.setString(3, socio.getDni());
            preparedStatement.setString(4, socio.getFechaAlta());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertarActividad(Actividad actividad) {
        try (Connection conn = connect()) {
            String query = "insert into actividades (nombre_actividad, precio_mensual) values (?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, actividad.getNombreActividad());
            preparedStatement.setDouble(2, actividad.getPrecioMensual());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertarInscripcion(int idSocio, int idActividad, boolean pagoAlDia) {
        try (Connection conn = connect()) {
            String query = "insert into inscripciones (id_socio, id_actividad, pago_al_dia) values (?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, idSocio);
            preparedStatement.setInt(2, idActividad);
            preparedStatement.setBoolean(3, pagoAlDia);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarSocio(Socio socio){
        try (Connection conn = connect()) {
            String query ="update socios set nombre = ?, apellido = ?, dni = ?, fecha_alta = ? where id_socio = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, socio.getNombre());
            preparedStatement.setString(2, socio.getApellido());
            preparedStatement.setString(3, socio.getDni());
            preparedStatement.setString(4, socio.getFechaAlta());
            preparedStatement.setInt(5, socio.getIdSocio());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean borrarSocio(int idSocio){
        try (Connection conn = connect()) {
            String query = "delete from socios where id_socio = ?;";
            PreparedStatement preparedStatement =conn.prepareStatement(query);
            preparedStatement.setInt(1, idSocio);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validarLogin(String nombre, String dni){
        try (Connection conn = connect()) {
            String query ="select id_socio from socios where nombre = ? and dni = ?;";
            PreparedStatement preparedStatement= conn.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, dni);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
