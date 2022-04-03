package app.com.swipeablecardsproject.converter;

import androidx.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import app.com.swipeablecardsproject.response.CardListResponse;
import retrofit2.Converter;
import retrofit2.Retrofit;
import okhttp3.ResponseBody;


public class ResponseSanitizerFactory extends Converter.Factory  {
    private ResponseSanitizerFactory(){}
    public static ResponseSanitizerFactory create(){return new ResponseSanitizerFactory();}

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == CardListResponse.class) {
            return CardListResponseConveter.INSTANCE;
        }
        return super.responseBodyConverter(type, annotations, retrofit);
    }
}
