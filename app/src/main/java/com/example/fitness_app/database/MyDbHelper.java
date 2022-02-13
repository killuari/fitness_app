package com.example.fitness_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Recipes.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "recipes";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_CALORIES = "calories";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_VARIANT = "variant";
    private static final String COLUMN_INGREDIENTS = "ingredients";
    private static final String COLUMN_AMOUNT = "amount";

    public MyDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_CALORIES + " TEXT, " +
                        COLUMN_VARIANT + " TEXT, " +
                        COLUMN_INGREDIENTS + " TEXT, " +
                        COLUMN_AMOUNT + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void addRecipes(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //ADD RECIPE
        cv.put(COLUMN_NAME, "chicken");
        cv.put(COLUMN_CALORIES, "300");
        cv.put(COLUMN_VARIANT, "dinner");
        cv.put(COLUMN_INGREDIENTS, "chicken");
        cv.put(COLUMN_AMOUNT, "280g");
        db.insert(TABLE_NAME, null, cv);
        //------

        //ADD RECIPE
        cv.put(COLUMN_NAME, "steak");
        cv.put(COLUMN_CALORIES, "300");
        cv.put(COLUMN_VARIANT, "dinner");
        cv.put(COLUMN_INGREDIENTS, "beef");
        cv.put(COLUMN_AMOUNT, "200");
        db.insert(TABLE_NAME, null, cv);
        //------

    }
}
