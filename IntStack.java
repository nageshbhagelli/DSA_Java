/*
What is a Stack?
    A stack is a one-ended linear data structure which models a real world stack by having two primary 
    operations, namely push and pop.

When and where is a stack used?
    -used by undo mechanisms in text editors.
    -used in compiler syntax checking for matching brackets and braces
    -can be used to model a pile of books or plates
    -used behind the scenes to support recursion by keeping track of previous function calls
    -can be used to do a Depth First Search(DFS) on a graph
*/

public class IntStack {

  private int[] ar;
  private int pos = 0;

  // maxSize is the maximum number of items
  // that can be in the queue at any given time
  public IntStack(int maxSize) {
    ar = new int[maxSize];
  }

  // Returns the number of elements insize the stack
  public int size() {
    return pos;
  }

  // Returns true/false on whether the stack is empty
  public boolean isEmpty() {
    return pos == 0;
  }

  // Returns the element at the top of the stack
  public int peek() {
    return ar[pos - 1];
  }

  // Add an element to the top of the stack
  public void push(int value) {
    ar[pos++] = value;
  }

  // Make sure you check that the stack is not empty before calling pop!
  public int pop() {
    return ar[--pos];
  }

  // Example usage
  public static void main(String[] args) {

    IntStack s = new IntStack(5);

    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);

    System.out.println(s.pop()); // 5
    System.out.println(s.pop()); // 4
    System.out.println(s.pop()); // 3

    s.push(3);
    s.push(4);
    s.push(5);

    while (!s.isEmpty())
      System.out.println(s.pop());

    benchMarkTest();
  }

  // BenchMark IntStack vs ArrayDeque.
  private static void benchMarkTest() {

    int n = 10000000;
    IntStack intStack = new IntStack(n);

    // IntStack times at around 0.0324 seconds
    long start = System.nanoTime();
    for (int i = 0; i < n; i++)
      intStack.push(i);
    for (int i = 0; i < n; i++)
      intStack.pop();
    long end = System.nanoTime();
    System.out.println("IntStack Time: " + (end - start) / 1e9);

    // ArrayDeque times at around 1.438 seconds
    java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
    // java.util.ArrayDeque <Integer> arrayDeque = new java.util.ArrayDeque<>(n); //
    // strangely the
    // ArrayQueue is slower when you give it an initial capacity.
    start = System.nanoTime();
    for (int i = 0; i < n; i++)
      arrayDeque.push(i);
    for (int i = 0; i < n; i++)
      arrayDeque.pop();
    end = System.nanoTime();
    System.out.println("ArrayDeque Time: " + (end - start) / 1e9);
  }
}