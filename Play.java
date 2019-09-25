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
		System.out.println("Votre score est de " + playerScore);
		System.out.println("La banque a un score de " + dealerCard_1);

			//Continue ?
		System.out.println("Do you want to take another card ?");
		System.out.println("Choose your option :");
		System.out.println("1. Yes");
		System.out.println("2. No");
		choice = sc.nextInt();

				//Continuer
			if (choice == 1) {
				System.out.println("jouer encore");
				int playerCard_3 = drawOneCard();
				playerScore += playerCard_3;

				System.out.println("Votre score est de " + playerScore);
				System.out.println("La banque a un score de " + dealerCard_1);


				if (playerScore < 21) {
					System.out.println("Do you want to take another card ?");
					System.out.println("Choose your option :");
					System.out.println("1. Yes");
					System.out.println("2. No");
					choice = sc.nextInt();
				} else if (playerScore == 21) {
					System.out.println("Player score: " + playerScore);
					System.out.println("Dealer score: " + dealerScore);
					System.out.println("You win !");
				} else {
					System.out.println("Your score is over than 21 !");
					System.out.println("You loose !");
				}



				//Stop
			} else {
				System.out.println("Comparaison des résultats");
				if (playerScore > dealerScore) {
					System.out.println("Player score: " + playerScore);
					System.out.println("Dealer score: " + dealerScore);
					System.out.println("You win !");
				} else {
					System.out.println("Player score: " + playerScore);
					System.out.println("Dealer score: " + dealerScore);
					System.out.println("You loose !");
					
				}


			}
		System.out.println("Aurevoir");
		System.exit(0);


		//Message de sortie
		} else {
			System.out.println("Aurevoir");
			System.exit(0);
		}

	}


}