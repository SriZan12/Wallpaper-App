package Apis;

import static Apis.RetrofitInstance.ApiKey;

import Models.MainDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface ApiInstance {

    @Headers(
            {
                    "Accept: application/json",
                    "Authorization: 563492ad6f91700001000001ad9391281fe84911838c7cd480062e8f"
            }
    )
    @GET("curated")
    Call<MainDetails> getAllWallpaper(
            @Query("page") int page,
            @Query("per_page") int per_page
    );
    @Headers(
            {
                    "Accept: application/json",
                    "Authorization: 563492ad6f91700001000001ad9391281fe84911838c7cd480062e8f"
            }
    )
    @GET("search")
    Call<MainDetails> getAllWallpaper(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int per_page
    );
}
