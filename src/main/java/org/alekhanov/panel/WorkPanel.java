package org.alekhanov.panel;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class WorkPanel extends JFrame {
    private JPanel mainPanel;
    private Object[][] data;
    private Object[] items;
    private TableModel model;
    private TableColumn tableColumn;
    private File root;

    public WorkPanel() throws HeadlessException {
        setComponents();
        setComponentsData();
        makeFrame();
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int type = 1;
                JOptionPane jOptionPane = new JOptionPane(helpMessage, type);
                jOptionPane.showMessageDialog(WorkPanel.this, helpMessage);
            }
        });
        progressBar1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                super.mouseMoved(mouseEvent);
                progressBar1.setToolTipText((String) String.valueOf(progressBar1.getValue()));
            }
        });
        fromTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                super.mouseReleased(mouseEvent);
                textField1.setText((String) fromTree.getLastSelectedPathComponent().toString());
            }
        });
        fromTree.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                super.keyReleased(keyEvent);
                textField1.setText((String) fromTree.getLastSelectedPathComponent().toString());
            }
        });
        toTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                super.mouseReleased(mouseEvent);
                textField2.setText((String) toTree.getLastSelectedPathComponent().toString());
            }
        });
        toTree.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                super.keyReleased(keyEvent);
                textField2.setText((String) toTree.getLastSelectedPathComponent().toString());
            }
        });
    }

    private void setComponents() {
//        rightPanel.setPreferredSize(new Dimension(2, 4));
//        leftPanel.setPreferredSize(new Dimension(20, 40));
        setRightPanel();
        setLeftPanel();
        setBottomPanel();

    }

    private void setJTableColumnsWidth(JTable table, int tablePreferredWidth, double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (tablePreferredWidth * (percentages[i] / total)));
        }
    }

    private void setComponentsData() {

    }

    private void setRightPanel() {
        items = new Object[]{"№", "", "Ссылка", "Сайт"};
        data = new Object[][]{{1, "--", "--", "--"}};
        model = new DefaultTableModel(data, items);
        table.setModel(model);
        setJTableColumnsWidth(table, 480, 3, 1, 50, 20);
    }

    private void setLeftPanel() {
        root = new File(System.getProperty("user.home"));
        FileTreeForAvito treeModel = new FileTreeForAvito(root);
        fromTree.setModel(treeModel);
        toTree.setModel(treeModel);
        textField1.setText(root.getAbsolutePath());
        textField2.setText(root.getAbsolutePath());
//        fromTree.setCellRenderer(new DefaultTreeCellRenderer().);
    }

    private void setBottomPanel() {

    }

    private void makeFrame() {
        JFrame frame = new JFrame("Avito Links Formatter");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private JTable table;
    private JProgressBar progressBar1;
    private JScrollPane rightPanel;
    private JPanel leftPanel;
    private JToolBar bottomPanel;
    private JButton CSVButton;
    private JButton excelButton;
    private JTree fromTree;
    private JTree toTree;
    private JScrollPane fromPanel;
    private JScrollPane toPanel;
    private JButton helpButton;
    private JTextField textField1;
    private JTextField textField2;
    private String helpMessage = "ИНСТРУКЦИЯ ПО ИСПОЛЬЗОВАНИЮ AVITO LINKS FORMATTER\n" +
            "\t- В окне \"From:\" выбрать файл с исходным файлом с ссылками.\n" +
            "\t- В окне \"To:\" выбрать папку, где будет сохранен полученный файл.\n" +
            "\t- Кнопка \"CSV\" - формирование файла в формате csv.\n" +
            "\t- Кнопка \"Excel\" - формирование файла в формате excel.";

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setBackground(new Color(-328966));
        mainPanel.setMinimumSize(new Dimension(500, 300));
        mainPanel.setPreferredSize(new Dimension(900, 500));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(leftPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        leftPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        fromPanel = new JScrollPane();
        leftPanel.add(fromPanel, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        fromPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        fromTree = new JTree();
        fromPanel.setViewportView(fromTree);
        toPanel = new JScrollPane();
        leftPanel.add(toPanel, new GridConstraints(3, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        toPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        toTree = new JTree();
        toPanel.setViewportView(toTree);
        final JLabel label1 = new JLabel();
        label1.setText("From:");
        leftPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("To:");
        leftPanel.add(label2, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField1 = new JTextField();
        leftPanel.add(textField1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textField2 = new JTextField();
        leftPanel.add(textField2, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        rightPanel = new JScrollPane();
        mainPanel.add(rightPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        rightPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        table = new JTable();
        rightPanel.setViewportView(table);
        bottomPanel = new JToolBar();
        mainPanel.add(bottomPanel, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 20), null, 0, false));
        bottomPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        CSVButton = new JButton();
        CSVButton.setText("CSV");
        CSVButton.setToolTipText("Создать csv файл");
        bottomPanel.add(CSVButton);
        final JToolBar.Separator toolBar$Separator1 = new JToolBar.Separator();
        bottomPanel.add(toolBar$Separator1);
        excelButton = new JButton();
        excelButton.setText("Excel");
        excelButton.setToolTipText("Создать excel файл");
        bottomPanel.add(excelButton);
        final Spacer spacer1 = new Spacer();
        bottomPanel.add(spacer1);
        final Spacer spacer2 = new Spacer();
        bottomPanel.add(spacer2);
        final JLabel label3 = new JLabel();
        label3.setText("Process: ");
        bottomPanel.add(label3);
        progressBar1 = new JProgressBar();
        bottomPanel.add(progressBar1);
        final JToolBar.Separator toolBar$Separator2 = new JToolBar.Separator();
        bottomPanel.add(toolBar$Separator2);
        helpButton = new JButton();
        helpButton.setDefaultCapable(false);
        helpButton.setText("(?)");
        helpButton.setToolTipText("Помощь");
        bottomPanel.add(helpButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
