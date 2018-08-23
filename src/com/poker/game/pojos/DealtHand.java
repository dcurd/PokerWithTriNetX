package com.poker.game.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DealtHand {

	@SerializedName("success")
	@Expose
	private Boolean success;
	@SerializedName("cards")
	@Expose
	private List<Card> cards = null;
	@SerializedName("deck_id")
	@Expose
	private String deckId;
	@SerializedName("remaining")
	@Expose
	private Integer remaining;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public String getDeckId() {
		return deckId;
	}

	public void setDeckId(String deckId) {
		this.deckId = deckId;
	}

	public Integer getRemaining() {
		return remaining;
	}

	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}

}