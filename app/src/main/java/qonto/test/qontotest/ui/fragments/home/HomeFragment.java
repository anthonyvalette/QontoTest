package qonto.test.qontotest.ui.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import qonto.test.qontotest.R;
import qonto.test.qontotest.model.user.User;
import qonto.test.qontotest.network.GetUserListTask;
import qonto.test.qontotest.ui.fragments.useralbum.UserAlbumFragment;

public class HomeFragment extends Fragment implements OnUsersRetrieved, OnItemClickListener{

    private static final String STATE_HOME_FRAGMENT = "STATE_HOME_FRAGMENT";
    private HomeFragmentViews mViews;
    private HomeFragmentState mState;

    private OnUsersRetrieved listener;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
        {
            mState = savedInstanceState.getParcelable(STATE_HOME_FRAGMENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mViews = new HomeFragmentViews(view);
        mViews.userList.setLayoutManager(new LinearLayoutManager(getContext()));
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        if (mState == null)
        {
            retrieveUserList();
        }
        else
        {
            updateList();
        }
        super.onResume();
    }

    private void updateList() {
        mViews.userListAdapter = new HomeFragmentUserListAdapter(mState.users, this);
        mViews.userList.setAdapter(mViews.userListAdapter);
        mViews.userListAdapter.notifyDataSetChanged();
    }

    private void retrieveUserList() {
        GetUserListTask getUserListTask = new GetUserListTask(this);
        getUserListTask.execute();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(STATE_HOME_FRAGMENT, mState);
    }

    @Override
    public void onUserRetrieved(List<User> users) {
        mState = new HomeFragmentState();
        mState.users = new ArrayList<>(users);

        updateList();
    }

    @Override
    public void onItemClick(User user) {
        Toast.makeText(getContext(), user.getUsername(), Toast.LENGTH_SHORT).show();
        UserAlbumFragment userAlbumFragment = UserAlbumFragment.newInstance(user.getId());
        getFragmentManager().beginTransaction().replace(R.id.activity_main_fragment, userAlbumFragment).commit();
    }
}
