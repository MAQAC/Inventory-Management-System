package com.qa.ims.persistance;

public class AppealsPledge {

	
	private int pledgeID;
	private int appealID;
	
	AppealsPledge(int appealID, int pledgeID) {
		this.appealID = appealID;
		this.pledgeID = pledgeID;
		
	}
	
	AppealsPledge() {
		
	}

	public int getPledgeID() {
		return pledgeID;
	}

	public void setPledgeID(int pledgeID) {
		this.pledgeID = pledgeID;
	}

	public int getAppealID() {
		return appealID;
	}

	public void setAppealID(int appealID) {
		this.appealID = appealID;
	}
	
	public void insertCustomer(AppealsPledge a, int appealID, int pledgeID) {
		String query = "INSERT INTO appealspledge (`appealID`, `pledgeID`)" + " VALUES (" + a.getAppealID() +"," + a.getPledgeID();
	DB.exUpdate(query);
	}
	
	
}
