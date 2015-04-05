package com.stockapp.rest;

public class Stocks {

	String Stock;
	int amt;
	String opt;
	
	public String getName() {
		return Stock;
	}

	public void setName(String name) {
		this.Stock = name;
	}

	public int getQty() {
		return amt;
	}

	public void setQty(int amt) {
		this.amt = amt;
	}
	
	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}
	

	@Override
	public String toString() {
		return "Stock [OPT=" + opt + ",StockID=" + Stock + ", Amount=" + amt + "]";
	}

}