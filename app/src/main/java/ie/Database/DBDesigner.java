package ie.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBDesigner extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bookings.db";
    private static final int 	DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE_TABLE_BOOKING = "create table bookings "
            + "(firstname text not null,"
            + "lastname text not null,"
            + "email text not null,"
            + "amountPicker int not null,"
            + "touroption int not null);";

    public DBDesigner(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_TABLE_BOOKING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBDesigner.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS bookings");
        onCreate(db);
    }
}

