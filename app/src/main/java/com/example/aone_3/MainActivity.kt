package com.example.aone_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var books = Books(this)
        book_Save.setOnClickListener {
            var db = books.writableDatabase
            db.execSQL("insert into books values (?,?,?,?)", arrayOf(book_id.text.toString(), book_Name.text.toString(),
            book_Release.text.toString(), book_Price.text.toString()))
            Toast.makeText(this, "Saved Complete", Toast.LENGTH_SHORT).show()
            book_id.setText("")
            book_Name.setText("")
            book_Release.setText("")
            book_Price.setText("")
        }
        book_Load.setOnClickListener {
            var db = books.readableDatabase
            var cur = db.rawQuery("select * from books where Id = ?", arrayOf(book_id.text.toString()))
            if (cur.count == 0){
                Toast.makeText(this, "Load Not Found", Toast.LENGTH_SHORT).show()
            }else{
                cur.moveToFirst()
                book_Name.setText(cur.getString(1))
                book_Release.setText(cur.getString(2))
                book_Price.setText(cur.getString(3))
                Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show()
            }
        }
        book_Update.setOnClickListener {
            var db = books.writableDatabase
            db.execSQL("update books set Name=?, Rel=?, Price=? where Id =? ", arrayOf(book_Name.text.toString(), book_Release.text.toString(),
            book_Price.text.toString(), book_id.text.toString()))
            Toast.makeText(this, "Update Complete", Toast.LENGTH_SHORT).show()
        }
        book_Delete.setOnClickListener {
            var db = books.writableDatabase
            db.execSQL("delete from books where Id = ?", arrayOf(book_id.text.toString()))
            Toast.makeText(this, "Delete Complete", Toast.LENGTH_SHORT).show()
            book_id.setText("")
            book_Name.setText("")
            book_Release.setText("")
            book_Price.setText("")
        }
    }
}