package app.com.swipeablecardsproject.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CardListResponse {
    @SerializedName("data")
    @Expose
    private List<CardResponse> cardList;

    public List<CardResponse> getCardList() {
        if(cardList == null)
            cardList = new ArrayList<>();
        return cardList;
    }

    public void setCardList(List<CardResponse> cardList) {
        this.cardList = cardList;
    }

}
