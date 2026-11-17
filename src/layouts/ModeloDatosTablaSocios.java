package layouts;

import controlador.Controlador;
import modelo.Socio;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloDatosTablaSocios extends AbstractTableModel {

    static final int COLUMNA_NOMBRE = 0;
    static final int COLUMNA_APELLIDO = 1;
    static final int COLUMNA_DNI = 2;
    static final int COLUMNA_FECHA_ALTA = 3;
    static final int NUMERO_COLUMNAS = 4;

    Controlador controlador = new Controlador();
    ArrayList<Socio> listaSocios;

    public ModeloDatosTablaSocios() {
        listaSocios = controlador.obtenerSocios();
    }

    public void recargar() {
        listaSocios = controlador.obtenerSocios();
        fireTableDataChanged();
    }

    public Socio getSocio(int fila) {
        return listaSocios.get(fila);
    }

    @Override
    public int getRowCount() {
        return listaSocios.size();
    }

    @Override
    public int getColumnCount() {
        return NUMERO_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Socio socio = listaSocios.get(rowIndex);
        switch (columnIndex) {
            case COLUMNA_NOMBRE:
                return socio.getNombre();
            case COLUMNA_APELLIDO:
                return socio.getApellido();
            case COLUMNA_DNI:
                return socio.getDni();
            case COLUMNA_FECHA_ALTA:
                return socio.getFechaAlta();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == COLUMNA_NOMBRE) {
            return "Nombre";
        }  else if (column == COLUMNA_APELLIDO) {
            return "Apellido";
        }   else if (column == COLUMNA_DNI) {
            return "Dni";
        }   else if (column == COLUMNA_FECHA_ALTA) {
            return "Fecha alta";
        }
        return "";
    }
}
