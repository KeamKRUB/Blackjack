public class Card
{
    public int[] deck = new int[52];
    private String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
    private String[] ranks = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "KING", "QUEEN"};
    private String currentSuit;
    private String currentRank;
    private int Rankvalue;
    
    private int currentIndex;
    
    public int getCurrentIndex(){
        return this.currentIndex;
    }
    public static int[] removeCardfromDeck(int[] arr, int index){
        if(arr == null || index < 0 || index >= arr.length){
            return arr;
        }
        else{
        int[] newDeck = new int[arr.length - 1];
        for(int i = 0, k = 0; i < arr.length; i++){
            if(i == index){
                continue;
            }
            else{
            newDeck[k++] = arr[i];
            }
        }
        return newDeck;
    }
    }
    
    public void nextCard(){
        this.currentIndex++;
    }
    
    public String getCurrentSuit(){
        return this.currentSuit;
    }
    
    public String getCurrentRank(){
        return this.currentRank;
    }
    public int getRankvalue(){
        return this.Rankvalue;
    }
    
    
    public int[] getDeck(){
        return this.deck;
    }
    
    public Card(){
        for(int i = 0; i < 52; i++){
            deck[i] = i;
        }
        this.currentIndex = 0;
    }
    
    public void shuffle(){
        for(int i = 0; i < 51; i++){
            int index = (int)(Math.random() * 52);
            int temp = deck[i];
            if(index != i){
                deck[i] = deck[index];
                deck[index] = temp;
            }
        }
        this.currentIndex = 0;
    }
    
    public void shuffle(int pCount){
        for(int i = 0; i < pCount; i++){
            int index = (int)(Math.random() * 52);
            
            int x = (int)(Math.random() * 52);
            int temp = deck[x];
            
            if(index != x){
                deck[x] = deck[index];
                deck[index] = temp;
            }
        }
    }
    public int getCard(int index){
        currentSuit = suits[deck[index] / 13];
        currentRank = ranks[deck[index] % 13];
        if(currentRank == "ACE"){
            Rankvalue = 1;
        }
        else if(currentRank == "JACK")
        {
            Rankvalue = 10;
        }
        else if(currentRank == "KING")
        {
            Rankvalue = 10;
        }
        else if(currentRank == "QUEEN")
        {
            Rankvalue = 10;
        }
        else{
            Rankvalue = Integer.parseInt(ranks[deck[index] % 13]);
        }
        deck = removeCardfromDeck(deck, 0);
        return deck[index];
    }
}