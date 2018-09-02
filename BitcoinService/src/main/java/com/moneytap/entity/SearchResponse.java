package com.moneytap.entity;

public class SearchResponse {

	private String dateTime;
	private Double bitcoinPrice;

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Double getBitcoinPrice() {
		return bitcoinPrice;
	}

	public void setBitcoinPrice(Double bitcoinPrice) {
		this.bitcoinPrice = bitcoinPrice;
	}

	@Override
	public String toString() {
		return "SearchResponse [dateTime=" + dateTime + ", bitcoinPrice=" + bitcoinPrice + "]";
	}

}
