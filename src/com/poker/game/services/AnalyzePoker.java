package com.poker.game.services;

import java.util.HashMap;

import com.poker.game.analysis.HighestScoringAnalysis;
import com.poker.game.pojos.Card;
import com.poker.game.pojos.DealtHand;

public class AnalyzePoker {
	
	
	public AnalyzePoker(){
		
	}
	
	public String getHighestScoringHand(DealtHand dh){
		HighestScoringAnalysis hs=new HighestScoringAnalysis();
		
		return hs.getHighestHand(analyzeValues(dh),analyzeSuits(dh) );
	}
	
	private HashMap<String,Integer> analyzeSuits(DealtHand dh){
		HashMap<String,Integer> results=new HashMap<String,Integer>();
		for(Card card: dh.getCards()){
			if(results.containsKey(card.getSuit())){
				Integer value= results.get(card.getSuit());
				value++;
				results.put(card.getSuit(), value);
			}else{
				results.put(card.getSuit(), 1);
			}
		}
		
		return results;
		
	}
	
	private HashMap<String,Integer> analyzeValues(DealtHand dh){
		HashMap<String,Integer> results=new HashMap<String,Integer>();
		for(Card card: dh.getCards()){
			if(results.containsKey(card.getValue())){
				Integer value= results.get(card.getValue());
				value++;
				results.put(card.getValue(), value);
			}else{
				results.put(card.getValue(), 1);
			}
		}
		
		return results;
		
	}

	
	

}
