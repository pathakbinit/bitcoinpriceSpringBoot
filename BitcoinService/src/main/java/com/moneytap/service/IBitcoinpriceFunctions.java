package com.moneytap.service;

import java.util.List;

import com.moneytap.entity.BitcoinPriceResponse;
import com.moneytap.entity.SearchResponse;

/**
 * This interface provides function to get avg,median,highest bitcoin price in
 * last X times
 * 
 * @author Binit
 *
 */
public interface IBitcoinpriceFunctions {
	/**
	 * Returns average bitcoin price in last X minutes
	 * 
	 * @param prices
	 * @return
	 */
	Double getAvg(List<BitcoinPriceResponse> prices);

	/**
	 * Returns median bitcoin price in last X minutes
	 * 
	 * @param prices
	 * @return
	 */

	Double getMedian(List<BitcoinPriceResponse> prices);

	/**
	 * Returns highest bitcoin price in last X minutes
	 * 
	 * @param prices
	 * @return
	 */

	Double getHighestPrice(List<BitcoinPriceResponse> prices);

	/**
	 * Returns bitcoin price for last X minutes
	 * 
	 * @param bitcoinPrice
	 * @return
	 */
	SearchResponse getBitcoinPrice(List<BitcoinPriceResponse> bitcoinPrice);
}
