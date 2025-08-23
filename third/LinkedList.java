package third;

public class LinkedList<E> {
  private class Node<E> {
    private E data;
    private Node<E> next;

    Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node<E> head;
  private int size;

  public LinkedList() {
    this.head = null;
    this.size = 0;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void clear() {
    this.head = null;
    this.size = 0;
  }

  public void add(int index, E element) throws IndexOutOfBoundsException {
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> newNode = new Node<>(element, null);
    if (index == 0) {
      newNode.next = this.head;
      this.head = newNode;
    } else {
      Node<E> current = this.head;
      for (int i = 0; i < index - 1; i++) {
        current = current.next;
      }
      newNode.next = current.next;
      current.next = newNode;
    }
    this.size++;
  }

  public void add(E element) {
    add(size, element);
  }

  public boolean contains(Object o) {
    Node<E> current = this.head;
    while (current != null) {
      if (current.data.equals(o)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  public E get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> current = this.head;
    for (int i = 0; i < index - 1; i++) {
      current = current.next;
    }
    return current.data;
  }

  public int indexOf(Object o) {
    Node<E> current = this.head;
    int index = 0;

    if (!(contains(o))) {
      return -1;
    } else {
      while (current != null) {
        if (current.data.equals(o)) {
          return index;
        }
        current = current.next;
        index++;
      }
      return -1;
    }
  }

  public E remove(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }

    Node<E> removedNode;
    if (index == 0) {
      // Handle removing the head node
      removedNode = this.head;
      this.head = this.head.next;
    } else {
      // Traverse to the node *before* the one to remove
      Node<E> current = this.head;
      for (int i = 0; i < index - 1; i++) {
        current = current.next;
      }
      // The node to remove is the one after 'current'
      removedNode = current.next;
      // Bypass the removed node
      current.next = removedNode.next;
    }
    this.size--;
    return removedNode.data;
  }

  public boolean remove(Object o) {
    Node<E> current = this.head;
    Node<E> previous = null;
    boolean found = false;
    while (current != null && !found) {
      if (current.data.equals(o)) {
        found = true;
      } else {
        previous = current;
        current = current.next;
      }
    }
    if (found) {
      if (previous == null) {
        this.head = current.next;
      } else {
        previous.next = current.next;
      }
      this.size--;
    }
    return found;
  }

  public E set(int index, E element) throws IndexOutOfBoundsException {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> current = this.head;

    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    E oldElement = current.data;
    current.data = element;
    return oldElement;
  }

  public String toString() {
    if (this.isEmpty()) {
      return "[]";
    } else {
      String result = "[";
      Node<E> current = this.head;
      while (current != null) {
        result += current.data + ", ";
        current = current.next;
      }
      result = result.substring(0, result.length() - 2) + "]";
      return result;
    }
  }

}
