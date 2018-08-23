This project is meant to play a game of Poker using the Deck of Cards API. 
This game is executed when you run the associated jar PokerWithTriNetX.jar. from
the command line.

The assumption taken place was that user may or may not want to play multiple games.
The user is also looking to only play to see the highest hand that he or she gets.

Also, the assumption was not include a Royal Flush as that is a Straight Flush. However,
if this logic was desired, the logic needed would be (as the cards are sorted from low to high) to verify if a User does have  a straight to check at the index of 4(as the list is sorted) if the card is an ACE. If so, set a boolean "flush" variable to true.

Also, the logic is there would be no Wild Cards and thus Five of a Kind would not be possible.

If there was time still alloted, I would have added tests that would have JSON of all 9 types of hands,covert all those to DealtHand POJOs and test the AnalyzePoker class to make sure the AnalysisPoker class would convert to the desired HashMaps and test the Highest Scoring Analysis