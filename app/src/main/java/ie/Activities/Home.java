package ie.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import ie.wit.tourbooking.R;

public class Home extends AppCompatActivity {

    private Button foodDrinkBtn;
    private Button historyBtn;
    private Button racingBtn;
    private Button visitBtn;
    private Button thingsBtn;
    private Button tourBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tourBtn = (Button) findViewById(R.id.tourBtn);

        if (tourBtn != null)
        {
            Log.v("Book", "Launching Booking.");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_booking, menu);
        return true;
    }

    public void tourBtnPressed (View view)
    {
        Log.v("Book", "Launching Booking");
    }

    public void openFoodDrink(View view)
    {
        Intent intent = new Intent(Home.this, foodDrink.class);
        startActivity(intent);
    }

    public void openHistoryBtn(View view)
    {
        Intent intent = new Intent(Home.this, History.class);
        startActivity(intent);
    }

    public void openRacingBtn(View view)
    {
        Intent intent = new Intent(Home.this, Racing.class);
        startActivity(intent);
    }

    public void openVisitBtn(View view)
    {
        Intent intent = new Intent(Home.this, Visit.class);
        startActivity(intent);
    }

    public void openThingsBtn(View view)
    {
        Intent intent = new Intent(Home.this, Things.class);
        startActivity(intent);
    }

    public void openBookBtn(View view)
    {
        Intent intent = new Intent(Home.this, Book.class);
        startActivity(intent);
    }


}

