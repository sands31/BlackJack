import java.util.Scanner;

public class Play {

	public static int drawOneCard() {
		int[] cardPackage = {1, 2, 3 , 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		int random = ((int)(Math.random() * (12)));
		int card = cardPackage[random];

		return card;
	}


	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);

		//Message d'accueil
		System.out.println("Do you want to play ?");

		System.out.println("Choose your option :");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int choice = sc.nextInt();

		//Début du jeu
		if (choice == 1) {

				//Tirage des cartes
			int playerCard_1 = drawOneCard();
			int playerCard_2 = drawOneCard();
			int playerScore = playerCard_1 + playerCard_2;


			int dealerCard_1 = drawOneCard();
			int dealerCard_2 = drawOneCard();
			int dealerScore = dealerCard_1 + dealerCard_2;
	
				//Affichage des résultats
			System.out.println("\nFIRST ROUND\n");
			System.out.println("Your score : " + playerScore);
			System.out.println("Dealer score : " + dealerCard_1);

			while (choice == 1) {
					//Continuer ?
				System.out.println("\nDo you want to take another card ?\n");
				System.out.println("Choose your option :");
				System.out.println("1. Yes");
				System.out.println("2. No\n");
				choice = sc.nextInt();

				if (choice == 1) {
					System.out.println("\nNEW ROUND\n");
					int playerCard_3 = drawOneCard();
					playerScore += playerCard_3;

					System.out.println("Your score : " + playerScore);
					System.out.println("Dealer score : " + dealerCard_1);

					if (playerScore > 21) {
						choice = 2;
					}
				} 
			} 
			//Comparaison des résultats
			if (playerScore > 21) {
				System.out.println("YOU LOOSE !");
			} else if (playerScore == 21) {
				System.out.println("BLACK JACK ! YOU WIN !");
			} else if (playerScore == dealerScore) {
				System.out.println("THIS IS A DRAW !"); 
			} else if (playerScore > dealerScore) {
				System.out.println("YOU WIN !");
			} else {
				System.out.println("YOU LOOSE !");	
			}
			System.out.println("\nSee you next time !");
			System.exit(0);

		//Fin du jeu (Intro)
		} else {
			System.out.println("\nBye !");
			System.exit(0);
		}

	}

}