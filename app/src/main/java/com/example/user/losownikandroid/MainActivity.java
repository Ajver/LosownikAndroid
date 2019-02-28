package com.example.user.losownikandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List list = new List();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button randButton = (Button) findViewById(R.id.RandButton);

        randButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                TextView result = (TextView) findViewById(R.id.result);

                EditText min = (EditText) findViewById(R.id.min);
                String sMin = min.getText().toString();
                if (sMin.isEmpty()) return;
                int iMin = Integer.parseInt(sMin);

                EditText max = (EditText) findViewById(R.id.max);
                String sMax = max.getText().toString();

                // Showing tab
                if(iMin == 888) {
                    if (list.size() > 0) {
                        result.setText("Zapisane liczby: \n");

                        for (int i = 0; i < list.size(); i++) {
                            String s = result.getText().toString();
                            result.setText(s + list.get(i) + "\n");
                        }
                    } else {
                        result.setText("Nie zapisano żadnej liczby!");
                    }

                    return;
                }

                if (sMax.isEmpty()) return;
                int iMax = Integer.parseInt(sMax);

                // Removing undefinding digits from tab
                if(iMin == 777) {
                    if(list.remove(iMax))
                        result.setText("Usunieto liczbe: " + iMax);
                    else
                        result.setText("Nie zapisano jeszcze liczby: " + iMax);

                    return;
                }

                // Saving undefinding digits to tab
                if(iMin == 666) {
                    if(list.size() < 10) { // If tab isn't full
                        if(list.findIn(iMax)) { // If there is that digit in tab
                            result.setText("Ta liczba jest już zapisana!");

                            return;
                        }

                        list.add(iMax);

                        // Signaling the user that tab is updated
                        result.setText("Zapisano liczbę: " + iMax);
                    }else { // If tab is full
                        // Signaling the user that tab is full
                        result.setText("Może zostać zapisanych maksymalnie 10 liczb!\n(Zrestartuj aplikację by usunąć liczby)");
                    }

                    return;
                }

                int x = Math.abs(iMax-iMin)+1;
                int lowest = iMin < iMax? iMin : iMax;

                if(x <= list.size()) {
                    boolean isError13 = true;

                    for(int i=0; i<x; i++) {
                        if(!list.findIn(lowest + i)) { // If there is same digit that can be find
                            isError13 = false;
                            break;
                        }
                    }

                    if(isError13) {
                        result.setText("ERROR 13");

                        return;
                    }

                    // else - find random digit!
                }



                Random r = new Random();

                int iResult;

                do
                    iResult = r.nextInt(x)+lowest;
                while(list.findIn(iResult));

                result.setText("Wylosowano liczbę: " + iResult);
            }
        });
    }


}
