package jcrafters.poker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PokerGameTest {

	@Test
	void playGame_withInvalidInput_NullOrEmpty_ShouldThrowIllegalArgumentException() {
		PokerGame pokerGame = new PokerGame();

		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame(null,null)).withMessage("Both hands must contain cards");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("2H",null)).withMessage("Both hands must contain cards");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame(null,"2H")).withMessage("Both hands must contain cards");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("",null)).withMessage("Both hands must contain cards");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame(null,"")).withMessage("Both hands must contain cards");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("","")).withMessage("Both hands must contain cards");
	}

	@Test
	void playGame_withInvalidInput_fiveCards_ShouldThrowIllegalArgumentException() {
		PokerGame pokerGame = new PokerGame();

		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("xx", "xx xx xx xx xx")).withMessage("Each hand should contain five card inputs");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("xx xx", "xx xx xx xx xx")).withMessage("Each hand should contain five card inputs");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("xx xx xx", "xx xx xx xx xx")).withMessage("Each hand should contain five card inputs");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("xx xx xx xx", "xx xx xx xx xx")).withMessage("Each hand should contain five card inputs");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("xx xx xx xx xx", "xx")).withMessage("Each hand should contain five card inputs");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("xx xx xx xx xx", "xx xx")).withMessage("Each hand should contain five card inputs");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("xx xx xx xx xx", "xx xx xx")).withMessage("Each hand should contain five card inputs");
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("xx xx xx xx xx", "xx xx xx xx ")).withMessage("Each hand should contain five card inputs");
	}

	@Test
	void playGame_withInvalidInput_NoCard_ShouldThrowIllegalArgumentException() {
		PokerGame pokerGame = new PokerGame();
		assertThatIllegalArgumentException().isThrownBy(() -> pokerGame.playGame("2H 3H 4H 5H 1H", "2S 3S 4X 5S 6S")).withMessage("One or more cards are invalid: [1H : Illegal value, 4X : Illegal suit]");
	}

	@Test
	void playGame_HighCardWins() {
		PokerGame pokerGame = new PokerGame();
//		Input: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH
//		Output: White wins - high card: Ace
		assertThat(pokerGame.playGame("2H 3D 5S 9C KD", "2C 3H 4S 8C AH")).isEqualTo("White wins - high card: Ace");
		assertThat(pokerGame.playGame("2H 3D 5S 9C KD", "2C 3H 4S 8C 9H")).isEqualTo("Black wins - high card: King");
	}
}