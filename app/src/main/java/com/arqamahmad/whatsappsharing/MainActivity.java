package com.arqamahmad.whatsappsharing;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (EditText)findViewById(R.id.edit_text);
        send = (Button)findViewById(R.id.send_button);


    }

    public void sendWhatsApp(View view){

        PackageManager pm = getPackageManager();
        try {
            //Check if WhatsApp is there installed
            PackageInfo pi = pm.getPackageInfo("com.whatsapp",PackageManager.GET_META_DATA);
            Toast.makeText(this,"Great WhatsApp is working",Toast.LENGTH_SHORT).show();



            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.putExtra(Intent.EXTRA_TEXT,message.getText().toString());
            intent.setType("text/plain");

           //intent.setPackage("com.whatsapp");
            //startActivity(intent);
            startActivity(Intent.createChooser(intent,getResources().getText(R.string.sending)));

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this,"You don't have WhatsApp installed",Toast.LENGTH_SHORT).show();
        }
    }

}
