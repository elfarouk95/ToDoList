package com.app.todolist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface ApiInterface {

    @GET("api/road/maps/1")
    Call<RoadMapModel> GetRoadMap(
            @Query("dateFrom") String from,
            @Query("dateTo") String to);

}
