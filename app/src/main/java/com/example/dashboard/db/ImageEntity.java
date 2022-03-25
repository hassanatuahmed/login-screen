package com.example.dashboard.db;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Images")
public class ImageEntity {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] captureImage;



}
