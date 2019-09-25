public class Functions {

	public static int drawOneCard() {
	int[] cardPackage = {1, 2, 3 , 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	int random = ((int)(Math.random() * (12)));
	int card = cardPackage[random];

	return card;
	}
}