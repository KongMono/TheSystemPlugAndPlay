package net.thesystemplugplay.tspp.rest.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import net.thesystemplugplay.tspp.Interface.PlugAndPlayService;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by kongmono on 7/1/15 AD.
 */

public class RestClient {
    private static final String BASE_URL = "";
    private PlugAndPlayService apiService;

    public RestClient() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiService = restAdapter.create(PlugAndPlayService.class);

    }

    public PlugAndPlayService getApiService() {
        return apiService;
    }

}
