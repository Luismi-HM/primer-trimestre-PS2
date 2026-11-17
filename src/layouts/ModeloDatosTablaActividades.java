package layouts;

import controlador.*;
import modelo.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloDatosTablaActividades extends AbstractTableModel {
    static final int COLUMNA_NOMBRE = 0;
    static final int COLUMNA_PRECIO = 1;
    static final int NUMERO_COLUMNAS = 2;

    Controlador controlador = new Controlador();
    ArrayList<Actividad> listaActividades;

    public ModeloDatosTablaActividades() {
        listaActividades = controlador.obtenerActividades();
    }

    public void recargar() {
        listaActividades=controlador.obtenerActividades();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listaActividades.size();
    }

    @Override
    public int getColumnCount() {
        return NUMERO_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Actividad actividad = listaActividades.get(rowIndex);
        switch (columnIndex) {
            case COLUMNA_NOMBRE:
                return actividad.getNombreActividad();
            case COLUMNA_PRECIO:
                return actividad.getPrecioMensual();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == COLUMNA_NOMBRE) {
            return "Actividad";
        } else if (column == COLUMNA_PRECIO) {
            return "Precio mensual (€)";
        }
        return "";
    }
}
