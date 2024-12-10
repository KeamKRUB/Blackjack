import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    Scanner input = new Scanner(System.in);
    boolean ace = true;
    int ace_d = 0;
    int total = 0;
    private int wins, losses, draws, blackjacks;
    public static void main(String args[]){
        Game blacklist = new Game();
    }
    public Game(){
        start();
    }
    public void start(){
        ace = true;
        total = 0;
        int player_d = 0;
        int player_r = 0;
        boolean getNum = true;
        boolean end = false;
        System.out.println("-------------Blackjack Game-------------");
        System.out.println("Blackjack: " + blackjacks + " Win: " + wins + " Lose: " + losses + " Draw: " + draws + "\n");
        Dealer Dealer = new Dealer();
        int i = 0;  
        Card objCard = Dealer.objCard;
        objCard.shuffle(20);
        Dealer.Dealerstart();
        delay();
        System.out.println("Dealer give you 2 cards");
        for(i = 0; i < 2; i++){
            objCard.getCard(0);        
            if(objCard.getRankvalue() == 1){
                System.out.println("You have " + objCard.getCurrentSuit() + " of " + objCard.getCurrentRank() + " Total: ...");
                player_ace();
            }
            else{
                total += objCard.getRankvalue();
                System.out.println("You have " + objCard.getCurrentSuit() + " of " + objCard.getCurrentRank() + " Total: " + total);
            }
        }
        if(total == 21){
            System.out.println("Black Jack. You win!");
            end = true;
            getNum = false;
            wins++;
            blackjacks++;
        }
        if(Dealer.total == 21){
            delay();
            Dealer.hasblackjack();
            System.out.println("Dealer has Black Jack. Dealer win!");
            end = true;
            losses++;
        }
        else{
            while(getNum){
                try{
                    System.out.println("Choose: 1) Hit 2) Stand");
                    player_d = input.nextInt();
                    getNum = false;
                }
                catch(Exception e){
                    System.out.println("Invalid");
                    input.nextInt();
                }
            if (player_d == 1) {
                delay();
                i++;
                objCard.getCard(0);
                System.out.println("Dealer give you 1 card");
                if(objCard.getRankvalue() == 1){
                    System.out.println("You have " + objCard.getCurrentSuit() + " of " + objCard.getCurrentRank() + " Total: " + "...");
                    player_ace();
                }
                else{
                    total += objCard.getRankvalue();
                    System.out.println("You get " + objCard.getCurrentSuit() + " of " + objCard.getCurrentRank() + " Total : " + total);
                    if(total < 21){
                        getNum = true;
                    }
                    else if(total == 21){
                        delay();
                        System.out.println("Black Jack. You win!");
                        wins++;
                        getNum = false;
                        end = true;
                        blackjacks++;
                    }
                    else{
                        delay();
                        System.out.println("More than 21. You lose!");
                        losses++;
                        getNum = false;
                        end = true;
                    }
                }
            }
            else if(player_d == 2){
                System.out.println("You stand. You have " + total + " points");
                Dealer.Draw();
                delay();
                if(Dealer.total == 21){
                    System.out.println("Dealer has Black Jack. Dealer win!");
                    losses++;
                    end = true;
                }
                else if(Dealer.total > 21){
                    System.out.println("Dealer has more than 21. You win!");
                    wins++;
                    end = true;
                }
                else if(Dealer.total > total){
                    System.out.println("You lose!");
                    losses++;
                    end = true;
                }
                else if(Dealer.total == total){
                    System.out.println("You both get the same score. Draw!");
                    draws++;
                    end = true;
                }
                else{
                    System.out.println("You win!");
                    wins++;
                    end = true;
                }
            }
            else{
                System.out.println("Invalid");
                getNum = true;
            }
        }
    }
    while(end){
        try{
            System.out.println("Choose: 1) Reset 2) Exit");
            player_r = input.nextInt();
            end = false;
        }
        catch(Exception e){
            System.out.println("Invalid");
            input.nextInt();
        }
        if (player_r == 1) {
            System.out.println("Wait for the dealer to shuffle cards...");
            reset();
            start();
        }
        else if(player_r == 2){
            end = false;
            System.out.println("Thanks for playing. Good bye!");
        }
        else{
            System.out.println("Invalid");
            end = true;
        }
    }
    }
        public void player_ace(){
            while(ace){
                try{
                    System.out.println("Ace Point: 1) 1 point 2) 11 points");
                    ace_d = input.nextInt();
                }
                catch(Exception e){
                    System.out.println("Invalid");
                    input.nextInt();
                } 
                if(ace_d == 1){
                    total += 1;
                    System.out.println("You choose 1 point for ACE" + " Total: " + total);
                    ace = false;
                }
                else if(ace_d == 2){
                    total += 11;
                    System.out.println("You choose 11 points for ACE" + " Total: " + total);
                    ace = false;
                }
                else{
                    System.out.println("Invalid");
                }
            }
        }
        public static void delay(){
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        public static void reset(){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
