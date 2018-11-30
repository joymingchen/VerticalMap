package com.joyming.verticalmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etFirst;
    private EditText etSecond;
    private Button btnConfirm;
    private Button btnSubmit;
    private SubtractionLayout subtractionLayout;
    private RadioGroup radioGroup;

    private int methodType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction);
        subtractionLayout = findViewById(R.id.subtraction_layout);
        etFirst = findViewById(R.id.et_first);
        etSecond = findViewById(R.id.et_second);
        btnConfirm = findViewById(R.id.btn_confirm);
        btnSubmit = findViewById(R.id.btn_submit);
        radioGroup = findViewById(R.id.rg);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_addition:
                        methodType = subtractionLayout.CODE_ADDITION;
                        break;
                    case R.id.rb_subtraction:
                        methodType = subtractionLayout.CODE_SUBTRACTION;
                        break;
                    case R.id.rb_multiplication:
                        methodType = subtractionLayout.CODE_MULTIPLICATION;
                        break;
                }
            }
        });


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    subtractionLayout.setNumber(Integer.parseInt(etFirst.getText().toString())
                            , Integer.parseInt(etSecond.getText().toString())
                            , methodType);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSubmit.setText(subtractionLayout.getNumberLineOne() + "\n" +
                        subtractionLayout.getNumberLineTwo() + "\n" +
                        subtractionLayout.getNumberLineThree() + "\n" +
                        subtractionLayout.getResultNumber() + "");
                Toast.makeText(MainActivity.this, subtractionLayout.isTrueAnswer() + "", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
