import java.util.Scanner;
import java.lang.Exception;

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
			System.out.println(Functions.choiceLayout(1));
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter 1 or 2.");
			}
			
		}


		//Début du jeu
		if (choice == 1) {

			//Tirage des cartes joueur
			int playerCard_1 =Functions.drawOneCard();
			int playerCard_2 = Functions.drawOneCard();
			int playerScore = playerCard_1 + playerCard_2;

			//Tirage des cartes dealer
			int dealerCard_1 = Functions.drawOneCard();
			int dealerCard_2 = Functions.drawOneCard();
			int dealerScore = dealerCard_1 + dealerCard_2;

			if (dealerCard_2 == 1 && (dealerScore + 10) >=17 && (dealerScore + 10) <=21) {
				dealerScore += 10;
			}

			//Affichage des résultats du 1er tour
			int round = 1;
			System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   ROUND 1   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println(Functions.scoreLayout(1, playerScore, playerCard_1, playerCard_2, dealerScore, dealerCard_1));

			//Gestion des as éventuels
			if (playerCard_1 == 1) {
				choice = -1;
				while (choice != 1 && choice != 2) {
					System.out.println(Functions.choiceLayout(2));
					try {
						choice = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("Please enter 1 or 2.");
					}					
				}
				if (choice == 1) {
					playerCard_1 = 1;
				} else {
					playerCard_1 = 11;
					playerScore += 10;
				}
				System.out.println(Functions.scoreLayout(2, playerScore, playerCard_1, playerCard_2, dealerScore, dealerCard_1));
			} if (playerCard_2 == 1) {
				choice = -1;
				while (choice != 1 && choice != 2) {
					System.out.println(Functions.choiceLayout(2));
					try {
						choice = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("Please enter 1 or 2.");
					}					
				}
				if (choice == 1) {
					playerCard_2 = 1;
				} else {
					playerCard_2 = 11;
					playerScore += 10;
				}
				System.out.println(Functions.scoreLayout(2, playerScore, playerCard_1, playerCard_2, dealerScore, dealerCard_1));
			}

			//Tirer d'autres cartes ?
			while (choice == 1) {
				System.out.println("\nDo you want to take another card ?\n");
				choice = -1;
				while (choice != 1 && choice != 2) {
					System.out.println(Functions.choiceLayout(1));
					try {
						choice = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("Please enter 1 or 2.");
					}					
				}

				if (choice == 1) {
					round++;
					System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   ROUND " + round + "   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");

					//Nouvelle carte joueur
					int playerCard_3 = Functions.drawOneCard();
					playerScore += playerCard_3;

					if (playerCard_3 == 1) {
						choice = -1;
						while (choice != 1 && choice != 2) {
							System.out.println(Functions.choiceLayout(2));
							try {
								choice = Integer.parseInt(sc.nextLine());
							} catch (Exception e) {
								System.out.println("Please enter 1 or 2.");
							}					
						}
						if (choice == 1) {
							playerCard_3 = 1;
						} else {
							playerCard_3 = 11;
							playerScore += 10;
						}
						System.out.println(Functions.scoreLayout(3, playerScore, playerCard_1, playerCard_2, dealerScore, dealerCard_1));
					}

					//Nouvelle carte banque(todo si plus de 21)
					int dealerCard_3;
					while (dealerScore <= 16) {
						dealerCard_3 = Functions.drawOneCard();
						dealerScore += dealerCard_3;

						if (dealerScore >=21) {
							choice = 2;
						}
					}

					if (playerScore >= 21) {
						choice = 2;
					}
				} 
			} 
			//Comparaison des résultats
			if (playerScore > 21) {
				System.out.println("YOU LOOSE ! ");
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
			System.out.println(Functions.scoreLayout(4, playerScore, playerCard_1, playerCard_2, dealerScore, dealerCard_1));
			System.out.println("\nSee you next time !\n");

		//Fin du jeu
		}
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    BYE !    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.exit(0);
	}

}