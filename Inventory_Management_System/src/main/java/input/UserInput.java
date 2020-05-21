package input;

import java.text.ParseException;
import java.util.Scanner;

import com.qa.ims.persistance.Customer;

public class UserInput {
	
	
	static Scanner sc = new Scanner(System.in);
	
	public String input() {
		return sc.nextLine();	} //cast to appropriate variable
	
	static int inputInt() {
		int input;
		input = sc.nextInt();
		sc.nextLine();
		return input;
	}
		
	

	public Customer inputCust(Customer cust) {
		System.out.print("Can you please provide your forename?");
		String fname = input();
		cust.setFname(fname); 
		System.out.print("Can you please provide your sirname?");
		String sname = input();
		cust.setLname(sname);
		System.out.print("Can you please provide your address?");
		String address = input();
		cust.setAddress1(address);
		System.out.print("Can you please provide your city?");
		String city = input();
		cust.setCity(city);
		System.out.print("Can you please provide your email?");
		String email = input();		
		cust.setEmail(email);
		
		return cust;
	}
	
	public int RetId() {
		System.out.print("Can you please provide your ID Number?");
		int id = inputInt();
		return id;
	}
	
	public int inputAppeal() {
		System.out.print("========================================================");
		System.out.println("\n");
		System.out.print("Can you please provide the ID Number of the Appeal you would like to Pledge to? ");
		int id = inputInt();
		
		return id;
	}
	
	public String inputDate() throws ParseException {
		System.out.print("Please enter todays Date: ");
		String d = input();
		String date = d;
		return date;
	}

	
	
}
