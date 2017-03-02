package qonto.test.qontotest.ui.fragments.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import qonto.test.qontotest.R;

public class HomeFragmentViews {
    public final RecyclerView userList;
    public HomeFragmentUserListAdapter userListAdapter;

    public HomeFragmentViews(View view) {
        userList = (RecyclerView) view.findViewById(R.id.home_fragment_list_of_users);
    }
}
