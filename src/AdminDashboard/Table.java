
package AdminDashboard;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Table extends JTable {
    
    private CellAction event;

    public void setEvent(CellAction event) {
        this.event = event;
    }
    public Table(){
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(35);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 6) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int row, int col) {
                if (col != 6) {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, row, col);         
                    if(selected==false){
                        com.setBackground(Color.WHITE);
                    }else{
                        com.setBackground(com.getBackground());
                    }
                    return com;
                } else {
                    ActionPanel action =new ActionPanel();
                    action.setOpaque(false);
                    if(selected==false){
                        action.setBackground(Color.WHITE);
                    }else{
                        action.setBackground(action.getBackground());
                    }
                    return action;
                }
            }
        });
        setDefaultEditor(Object.class, new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (column == 6) {
                // Update actionPanel to hold the current ActionPanel
                ActionPanel action = new ActionPanel();
                action.initEvent(event, row);
                return action;
            }
            return super.getTableCellEditorComponent(table, value, isSelected, row, column);
            }
            
        });
    }
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
    
}
