package com.example.aone_3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Books(context: Context) : SQLiteOpenHelper(context, "books.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table books (Id integer primary key autoincrement, Name text, Rel integer, Price Integer)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

}