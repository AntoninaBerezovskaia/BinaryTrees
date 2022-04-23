import java.util.Scanner;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public boolean insert(Listing newStudent) {
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNode n = new TreeNode();

        n.node = newStudent.deepCopy();
        n.lc = null;
        n.rc = null;
        if (root == null) {
            root = n;
        } else {
            findNode(newStudent.getKey(), p, c);
            if (newStudent.getKey().compareTo(p.get().node.getKey()) < 0) {
                p.get().lc = n;
            } else {
                p.get().rc = n;
            }
        }
        return true;
    }

    public Listing fetch(String targetKey) {
        boolean found;
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        found = findNode(targetKey, p, c);
        if (found ) {
            return c.get().node.deepCopy();
        } else {
            return null;
        }
    }

    public boolean delete(String targetKey) {
        boolean found;
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNode largest, nextLargest;
        found = findNode(targetKey, p, c);
        if (!found) {
            return false;
        } else {
            //case 1
            if (c.get().lc == null && c.get().rc == null) {
                if (p.get().lc == c.get()) {
                    p.get().lc = null;
                } else {
                    p.get().rc = null;
                }//end case 1
            } else if (c.get().lc == null || c.get().rc == null) {//case 2
                if (p.get().lc == c.get()) {//deleted node is a left child
                    if (c.get().lc != null) {//deleted node has a left child
                        p.get().lc = c.get().lc;
                    } else {
                        p.get().lc = c.get().rc;
                    }
                } else {//deleted node is a right child
                    if (c.get().lc != null) {//deleted node has a left child
                        p.get().rc = c.get().lc;
                    } else {
                        p.get().rc = c.get().rc;
                    }
                }//end case 2
            } else {//case 3
                nextLargest = c.get().lc;
                largest = nextLargest.rc;
                if (largest != null) {
                    while (largest.rc != null) {
                        nextLargest = largest;
                        largest = largest.lc;
                    }
                    c.get().node = largest.node;
                    nextLargest.rc = largest.lc;
                } else {
                    nextLargest.rc = c.get().rc;
                    if (p.get().lc == c.get()) {
                        p.get().lc = nextLargest;
                    } else {
                        p.get().rc = nextLargest;
                    }
                }
            }//end case 3
        }
        return true;
    }

    public boolean update(String target, Listing l) {
        if (!delete(target)) {
            return false;
        } else if (!insert(l)) {
            return false;
        }
        return true;

    }

    private boolean findNode(String targetKey, TreeNodeWrapper parent, TreeNodeWrapper child) {
        parent.set(root);
        child.set(root);
        if (root == null) {
            return true;
        }

        while (child.get() != null) {
            if (child.get().node.compareTo(targetKey) == 0) {
                return true;
            } else {
                parent.set(child.get());
                if (targetKey.compareTo(child.get().node.getKey()) < 0) {
                    child.set(child.get().lc);
                } else {
                    child.set(child.get().rc);
                }
            }
        }
        return false;
    }

    public void RNLTraversal(TreeNode n) {
        if (n.rc != null) {
            RNLTraversal(n.rc);
        }

        System.out.println(n.node.toString());

        if (n.lc != null) {
            RNLTraversal(n.lc);
        }
    }

    public class TreeNode {
        private Listing node;
        private TreeNode lc;
        private TreeNode rc;

        public TreeNode() {

        }
    }

    public class TreeNodeWrapper {
        TreeNode treeRef = null;

        public TreeNodeWrapper() {

        }

        public TreeNode get() {
            return treeRef;
        }

        public void set(TreeNode t) {
            treeRef = t;
        }
    }



}






