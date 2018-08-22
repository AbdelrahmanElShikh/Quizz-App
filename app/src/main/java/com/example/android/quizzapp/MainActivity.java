package com.example.android.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void resetImage(ImageView t, ImageView f) {
        t.setVisibility(View.INVISIBLE);
        f.setVisibility(View.INVISIBLE);
        t.getLayoutParams().height = 0;
        t.requestLayout();
        f.getLayoutParams().height = 0;
        f.requestLayout();
    }

    private void showImage(ImageView img) {
        img.setVisibility(View.VISIBLE);
        img.getLayoutParams().height = 100;
        img.requestLayout();
    }

    private int qu1(int mark) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.qu1RadioGroup);
        ImageView _true = (ImageView) findViewById(R.id._true1);
        ImageView _false = (ImageView) findViewById(R.id._false1);
        resetImage(_true, _false);

        int selectedRadioButtonID = rg.getCheckedRadioButtonId();
        if (selectedRadioButtonID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
            String selectedRadioButtonText = selectedRadioButton.getText().toString();
            String answer = getString(R.string.radioButton1_3);
            if (selectedRadioButtonText.equals(answer)) {
                mark += 1;
                showImage(_true);
            } else {
                showImage(_false);
            }
        } else {
            showImage(_false);
        }
        return mark;
    }

    private int qu2(int mark) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.qu2RadioGroup);
        ImageView _true = (ImageView) findViewById(R.id._true2);
        ImageView _false = (ImageView) findViewById(R.id._false2);
        resetImage(_true, _false);
        int selectedRadioButtonID = rg.getCheckedRadioButtonId();
        if (selectedRadioButtonID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
            String selectedRadioButtonText = selectedRadioButton.getText().toString();
            String answer = getString(R.string.radioButton2_3);
            if (selectedRadioButtonText.equals(answer)) {
                mark += 1;
                showImage(_true);
            } else {
                showImage(_false);
            }

        } else {
            showImage(_false);
        }
        return mark;
    }


    private int qu3(int mark) {
        CheckBox box1 = (CheckBox) findViewById(R.id.checkBoxNew);
        CheckBox box2 = (CheckBox) findViewById(R.id.checkBoxAbstract);
        CheckBox box3 = (CheckBox) findViewById(R.id.checkBoxBoolean);
        CheckBox box4 = (CheckBox) findViewById(R.id.checkBoxLayla);
        ImageView _true = (ImageView) findViewById(R.id._true3);
        ImageView _false = (ImageView) findViewById(R.id._false3);
        resetImage(_true, _false);
        if (box1.isChecked() && box2.isChecked() && box3.isChecked() && !box4.isChecked()) {
            mark += 1;
            showImage(_true);
        } else {
            showImage(_false);
        }

        return mark;
    }

    private int qu4(int mark) {
        EditText eText = (EditText) findViewById(R.id.editTextPrivate);
        ImageView _true = (ImageView) findViewById(R.id._true4);
        ImageView _false = (ImageView) findViewById(R.id._false4);
        resetImage(_true, _false);
        String editTextContent = eText.getText().toString().trim();
        String answer = getString(R.string.accessModifier);
        if (editTextContent.equalsIgnoreCase(answer)) {
            mark += 1;
            showImage(_true);
        } else {
            showImage(_false);
        }

        return mark;

    }

    public void total(View view) {
        int totalMark = 0;
        totalMark = qu1(totalMark);
        totalMark = qu2(totalMark);
        totalMark = qu3(totalMark);
        totalMark = qu4(totalMark);
        Toast.makeText(getApplicationContext(), "Your Mark " + totalMark + " /4",
                Toast.LENGTH_SHORT).show();
    }
}