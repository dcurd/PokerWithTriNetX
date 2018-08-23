package com.poker.game.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HighestScoringAnalysis {
	
	HashMap<String,Integer> rankingOfCards=new HashMap<String,Integer>();
	public HighestScoringAnalysis(){
		loadCardRankings();
	}
	
	public String getHighestHand(HashMap<String,Integer> values, HashMap<String,Integer> suits){
		String highestHand="";
		switch(getMaximumRank(values)){
		case 4: highestHand= "Four of a Kind";
				break;
		case 3: highestHand=sortRankOfThree(values);
				break;
		case 2: highestHand=sortRankOfTwo(values);
				break;
		case 1: highestHand=sortRankOfOne(values,suits);
		}
			
		return highestHand;
	}
	
	
	private String sortRankOfThree(HashMap<String,Integer> cValues){
		if(cValues.values().contains(2)){
			return "Full House";
		}
		
		return "Three of a Kind";
	}
	
	private String sortRankOfTwo(HashMap<String,Integer> cValues){
		int i = 0;
		for(String key : cValues.keySet()){
			if(cValues.get(key)==2){
				i++;
			}
		}		
		if(i>1){
			return "Two Pair";
		}		
		return "One Pair";		
	}
	
	private String sortRankOfOne(HashMap<String,Integer> cValues, HashMap<String,Integer> suits){
		Boolean flush= suits.containsValue(5);
		Boolean straight=true;
		List<Integer> listOfCardValues=createNumericalRanking(cValues.keySet());
		Integer previousValue=listOfCardValues.get(0);
		for(int i=1;i<listOfCardValues.size();i++){
			previousValue++;
			if(listOfCardValues.get(i)!=previousValue){
				straight=false;
				break;
			}
			previousValue=listOfCardValues.get(i);
		}
		
		if(flush&&straight){
			return "Straight Flush";
		}else if(flush){
			return "Flush";
		}else if(straight){
			return "Straight";
		}
		
		return "High Card";
	}
	
	
	
	private Integer getMaximumRank(HashMap<String,Integer> values){
		Map.Entry<String,Integer> maximumEntry=null;
		
		for(Map.Entry<String, Integer> entry : values.entrySet() ){
			if(maximumEntry == null || entry.getValue().compareTo(maximumEntry.getValue())>0){
				maximumEntry=entry;
			}
		}
		
		return maximumEntry.getValue();
	}
	
	private List<Integer> createNumericalRanking(Set<String> keys){
		List<Integer> list = new ArrayList<Integer>();
		for(String key : keys){
			list.add(getCardRanking(key));
		}
		Collections.sort(list);
		return list;
	}
	
	
	private Integer getCardRanking(String value){
		
		return rankingOfCards.get(value);
	}
	private void loadCardRankings(){
		Integer i=0;
		rankingOfCards.put("2",++i);
		rankingOfCards.put("3",++i);
		rankingOfCards.put("4",++i);
		rankingOfCards.put("4",++i);
		rankingOfCards.put("5",++i);
		rankingOfCards.put("6",++i);
		rankingOfCards.put("7",++i);
		rankingOfCards.put("8",++i);
		rankingOfCards.put("9",++i);
		rankingOfCards.put("10",++i);
		rankingOfCards.put("JACK",++i);
		rankingOfCards.put("QUEEN",++i);
		rankingOfCards.put("KING",++i);
		rankingOfCards.put("ACE",++i);
	}

}
