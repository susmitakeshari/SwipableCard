package app.com.swipeablecardsproject.retrofit;
import java.util.List;

import app.com.swipeablecardsproject.response.CardListResponse;
import app.com.swipeablecardsproject.response.CardResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("HiringTask.json")
    Call<CardListResponse> getCardList();
}
