package e;

import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;



public class I0516Collections {
  public static void main(String[] args) {
    Queue<String> queue = new ArrayDeque<>();
    queue.add("First");
    queue.add("Second");
    queue.add("Third");
    System.out.println("queue.element():" + queue.element());
    System.out.println("queue.element():" + queue.element());
    System.out.println("queue.remove():" + queue.remove());
    System.out.println("queue.remove():" + queue.remove());

    Deque<String> deque = new ArrayDeque<>();
    deque.addLast("One");
    deque.addLast("Two");
    deque.addFirst("Three");
    deque.addFirst("Four");
    System.out.println("deque.getFirst():" + deque.getFirst());
    System.out.println("deque.removeFirst():" + deque.removeFirst());
    System.out.println("deque.removeFirst():" + deque.removeFirst());
    System.out.println("deque.removeFirst():" + deque.removeFirst());

    deque = new ArrayDeque<>();
    deque.addLast("One");
    deque.addLast("Two");
    deque.addFirst("Three");
    deque.addFirst("Four");
    System.out.println("deque.getLast():" + deque.getLast());
    System.out.println("deque.removeLast():" + deque.removeLast());
    System.out.println("deque.removeLast():" + deque.removeLast());
    System.out.println("deque.removeLast():" + deque.removeLast());

    deque = new ArrayDeque<>();
    deque.addLast("One");
    deque.addLast("Two");
    System.out.println("deque.getLast():" + deque.getLast());
    System.out.println("deque.removeLast():" + deque.removeLast());
    System.out.println("deque.removeLast():" + deque.removeLast());

    deque = new ArrayDeque<>();
    deque.add(null);
  }
}
