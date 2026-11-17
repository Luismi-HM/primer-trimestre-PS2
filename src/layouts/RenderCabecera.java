package layouts;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class RenderCabecera extends DefaultTableCellRenderer {
    public RenderCabecera() {
        setHorizontalAlignment(JLabel.CENTER);
        setOpaque(true);
        setBackground(Recursos.FONDOS_VENTANAS);
        setForeground(Color.WHITE);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setFont(Recursos.FUENTE_CABECERA);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        return this;
    }
}
