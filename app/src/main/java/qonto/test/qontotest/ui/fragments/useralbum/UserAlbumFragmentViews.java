package qonto.test.qontotest.ui.fragments.useralbum;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import qonto.test.qontotest.R;

public class UserAlbumFragmentViews {
    RecyclerView albumListView;
    public UserAlbumFragmentViews(View view) {
        albumListView = (RecyclerView) view.findViewById(R.id.user_album_fragment_list_of_albums);
    }
}
