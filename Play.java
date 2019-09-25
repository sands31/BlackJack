import java.util.Scanner;

public class Play {


	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);

		//Message d'accueil
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WILD-BLACK-JACK~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("\nDo you want to play ?\n");

		
		int choice = -1;
		while (choice != 1 && choice != 2) {
			System.out.println("Choose your option :");
			System.out.println("1. Yes");
			System.out.println("2. No");
			choice = sc.nextInt();
		}


		//Début du jeu
		if (choice == 1) {

				//Tirage des cartes joueur
			int playerCard_1 = Functions.drawOneCard();
			int playerCard_2 = Functions.drawOneCard();
			int playerScore = playerCard_1 + playerCard_2;

				//Tirage des cartes dealer
			int dealerCard_1 = Functions.drawOneCard();
			int dealerCard_2 = Functions.drawOneCard();
			int dealerScore = dealerCard_1 + dealerCard_2;

			if (dealerCard_2 == 1 && (dealerScore + 10) >=17 && (dealerScore + 10) <=21) {
				dealerScore += 10;
			}

				//Affichage des résultats
			int round = 1;
			System.out.println("\nFIRST ROUND\n");
			System.out.println("Your score : " + playerScore + " (" + playerCard_1 + " + " + playerCard_2 + ")");
			System.out.println("Dealer score : "+ dealerScore +" (" + dealerCard_1 + " + " + dealerCard_2 + ")");

			if (playerCard_1 == 1) {
				System.out.println("\nYou've got an ace ! Do you want to change your ace to  1 or 11 ?");
				System.out.println("Choose your option :");
				System.out.println("1. Ace = 1");
				System.out.println("2. Ace = 11");
				int ace_choice = sc.nextInt();
				if (ace_choice == 1) {
					playerCard_1 = 1;
				} else {
					playerCard_1 = 11;
					playerScore += 10;
				}
				System.out.println("\nActualisation du score\n");
				System.out.println("Your score : " + playerScore + " (" + playerCard_1 + " + " + playerCard_2 + ")");
				System.out.println("Dealer score : " + dealerScore +" (" + dealerCard_1 + " + " + dealerCard_2 + ")");
			} else if (playerCard_2 == 1) {
				System.out.println("\nYou've got an ace ! Do you want to change your ace to  1 or 11 ?");
				System.out.println("Choose your option :");
				System.out.println("1. Ace = 1");
				System.out.println("2. Ace = 11");
				int ace_choice = sc.nextInt();
				if (ace_choice == 1) {
					playerCard_2 = 1;
				} else {
					playerCard_2 = 11;
					playerScore += 10;
				}
				System.out.println("\nActualisation du score\n");
				System.out.println("Your score : " + playerScore + " (" + playerCard_1 + " + " + playerCard_2 + ")");
				System.out.println("Dealer score : " + dealerScore +" (" + dealerCard_1 + " + " + dealerCard_2 + ")");
			}

			while (choice == 1) {
					//Continuer ?
				System.out.println("\nDo you want to take another card ?\n");
				System.out.println("Choose your option :");
				System.out.println("1. Yes");
				System.out.println("2. No\n");
				choice = sc.nextInt();

				if (choice == 1) {
					round++;
					System.out.println("\nROUND " + round + "\n");

					//Nouvelle carte joueur
					int playerCard_3 = Functions.drawOneCard();
					playerScore += playerCard_3;

					if (playerCard_3 == 1) {
						System.out.println("\nYou've got an ace ! Do you want to change your ace to  1 or 11 ?");
						System.out.println("Choose your option :");
						System.out.println("1. Ace = 1");
						System.out.println("2. Ace = 11");
						int ace_choice = sc.nextInt();
						if (ace_choice == 1) {
							playerCard_3 = 1;
						} else {
							playerCard_3 = 11;
							playerScore += 10;
						}
						System.out.println("\nActualisation du score\n");
						System.out.println("Your score : " + playerScore);
						System.out.println("Dealer score : " + dealerScore);
					}

					//Nouvelle carte banque
					int dealerCard_3;
					while (dealerScore <= 16) {
						dealerCard_3 = Functions.drawOneCard();
						dealerScore += dealerCard_3;

						if (dealerScore >=21) {
							choice = 2;
							break;
						}
					}

					System.out.println("Your score : " + playerScore);
					System.out.println("Dealer score : " + dealerScore);

					if (playerScore >= 21) {
						choice = 2;
					}
				} 
			} 
			//Comparaison des résultats
			if (playerScore > 21) {
				System.out.println("YOU LOOSE !");
			} else if (dealerScore > 21) {
				System.out.println("YOU WIN !");
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

		//Fin du jeu (Intro)
		} else {
			System.out.println("\nBye !");		
		}
		System.exit(0);
	}

}