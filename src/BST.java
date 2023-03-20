//public class BST<T extends Comparable<T>>{
//    private Node<T> root;
//    private int counter=0;
//
//
//    public void insert(T data) {
//        if(isEmpty()){
//            root=new Node<T>();
//            root.setData(data);
//        }
//        else {
//            insert(data, root);
//        }
//        counter++;
//
//    }
//    private void insert(T data,Node<T> node){
//        if(data.compareTo(node.getData())<0){
//            if(node.getLeftChild()==null){
//                Node<T> newNode = new Node<T>();
//                newNode.setData(data);
//                node.setLeftChild(newNode);
//            }
//            else{
//                insert(data,node.getLeftChild());
//            }
//        }
//        else if (data.compareTo(node.getData()) > 0) {
//            if(node.getRightChild()==null){
//                Node<T> newNode = new Node<T>();
//                newNode.setData(data);
//                node.setRightChild(newNode);
//            }
//            else{
//                insert(data,node.getRightChild());
//            }
//        }
//    }
//    public void delete(T data) {
//
//        root=delete(data,root);
//    }
//    private Node<T> delete(T data, Node<T> node){
//        if(node==null){
//            return null;
//        }
//        if(data.compareTo(node.getData())<0){
//            node.setLeftChild(delete(data,node.getLeftChild()));
//        }
//        else if (data.compareTo(node.getData())>0) {
//            node.setRightChild(delete(data,node.getRightChild()));
//        }
//        else{
//            //One child or no children
//            if(node.getLeftChild()==null){
//                return node.getRightChild();
//            }
//            else if (node.getRightChild()==null)
//            {
//                return node.getLeftChild();
//            }
//            //2 children
//            node.setData(getMax(node.getLeftChild()));
//            node.setLeftChild(delete(node.getData(),node.getLeftChild()));
//        }
//        counter--;
//        return node;
//    }
//
//    public void traverse() {
//        traverseInOrder(root);
//    }
//    private void traverseInOrder(Node<T> node){
//        if(node != null){
//            traverseInOrder(node.getLeftChild());
//            System.out.println(node.getData());
//            traverseInOrder(node.getRightChild());
//        }
//    }
//
//
//    public T getMax() {
//        if(isEmpty()){
//            return null;
//        }
//        return getMax(root);
//    }
//    private T getMax(Node<T> node){
//        if(node.getRightChild()!=null){
//            return getMax(node.getRightChild());
//        }
//        return node.getData();
//    }
//
//
//    public T getMin() {
//        if(isEmpty()){
//            return null;
//        }
//        return getMin(root);
//    }
//    private T getMin(Node<T> node){
//        if(node.getLeftChild()!=null){
//            return getMin(node.getLeftChild());
//        }
//        return node.getData();
//    }
//
//    public boolean isEmpty() {
//        return root==null;
//    }
//
//    public int getSize(){
//        return counter;
//    }
//}
