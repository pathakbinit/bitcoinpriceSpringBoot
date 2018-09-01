package com.moneytap.service;

import java.util.List;

import com.moneytap.entity.BitcoinPriceResponse;

public interface IBitcoinpriceFunctions {
	Double getAvg(List<BitcoinPriceResponse> prices);

	Double getMedian(List<BitcoinPriceResponse> prices);

	Double getHighestPrice(List<BitcoinPriceResponse> prices);
}
