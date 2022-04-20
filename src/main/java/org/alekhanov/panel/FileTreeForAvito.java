package org.alekhanov.panel;

import javax.swing.*;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.io.File;

public class FileTreeForAvito implements TreeModel {
    protected File root;

    public FileTreeForAvito(File root) {
        this.root = root;
    }

    public void setRoot(File root) {
        this.root = root;
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        String[] children = ((File) parent).list();
        if ((children == null) || (index >= children.length)) return null;
        return new File((File) parent, children[index]);
    }

    @Override
    public int getChildCount(Object parent) {
        String[] children = ((File) parent).list();
        if (children == null) return 0;
        return children.length;
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((File) node).isFile();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newvalue) {
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        String[] children = ((File) parent).list();
        if (children == null) return -1;
        String childname = ((File) child).getName();
        for (int i = 0; i < children.length; i++) {
            if (childname.equals(children[i])) return i;
        }
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
    }
}
