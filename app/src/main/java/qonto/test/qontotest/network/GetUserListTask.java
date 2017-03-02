package qonto.test.qontotest.network;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import qonto.test.qontotest.model.user.User;
import qonto.test.qontotest.ui.fragments.home.OnUsersRetrieved;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetUserListTask extends AsyncTask<Object, Object, List<User>> {
    private final OnUsersRetrieved listener;

    public GetUserListTask(OnUsersRetrieved listener) {
        this.listener = listener;
    }

    @Override
    protected List<User> doInBackground(Object... voids) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WebService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebService webService = retrofit.create(WebService.class);
        Call<List<User>> userList = webService.getUserList();
        Response<List<User>> listResponse = null;

        try {
            listResponse = userList.execute();
        } catch (IOException e) {
            Log.e(GetUserListTask.class.getName(), e.getMessage());
        }
        if (listResponse != null)
            return listResponse.body();
        return null;
    }

    @Override
    protected void onPostExecute(List<User> users) {
        super.onPostExecute(users);
        listener.onUserRetrieved(users);
    }
}
