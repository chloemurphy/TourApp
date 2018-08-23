package ie.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ie.Models.Booking;

public class DBManager {

    private SQLiteDatabase database;
    private DBDesigner dbHelper;

    public DBManager(Context context) {
        dbHelper = new DBDesigner(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public void add(Booking d) {
        ContentValues values = new ContentValues();
        values.put("fname", d.firstname);
        values.put("lname", d.lastname);
        values.put("email", d.email);
        values.put("amountPicker", d.amountPicker);
        values.put("touroption", d.tourOption);

        database.insert("bookings", null, values);
    }

    public List<Booking> getAll() {
        List<Booking> bookings = new ArrayList<Booking>();
        Cursor cursor = database.rawQuery("SELECT * FROM bookings", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Booking d = toBooking(cursor);
            bookings.add(d);
            cursor.moveToNext();
        }
        cursor.close();
        return bookings;
    }

    private Booking toBooking(Cursor cursor) {
        Booking pojo = new Booking();
        pojo.firstname = String.valueOf(cursor.getInt(0));
        pojo.lastname = String.valueOf(cursor.getInt(1));
        pojo.email = cursor.getString(2);
        pojo.amountPicker = cursor.getInt(3);
        pojo.tourOption = cursor.getInt(4);
        return pojo;
    }

    public void reset() {
        database.delete("donations", null, null);
    }
}
