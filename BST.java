import javax.lang.model.util.ElementScanner6;

public class BST {
    Tree root;

    BST() {
        root = null;
    }

    void InsertElement(int key) {
        root = InsertElement(key, root);
    }

    Tree InsertElement(int key, Tree rt) {
        if (rt == null) {
            rt = new Tree(key);
        } else {
            if (rt.val > key) {
                rt.lc = InsertElement(key, rt.lc);
            }
            if (rt.val < key) {

                rt.rc = InsertElement(key, rt.rc);

            }
        }
        return rt;
    }

    private Tree SearchElement(int a, Tree rt) {
        if (rt.val == a)
            return rt;
        else if (a > rt.val)
            return SearchElement(a, rt.rc);
        else
            return SearchElement(a, rt.lc);
    }

    void PreOrderTraverse(Tree rt) {
        if (rt != null) {
            System.out.println(rt.val + ", ");
            PreOrderTraverse(rt.lc);
            PreOrderTraverse(rt.rc);
        }
    }

    void InOrderTraverse(Tree rt) {
        if (rt != null) {
            InOrderTraverse(rt.lc);
            System.out.print(rt.val + ", ");
            InOrderTraverse(rt.rc);
        }

    }

    void PostOrderTraverse(Tree rt) {
        if (rt != null) {
            PostOrderTraverse(rt.lc);
            PostOrderTraverse(rt.rc);
            System.out.print(rt.val + ", ");
        }
    }

    Tree findparent(Tree node, int value) {
        if (node.lc != null) {
            if (node.lc.val == value)
                return node;
        } else if (node.rc != null) {
            if (node.rc.val == value)
                return node;
        }
        if (node.val > value) {
            return findparent(node.lc, value);
        } else {
            return findparent(node.rc, value);
        }
    }

    void DeleteElement(int key) {
        root = DeleteElement(root, key);
    }

    Tree DeleteElement(Tree rt, int a) {
        if (rt.val == a) {
            if (rt.lc == null && rt.rc == null) {
                rt = null;
            } else {
                if (rt.rc == null) {
                    rt = rt.lc;
                } else if (rt.lc == null) {
                    rt = rt.rc;
                } else {
                    Tree temp = rt.lc;
                    while (temp.rc != null)
                        temp = temp.rc;
                    int key = temp.val;
                    DeleteElement(key);
                    rt.val = key;
                }
            }
        } else if (rt.val > a) {
            rt.lc = DeleteElement(rt.lc, a);
        } else {
            rt.rc = DeleteElement(rt.rc, a);
        }
        return rt;
    }
}
