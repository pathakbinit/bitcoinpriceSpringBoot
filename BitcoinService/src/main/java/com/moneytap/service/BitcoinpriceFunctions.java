package com.moneytap.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.moneytap.entity.BitcoinPriceResponse;
import com.moneytap.entity.SearchResponse;
import com.moneytap.helper.BitcoinpriceComparator;

@Service
public class BitcoinpriceFunctions implements IBitcoinpriceFunctions {
	private Logger log = LoggerFactory.getLogger(BitcoinpriceFunctions.class);

	@Override
	public Double getAvg(List<BitcoinPriceResponse> bitcoinStatistics) {
		Double avgBitcoinPrice = 0.0;
		for (BitcoinPriceResponse bitcoinPriceResponse : bitcoinStatistics) {
			avgBitcoinPrice += bitcoinPriceResponse.getPrice_close();
		}
		Double avgPrice = avgBitcoinPrice / bitcoinStatistics.size();
		log.debug("Returned avg price {}", avgPrice);
		return avgPrice;
	}

	@Override
	public Double getMedian(List<BitcoinPriceResponse> bitcoinStatistics) {
		int size = bitcoinStatistics.size();
		Double median;
		if (size / 2 == 0) {
			double firstValue = bitcoinStatistics.get(size / 2).getPrice_close();
			double secondValue = bitcoinStatistics.get(size / 2 + 1).getPrice_close();
			median = (firstValue + secondValue) / 2;
		} else {
			median = bitcoinStatistics.get(size / 2).getPrice_close();
		}
		log.debug("Returned median {}", median);
		return median;
	}

	@Override
	public Double getHighestPrice(List<BitcoinPriceResponse> prices) {
		Collections.sort(prices, new BitcoinpriceComparator());
		log.debug("Sorted bitcoin data {}", prices);
		return prices.get(0).getPrice_close();
	}

	@Override
	public List<SearchResponse> getBitcoinPrice(List<BitcoinPriceResponse> bitcoinPrice) {
		List<SearchResponse> response = new ArrayList<>();
		Collections.sort(bitcoinPrice, new BitcoinpriceComparator());
		for (BitcoinPriceResponse bitcoinPriceResponse : bitcoinPrice) {
			SearchResponse searchResponse = new SearchResponse();
			searchResponse.setDateTime(bitcoinPriceResponse.getTime_close());
			searchResponse.setBitcoinPrice(bitcoinPriceResponse.getPrice_close());
			response.add(searchResponse);
		}
		log.debug("Response {}", response.toString());
		return response;
	}

}
