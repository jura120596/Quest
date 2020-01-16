package com.example.lesson2312;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuestActivity extends AppCompatActivity {
    TextView subject;
    TextView text;
    EditText answer;
    Button answerButton;
    Character manager;
    Story story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest2);
        this.subject = findViewById(R.id.subject);
        this.text = findViewById(R.id.text);
        this.answer = findViewById(R.id.answer);
        this.answerButton = findViewById(R.id.answerButton);
        //Созадаем ситуации и менеджера
        this.manager = new Character("Юра");
        this.story = new Story();
        // Заполняем экран по данным первой ситуации
        this.subject.setText(this.story.currentSituation.subject);
        this.text.setText(this.story.currentSituation.text);
        //Задаем кнопке действие
        this.answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.getText().toString().isEmpty()) {
                    return;
                }
                int num = Integer.parseInt(answer.getText().toString());
                try {
                    story.go(num);
                } catch (IncorrectAnswerException e) {
                    Toast.makeText(QuestActivity.this,
                            "Неправильный ответ",
                            Toast.LENGTH_LONG).show();
                }
                subject.setText(story.currentSituation.subject);
                text.setText(story.currentSituation.text);
                answer.setText("");
            }
        });

    }
}
