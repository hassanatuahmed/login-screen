package com.example.dashboard.db;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(PEntity pEntity);

    //CHECKING IF USER EXIST
    @Query("SELECT * FROM users WHERE email=(:email) and password=(:password)")
    PEntity login(String email,String password);


    @Query("SELECT * FROM users")
    List<PEntity> getAllUsers();


//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertImage(ImageEntity imageEntity);




    @Delete
    void delete(PEntity pEntity);

}
