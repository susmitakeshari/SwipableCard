package app.com.swipeablecardsproject.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import app.com.swipeablecardsproject.repository.*;

import java.util.List;

import app.com.swipeablecardsproject.response.CardListResponse;
import app.com.swipeablecardsproject.response.CardResponse;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<CardListResponse> cardResponseLiveData;
    private  CardRepository cardRepository;
    public void init(){
        if (cardResponseLiveData != null){
            return;
        }
        cardRepository = CardRepository.getInstance();
        cardResponseLiveData = cardRepository.getCardList();
    }

    public LiveData<CardListResponse> getCardResponseLiveData() {
        return cardResponseLiveData;
    }
}