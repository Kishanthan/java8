package java8.example.completablefuture;

import java.util.Random;

import static java8.example.Util.delay;
import static java8.example.Util.format;
import static java8.example.Util.randomDelay;

public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getPrice(String product) {
//        System.out.println("getPrice executed by : " + Thread.currentThread().getName() + " for - " + name);
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
    }

    public double calculatePrice(String product) {
        delay();
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

    public String getName() {
        return name;
    }
}
