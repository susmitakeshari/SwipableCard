package app.com.swipeablecardsproject.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import app.com.swipeablecardsproject.response.CardListResponse;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class CardListResponseConveter implements Converter<ResponseBody, CardListResponse> {

    public final static CardListResponseConveter INSTANCE = new CardListResponseConveter();

    @Override
    public CardListResponse convert(ResponseBody value) throws IOException {
        String jsonString = value.string();
        CardListResponse response = new CardListResponse();
        if(jsonString != null && jsonString.length() >0){
            if(jsonString.charAt(0) =='/')
                jsonString = jsonString.substring(1);
            Gson gson = new GsonBuilder().setLenient().create();
            response = gson.fromJson(jsonString,CardListResponse.class);
        }
        return response;
    }
}
