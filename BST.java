public class BST {
    Tree root;

    BST(int val) {
        root = new Tree(val);
    }

    void InsertElement(int key) {
        root = InsertElement(key, root);
    }

    Tree InsertElement(Integer key, Tree rt) {

        if (rt.val > key) {
            if (rt.lc == null)
                rt.lc = new Tree(key);
            else
                rt.lc = InsertElement(key, rt.lc);
        }
        if (rt.val < key) {
            if (rt.rc == null)
                rt.rc = new Tree(key);
            else
                rt.rc = InsertElement(key, rt.rc);

        }
        return rt;
    }

    Tree SearchElement(Integer a, Tree rt) {
        if (rt.val == a)
            return rt;
        else if (a > rt.val)
            return SearchElement(a, rt.rc);
        else
            return SearchElement(a, rt.lc);
    }

    void PreOrderTraverse(Tree rt) {
        if (rt != null) {
            System.out.print(rt.val + ", ");
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
    }public Node<D> ChildLeft(Node<D> x) {public Node<D> ChildLeft(Node<D> x) {
        if (x.left == null)
            return x;
        else
            return ChildLeft(x.left);
    }
    public Node<D> ChildRight(Node<D> x) {
        if (x.right == null)
            return x;
        else
            return ChildRight(x.right);
    }

        if (x.left == null)
            return x;
        else
            return ChildLeft(x.left);
    }
    public Node<D> ChildRight(Node<D> x) {
        if (x.right == null)
            return x;
        else
            return ChildRight(x.right);
    }


    Tree findparent(Tree node, Integer value) {
        if (node.lc != null) {
            if (node.lc.val == value)
                return node;
        }
        if (node.rc != null) {
            if (node.rc.val == value)
                return node;
        }

        if (node.val > value) {
            return findparent(node.lc, value);
        } else {
            return findparent(node.rc, value);
        }

    }
    public Tree ChildLeft(Tree x) {
        if (x.lc == null)
            return x;
        else
            return ChildLeft(x.lc);
    }
    public Tree ChildRight(Tree x) {
        if (x.rc == null)
            return x;
        else
            return ChildRight(x.rc);
    }

    void DeleteElement(Integer a) {
        Tree ele = SearchElement(a, root);
        if (ele.lc == null && ele.rc == null) {
            Tree parent = findparent(root, a);
            if (a > parent.val) {
                parent.rc = null;
            } else {
                parent.lc = null;
            }
        } else {
            if (ele.lc == null && ele.rc != null) {
                if (ele.val == root.val) {
                    if {t.val == root.val) {
                    Integer temp = root.rc.val;
                    DeleteElement(root.rc.val);
                    root.val = temp;
                    }
                    else{
                    Tree Child = ChildLeft(root.rc);
                    Integer temp = Child.val;
                    Delete(Child.val);
                    root.val = (D) temp;                 
                    }
                } else {
                    Tree parent = findparent(root, a);
                    if (parent.rc == ele) {
                        parent.rc = ele.rc;
                    } else {
                        parent.lc = ele.rc;
                    }
                }
            } else {
                if (ele.rc == null && ele.lc != null) {
                    if ( t.val ==  root.val) {
                    Integer temp = root.lc.val;
                    DeleteElement(root.lc.val);
                    root.val = temp;
                    }
                    else{
                    Tree Child = ChildRight(root.lc);
                    Integer temp = Child.val;
                    Delete(Child.val);
                    root.val = (D) temp;                 
                    }else {
                        Tree parent = findparent(root, a);
                        if (parent.rc == ele) {
                            parent.rc = ele.lc;
                        } else {
                            parent.lc = ele.lc;
                        }
                    }
                } else {
                    Tree temp = ele.rc;
                    Integer key = ChildLeft(temp).val;
                    DeleteElement(key);
                    ele.val = key;
                }
            }
        }
    }
}
