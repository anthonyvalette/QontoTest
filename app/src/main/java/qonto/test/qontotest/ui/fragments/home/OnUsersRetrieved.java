package qonto.test.qontotest.ui.fragments.home;

import java.util.List;

import qonto.test.qontotest.model.user.User;

public interface OnUsersRetrieved
{
    void onUserRetrieved(List<User> users);
}
