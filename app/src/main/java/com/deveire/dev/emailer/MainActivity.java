package com.deveire.dev.emailer;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    private Button sendButton;
    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = (EditText) findViewById(R.id.emailEditText);

        sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendEmail();
            }
        });
    }

    private void sendEmail()
    {
        //GMailSender sm = new GMailSender(this, "dan@deveire.com", "New Trouble Ticket", "https://www.youtube.com/watch?v=dQw4w9WgXcQ");

        SimpleDateFormat format = new SimpleDateFormat(" hh:mm  dd/MM/yyyy");
        Calendar aCalendar = Calendar.getInstance();

        GMailSender sm = new GMailSender(this, emailEditText.getText().toString(), "New Trouble Ticket", "Trouble Ticket:\n\n\tType: Maintenance \n\n\tLocation: Ceo's Bathroom \n\n\tAlert: Leaking sink. \n\n\tRegistered:" + format.format(aCalendar.getTime()));
        //Executing sendmail to send email
        sm.execute();
    }

}
