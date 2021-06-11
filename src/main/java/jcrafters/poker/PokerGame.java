package jcrafters.poker;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerGame {
	public String playGame(String blackHand, String whiteHand) {
		if(StringUtils.isAnyBlank(blackHand, whiteHand)){
			throw new IllegalArgumentException("Both hands must contain cards");
		}
		if(blackHand.split(" ").length != 5 || whiteHand.split(" ").length != 5){
			throw new IllegalArgumentException("Each hand should contain five card inputs");
		}
		List<String> errors = validateCards(blackHand, whiteHand);
		if(!errors.isEmpty()){
			throw new IllegalArgumentException("One or more cards are invalid: " + errors);
		}


		List<Card> blackHandCards = createCardsForHand(blackHand, errors);
		List<Card> whiteHandCards = createCardsForHand(whiteHand, errors);

		Card blackHighestCard = getHighestCard(blackHandCards);
		Card whiteHighestCard = getHighestCard(whiteHandCards);

		if(blackHighestCard.isHigherThan(whiteHighestCard)){
			return "Black wins - high card: " + blackHighestCard.getValueName();
		}else {
			return "White wins - high card: " + whiteHighestCard.getValueName();
		}
	}

	private Card getHighestCard(List<Card> handCards) {
		return handCards.stream()
				.max((card1, card2) -> card1.isHigherThan(card2) ? 1 : card1.equals(card2) ? 0 : -1)
				.get();
	}

	private List<String> validateCards(String blackHand, String whiteHand) {
		List<String> errors = new ArrayList<>();

		for (String s : ArrayUtils.addAll(blackHand.split(" "), whiteHand.split(" "))) {
			try {
				new Card(s);
			} catch (IllegalArgumentException ex) {
				errors.add(s + " : " + ex.getMessage());
			}
		}
		return errors;
	}

	private List<Card> createCardsForHand(String whiteHand, List<String> errors) {
		List<Card> result = new ArrayList<>();
		for (String s : whiteHand.split(" ")) {
			try {
				result.add(new Card(s));
			} catch (IllegalArgumentException ex) {
				errors.add(s + " : " + ex.getMessage());
			}
		}
		return result;
	}

}
