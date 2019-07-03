package com.exomatik.mpm.tes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by IrfanRZ on 03/07/2019.
 */

public interface Api {
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
