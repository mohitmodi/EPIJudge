package bigbubuclass;

import java.util.HashMap;
import java.util.Map;

public class StockPrice {
    HashMap<Long, Double> map;
    double max = Integer.MIN_VALUE;
    double min = Integer.MAX_VALUE;
    double sum;

    StockPrice() {
        map = new HashMap<>();
    }

    public void add(long time, double price) {
        map.put(time, price);
        if (price > max) {
            max = price;
        }
        if (price < min) {
            min = price;
        }
        sum += price;
    }

    public void update(long time, double price) {
        remove(time);
        add(time, price);
    }

    public void remove(long time) {
        double origPrice = map.remove(time);

        if (origPrice == max) {
            max = Integer.MIN_VALUE;
            for (Double value : map.values()) {
                max = Math.max(max, value);
            }
        }
        if (origPrice == min) {
            min = Integer.MAX_VALUE;
            for (Double value : map.values()) {
                min = Math.min(min, value);
            }
        }
        sum = sum - origPrice;
    }

    public double min() {
        return min;
    }

    public double max() {
        return max;
    }

    public double avg() {
        return sum / map.size();
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.add(1, 7);
        stockPrice.add(2, 8);
        stockPrice.add(3, 1);
        System.out.println(stockPrice.max);
        System.out.println(stockPrice.min);
        System.out.println(stockPrice.sum);

        stockPrice.update(1, 20);
        stockPrice.update(3, 56);
        System.out.println(stockPrice.max);
        System.out.println(stockPrice.min);
        System.out.println(stockPrice.sum);

        stockPrice.remove(1);
        System.out.println(stockPrice.max);
        System.out.println(stockPrice.min);
        System.out.println(stockPrice.sum);

        stockPrice.add(1, 7);
        System.out.println(stockPrice.max);
        System.out.println(stockPrice.min);
        System.out.println(stockPrice.sum);

        stockPrice.remove(2);
        System.out.println(stockPrice.max);
        System.out.println(stockPrice.min);
        System.out.println(stockPrice.sum);

    }

}
