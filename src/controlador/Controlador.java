package controlador;

import modelo.*;
import java.util.*;

public class Controlador {
    DAOPiscina dao =  new DAOPiscina();

    public ArrayList<Socio> obtenerSocios(){
        return dao.selectSocios();
    }

    public ArrayList<Actividad> obtenerActividades(){
        return dao.selectActividades();
    }

    public ArrayList<Inscripcion> obtenerInscripciones(){
        return dao.selectInscripciones();
    }

    public boolean agregarSocio(Socio socio){
        return dao.insertarSocio(socio);
    }

    public boolean modificarSocio(Socio socio){
        return dao.actualizarSocio(socio);
    }

    public boolean eliminarSocio(int idSocio){
        return dao.borrarSocio(idSocio);
    }

    public boolean agregarActividad(Actividad actividad){
        return dao.insertarActividad(actividad);
    }

    public boolean agregarInscripcion(int idSocio, int idActividad, boolean pagoAlDia){
        return dao.insertarInscripcion(idSocio, idActividad, pagoAlDia);
    }

    public boolean validorLogin(String login, String contraseña){
        return dao.validarLogin(login, contraseña);
    }
}