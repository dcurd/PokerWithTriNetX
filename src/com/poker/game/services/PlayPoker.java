package com.poker.game.services;

import com.google.gson.Gson;
import com.poker.game.pojos.Card;
import com.poker.game.pojos.DealtHand;
import com.poker.game.utilities.WebServiceUtil;

public class PlayPoker implements IPlayPoker {

	
	
	@Override
	public DealtHand deal() {
		WebServiceUtil ws=new WebServiceUtil();
		String json=ws.callExternalService("https://deckofcardsapi.com/api/deck/new/draw/?count=5", "GET");
		if(json!=null || json ==""){
			Gson gson=new Gson();
			DealtHand dh= gson.fromJson(json, DealtHand.class);
			printHand(dh);
			return dh;
		}else{
			System.out.println("Issue with WebService request");
		}
		
		return null;
	}
	
	private void printHand(DealtHand dh){
		for(Card card : dh.getCards()){
			System.out.println(card.getValue()+" of "+ card.getSuit());
		}
	}
	

}
