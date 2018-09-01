package com.moneytap.entity;

import io.netty.handler.codec.http.HttpResponseStatus;

public class SearchResponse extends HttpResponseStatus {
	public SearchResponse(int code, String reasonPhrase) {
		super(code, reasonPhrase);
		// TODO Auto-generated constructor stub
	}

	private Double avg;
	private Double median;

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public Double getMedian() {
		return median;
	}

	public void setMedian(Double median) {
		this.median = median;
	}

	@Override
	public String toString() {
		return "SearchResponse [avg=" + avg + ", median=" + median + "]";
	}

}
