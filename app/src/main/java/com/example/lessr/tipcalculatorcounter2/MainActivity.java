package com.example.lessr.tipcalculatorcounter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private static SeekBar seekbar;
    private static TextView seekbarPercent;
    private double numPeople;
    private double billTotal;
    private double totalPerPerson;
    private EditText numOfPeople;
    private EditText totalBill;
    private double finalAmount;
    private TextView numTip;
    private TextView numTotalPerPerson;
    private double tipAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbar();
        double tipPercent;
        tipPercent = seekbar.getProgress();
        numPeople = Double.parseDouble(numOfPeople.getText().toString());
        billTotal = Double.parseDouble(totalBill.getText().toString());

        tipAmount = tipPercent * billTotal;
        finalAmount = billTotal + tipAmount;
        totalPerPerson = finalAmount / numPeople;

        numTotalPerPerson.setText((int) totalPerPerson);
        numTip.setText((int) tipAmount);

    }

    public void seekbar(){
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbarPercent = (TextView) findViewById(R.id.textView3);
        seekbarPercent.setText(seekbar.getProgress());
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                value = i;
                seekbarPercent.setText(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarPercent.setText(value);
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("MyString", Double.toString(numPeople));
        savedInstanceState.putString("MyBill", Double.toString(billTotal));
        savedInstanceState.putString("MyTPPerson", Double.toString(totalPerPerson));
        savedInstanceState.putString("MyTip", Double.toString(tipAmount));
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String myString = savedInstanceState.getString("MyString");
        numPeople = Double.valueOf(myString);
        numOfPeople.setText(Double.toString(numPeople));

        String myBill = savedInstanceState.getString("MyBill");
        billTotal = Double.valueOf(myBill);
        totalBill.setText(Double.toString(billTotal));

        String myTPPerson = savedInstanceState.getString("MyTotal");
        totalPerPerson = Double.valueOf(myTPPerson);
        numTotalPerPerson.setText(Double.toString(totalPerPerson));

        String myTip = savedInstanceState.getString("MyTip");
        tipAmount = Double.valueOf(myTip);
        numTip.setText(Double.toString(tipAmount));
    }

   /** private void showErrorAlert(String errorMessage, final int fieldId) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(errorMessage)
                .setNeutralButton("Close",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                findViewById(fieldId).requestFocus();
                            }
                        }).show();
    } */
}
