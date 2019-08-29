package com.maicondcastro.theswitcher.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Division")
public class Division implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private boolean active;

    public Division(int id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    protected Division(Parcel in) {
        id = in.readInt();
        name = in.readString();
        active = in.readByte() != 0;
    }

    public static final Creator<Division> CREATOR = new Creator<Division>() {
        @Override
        public Division createFromParcel(Parcel in) {
            return new Division(in);
        }

        @Override
        public Division[] newArray(int size) {
            return new Division[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeByte((byte) (active ? 1 : 0));
    }
}
