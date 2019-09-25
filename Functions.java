public class Functions {

	public static int drawOneCard() {
	int[] cardPackage = {1, 2, 3 , 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	int random = ((int)(Math.random() * (12)));
	int card = cardPackage[random];

	return card;
	}

	/*public static String choose() {
	int choice = -1;
		while (choice != 1 && choice != 2) {
			System.out.println("Choose your option :");
			System.out.println("1. Yes");
			System.out.println("2. No");
			choice = sc.nextInt();
		}
	}*/

}