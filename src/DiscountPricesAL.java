import java.math.BigDecimal;

public class DiscountPricesAL {
	/*
	String sentence = "there are $1 $2 and 5$ candies in the shop";
        int discount = 50;
        DiscountPricesAL discountPricesAL = new DiscountPricesAL();
        String result = discountPricesAL.discountPrices(sentence,discount);
        System.out.println(result);

	 */
	/**
	 *
	 * @param sentence
	 * @param discount
	 * @return
	 */
	public String discountPrices(String sentence, int discount) {
		StringBuilder resultSB = new StringBuilder("");
		String []strs = sentence.split(" ");
		BigDecimal origPrice;
		BigDecimal coeff;
		BigDecimal price;
		double d = 1 - discount / 100.0;
		for(int i=0;i<strs.length;i++){
			String regx="^\\$\\d+";
			if(strs[i].matches(regx)) {
				origPrice = new BigDecimal(strs[i].substring(1));
				coeff = new BigDecimal(100 - discount);
				price = origPrice.multiply(coeff).divide(new BigDecimal(100)).setScale(2);
				strs[i] = "$" + String.valueOf(price);
			}
			resultSB.append(strs[i]);
			if(i != strs.length-1){
				resultSB.append(" ");
			}
		}
		return resultSB.toString();
	}
}
