package com.moneytap.entity;

public class BitcoinPriceResponse {

	String time_period_start; // Period starting time (range left inclusive)
	String time_period_end; // Period ending time (range right exclusive)
	String time_open; // Time of first trade inside period range
	String time_close; // Time of last trade inside period range
	Double price_open; // First trade price inside period range
	Double price_high; // Highest traded price inside period range
	Double price_low; // Lowest traded price inside period range
	Double price_close; // Last trade price inside period range
	Double volume_traded;// Cumulative base amount traded inside period range
	Integer trades_count;// Amount of trades executed inside period range

	public String getTime_period_start() {
		return time_period_start;
	}

	public void setTime_period_start(String time_period_start) {
		this.time_period_start = time_period_start;
	}

	public String getTime_period_end() {
		return time_period_end;
	}

	public void setTime_period_end(String time_period_end) {
		this.time_period_end = time_period_end;
	}

	public String getTime_open() {
		return time_open;
	}

	public void setTime_open(String time_open) {
		this.time_open = time_open;
	}

	public String getTime_close() {
		return time_close;
	}

	public void setTime_close(String time_close) {
		this.time_close = time_close;
	}

	public Double getPrice_open() {
		return price_open;
	}

	public void setPrice_open(Double price_open) {
		this.price_open = price_open;
	}

	public Double getPrice_high() {
		return price_high;
	}

	public void setPrice_high(Double price_high) {
		this.price_high = price_high;
	}

	public Double getPrice_low() {
		return price_low;
	}

	public void setPrice_low(Double price_low) {
		this.price_low = price_low;
	}

	public Double getPrice_close() {
		return price_close;
	}

	public void setPrice_close(Double price_close) {
		this.price_close = price_close;
	}

	public Double getVolume_traded() {
		return volume_traded;
	}

	public void setVolume_traded(Double volume_traded) {
		this.volume_traded = volume_traded;
	}

	public Integer getTrades_count() {
		return trades_count;
	}

	public void setTrades_count(Integer trades_count) {
		this.trades_count = trades_count;
	}

	@Override
	public String toString() {
		return "BitcoinPriceResponse [time_period_start=" + time_period_start + ", time_period_end=" + time_period_end
				+ ", time_open=" + time_open + ", time_close=" + time_close + ", price_open=" + price_open
				+ ", price_high=" + price_high + ", price_low=" + price_low + ", price_close=" + price_close
				+ ", volume_traded=" + volume_traded + ", trades_count=" + trades_count + "]";
	}

}
