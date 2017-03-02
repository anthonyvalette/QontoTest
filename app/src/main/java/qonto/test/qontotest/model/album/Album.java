package qonto.test.qontotest.model.album;


import android.os.Parcel;
import android.os.Parcelable;

public class Album implements Parcelable{
    private int userid;
    private int id;
    private String title;

    protected Album(Parcel in) {
        userid = in.readInt();
        id = in.readInt();
        title = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(userid);
        parcel.writeInt(id);
        parcel.writeString(title);
    }
}
