/*
 * Copyright (C) 2020 pierpaolo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package di.uniba.map.b.lab.swing.esercizi;

import di.uniba.map.b.lab.collection.esercizi.Articolo;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author pierpaolo
 */
public class CercaArticoloDialog extends javax.swing.JDialog {

    /**
     * Creates new form CercaArticoloDialog
     */
    public CercaArticoloDialog(java.awt.Frame parent, DBManager dbm, boolean modal) {
        super(parent, modal);
        this.dbm = dbm;
        initComponents();
        listmodel = new DefaultListModel<>();
        searchList.setModel(listmodel);
    }

    private final DBManager dbm;

    private final DefaultListModel<String> listmodel;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfQuery = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cerca articolo...");

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("Search: ");
        jPanel1.add(jLabel1);

        tfQuery.setColumns(15);
        tfQuery.setToolTipText("");
        jPanel1.add(tfQuery);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(searchList);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String query = tfQuery.getText();
        if (query != null && query.length() > 0) {
            listmodel.removeAllElements();
            try {
                List<Articolo> results = dbm.searchArticolo(query);
                for (Articolo a : results) {
                    listmodel.addElement(a.toPrettyString());
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JList<String> searchList;
    private javax.swing.JTextField tfQuery;
    // End of variables declaration//GEN-END:variables
}