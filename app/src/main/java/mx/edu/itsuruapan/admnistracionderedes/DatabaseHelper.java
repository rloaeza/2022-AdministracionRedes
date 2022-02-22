package mx.edu.itsuruapan.admnistracionderedes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.Nullable;

import java.io.FileInputStream;
import java.io.IOException;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "imageDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE images (id integer primary key autoincrement,us text, img blob not null)");
        //System.out.println(BaseDeDatos.getPath());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists images");
    }

    public boolean insertImage(String x, String us){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            FileInputStream fs = new FileInputStream(x);
            byte[] imgbyte = new byte[fs.available()];
            fs.read(imgbyte);
            ContentValues contentValues = new ContentValues();
            //contentValues.put("id","2");
            contentValues.put("img", imgbyte);
            contentValues.put("us", us);
            db.insert("images",null,contentValues);
            fs.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public Bitmap getImage(String us){
        SQLiteDatabase db = this.getWritableDatabase();
        Bitmap bt = null;
        Cursor cursor = db.rawQuery("select * from images where us=?",new String[]{String.valueOf(us)});
        if(cursor.moveToNext()){
            byte[] imag = cursor.getBlob(2);
            bt = BitmapFactory.decodeByteArray(imag,0,imag.length);
        }
        return bt;
    }

    public void deletImage(String us){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.execSQL("delete from images where us=?",new String[]{String.valueOf(us)});
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            db.close();
        }
    }

}
