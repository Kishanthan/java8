package java8.example.completablefuture;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class BestPriceFinderMain {


    public static void main(String[] args) {
//        BestPriceFinderV1 bestPriceFinderV1 = new BestPriceFinderV1();
//        print("sequential", () -> bestPriceFinderV1.findPricesSequential("myPhone27S"));
//        print("parallel", () -> bestPriceFinderV1.findPricesParallel("myPhone27S"));
//        print("completableFuture", () -> bestPriceFinderV1.findPricesFuture("myPhone27S"));


        BestPriceFinderV2 bestPriceFinderV2 = new BestPriceFinderV2();
        print("sequential", () -> bestPriceFinderV2.findPricesSequential("myPhone27S"));
        print("parallel", () -> bestPriceFinderV2.findPricesParallel("myPhone27S"));
        print("completableFuture", () -> bestPriceFinderV2.findPricesFuture("myPhone27S"));
//        bestPriceFinderV2.printPricesStream("myPhone27S");
    }

    private static void print(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }
}
