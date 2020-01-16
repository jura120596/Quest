package com.example.lesson2312;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView towers;
    EditText from;
    EditText where;
    Button go;
    ArrayList<Integer> tower1 = new ArrayList<>();
    ArrayList<Integer> tower2= new ArrayList<>();
    ArrayList<Integer> tower3= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int n =8; n > 0;n--){
            tower1.add(n);
        }
        setContentView(R.layout.activity_main);
        towers = findViewById(R.id.towers);
        from = findViewById(R.id.from);
        where = findViewById(R.id.where);
        go = findViewById(R.id.answerButton);
        towers.setText("1) " + Arrays.toString(tower1.toArray()) + "\n");
        towers.append("2) " + Arrays.toString(tower2.toArray()) + "\n");
        towers.append("3) " + Arrays.toString(tower3.toArray()) + "\n");
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fromNumber = Integer.parseInt(from.getText().toString());
                int whereNumber = Integer.parseInt(where.getText().toString());
                from.setText("");
                where.setText("");
                switch (fromNumber) {
                    case 1:
                        switch (whereNumber) {
                            case 2:
                                tower2.add(tower1.get(tower1.size() - 1));
                                tower1.remove(tower1.size() - 1);
                                break;
                            case 3:
                                tower3.add(tower1.get(tower1.size() - 1));
                                tower1.remove(tower1.size() - 1);
                                break;
                        }
                        break;
                    case 2:
                        switch (whereNumber) {
                            case 1:
                                tower1.add(tower2.get(tower2.size() - 1));
                                tower2.remove(tower2.size() - 1);
                                break;
                            case 3:
                                tower3.add(tower2.get(tower2.size() - 1));
                                tower2.remove(tower2.size() - 1);
                                break;
                        }
                        break;
                    case 3:
                        switch (whereNumber) {
                            case 2:
                                tower2.add(tower3.get(tower3.size() - 1));
                                tower3.remove(tower3.size() - 1);
                                break;
                            case 1:
                                tower1.add(tower3.get(tower3.size() - 1));
                                tower3.remove(tower3.size() - 1);
                                break;
                        }
                        break;
                }


                towers.setText("1) " + Arrays.toString(tower1.toArray()) + "\n");
                towers.append("2) " + Arrays.toString(tower2.toArray()) + "\n");
                towers.append("3) " + Arrays.toString(tower3.toArray()) + "\n");
            }
        });
    }
}
