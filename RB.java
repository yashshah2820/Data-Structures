public class RB {
    RBnode root;

    RB(int val) {
        root = new RBnode(val);
        root.colour = false;
    }

    void insert(int val) {
        root = Insertelement(root, val);
        root.colour = false;
        // Fixup(root, val);
    }

    RBnode Insertelement(RBnode rt, int a) {
        if (rt == null) {
            rt = new RBnode(a);
        } else if (rt.value < a) {
            rt.rc = Insertelement(rt.rc, a);
            if (rt.rc.lc != null) { // case of right left
                if (rt.rc.lc.colour == true && rt.rc.colour == true) {
                    if (rt.lc != null && rt.lc.colour == true) {
                        rt.colour = true;
                        rt.lc.colour = false;
                        rt.rc.colour = false;
                    } else {
                        rt = rightleftrotation(rt);
                    }
                }
            } else if (rt.rc.rc != null) {
                if (rt.rc.rc.colour == true && rt.rc.colour == true) {
                    if (rt.lc != null && rt.lc.colour == true) {
                        rt.colour = true;
                        rt.lc.colour = false;
                        rt.rc.colour = false;
                    } else {
                        rt = leftleftrotation(rt);
                    }
                }
            }

        } else if (rt.value > a) {
            rt.lc = Insertelement(rt.lc, a);
            if (rt.lc.lc != null) { // case of right left
                if (rt.lc.lc.colour == true && rt.lc.colour == true) {
                    if (rt.rc != null && rt.rc.colour == true) {
                        rt.colour = true;
                        rt.rc.colour = false;
                        rt.lc.colour = false;
                    } else {
                        rt = rightrightrotation(rt);
                    }
                }
            } else if (rt.lc.rc != null) {
                if (rt.lc.rc.colour == true && rt.lc.colour == true) {
                    if (rt.rc != null && rt.rc.colour == true) {
                        rt.colour = true;
                        rt.lc.colour = false;
                        rt.rc.colour = false;
                    } else {
                        rt = leftrightrotation(rt);
                    }
                }
            }
        }
        return rt;
    }

    // void Fixup(RBnode rt, int val) {
    // if (root.value == val) {
    // rt.colour = false;
    // } else {
    // RBnode parent = findparent(root, val);
    // if (siblingof(rt) != null) {
    // if (parent.colour == true) {
    // RBnode sibling = siblingof(rt);
    // if (sibling.colour == true) {
    // parent.colour = true;
    // sibling.colour = false;
    // rt.colour = false;
    // } else {
    // if (parent.value > rt.value) {
    // if (rt.rc != null) {
    // parent = leftleftrotation(parent);
    // } else {
    // parent = rightleftrotation(parent);
    // }
    // } else {
    // if (parent.value > rt.value) {
    // parent = rightrightrotation(parent);
    // } else {
    // parent = leftrightrotation(parent);
    // }
    // }
    // }
    // }
    // }
    // }

    // }

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

    void InOrderTraverseColour(RBnode rt) {
        if (rt != null) {
            InOrderTraverse(rt.lc);
            System.out.print(rt.colour + ", ");
            InOrderTraverse(rt.rc);
        }

    }
}