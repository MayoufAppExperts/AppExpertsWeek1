package com.example.theappexperts.intentstuff;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCamera, btnAlarm, btnEmail, btnCalendar, btnPhone, btnMusic, btnMap, btnContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = (Button)findViewById(R.id.btnCamera);
    }

    public void LaunchIntents(View view) {
        if (view.getId() == R.id.btnCamera) {
            Intent camIntent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
            if (camIntent.resolveActivity(getPackageManager()) != null)
                startActivity(camIntent);
        }
        else if (view.getId() == R.id.btnAlarm) {
            Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Wake up")
                    .putExtra(AlarmClock.EXTRA_HOUR, 6)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 45);
            if (alarmIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(alarmIntent);
            }
        }
        else if (view.getId() == R.id.btnEmail) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:")); // only email apps should handle this
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "mohammedmayouf@gmail.com");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "tae");
            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            }
        }
        else if (view.getId() == R.id.btnCalendar) {
            Intent intent = new Intent(Intent.ACTION_INSERT)
                    .setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.Events.TITLE, "Tae")
                    .putExtra(CalendarContract.Events.EVENT_LOCATION, "Tower Hill")
                    .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
        else if (view.getId()== R.id.btnPhone) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0129723047"));
            startActivity(callIntent);
        }
        else if (view.getId()== R.id.btnMusic){
            Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
            intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS,
                    MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
            intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, "Eminem");
            intent.putExtra(SearchManager.QUERY, "Eminem");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
        else if (view.getId()== R.id.btnMap){
            Intent mapIntent = new Intent(Intent.ACTION_VIEW);
            mapIntent.setData(Uri.parse("geo:47.6,-122.3"));
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }
        }
        else if (view.getId()== R.id.btnContacts){
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
            intent.putExtra(ContactsContract.Intents.Insert.NAME, "mohammed");
            intent.putExtra(ContactsContract.Intents.Insert.EMAIL, "mayouf@gmail.com");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }


    } //End launch intents
}// END CLASS
