package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int valeur1 =0 ;
    int valeur2 =0  ;
    String operation  ;
    boolean isOp1=true ;
    TextView opt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opt = this.findViewById(R.id.operation);
        opt.setText("0");




    }

    public void setOperator(View view){
        isOp1=false ;
        String val = opt.getText().toString();
        Button btn = findViewById(view.getId());
        operation = btn.getText().toString();
        System.out.println(btn.getText().toString());
        opt.setText(val+btn.getText().toString());


    }
    public void equal(View view){
        int  result=10;

        if(operation.equals("+")){
            result=valeur1+valeur2;
            opt.setText("");
            opt.setText(""+result);
        }
        if(operation.equals("-")){
            result=valeur1-valeur2;
            opt.setText("");
            opt.setText(""+result);
            System.out.println("rs="+result);
        }
        if(operation.equals("X")){
            result=valeur1*valeur2;
            opt.setText("");
            opt.setText(""+result);
        }
        if(operation.equals("/")){
            result=valeur1/valeur2;
            opt.setText("");
            opt.setText(""+result);
        }

    }
    public void ajouterNbr(View view){
        Button btn = findViewById(view.getId());
        String val = opt.getText().toString();


        if(isOp1){
            valeur1= valeur1*10+Integer.parseInt(btn.getText().toString()) ;
        }
        if(!isOp1){
            valeur2= valeur2*10+Integer.parseInt(btn.getText().toString()) ;
        }

        if(val.equals("0")){
            opt.setText(""+btn.getText().toString());
        }else{
        opt.setText(val+btn.getText().toString());}
    }
}