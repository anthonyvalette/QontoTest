package qonto.test.qontotest.ui.fragments.useralbum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import qonto.test.qontotest.R;

public class UserAlbumFragment extends Fragment {


    private static final String ARG_ID = "ARG_ID";
    private UserAlbumFragmentState mState;
    private UserAlbumFragmentViews mViews;

    public static UserAlbumFragment newInstance(int id) {
        Bundle args = new Bundle();

        UserAlbumFragment fragment = new UserAlbumFragment();
        args.putInt(ARG_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null)
        {
            mState = new UserAlbumFragmentState();
            mState.id = arguments.getInt(ARG_ID, 1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_album_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViews = new UserAlbumFragmentViews(view);
    }

    @Override
    public void onResume() {
        // TODO launch request for retrieving albums from mstate.id
        super.onResume();
    }
}
