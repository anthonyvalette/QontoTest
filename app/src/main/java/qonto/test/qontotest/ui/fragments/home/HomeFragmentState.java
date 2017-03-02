package qonto.test.qontotest.ui.fragments.home;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import qonto.test.qontotest.model.user.User;

public class HomeFragmentState implements Parcelable{
    public ArrayList<User> users;

    protected HomeFragmentState(Parcel in) {
        users = in.readArrayList(HomeFragmentState.class.getClassLoader());
    }

    public static final Creator<HomeFragmentState> CREATOR = new Creator<HomeFragmentState>() {
        @Override
        public HomeFragmentState createFromParcel(Parcel in) {
            return new HomeFragmentState(in);
        }

        @Override
        public HomeFragmentState[] newArray(int size) {
            return new HomeFragmentState[size];
        }
    };

    public HomeFragmentState() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(users);
    }
}
