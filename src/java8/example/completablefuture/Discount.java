package java8.example.completablefuture;

import static java8.example.Util.delay;
import static java8.example.Util.format;

public class Discount {

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
//        System.out.println("discount executed by : " + Thread.currentThread().getName() + " for - " +
//                quote.getShopName());
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }
    private static double apply(double price, Code code) {
//        delay();
        return format(price * (100 - code.percentage) / 100);
    }
}
