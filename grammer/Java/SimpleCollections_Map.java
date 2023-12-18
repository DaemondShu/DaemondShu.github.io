// ![2022-11-27T200913](SimpleCollections/2022-11-27T200913.png)
import java.util.*;
import java.lang.*;
import java.io.*;

public class SimpleCollections_Map {
    public static void main(String[] args) throws Exception {
        // Collections Common API

        // -------------------------- Collection Interfaces 1 List ----------------------------
        // IMPL
        //      ArrayList 
        //      Vector (thread safe, synchronized)
        //          Stack
        //      LinkedList 
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(3);
        a.remove(0);
        a.add(5);
        System.out.println(Arrays.deepToString(a.toArray())); //[3, 5]

        // stack add, pop, peek
        Stack<String> s = new Stack<String>();
        s.add("1");
        s.add("2");
        s.add("3");
        System.out.println(s.peek()); //3
        s.pop();
        System.out.println(Arrays.deepToString(s.toArray())); //[1, 2] traverse as array, it's implemented by vector

        // linkedlist remove
        LinkedList<Integer> l = new LinkedList<>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        l.removeFirst();
        l.removeLast();
        System.out.println(Arrays.deepToString(l.toArray())); //[2]

        // -------------------------- Collection Interface 2 Queue ----------------------------
        // add() 和 offer() 都是向队列中添加一个元素 . 一些队列有大小限制,因此如果想在已满的队列加入一个新队列, 调用 add() 方法就会抛出一个 unchecked 异常, 而调用 offer() 方法返回 flase . 因此就可以在程序中进行有效的判断 .
        // poll() 和 remove() 方法都是从队列中删除第一个元素. 如果队列元素为空 ,调用 remove() 的行为与 Collection 接口的版本相似会抛出异常 . 但是新的 poll() 方法会在用空集合调用时只会返回 null . 因此新的方法更适合容易出现异常条件的情况.
        // element() 和 peek()用于在队列的头部查询元素. 与 remove() 方法类似 , 在队列为空时 , element () 抛出一个异常 , 而 peek()返回 null .
        // IMPL
        //      linkedlist
        //      Deque, ArrayDeque
        //      PriorityQueue,  thread safe version: PriorityBlockingQueue
        Queue<Integer> pq = new PriorityQueue<>() {
            {
                offer(10);
                offer(50);
                offer(30);
                offer(20);
            }
        };
        // pq.iterator //no order, since it did not pop out elements
        while (pq.size() > 0) {
            System.out.printf("%d ", pq.poll());
        }
        System.out.printf("\n");

        // -------------------------- Collection Interface 3 Set ----------------------------
        // Set
        //     HashSet  (太基本了)
        //         !! LinkedHashSet
        //     TreeSet
        Set<Integer> ts = new TreeSet<>((x, y) -> y - x); //descending ordered
        ts.addAll(Arrays.asList(9, 2, 5, 4));
        System.out.println(Arrays.deepToString(ts.toArray())); // 9 5 4 2,  by tree

        LinkedHashSet<Integer> ls = new LinkedHashSet<>(Arrays.asList(9, 2, 5, 4));
        System.out.println(Arrays.deepToString(ls.toArray())); //9 2 5 4 inside it's a sequential linked list
        ls.add(8); //only support add at tail
        ls.contains(5); //true
        ls.remove(5);
        System.out.println(Arrays.deepToString(ls.toArray())); //9 2 4 8 inside it's a sequential linked list

        // -------------------------- Map(not collectiosn) Interface 4 ----------------------------
        // Map
        //     HashMap 
        //          LinkedHashMap 类似linkedhashset
        //     TreeMap
        Map<Integer, String> m = new HashMap<>();
        m.put(2, "2a");
        m.put(5, "5b");
        System.out.println(m.get(1)); //null
        System.out.println(m.getOrDefault(3, "default")); //default

        // traverse the map
        for (Map.Entry<Integer, String> e : m.entrySet()) {
            System.out.printf("%d %s;", e.getKey(), e.getValue());
        }
        System.out.printf("\n");

        // 迭代器只通过next获得下一个值，非常垃圾
        for (Iterator<Map.Entry<Integer, String>> mi = m.entrySet().iterator(); mi.hasNext();) {
            Map.Entry<Integer, String> e = mi.next();
            System.out.printf("%d %s;", e.getKey(), e.getValue());
        }
        System.out.printf("\n");

        // quick print
        System.out.println(m.keySet().toString());  // 2 5
        System.out.println(m.values().toString());  // 2a 5b

    }
}
