package java8.example.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    private final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>() {{
        putIfAbsent("foo", "bar");
        putIfAbsent("han", "solo");
        putIfAbsent("r2", "d2");
        putIfAbsent("c3", "p0");
    }};

    public static void main(String[] args) {
//        System.out.println("Parallelism: " + ForkJoinPool.getCommonPoolParallelism());

        ConcurrentHashMapExample example = new ConcurrentHashMapExample();
//        example.testForEach();
//        example.testSearch();
//        example.testReduce();
        example.testOther();
    }

    private void testForEach() {
        System.out.println("\nforEach()\n");

        map.forEach(1, (key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n", key, value,
                Thread.currentThread().getName()));

        map.forEachKey(1, key -> System.out.printf("key is : %s; thread: %s\n", key, Thread.currentThread().getName()));

        map.forEachValue(1, value -> System.out.printf("value is : %s; thread: %s\n", value,
                Thread.currentThread().getName()));
    }

    private void testSearch() {
        System.out.println("\nsearch()\n");

        String result1 = map.search(1, (key, value) -> {
//            System.out.println(Thread.currentThread().getName());
            if (key.equals("foo") && value.equals("bar")) {
                return "foobar";
            }
            return null;
        });

        System.out.println(result1);

        System.out.println("\nsearchValues()\n");

        String result2 = map.searchValues(1, value -> {
//            System.out.println(Thread.currentThread().getName());
            if (value.length() > 3) {
                return value;
            }
            return null;
        });

        System.out.println(result2);
    }

    private void testReduce() {
        String reduced = map.reduce(1,
                (key, value) -> {
//                    System.out.println("Transform: " + Thread.currentThread().getName());
                    return key + "=" + value;
                },
                (s1, s2) -> {
//                    System.out.println("Reduce: " + Thread.currentThread().getName());
                    return s1 + ", " + s2;
                });

        System.out.println(reduced);
    }

    private void testOther() {
        String val1 = map.putIfAbsent("c3", "p1");
        System.out.println(val1);

        String val2 = map.getOrDefault("hi", "there");
        System.out.println(val2);

        map.replaceAll((key, value) -> "r2".equals(key) ? "d3" : value);
        System.out.println(map.get("r2"));

        map.compute("foo", (key, value) -> value + value);
        System.out.println(map.get("foo"));

        map.merge("foo", "boo", (oldVal, newVal) -> newVal + " was " + oldVal);
        System.out.println(map.get("foo"));
    }
}
