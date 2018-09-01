package com.moneytap.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.moneytap.entity.BitcoinPriceResponse;
import com.moneytap.helper.BitcoinpriceComparator;

@Service
public class BitcoinpriceFunctions implements IBitcoinpriceFunctions {

	@Override
	public Double getAvg(List<BitcoinPriceResponse> bitcoinStatistics) {
		Double avgBitcoinPrice = 0.0;
		for (BitcoinPriceResponse bitcoinPriceResponse : bitcoinStatistics) {
			avgBitcoinPrice += bitcoinPriceResponse.getPrice_close();
		}
		return avgBitcoinPrice / bitcoinStatistics.size();
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
		return median;
	}

	@Override
	public Double getHighestPrice(List<BitcoinPriceResponse> prices) {
		Collections.sort(prices, new BitcoinpriceComparator());
		System.out.println(prices);
		return prices.get(0).getPrice_close();
	}

}
