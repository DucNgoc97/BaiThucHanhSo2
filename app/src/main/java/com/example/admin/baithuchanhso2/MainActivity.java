package com.example.admin.baithuchanhso2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    EditText txtcol;
    EditText txtrow;
    Button btinit;
    Button btcalc;
    int col=0,row=0;
    GridLayout grid1,grid2,grid3;

    private View.OnClickListener onClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btinit)
                btinit_onClick();
            if(v.getId()==R.id.btcalc)
                btcalc_onClick();
        }
    };

    private void btcalc_onClick() {
        for (int i=0; i<col*row;i++){
            float a = Float.parseFloat(((EditText)(grid1.getChildAt(i))).getText().toString().trim());
            float b = Float.parseFloat(((EditText)(grid2.getChildAt(i))).getText().toString().trim());
            float c = a + b;
            ((EditText)(grid2.getChildAt(i))).setText(c+"");
        }
    }

    private void btinit_onClick() {
        grid1.removeAllViews();
        grid2.removeAllViews();
        grid3.removeAllViews();
        col=Integer.parseInt(txtcol.getText().toString().trim());
        row=Integer.parseInt(txtrow.getText().toString().trim());
        grid1.setColumnCount(col);
        grid1.setRowCount(row);
        grid2.setColumnCount(col);
        grid2.setRowCount(row);
        grid3.setColumnCount(col);
        grid3.setRowCount(row);
        for (int i=0;i<col*row;i++){
            EditText txt=new EditText(getApplicationContext());
            txt.setWidth(60);
            txt.setText("0");
            grid1.addView(txt,i);
        }
        for (int i=0;i<col*row;i++) {
            EditText txt = new EditText(getApplicationContext());
            txt.setWidth(60);
            txt.setText("0");
            grid2.addView(txt, i);
        }
        for (int i=0;i<col*row;i++) {
            EditText txt = new EditText(getApplicationContext());
            txt.setWidth(60);
            txt.setText("0");
            grid3.addView(txt,i);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //lay tu file thiet ke xml
        txtcol=findViewById(R.id.txtcol);
        txtrow=findViewById(R.id.txtrow);
        btinit=findViewById(R.id.btinit);
        btcalc=findViewById(R.id.btcalc);
        grid1=findViewById(R.id.grid1);
        grid2=findViewById(R.id.grid2);
        grid3=findViewById(R.id.grid3);

        //them su kien kich chuot cho 2 nut init va calc
        btinit.setOnClickListener(onClick);
        btcalc.setOnClickListener(onClick);
    }
}


