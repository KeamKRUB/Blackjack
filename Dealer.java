public class Dealer{
    int total = 0;
    Card objCard = new Card();
    public void Dealerstart(){
        System.out.println("The dealer's hand:");
        objCard.getCard(0);
        if(objCard.getRankvalue() == 1){
            System.out.println("Dealer has " + objCard.getCurrentSuit() + " of " + objCard.getCurrentRank() + " Total: " + "...");
            Game.delay();
            dealer_ace();
            System.out.println("The second card is face down");
        }
        else{
            total += objCard.getRankvalue();
            System.out.println("Dealer has " + objCard.getCurrentSuit() + " of " + objCard.getCurrentRank() + " Total: " + total);
            System.out.println("The second card is face down");
        }
    }
    public void Draw(){
        boolean more = true;
        
        objCard.getCard(0);
        System.out.println("Dealer show another card");
        if(objCard.getRankvalue() == 1){
            total += objCard.getRankvalue();
            System.out.println("Dealer has " + objCard.getCurrentSuit() + " of " + objCard.getCurrentRank() + " Total: ...");
            Game.delay();
            dealer_ace();
        }
        else{
            total += objCard.getRankvalue();
            System.out.println("Dealer has " + objCard.getCurrentSuit() + " of " + objCard.getCurrentRank() + " Total: " + total);
        }
        while(more){
            if(total < 17){
                Game.delay();
                
                System.out.println("Dealer get 1 card");
                objCard.getCard(0);
                if(objCard.getRankvalue() == 1){
                    System.out.println("Dealer has " + objCard.getCurrentSuit() + " of " + objCard.getCurrentRank() + " Total: ...");
                    dealer_ace();
                }
                else{                    
                    total += objCard.getRankvalue();
                    System.out.println("Dealer has " + objCard.getCurrentSuit() + " of " + objCard.getCurrentRank() + " Total: " + total);
                }
                
            }
            else{
                Game.delay();
                if(total < 21){
                    System.out.println("Dealer stand. Dealer has " + total + " points");
            }
                else{
                    System.out.println("Dealer has " + total + " points");
                }
                    return;
                }
            }
        }
        public void dealer_ace(){
                if(total > 10){
                    total += 1;
                    System.out.println("Dealer choose 1 point for ACE" + " Total: " + total);
                }
                else{
                    total += 11;
                    System.out.println("Dealer choose 1 point for ACE" + " Total: " + total);
                }
            }
    public void hasblackjack(){
        System.out.println("Dealer show another card");
        System.out.println("Dealer has " + objCard.getCurrentSuit() + " of " + objCard.getCurrentRank() + " Total: " + total);
        return;
    }
}

