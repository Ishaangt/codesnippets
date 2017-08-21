/**
 * 
 */
package com.codesnippet.webservices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

/**
 * @author Grim42
 * @category WebServices - Java
 * @category Rest
 *
 */
public class SendPostRequest {

	private static long sysTimeStart, sysTimeEnd;
	private static double sysTimeElapsed;
	private final static Logger LOGGER = Logger.getLogger(SendPostRequest.class.getName());
	
	public static String sendPostRequest(String requestUrl, String payload) {
		LOGGER.info("Starting Rest Connection");
		sysTimeStart = System.currentTimeMillis();
		StringBuffer jsonString = new StringBuffer();
		HttpURLConnection connection = null;
		try {
			URL url = new URL(requestUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			// connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			// OutputStreamWriter writer = new
			// OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			// writer.write(payload);
			// writer.close();

			System.out.println(connection.getResponseCode() + " " + connection.getResponseMessage());
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				jsonString.append(line);
			}
			br.close();

			sysTimeEnd = System.currentTimeMillis();
			sysTimeElapsed = (sysTimeEnd - sysTimeEnd)/1000;
			System.out.println("Total Time Taken ::::::::>>" + sysTimeElapsed);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			LOGGER.info("Ending Rest Connection");
			connection.disconnect();
		}
		return jsonString.toString();
	}

	public static void main(String[] args) {
		final String requestUrl = "http://demo6467500.mockable.io/v1";
		String payload = "";
		String json = sendPostRequest(requestUrl, payload);
		System.out.println("Json Response: " + json);
		final String requestUrl2 = "http://demo6467500.mockable.io/v1/seat";
		json = sendPostRequest(requestUrl2, payload);
		System.out.println("Json Response: " + json);
	}
}
