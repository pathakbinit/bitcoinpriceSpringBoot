package com.moneytap.rest.api;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.moneytap.entity.BitcoinPriceResponse;
import com.moneytap.entity.SearchResponse;
import com.moneytap.helper.BitcoinpriceHelper;
import com.moneytap.service.IBitcoinpriceFunctions;

@RestController
public class BitcoinPriceGetResource extends BitcoinpriceHelper {

	private Logger log = LoggerFactory.getLogger(BitcoinPriceGetResource.class);
	@Autowired
	private IBitcoinpriceFunctions bitcoinpriceFunctions;

	@GetMapping("/average/{time}")
	public String getBitcoinAverage(@PathVariable String time) throws IOException {
		try {
			List<BitcoinPriceResponse> bitcoinStatistics = getBitcoinPriceInTimeInterval(time);
			Double avg = bitcoinpriceFunctions.getAvg(bitcoinStatistics);
			log.debug("Average computed {}", avg);
			return "Average bitcoin price for last " + time + " mins is " + avg;
		} catch (Exception exception) {
			return "Cannot process the request";
		}
	}

	@GetMapping("/median/{time}")
	public String getBitcoinMedian(@PathVariable String time) throws IOException {
		try {
			List<BitcoinPriceResponse> bitcoinStatistics = getBitcoinPriceInTimeInterval(time);
			Double median = bitcoinpriceFunctions.getMedian(bitcoinStatistics);
			log.debug("Median computed {}", median);
			return "Median bitcoin price for last " + time + " mins is " + median;
		} catch (Exception exception) {
			return "Cannot process the request";
		}
	}

	@GetMapping("/highest/{time}")
	public String getHighestPrice(@PathVariable String time) {
		try {
			List<BitcoinPriceResponse> bitcoinStatistics = getBitcoinPriceInTimeInterval(time);
			Double highestPrice = bitcoinpriceFunctions.getHighestPrice(bitcoinStatistics);
			return "Highest bitcoin price for last " + time + " mins is " + highestPrice;
		} catch (Exception e) {
			return "Cannot process the request";
		}
	}

	@GetMapping("/price/{time}")
	public SearchResponse getBitcoinPrice(@PathVariable String time) throws Exception {
		try {
			List<BitcoinPriceResponse> bitcoinPrice = getBitcoinPriceInTimeInterval(time);
			SearchResponse response = bitcoinpriceFunctions.getBitcoinPrice(bitcoinPrice);
			return response;
		} catch (Exception ex) {
			throw new Exception("No data availbale");
		}
	}
}
