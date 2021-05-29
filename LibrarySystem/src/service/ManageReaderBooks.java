/*
 * Created by JFormDesigner on Wed May 19 17:56:30 CST 2021
 */

package service;

import dao.LinkOracle;
import reader.readbooks;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static dao.LinkOracle.stmt;

/**
 * @author 1
 */
public class ManageReaderBooks extends JFrame {
    public ManageReaderBooks(int rid,String mname) {
        initComponents(rid,mname);
    }

    private void initComponents(int rid,String mname) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) { }
            @Override
            public void windowClosing(WindowEvent e) {
                ManageReader manageReader=new ManageReader(mname);
                manageReader.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
            DefaultTableModel tableModel = new DefaultTableModel(queryData(rid), head) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table1.setModel(tableModel);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 15, 375, 240);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private Object[][] data = null;
    String[] head = {"书籍ID", "书籍名称", "作者","归还日期"};

    public Object[][] queryData(int rid) {
        List<readbooks> readbooksList = new ArrayList<readbooks>();
        String sql="select books.*,readerbook.rbtime from books,readerbook where books.bid=readerbook.bid and readerbook.rid="+rid+"";
        System.out.println(sql);
        ResultSet rs = null;
        try {
            LinkOracle linkOracle=new LinkOracle();
            linkOracle.LinkOracle();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                readbooks readbook=new readbooks();
                readbook.setBid(rs.getInt(1));
                readbook.setBname(rs.getString(3));
                readbook.setBauthor(rs.getString(4));
                readbook.setRbtime(rs.getString(6));
                readbooksList.add(readbook);
            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                LinkOracle.conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        data = new Object[readbooksList.size()][head.length];
        for (int i = 0; i < readbooksList.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = readbooksList.get(i).getBid();
                data[i][1] = readbooksList.get(i).getBname();
                data[i][2] = readbooksList.get(i).getBauthor();
                data[i][3] = readbooksList.get(i).getRbtime();

            }
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
