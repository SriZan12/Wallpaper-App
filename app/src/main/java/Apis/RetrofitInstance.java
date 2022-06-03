package Apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance{

    private static Retrofit retrofit = null;
    private static String BaseUrl = "https://api.pexels.com/v1/";
    public static final String ApiKey = "563492ad6f91700001000001ad9391281fe84911838c7cd480062e8f";

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }


}
