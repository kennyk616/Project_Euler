import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * poker hands
 * http://projecteuler.net/problem=54
 * @author ken
 *
 */

class Card implements Comparable<Card>{
	int val;
	char suit;
	public Card(String s){
		this.suit = s.charAt(1);
	
		if (s.charAt(0)>='1' && s.charAt(0)<='9'){
			this.val = s.charAt(0) - '0';
		} else if (s.charAt(0)=='T'){
			this.val = 10;
		} else if (s.charAt(0)=='J'){
			this.val = 11;
		} else if (s.charAt(0)=='Q'){
			this.val = 12;
		} else if (s.charAt(0)=='K'){
			this.val = 13;
		} else if (s.charAt(0)=='A'){
			this.val = 14;
		}
		
	}
	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	} 
}

class Hand implements Comparable<Hand>{
	
	final static int handSize = 5;
	
	Card[] hand;
	int[] handType;
	
	public Hand(String[] cards){
		hand = new Card[handSize];
		for (int i = 0; i<handSize; i++){
			hand[i] = new Card(cards[i]);
		}
		
		Arrays.sort(hand);
		
		handType = handType();
	}
	/*
	 * {x, y}
	 * x refers to the ranks:
	 * 1: high card. y = highest card		-done
	 * 2. one pair. y = pair				-done
	 * 3. two pairs. y = pair				-done
	 * 4. three of a kind. y = triple		-done
	 * 5. straight. y = highest card		-done
	 * 6. flush. y = highest card			-done
	 * 7. full house. y = triple			-done	
	 * 8. four of a kind. y = four			-done
	 * 9. straight flush. y = highest card	-done
	 * 10. royal flush. y = highest card	-done
	 */
	private int[] handType() {
		boolean isFlush = isFlush();
		boolean isStraight = isStraight();
		int[] type = new int[2];
		
		// is straight flush or royal flush (9, 10)
		if (isFlush && isStraight){
			if (hand[handSize-1].val ==14 && hand[0].val == 10){
				type[0] = 10;
			}else {
				type[0] = 9;
			}
			type[1] = hand[handSize-1].val;
			return type;
		}
		// is straight (5)
		if (isStraight){
			type[0] = 5;
			type[1] = hand[handSize-1].val;
			return type;
		}
		//is flush (6)
		if (isFlush) {
			type[0] = 6;
			type[1] = hand[handSize-1].val;
			return type;
		}
		
		int[] count = calculateCount();
		for (int i = 0; i<count.length; i++){
			//four-of-a-kind (8)
			if (count[i]==4){
				type[0] = 8;
				type[1] = i;
				return type;
			}
			
			if (count[i]==3){
				for (int j = 0; j<count.length; j++){
					if (count[j]==2){
						//full-house (7)
						type[0] = 7;
						type[1] = i;
						return type;
					}
				}
				//three-of-a-kind (4)
				type[0] = 4;
				type[1] = i;
				return type;
			}
		}
			
		for (int i = 0; i<count.length; i++) {
			if (count[i]==2){
				for (int j = i+1; j<count.length; j++){
					if (count[j]==2) {
						//two-pair(3)
						type[0] = 3;
						type[1] = Math.max(i,  j);
						return type;
					}
				}
				//pair (2)
				type[0] = 2;
				type[1] = i;
				return type;
			}
		}
		// single (1)
		type[0] = 1;
		type[1] = hand[handSize-1].val;
		return type;
		
	}
	
	private int[] calculateCount(){
		int[] count = new int[15];
		for (Card c : hand){
			count[c.val]++;
		}
		return count;
	}
	
	private boolean isFlush(){
		for (Card c : hand){
			if (c.suit!=hand[0].suit){
				return false;
			}
		}
		return true;
	}
	
	private boolean isStraight(){
		for (int i = 1; i<handSize; i++){
			if (hand[i].val==14 && hand[i-1].val ==5){
				continue;
			}
			if (hand[i].val - hand[i-1].val !=1){
				return false;
			}
		}
		return true;
	}
	
	private int compareSingles(Hand o){
		for (int i = handSize-1; i>=0; i--){
			int val = hand[i].val;
			int other = o.hand[i].val;
			if (val != other){
				return val - other;
			}
		}
		return 0;
	}
	
	private int comparePairs(Hand o){
		int pair = handType[1];
		int pairOther = o.handType[1];
		if (pair != pairOther){
			return pair - pairOther;
		}
		
		int[] compare = new int[3];
		int[] compareOther = new int[3];
		int idx = 0;
		int idxO = 0;
		for (int i = hand.length-1; i>=0; i--){
			if (hand[i].val!=pair){
				compare[idx] = hand[i].val;
				idx++;
			}
			if (o.hand[i].val!=pair){
				compareOther[idxO] = o.hand[i].val;
				idxO ++;
			}
		}
		
		for (int i =0; i<3; i++){
			if (compare[i]!=compareOther[i]){
				return compare[i] - compareOther[i];
			}
		}
		
		
		return 0;
	}
	
	private int compareDoublePair(Hand o) {
		int pair = handType[1];
		int pairOther = o.handType[1];
		if (pair != pairOther){
			return pair - pairOther;
		}
		
		int[] count = calculateCount();
		int[] countOther = o.calculateCount();
		int pair2 = 0;
		int pair2Other = 0;
		int single = 0;
		int singleOther = 0;
		
		for (int i = 0; i<count.length; i++){
			if (count[i]==2 && i!=pair){
				pair2 = i;
			}
			if (countOther[i]==2 && i!=pair){
				pair2Other = i;
			}
			
			if (count[i]==1){
				single = i;
			}
			
			if (countOther[i]==1){
				singleOther = i;
			}
		}
		
		if (pair2 != pair2Other){
			return pair2 - pair2Other;
		}
		
		
		return single - singleOther;
	}
	
	
	@Override
	public int compareTo(Hand o) {
		// TODO Auto-generated method stub
		if (this.handType[0]==o.handType[0]){
			if (this.handType[0]>=4 && this.handType[0]<=9){
				return this.handType[1] - o.handType[1];
			}else {
				if (this.handType[0]==1){
					return compareSingles(o);
				}else if (this.handType[0]==2){
					return comparePairs(o);
				}else {
					return compareDoublePair(o);
				}
			}
		} else{
			return this.handType[0] - o.handType[0];
		}
	}
	
}


public class Problem054 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = 1000;
		int count = 0;
		int handSize = 5;
		BufferedReader br = new BufferedReader(new FileReader("poker.txt"));
		for (int i = 0; i<n; i++){
			String[] play = br.readLine().split(" ");
			Hand playerA = new Hand(Arrays.copyOfRange(play, 0, handSize));
			Hand playerB = new Hand(Arrays.copyOfRange(play, handSize, handSize*2));
			
			if (playerA.compareTo(playerB)>0){
				count++;
			}
		}
		
		System.out.println(count);
		br.close();
		System.exit(0);
		
	}

}
