package app.com.swipeablecardsproject.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import app.com.swipeablecardsproject.converter.ResponseSanitizerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import static app.com.swipeablecardsproject.constants.AppConstant.BASE_URL;

public class RetrofitRequest {
    private static Retrofit retrofit;
    public static Retrofit getRetrofitInstance() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(ResponseSanitizerFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }


}
