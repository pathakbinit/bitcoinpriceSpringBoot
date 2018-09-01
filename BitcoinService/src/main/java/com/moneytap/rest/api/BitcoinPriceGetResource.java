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

import io.netty.handler.codec.http.HttpResponseStatus;

@RestController
public class BitcoinPriceGetResource {

	private Logger log = LoggerFactory.getLogger(BitcoinPriceGetResource.class);
	@Autowired
	private IBitcoinpriceFunctions bitcoinpriceFunctions;

	BitcoinpriceHelper bitcoinpriceHelper = new BitcoinpriceHelper();

	@GetMapping("/average/{time}")
	public SearchResponse getBitcoinAverage(@PathVariable String time) throws IOException {

		SearchResponse response = null;
		try {
			List<BitcoinPriceResponse> bitcoinStatistics = bitcoinpriceHelper.getBitcoinPriceInTimeInterval(time);
			Double avg = bitcoinpriceFunctions.getAvg(bitcoinStatistics);
			log.debug("Average computed {}", avg);
			if (avg == 0) {
				response = new SearchResponse(HttpResponseStatus.OK.code(), "Average value is zero");
			} else {
				response = new SearchResponse(HttpResponseStatus.ACCEPTED.code(), "Got the average value");
				response.setAvg(avg);
			}
			return response;
		} catch (Exception exception) {
			response = new SearchResponse(HttpResponseStatus.INTERNAL_SERVER_ERROR.code(), "Check for valid data");
			return response;
		}
	}

	@GetMapping("/median/{time}")
	public SearchResponse getBitcoinMedian(@PathVariable String time) throws IOException {

		SearchResponse response = null;
		try {
			List<BitcoinPriceResponse> bitcoinStatistics = bitcoinpriceHelper.getBitcoinPriceInTimeInterval(time);
			Double median = bitcoinpriceFunctions.getMedian(bitcoinStatistics);
			log.debug("Median computed {}", median);
			if (median == 0) {
				response = new SearchResponse(HttpResponseStatus.OK.code(), "Median value is zero");
			} else {
				response = new SearchResponse(HttpResponseStatus.ACCEPTED.code(), "Got the median value");
				response.setMedian(median);
			}
			return response;
		} catch (Exception exception) {
			response = new SearchResponse(HttpResponseStatus.INTERNAL_SERVER_ERROR.code(), "Check for valid data");
			return response;
		}
	}

	@GetMapping("/highest/{time}")
	public Double getHighestPrice(@PathVariable String time) {
		try {
			List<BitcoinPriceResponse> bitcoinStatistics = bitcoinpriceHelper.getBitcoinPriceInTimeInterval(time);
			Double highestPrice = bitcoinpriceFunctions.getHighestPrice(bitcoinStatistics);
			return highestPrice;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
