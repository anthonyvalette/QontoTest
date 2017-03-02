package qonto.test.qontotest.network;

import java.util.List;

import qonto.test.qontotest.model.user.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {
    String ENDPOINT = "https://jsonplaceholder.typicode.com";

    @GET("/users")
    Call<List<User>> getUserList();
}
