package com.example.dashboard.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class PEntity {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name="password")
    public String password;

    @ColumnInfo(name="userName")
    public String userName;

    @ColumnInfo(name = "email")
    public String email;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
