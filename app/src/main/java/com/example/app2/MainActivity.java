package com.example.app2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button refBtnOK;
    private EditText refEdtPseudo;
    private final String TAG = "PMR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refBtnOK = findViewById(R.id.btnOK);
        refEdtPseudo = findViewById(R.id.edtPseudo);

        refBtnOK.setOnClickListener(this);
        refEdtPseudo.setOnClickListener(this);

/*        refBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerter("click par écouteur spécifique");
            }
        });*/
    }
    public void alerter(String s){
        Log.i(TAG,s);
        Toast t = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        t.show();
    }
    public void foo(View view) {
        //cette fonction n'est plus appelée lors d'un clic -> surcharge
        alerter("Click sur OK");
    }

    @Override
    public void onClick(View view) {
        String s = refEdtPseudo.getText().toString();
        switch(view.getId()){
            case R.id.btnOK:
                alerter("Pseudo = "+s);
                break;

            case R.id.edtPseudo:
                alerter("Click sur zone pseudo");
                break;
        }
    }

    /*Gestion des menus*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.menu_compte:
                alerter("click sur compte");
                break;
            case R.id.menu_pref:
                alerter("click sur préférences");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}