package com.poker.game.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class WebServiceUtil {

	 
	public WebServiceUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public String callExternalService(String _url,String _method){
		try{
			URL url = new URL(_url);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			connection.addRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			connection.setRequestMethod(_method);
			connection.setDoInput(true);
			Integer responseCode = connection.getResponseCode();
			if(responseCode==200){
				BufferedReader input= new BufferedReader(new InputStreamReader(connection.getInputStream()));
				 String payLoad="";
				StringBuilder response= new StringBuilder(); 
				while((payLoad=input.readLine())!=null){
					
					response.append(payLoad);
				}
				
				return response.toString();
			}else{
				System.out.println(connection.getResponseMessage());
				return null;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args){
		WebServiceUtil wsUtil = new WebServiceUtil();
		wsUtil.callExternalService("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1", "GET");
		wsUtil.callExternalService("https://www.google.com", "GET");
		
	}

}
