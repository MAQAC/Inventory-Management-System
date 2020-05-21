package logic;

import java.math.BigDecimal;

import com.qa.ims.persistance.Appeal;


public class BusinessLogic {

	
	
	
	public BigDecimal totalCost(Appeal a,BigDecimal quantity) {
		BigDecimal total = a.getPrice().multiply(quantity);
		
		return total;
	}
}
