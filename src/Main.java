import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String sentence = "there are $1 $2 and 5$ candies in the shop";
        int discount = 50;
        DiscountPricesAL discountPricesAL = new DiscountPricesAL();
        String result = discountPricesAL.discountPrices(sentence,discount);
        System.out.println(result);

    }

}