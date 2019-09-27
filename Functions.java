public class Functions {

	public static int drawOneCard() {
	int[] cardPackage = {1, 2, 3 , 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	int random = ((int)(Math.random() * (12)));
	int card = cardPackage[random];

	return card;
	}

	public static String choiceLayout(int choiceType) {
		if (choiceType == 1)
			return "Choose your number option : \n1. Yes\n2. No\n";
		else
			return "\nYou've got an ace ! Do you want to change your ace to  1 or 11 ?\nChoose your number option : \n1. Ace = 1\n2. Ace = 11\n";
	}

	public static String scoreLayout(int scoreLayoutType, int playerScore, int playerCard_1, int playerCard_2, int dealerScore, int dealerCard_1) {
		if (scoreType == 1)
			return "\nYour score : " + playerScore + " (" + playerCard_1 + " + " + playerCard_2 + ")\nDealer score : ? (" + dealerCard_1 + " + ?)";
		else if (scoreType == 2)
			return "\nScore update\n\nYour score : " + playerScore + " (" + playerCard_1 + " + " + playerCard_2 + ")\nDealer score : ? (" + dealerCard_1 + " + ?)";
		else if (scoreType == 3)
			return "\nScore update\nYour score : " + playerScore + "\n" + "Dealer score : " + dealerScore;
		else
			return "\nYour score : " + playerScore + "\n" + "Dealer score : " + dealerScore;
	}
}