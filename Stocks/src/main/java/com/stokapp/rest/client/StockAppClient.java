package com.stokapp.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class StockAppClient {

	static void callapi(int qty, String name, String opt){
		try {

			URL url = new URL(
					"http://localhost:8080/Stocks/stockapp/post");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			String input = "{\"qty\":" + qty +",\"name\":\""+ name +"\",\"opt\":\""+ opt +"\"}";
			
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Transaction Report\n=====================");
			while ((output = br.readLine()) != null) {

				System.out.println(output + "\n");
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}


	}
	public static void main(String[] args) {
		int quantity;
		String Stock;
		System.out.println("Enter Stock Name");
		Scanner inp = new Scanner(System.in);
		Stock = inp.next();
		System.out.println("Enter Amount of Stock");
		quantity = inp.nextInt();
		String NextAction = "BUY";
		try{


			while(true){
				if(NextAction.equalsIgnoreCase("BUY")){
					NextAction = "Sell";
				}else{
					NextAction = "Buy";
				}

							
				callapi(quantity,Stock,NextAction);


				Thread.sleep((long)(Math.random() * 1000));

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}