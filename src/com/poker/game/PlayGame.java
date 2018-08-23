package com.poker.game;

import java.util.Scanner;

import com.poker.game.pojos.DealtHand;
import com.poker.game.services.AnalyzePoker;
import com.poker.game.services.IPlayPoker;
import com.poker.game.services.PlayPoker;

public class PlayGame {

	public PlayGame() {
		// TODO Auto-generated constructor stub
	}
	
	public Boolean play(){
		Boolean check=true;
		AnalyzePoker analyzePoker=new AnalyzePoker();
		Scanner scan=new Scanner(System.in);
		do{
			System.out.println("Enter START to Start a Game");

			String input=scan.nextLine();
			if(input.toUpperCase().equals("START")){
				check=false;
			}
		}while(check);		
		IPlayPoker poker=new PlayPoker();
		DealtHand dh = poker.deal();
		if(dh!=null){
			String highestHand=analyzePoker.getHighestScoringHand(dh);
			System.out.println("Highest Hand is "+highestHand);
		}else{
			System.out.println("Something went wrong, please try again");
			return false;
		}
		
		System.out.println("Want to play again? Enter YES if so");
		String response=scan.nextLine();
		if(response.toUpperCase().equals("YES")){
			return true;
		}
		return false;
				
	}
	


}
