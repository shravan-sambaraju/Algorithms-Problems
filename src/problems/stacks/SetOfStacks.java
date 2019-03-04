package problems.stacks;

/* Implement stack of plates */

import java.util.ArrayList;
import java.util.EmptyStackException;

class SetOfStacks {

    ArrayList<Stack> stacks = new ArrayList<Stack>();
    private int capacity;

    private SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        int capacity_per_substack = 5;
        SetOfStacks set = new SetOfStacks(capacity_per_substack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i < 35; i++) {
            System.out.println("Popped " + set.pop());
        }
    }

    private Stack getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    private void push(int v) {
        Stack last = getLastStack();
        if (last != null && !last.isFull()) { // add to last
            last.push(v);
        } else { // must create new stack
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    private int pop() {
        Stack last = getLastStack();
        if (last == null) {
            throw new EmptyStackException();
        }
        int v = last.pop();
        if (last.size == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }

    private int popAt(int index) {
        return leftShift(index, true);
    }

    private int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removed_item;
        if (removeTop) {
            removed_item = stack.pop();
        } else {
            removed_item = stack.removeBottom();
        }
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removed_item;
    }

    private boolean isEmpty() {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }

    private class Node {
        private Node above;
        private Node below;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private class Stack {
        private int capacity;
        private Node top;
        private Node bottom;
        private int size = 0;

        public Stack(int capacity) {
            this.capacity = capacity;
        }

        private boolean isFull() {
            return capacity == size;
        }

        private void join(Node above, Node below) {
            if (below != null) {
                below.above = above;
            }
            if (above != null) {
                above.below = below;
            }
        }

        private boolean push(int v) {
            if (size >= capacity) {
                return false;
            }
            size++;
            Node n = new Node(v);
            if (size == 1) {
                bottom = n;
            }
            join(n, top);
            top = n;
            return true;
        }

        private int pop() {
            if (top == null) {
                throw new EmptyStackException();
            }
            Node t = top;
            top = top.below;
            size--;
            return t.value;
        }

        private boolean isEmpty() {
            return size == 0;
        }

        private int removeBottom() {
            Node b = bottom;
            bottom = bottom.above;
            if (bottom != null) {
                bottom.below = null;
            }
            size--;
            return b.value;
        }
    }
}
