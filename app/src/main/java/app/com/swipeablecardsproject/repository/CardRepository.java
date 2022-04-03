package app.com.swipeablecardsproject.repository;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

import app.com.swipeablecardsproject.response.CardListResponse;
import app.com.swipeablecardsproject.response.CardResponse;
import app.com.swipeablecardsproject.retrofit.ApiRequest;
import app.com.swipeablecardsproject.retrofit.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardRepository {
    private ApiRequest apiRequest;
    private static CardRepository cardRepository;
    public static CardRepository getInstance(){
        if (cardRepository == null){
            cardRepository = new CardRepository();
        }
        return cardRepository;
    }

    public CardRepository(){
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);/*createService(ApiRequest.class);*/
    }

    public MutableLiveData<CardListResponse> getCardList(){
        MutableLiveData<CardListResponse> data = new MutableLiveData<>();
        apiRequest.getCardList().enqueue(new Callback<CardListResponse>() {
            @Override
            public void onResponse(Call<CardListResponse> call,
                                   Response<CardListResponse> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<CardListResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}

