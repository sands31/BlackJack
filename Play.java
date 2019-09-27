import java.util.Scanner;
import java.lang.Exception;

public class Play {


	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);

		//Message d'accueil
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WILD-BLACK-JACK~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println("--------------------------------------------------------------------------------------------------");

		//Commencer le jeu ?		
		System.out.println("\nAre you ready ?\n");		
		int choice = -1;
		while (choice != 1 && choice != 2) {
			System.out.println(Functions.choiceLayout(1));
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("\nPlease enter 1 or 2 !");
			}	
		}

		//Début du jeu
		if (choice == 1) {

			int[] playerGame = new int [4];
			int[] dealerGame = new int [4];

			//Tirage des cartes joueur
			playerGame[1] = Functions.drawOneCard();
			playerGame[2] = Functions.drawOneCard();
			playerGame[0] = playerGame[1] + playerGame[2];

			//Tirage des cartes dealer
			dealerGame[1] = Functions.drawOneCard();
			dealerGame[2] = Functions.drawOneCard();
			dealerGame[0] = dealerGame[1] + dealerGame[2];

			if (dealerGame[1] == 1 && (dealerGame[0] + 10) >=17 && (dealerGame[0] + 10) <=21) {
				dealerGame[0] += 10;
			}
			if (dealerGame[2] == 1 && (dealerGame[0] + 10) >=17 && (dealerGame[0] + 10) <=21) {
				dealerGame[0] += 10;
			}

			//Affichage des résultats du 1er tour
			int round = 1;
			System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   ROUND " + round + "   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
			System.out.println(Functions.scoreLayout(1, playerGame[0], playerGame[1], playerGame[2], dealerGame[0], dealerGame[1]));

			//Gestion des as éventuels
			for (int i = 1; i < 3; i++) {
				if (playerGame[i] == 1) {
					int ace_choice = -1;
					while (ace_choice != 1 && ace_choice != 2) {
						System.out.println(Functions.choiceLayout(2));
						try {
							ace_choice = Integer.parseInt(sc.nextLine());
						} catch (Exception e) {
							System.out.println("Please enter 1 or 2.");
						}
					}					
				
					if (ace_choice == 1) {
						playerGame[i] = 1;
					} else {
						playerGame[i] = 11;
						playerGame[0] += 10;
					}
					System.out.println(Functions.scoreLayout(2, playerGame[0], playerGame[1], playerGame[2], dealerGame[0], dealerGame[1]));
				}		
			}

			if (playerGame[0] == 21) {
				choice = 2;
			}

			//Faire un tour suppmémentaire (en boucle) ?
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

				//Tour supplémentaire
				if (choice == 1) {
					round++;
					System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   ROUND " + round + "   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");

					//Nouvelle carte joueur
					playerGame[3] = Functions.drawOneCard();
					playerGame[0] += playerGame[3];

						//Gestion de l'as
					if (playerGame[3] == 1) {
						int ace_choice = -1;
						while (ace_choice != 1 && ace_choice != 2) {
							System.out.println(Functions.choiceLayout(2));
							try {
								ace_choice = Integer.parseInt(sc.nextLine());
							} catch (Exception e) {
								System.out.println("Please enter 1 or 2.");
							}					
						}
						if (ace_choice == 1) {
							playerGame[3] = 1;
						} else {
							playerGame[3] = 11;
							playerGame[0] += 10;
						}
					}

					//Nouvelles cartes banque
					while (dealerGame[0] <= 16) {
						dealerGame[3] = Functions.drawOneCard();
						dealerGame[0] += dealerGame[3];

						if (dealerGame[0] >=21) {
							choice = 2;
						}
					}

					if (playerGame[0] >= 21) {
						choice = 2;
					}
					
					//Affichage score final
					System.out.println(Functions.scoreLayout(4, playerGame[0], playerGame[1], playerGame[2], dealerGame[0], dealerGame[1]));
				} 
			}

			//Comparaison des résultats
			System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   FINAL SCORE   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
			if (playerGame[0]> 21) {
				System.out.println("YOU LOOSE ! You've reached 21 first...\n");
			} else if (dealerGame[0] > 21) {
				System.out.println("YOU WIN ! The dealer has reached 21 first\n");
			} else if (playerGame[0] == dealerGame[0]) {
				System.out.println("THIS IS A DRAW !\n");
			} else if (playerGame[0] == 21) {
				System.out.println("BLACK JACK ! YOU WIN !\n");
			} else if (playerGame[0] > dealerGame[0]) {
				System.out.println("YOU WIN !\n");
			} else {
				System.out.println("YOU LOOSE !\n");	
			}
			
			//Affichage score final
			System.out.println(Functions.scoreLayout(4, playerGame[0], playerGame[1], playerGame[2], dealerGame[0], dealerGame[1]));

			//Rejouer ?
			System.out.println("\nDo you want to play again ?\n");		
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
				Play.main(args);
			}


		//Fin du jeu
		}
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    BYE !    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.exit(0);
	}
}