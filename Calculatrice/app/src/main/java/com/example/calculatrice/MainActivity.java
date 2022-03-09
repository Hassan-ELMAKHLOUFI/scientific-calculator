package com.example.calculatrice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.*;
import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    TextView operation ;
    EditText resultat ;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operation = this.findViewById(R.id.operation);
        resultat = this.findViewById(R.id.resultat);
        resultat.setShowSoftInputOnFocus(false);


    }

    public void changer(String str){
        String leftPos,rightPos;
        String value=resultat.getText().toString();
        int cursorPosition=resultat.getSelectionStart();
        leftPos=value.substring(0,cursorPosition);
        rightPos=value.substring(cursorPosition);
        resultat.setText(leftPos+str+rightPos);
        resultat.setSelection(cursorPosition+str.length());


    }


    public void zero(View view){
        changer("0");
    }
    public void one(View view){
        changer("1");
    }
    public void two(View view){
        changer("2");
    }
    public void three(View view){
        changer("3");
    }
    public void four(View view){
        changer("4");
    }
    public void five(View view){
        changer("5");
    }
    public void six(View view){
        changer("6");
    }
    public void seven(View view){
        changer("7");
    }
    public void eight(View view){
        changer("8");
    }
    public void nine(View view){
        changer("9");
    }
    public void mul(View view){
        changer("*");
    }
    public void div(View view){
        changer("/");
    }
    public void sous(View view){
        changer("-");
    }
    public void add(View view){
        changer("+");
    }
    public void delete(View view){
       int curPos = resultat.getSelectionStart();
       int stringSize = resultat.getText().length();

       if(curPos != 0){
           SpannableStringBuilder selection= (SpannableStringBuilder) resultat.getText();
            selection.replace(curPos-1,curPos,"");
       }
    }
    public void clear(View view){
        resultat.setText("");
    }
    public void parClose(View view){
        changer(")");
    }
    public void parOpen(View view){
        changer("(");
    }
    public void Decimal(View view){
        changer(".");
    }
    public void equal(View view){
        String opt = resultat.getText().toString();
        Expression exp= new Expression(opt);
        String res=String.valueOf(exp.calculate());
        resultat.setText(res);
        resultat.setSelection(resultat.length());
    }


}