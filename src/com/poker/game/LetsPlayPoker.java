package com.poker.game;

import java.util.Scanner;



public class LetsPlayPoker {


	public static void main(String[] args) {
		System.out.println("Welcome to Let's Play Poker!");
		Scanner scan = new Scanner(System.in);
		PlayGame playGame=new PlayGame();
		Boolean response=false;
		do{
			response=playGame.play();
		}while(response);
		scan.nextLine();
		scan.close();
	}

}
