package java8.example.stream;


import static java8.example.Util.measurePerf;

public class ParallelStreamPerformance {

    public static void main(String[] args) {
//        System.out.println("Iterative Sum done in: " +
//                measurePerf(ParallelStreams::iterativeSum, 10_000_000L) + " msecs");


//        System.out.println("Sequential Sum done in: " +
//                measurePerf(ParallelStreams::sequentialSum, 10_000_000L) + " msecs");
//        System.out.println("Parallel sum done in: " +
//                measurePerf(ParallelStreams::parallelSum, 10_000_000L) + " msecs");
////
////
//        System.out.println("Range sum done in: " +
//                measurePerf(ParallelStreams::rangedSum, 10_000_000L) + " msecs");
//        System.out.println("Parallel range sum done in: " +
//                measurePerf(ParallelStreams::parallelRangedSum, 10_000_000L) + " msecs");
//
//
        System.out.println("SideEffect sum done in: " +
                measurePerf(ParallelStreams::sideEffectSum, 10_000_000L) + " msecs");
        System.out.println("SideEffect prallel sum done in: " +
                measurePerf(ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msecs");
    }

}
