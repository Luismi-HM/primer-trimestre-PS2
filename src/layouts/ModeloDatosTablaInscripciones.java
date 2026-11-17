package layouts;

import controlador.Controlador;
import modelo.Inscripcion;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloDatosTablaInscripciones extends AbstractTableModel {

    static final int COLUMNA_SOCIO = 0;
    static final int COLUMNA_ACTIVIDAD = 1;
    static final int COLUMNA_PAGO_AL_DIA = 2;
    static final int NUMERO_COLUMNAS = 3;

    Controlador controlador =  new Controlador();
    ArrayList<Inscripcion> listaInscripciones;

    public ModeloDatosTablaInscripciones() {
        listaInscripciones = controlador.obtenerInscripciones();
    }

    public void recargar() {
        listaInscripciones = controlador.obtenerInscripciones();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listaInscripciones.size();
    }

    @Override
    public int getColumnCount() {
        return NUMERO_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Inscripcion inscripcion = listaInscripciones.get(rowIndex);
        switch (columnIndex) {
            case COLUMNA_SOCIO:
                return inscripcion.getNombreSocio();
            case COLUMNA_ACTIVIDAD:
                return inscripcion.getNombreActividad();
            case COLUMNA_PAGO_AL_DIA:
                return inscripcion.isPagoAlDia();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COLUMNA_PAGO_AL_DIA) {
            return Boolean.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == COLUMNA_SOCIO) {
            return "Socio";
        } else if (column == COLUMNA_ACTIVIDAD) {
            return "Actividad";
        } else if (column == COLUMNA_PAGO_AL_DIA) {
            return "Pago dia";
        }
        return "";
    }


}
