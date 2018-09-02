package com.moneytap.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.moneytap.entity.BitcoinPriceResponse;

public class BitcoinpriceHelper {
	static Logger logger = LoggerFactory.getLogger(BitcoinpriceHelper.class);

	public List<BitcoinPriceResponse> getBitcoinPriceInTimeInterval(String time) throws IOException {
		String formatDate = "yyyy-MM-dd'T'HH:mm:ss";
		DateTimeFormatter date = DateTimeFormatter.ofPattern(formatDate);
		LocalDateTime dateTime = LocalDateTime.now();
		String toTime = date.format(dateTime);
		LocalDateTime dateTime2 = dateTime.minusMinutes(Long.valueOf(time));
		String fromTime = date.format(dateTime2);
		System.out.println("Fetching bitcoin price from : " + fromTime + " to : " + toTime);
		URL url;
		try {
			url = new URL("https://rest.coinapi.io/v1/ohlcv/BITSTAMP_SPOT_BTC_USD/history?period_id=1MIN&time_start="
					+ fromTime + "&time_end" + toTime);
		} catch (MalformedURLException e) {
			throw new MailAuthenticationException("The URL formed is not valid", e);
		}
		logger.debug("Url for fetching the bitcoin price {}", url.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(RequestMethod.GET.name());

		connection.setRequestProperty("X-CoinAPI-Key", "D4296370-46A0-4966-B068-7A28ECC8B1DB");

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		List<BitcoinPriceResponse> bitcoinPriceResponses = new ArrayList<>();
		Gson gson = new Gson();
		JsonArray element = gson.fromJson(content.toString(), JsonArray.class);
		for (JsonElement jsonElement : element) {
			BitcoinPriceResponse bitcoinPriceResponse = gson.fromJson(jsonElement, BitcoinPriceResponse.class);
			bitcoinPriceResponses.add(bitcoinPriceResponse);
		}
		in.close();

		return bitcoinPriceResponses;

	}
}
