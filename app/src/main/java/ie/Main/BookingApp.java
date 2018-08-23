package ie.Main;

import android.app.Application;
import android.util.Log;

import ie.Database.DBManager;
import ie.Models.Booking;

public class BookingApp extends Application
{
    //public List <Donation> donations    = new ArrayList<Donation>();
    public DBManager dbManager;


    public Booking newBooking(Booking booking)
    {
            dbManager.add(booking);
            return booking;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.v("Booking", "Booking App Started");
        dbManager = new DBManager(this);
        Log.v("Booking", "Database Created");

    }
}
