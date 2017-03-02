package qonto.test.qontotest.ui.fragments.useralbum;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import qonto.test.qontotest.model.album.Album;

public class UserAlbumFragmentState implements Parcelable {
    public int id;
    public ArrayList<Album> albums;

    protected UserAlbumFragmentState(Parcel in) {
        id = in.readInt();
        albums = in.createTypedArrayList(Album.CREATOR);
    }

    public static final Creator<UserAlbumFragmentState> CREATOR = new Creator<UserAlbumFragmentState>() {
        @Override
        public UserAlbumFragmentState createFromParcel(Parcel in) {
            return new UserAlbumFragmentState(in);
        }

        @Override
        public UserAlbumFragmentState[] newArray(int size) {
            return new UserAlbumFragmentState[size];
        }
    };

    public UserAlbumFragmentState() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeTypedList(albums);
    }
}
