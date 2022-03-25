package cardGames;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Deck d = new Deck();
        d.shuffle();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How much would you like to bet?");
        int bet = sc.nextInt();
        
        Hand dealer = new Hand();
        Hand player = new Hand();
        
        Card dc1 = d.dealCard();
        dc1.flip();
        Card dc2 = d.dealCard();
        dealer.addCard(dc1);
        dealer.addCard(dc2);
        System.out.println("The dealer's first card is a: " + dc1.toString());
        
        Card pc1 = d.dealCard();
        pc1.flip();
        Card pc2 = d.dealCard();
        pc2.flip();
        player.addCard(pc1);
        player.addCard(pc2);
        System.out.println("You were dealt: " + pc1.toString() + " and " + pc2.toString() + "\n" + "The value of your hand is: " + player.value());
        
        dc2.flip();
        boolean playerBust = false;
        if (player.value() == 21 && dealer.value() != 21) {
    		System.out.println("The value of the dealer's hand is: " + dealer.value());
    		System.out.println("CONGRATULATIONS! You have won R" + 3*bet);
    		System.exit(0);
    	}

        System.out.println("Press 1 to HIT or 0 to STAND");
        int response = sc.nextInt();
        while (response == 1) {
        	Card pc3 = d.dealCard();
        	pc3.flip();
        	player.addCard(pc3);
        	System.out.println("You were dealt a " + pc3.toString());
        	if (player.value() <= 21)
        		System.out.println("The value of your hand is: " + player.value());
        	else {
        		System.out.println("BUST! Your hand has a value of " + player.value());
        		playerBust = true;
        		break;
        	}
        	System.out.println("Press 1 to HIT or 0 to STAND");
        	response = sc.nextInt();
        }
        	System.out.println("The second card in the dealer's hand is a " + dc2.toString());
        	while (dealer.value() < 16) {
        		Card dc3 = d.dealCard();
        		dc3.flip();
        		System.out.println("The dealer was dealt a " + dc3.toString());
        		dealer.addCard(dc3);
        	}
        	boolean dealerBust = false;
        	if (dealer.value() > 21) {
        		dealerBust = true;
        	}
        	
        	if (dealerBust == true && playerBust == false) {
        		System.out.println("The dealer BUST!");
        		System.out.println("Congratulations!! You WIN R" + 3*bet);
        	} else if (dealerBust == false && playerBust == true) {
        		System.out.println("YOU LOSE");
        	} else if (player.value() > dealer.value()) {
        		System.out.println("Congratulations!! You WIN R" + 3*bet);
        		System.out.println("Your hand: " + player.value());
        		System.out.println("Dealer's hand: " + dealer.value());
        	} else if (player.value() == dealer.value())
        		System.out.println("DRAW");
        	else
        		System.out.println("YOU LOSE");
        
        
    }
}

