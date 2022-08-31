import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CalculateAverage {

	static Map <Integer, Double> avg (List <Product> productHistory,LocalDate dateStart, LocalDate dateEnd) {	
		
		productHistory.sort(Comparator.comparing(Product::getProductId));
		Double average = 0.0;
		Double suma = 0.0;
		Double count = 0.0;
		Integer i=0;
		Integer n = productHistory.size();
		Map<Integer,Double> result = new HashMap<>();

		for (i=0; i<n; i++) {
			
			if ((productHistory.get(i).getCurrentDate().compareTo(dateStart)>=0)&&(productHistory.get(i).getCurrentDate().compareTo(dateEnd)<=0)){
				suma = suma + productHistory.get(i).getInventory();
				count ++;
			}
			if (count>0) {
				average = suma/count;
				result.put(productHistory.get(i).getProductId(), average);
				
			}	
			if(i<n-1) {
				Integer thisproduct = productHistory.get(i).getProductId();
				Integer nextproduct = productHistory.get(i+1).getProductId();
				
			if (thisproduct != nextproduct) {
				suma = 0.0;
				count = 0.0;
			}
			}
			
		
		}
		

		return result;
		
	}
	
	public static void main(String[] args) {
	
		List <Product>productList = new ArrayList<Product>();
		productList.add(new Product(1, LocalDate.of(2022, 01, 10), 1));
		productList.add(new Product(1, LocalDate.of(2022, 01, 11), 1));
		productList.add(new Product(1, LocalDate.of(2022, 01, 12), 5));
		productList.add(new Product(2, LocalDate.of(2022, 01, 13), 1));
		productList.add(new Product(2, LocalDate.of(2022, 01, 14), 3));
		productList.add(new Product(3, LocalDate.of(2022, 01, 15), 9));
		productList.add(new Product(4, LocalDate.of(2022, 01, 16), 12));
		productList.add(new Product(5, LocalDate.of(2022, 01, 17), 44));
		productList.add(new Product(5, LocalDate.of(2022, 01, 18), 2));
		productList.add(new Product(5, LocalDate.of(2022, 01, 19), 2));
		productList.add(new Product(7, LocalDate.of(2022, 01, 20), 8));
		productList.add(new Product(7, LocalDate.of(2022, 01, 21), 3));
		productList.add(new Product(7, LocalDate.of(2022, 01, 22), 3));
		productList.add(new Product(8, LocalDate.of(2022, 01, 22), 6));
		
		System.out.println(avg(productList,LocalDate.of(2022, 01, 10),LocalDate.of(2022, 01, 22)));

	}

}
