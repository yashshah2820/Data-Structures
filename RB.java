public class RB {
    RBnode root;

    RB(int val) {
        root = new RBnode(val);
        root.colour = false;
    }

    void insert(int val) {
        root = Insertelement(root, val);
    }

    RBnode Insertelement(RBnode rt, int a) {
        if (rt == null) {
            rt = new RBnode(a);

        } else if (rt.value < a) {
            rt.rc = Insertelement(rt.rc, a);
            Fixup(rt);

        } else if (rt.value > a) {
            rt.lc = Insertelement(rt.lc, a);
            Fixup(rt);
        }
        return rt;
    }

    void Fixup(RBnode rt) {
        if (rt == root) {
            rt.colour = false;
        } else {
            RBnode parent = findparent(root, rt.value);

            if (siblingof(rt) != null) {
                if (parent.colour == true) {
                    RBnode uncle = uncleof(rt);
                    if (uncle.colour == true) {
                        uncle.colour = false;
                        parent.colour = false;
                    } else {
                        if (gparent.value > parent.value) {
                            if (parent.value < rt.value) {
                                rt = leftleftrotation(gparent);
                            } else {
                                rt = rightleftrotation(gparent);
                            }
                        } else {
                            if (parent.value > rt.value) {
                                rt = rightrightrotation(gparent);
                            } else {
                                rt = leftrightrotation(gparent);
                            }
                        }

                    }
                }
            }
        }

    }

    RBnode findparent(RBnode node, Integer a) {
        if (node.lc != null) {
            if (node.lc.value == a)
                return node;
        }
        if (node.rc != null) {
            if (node.rc.value == a)
                return node;
        }

        if (node.value > a) {
            return findparent(node.lc, a);
        } else {
            return findparent(node.rc, a);
        }

    }

    RBnode siblingof(RBnode rt) {
        RBnode sibling = new RBnode();
        RBnode parent = findparent(root, rt.value);
        if (rt.value > parent.value) {
            sibling = parent.lc;
        } else {
            sibling = parent.rc;
        }
        return sibling;
    }

    RBnode rightrightrotation(RBnode x) {
        RBnode temp;
        temp = x.lc;
        x.lc = temp.rc;
        temp.rc = x;
        x.colour = true;
        temp.colour = false;
        temp.rc.colour = true;
        return temp;
    }

    RBnode leftleftrotation(RBnode x) {
        RBnode temp;
        temp = x.rc;
        x.rc = temp.lc;
        temp.lc = x;
        x.colour = true;
        temp.colour = false;
        temp.lc.colour = true;
        return temp;
    }

    RBnode leftrightrotation(RBnode x) {
        RBnode temp = x.lc;
        temp = leftleftrotation(temp);
        return rightleftrotation(x);
    }

    RBnode rightleftrotation(RBnode x) {
        RBnode temp = x.rc;
        temp = rightrightrotation(temp);
        return leftleftrotation(x);
    }

    void InOrderTraverse(RBnode rt) {
        if (rt != null) {
            InOrderTraverse(rt.lc);
            System.out.print(rt.value + ", ");
            InOrderTraverse(rt.rc);
        }

    }
}