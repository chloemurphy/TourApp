package ie.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ie.Models.Booking;
import ie.wit.tourbooking.R;

public class Report extends Base implements AdapterView.OnItemClickListener
{
    ListView listView;
    BookingAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        listView = (ListView) findViewById(R.id.reportList);
        adapter = new BookingAdapter(this, app.dbManager.getAll());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long id) {

        Toast.makeText(this, "You Selected Row [ " + pos + "]\n" +
                "For Booking Data [ " + adapter.bookings.get(pos) + "]\n " +
                "With ID of [" + id + "]", Toast.LENGTH_LONG).show();

    }
}


class BookingAdapter extends ArrayAdapter<Booking> {
    private Context context;
    public List<Booking> bookings;

    public BookingAdapter(Context context, List<Booking> bookings) {
        super(context, R.layout.row_booking, bookings);
        this.context = context;
        this.bookings = bookings;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.row_booking, parent, false);

        Booking booking = bookings.get(position);

        TextView fnameView = (TextView) view.findViewById(R.id.row_fname);
        TextView lnameView = (TextView) view.findViewById(R.id.row_lname);
        TextView emailView = (TextView) view.findViewById(R.id.row_email);
        TextView tourOptionView = (TextView) view.findViewById(R.id.row_tourOption);
        TextView amountPicker = (TextView) view.findViewById(R.id.row_amountPicker);

        fnameView.setText(booking.firstname);
        lnameView.setText(booking.lastname);
        emailView.setText(booking.email);
        tourOptionView.setText(booking.tourOption);
        amountPicker.setText(booking.amountPicker);

        return view;
    }

    @Override
    public int getCount() {
        return bookings.size();
    }
}
