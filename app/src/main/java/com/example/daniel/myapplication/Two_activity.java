package com.example.daniel.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Two_activity extends Activity {
    boolean[] zaznaczony = new boolean[5];
    int iterator = 0;

    String[] OdpowiedziPoprawne = {"Szop", "Kot", "Króliki", "Wilk", "Wiewiórka"};
    String[] OdpowiedziNiePoprawne = {"Ostronos", "Gepard", "Zając", "Pies", "Burunduk"};
    int[] idButton = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5};
    int[] idRadioGroup = {R.id.radioGroup1, R.id.radioGroup2, R.id.radioGroup3, R.id.radioGroup4, R.id.radioGroup5};

    Button[] button = new Button[idButton.length];
    RadioGroup[] RadioGroup = new RadioGroup[idRadioGroup.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_activity);
        Button wynik = (Button) findViewById(R.id.button6);
        for (int i = 0; i < idButton.length; i++) {
            final int j = i;
            button[j] = (RadioButton) findViewById(idButton[j]);
            button[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (zaznaczony[j] == true) {
                        Toast.makeText(getApplicationContext(), "Wybrałeś " + OdpowiedziPoprawne[j], Toast.LENGTH_SHORT).show();
                        iterator++;
                    } else {
                        Toast.makeText(getApplicationContext(), "Wybrałeś " + OdpowiedziNiePoprawne[j], Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        for (int i = 0; i < idRadioGroup.length; i++) {
            final int j = i;
            RadioGroup[j] = (RadioGroup) findViewById(idRadioGroup[j]);
            RadioGroup[j].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Button result = (Button) findViewById(checkedId);
                    if (result.getText().equals(OdpowiedziPoprawne[j])) zaznaczony[j] = true;
                    else zaznaczony[j] = false;
                }
            });
            wynik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(iterator == 1){
                    Toast.makeText(getApplicationContext(), "Masz " + iterator + " punkt", Toast.LENGTH_SHORT).show();
                    }
                    else if(iterator > 1 && iterator < 5){
                        Toast.makeText(getApplicationContext(), "Masz " + iterator + " punkty", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Masz " + iterator + " punktów", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
