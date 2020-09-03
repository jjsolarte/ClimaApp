package co.jjsolarte.climaapp.services;

import java.util.List;

import co.jjsolarte.climaapp.model.City;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServices {

    String API_ROUTE = "/api/location/search/?query=bo";

    @GET(API_ROUTE)
    Call<List<City>> getPost();

}
