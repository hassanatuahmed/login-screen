package com.example.dashboard.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = PEntity.class,version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract  Dao dao();
    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"DB_NAME")
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;

    }

}
