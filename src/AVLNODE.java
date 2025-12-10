class AVLNODE<T> {
    T data;
    AVLNODE<T> left;
    AVLNODE<T> right;
    int height;
    /*********************************************************************
    Name: AVLNODE
    Parameters: T data
    Purpose: Constructor to initialize an AVL tree node with given data
    ***********************************************************************/
    public AVLNODE(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1; 
    }

}