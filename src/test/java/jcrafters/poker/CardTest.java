package jcrafters.poker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CardTest {

	@Test
	void cardAllowedValues() {
		assertThatCode(() -> new Card("2H")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("3H")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("4H")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("5H")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("6H")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("7H")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("8H")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("9H")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("TH")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("JH")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("QH")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("KH")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("AH")).doesNotThrowAnyException();
		
		assertThatCode(() -> new Card("2C")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("3C")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("4C")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("5C")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("6C")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("7C")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("8C")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("9C")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("TC")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("JC")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("QC")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("KC")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("AC")).doesNotThrowAnyException();	
		
		assertThatCode(() -> new Card("2D")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("3D")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("4D")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("5D")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("6D")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("7D")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("8D")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("9D")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("TD")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("JD")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("QD")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("KD")).doesNotThrowAnyException();		
		assertThatCode(() -> new Card("AD")).doesNotThrowAnyException();
		
		assertThatCode(() -> new Card("2S")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("3S")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("4S")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("5S")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("6S")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("7S")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("8S")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("9S")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("TS")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("JS")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("QS")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("KS")).doesNotThrowAnyException();
		assertThatCode(() -> new Card("AS")).doesNotThrowAnyException();
	}

	@Test
	void cardNotAllowed() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Card("XH")).withMessageContaining("Illegal value");
		assertThatIllegalArgumentException().isThrownBy(() -> new Card("1H")).withMessageContaining("Illegal value");

		assertThatIllegalArgumentException().isThrownBy(() -> new Card("2X")).withMessageContaining("Illegal suit");
		assertThatIllegalArgumentException().isThrownBy(() -> new Card("2A")).withMessageContaining("Illegal suit");

		assertThatIllegalArgumentException().isThrownBy(() -> new Card("2HS")).withMessageContaining("Card should contain value and suit, ex : 2H");
		assertThatIllegalArgumentException().isThrownBy(() -> new Card("2")).withMessageContaining("Card should contain value and suit, ex : 2H");

		assertThatIllegalArgumentException().isThrownBy(() -> new Card("")).withMessageContaining("Card should contain value and suit, ex : 2H");
		assertThatIllegalArgumentException().isThrownBy(() -> new Card(null)).withMessageContaining("Card should contain value and suit, ex : 2H");
	}



	@Test
	void isHigherThan() {
		assertThat(new Card("2H").isHigherThan(new Card("3H"))).isFalse();
		assertThat(new Card("4H").isHigherThan(new Card("3H"))).isTrue();


		assertThat(new Card("TH").isHigherThan(new Card("3H"))).isTrue();
		assertThat(new Card("9H").isHigherThan(new Card("TH"))).isFalse();

		assertThat(new Card("AH").isHigherThan(new Card("KH"))).isTrue();
		assertThat(new Card("KH").isHigherThan(new Card("QH"))).isTrue();

		assertThat(new Card("JH").isHigherThan(new Card("QH"))).isFalse();

		assertThat(new Card("JH").isHigherThan(new Card("JH"))).isFalse();
	}


}
