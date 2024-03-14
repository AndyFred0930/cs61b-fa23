import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque <T> implements Deque<T>{
    public static class Node<T>{
        T data;
        Node<T> prev,next;
    }
    Node<T> sentinel = new Node<T>();
    int len;
    public LinkedListDeque(){
        len = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    @Override
    public void addFirst(T x) {
        Node<T> first = new Node<T>();
        first.data = x;
        first.next=sentinel.next;
        sentinel.next.prev=first;
        sentinel.next=first;
        first.prev=sentinel;
        len++;
    }

    @Override
    public void addLast(T x) {
        Node<T> last = new Node<T>();
        last.data = x;
        last.prev = sentinel.prev;
        sentinel.prev.next = last;
        sentinel.prev = last;
        last.next = sentinel;
        len++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node<T> tmp = sentinel;
        for (int i=0;i<size();i++)
        {
            tmp = tmp.next;
            T var = get(i);
            returnList.add(i,var);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
         return len;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        Node<T> tmp = sentinel;
        int i=0;
        do {
            tmp = tmp.next;
            i++;
        }while(i<=index);
        return tmp.data;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size())
        {
            throw new IndexOutOfBoundsException("Index"+index+"is out of bounds");
        }
       return getRecursiveHelper(sentinel.next,index);
    }
    public T getRecursiveHelper(Node<T> node,int index){
        if (index == 0) return node.next.data;
        return getRecursiveHelper(node.next,index-1);
    }
}
