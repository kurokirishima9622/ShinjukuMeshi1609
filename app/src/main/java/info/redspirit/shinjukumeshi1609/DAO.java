package info.redspirit.shinjukumeshi1609;

/**
 * Created by rj on 16/09/21.
 */
import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAO {

    private SQLiteDatabase db;

    /**
     * コンストラクタ
     * @param db
     */
    public DAO(SQLiteDatabase db) {
        this.db = db;
    }



    public ArrayList<Hoge> select(){

        ArrayList<Hoge> list = new ArrayList<Hoge>();


        Cursor cursor = db.rawQuery("SELECT * FROM shinjukumeshi", null);
        try {
            while (cursor.moveToNext()) {
                Hoge hoge = new Hoge();
                hoge.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                hoge.setName(cursor.getString(cursor.getColumnIndex("name")));
                hoge.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                hoge.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                hoge.setZahyou(cursor.getString(cursor.getColumnIndex("zahyou")));
                hoge.setYosan(cursor.getString(cursor.getColumnIndex("yosan")));
                list.add(hoge);
            }
        } finally {
            cursor.close();
        }



        return list;


    }
    public ArrayList<Hoge> select(String str){

        ArrayList<Hoge> list = new ArrayList<Hoge>();


        Cursor cursor = db.rawQuery("SELECT * FROM shinjukumeshi where name like   ? ", new String[]{"%"+str+"%"});
        try {
            while (cursor.moveToNext()) {
                Hoge hoge = new Hoge();
                hoge.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                hoge.setName(cursor.getString(cursor.getColumnIndex("name")));
                hoge.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                hoge.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                hoge.setZahyou(cursor.getString(cursor.getColumnIndex("zahyou")));
                hoge.setYosan(cursor.getString(cursor.getColumnIndex("yosan")));
                list.add(hoge);
            }
        } finally {
            cursor.close();
        }

        return list;


    }
    public Hoge select(int id){

        Hoge hoge = new Hoge();
        Cursor cursor = db.rawQuery("SELECT * FROM shinjukumeshi where _id = ?", new String[]{""+id+""});
        try {
            while (cursor.moveToNext()) {
                hoge.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                hoge.setName(cursor.getString(cursor.getColumnIndex("name")));
                hoge.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                hoge.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                hoge.setZahyou(cursor.getString(cursor.getColumnIndex("zahyou")));
                hoge.setYosan(cursor.getString(cursor.getColumnIndex("yosan")));
            }
        } finally {
            cursor.close();
        }
        return hoge;


    }
}
