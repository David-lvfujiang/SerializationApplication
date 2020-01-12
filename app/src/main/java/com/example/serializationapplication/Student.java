package com.example.serializationapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/12/25
 * @Describe:
 */
public class Student implements Parcelable {
    String name;
    public Student(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    protected Student(Parcel in) {
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
