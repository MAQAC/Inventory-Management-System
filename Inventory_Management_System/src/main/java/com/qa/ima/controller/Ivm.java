package com.qa.ima.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Scanner;

import com.qa.ims.persistance.Appeal;
import com.qa.ims.persistance.Customer;
import com.qa.ims.persistance.DB;
import com.qa.ims.persistance.Pledge;

import input.UserInput;
import logic.BusinessLogic;

public class Ivm {
	
	CustomerControl custcon = new CustomerControl(new Customer());
	Customer cust = new Customer();
	AppealControl ac = new AppealControl();
	Appeal a = new Appeal();
	Pledge p = new Pledge();
	PledgeControl pc = new PledgeControl();
	UserInput ui = new UserInput();
	BusinessLogic bl = new BusinessLogic();
	void showMenu() throws ParseException {
		
		String option = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Welcome, how can we help you today?");
		System.out.print("\n");
		System.out.print("Please choose from the following options");
		System.out.print("\n");
		System.out.print("A. Register Details");
		System.out.print("\n");
		System.out.print("B. See Available Appeals");
		System.out.print("\n");
		System.out.print("C. Previous Pledges");
		System.out.print("\n");
		System.out.print("D. Update Details");
		System.out.print("\n");
		System.out.print("E. Add Appeal");
		System.out.print("\n");
		System.out.print("F. Exit");
		do {
			
			System.out.print("\n");
			System.out.print("========================================================");
			System.out.print("\n");
			System.out.print("Enter an option: ");
			option = ui.input();
			System.out.print("\n");
			System.out.print("========================================================");
			
			System.out.print("\n");
			
			DB.connect();
			switch(option) {
			
			case "A":
				
				custcon.insertCustomer(ui.inputCust(cust));
				custcon.showID(cust);
				showMenu();
				break;
				
			case "B":
				
				ac.queryAppeal(a);
				int id =ui.inputAppeal();
				int custid = ui.RetId();
				String date = ui.inputDate();
				BigDecimal price = ac.appPrice(a,id);
				price = bl.totalCost(a,ui.insertQuantity());
				pc.insertPledge(custid, date, price);
				showMenu();
				
				break;
				
			case "C": 
				
				int custid1 = ui.RetId();
				pc.queryPledge(p, custid1);
				
				break;
				
			case "D":
				
				id = ui.RetId();
				cust = ui.inputCust(cust);
				custcon.updateCustomer(cust, id);
				showMenu();
				break;
			
			case "E":
				a = ui.inputAppeal(a);
				ac.insertAppeal(a);
				showMenu();
				break;
				
			case "F":
				break;
				
			default:
				System.out.print("Please enter a valid option!");
				break;				
			}
			
			} while(option != "F");
		scanner.close();
		System.out.println("Thank you for using our services");
	}

	
	
}
