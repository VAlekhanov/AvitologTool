package org.alekhanov.panel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class AvitoCellRenderer extends DefaultTreeCellRenderer {
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
//        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
//        if (tree.getModel().getRoot().equals(nodo)) {
//            setIcon(root);
//            setName();
//        } else if (nodo.getChildCount() > 0) {
//            setIcon(parent);
//        } else {
//            setIcon(leaf);
//        }
        return this;
//        return super.getTreeCellRendererComponent(jTree, o, b, b1, b2, i, b3);
    }

    public AvitoCellRenderer() {
//        super();
    }
}
