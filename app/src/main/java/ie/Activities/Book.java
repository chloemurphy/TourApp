package ie.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.view.Menu;
import android.view.MenuItem;

import ie.wit.tourbooking.R;

public class Book extends AppCompatActivity {

    private Button booking;
    private EditText firstname;
    private EditText lastname;
    private EditText email;
    private RadioGroup tourOption;
    private NumberPicker amountPicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        firstname   = (EditText)  findViewById(R.id.firstname);
        lastname  = (EditText) findViewById(R.id.lastname);
        email = (EditText) findViewById(R.id.email);
        booking = (Button) findViewById(R.id.booking);
        tourOption = (RadioGroup)   findViewById(R.id.tourOption);
        amountPicker = (NumberPicker) findViewById(R.id.amountPicker);

        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_booking, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuReport : startActivity (new Intent(this, Report.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void makeBooking (View view)
    {
        String fname = firstname.getText().toString();
        String lname = lastname.getText().toString();
        String emailaddress = email.getText().toString();
        int radioId = tourOption.getCheckedRadioButtonId();
        int amount = amountPicker.getValue();
        String method = radioId == R.id.tour1 ? "Tour 1" : "Tour 2";

        Log.v("Booking", "Booking Pressed! with First Name: " + fname + ", Last Name: " + lname +", Email Address: " + emailaddress + ", Tour Option: " + method + ", Amount of People: " + amount);

        Intent intent = new Intent(Book.this, Report.class);
        startActivity(intent);
    }
}

