package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    int cnt=0;
    Button[] btn=new Button[9];
    TextView textView;
    Button restart;
    ArrayList list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.display);
        restart=findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }
        });
        for(int i=0;i<btn.length;i++)
        {
            int id=getResources().getIdentifier("btn"+i,"id",getPackageName());
            btn[i]=findViewById(id);
            btn[i].setOnClickListener(this);
            System.out.println("id="+id);
        }

    }

    private void restartGame()
    {
        for(int i=0;i<btn.length;i++)
        {
            btn[i].setEnabled(true);
            list.clear();
            btn[i].setText("");
            cnt=0;
            textView.setText("");
        }
    }

    @Override
    public void onClick(View view)
    {
        for(int i=0;i< btn.length;i++)
        {
            if(view.getId()==btn[i].getId())
            {
//                if(cnt%2==0)
//                {
//                    btn[i].setText("X");
//                    cnt++;
//                    win();
//                    btn[i].setEnabled(false);
//                }
//                else
//                {
//
//                    btn[i].setText("O");
//                    btn[i].setEnabled(false);
//                    cnt++;
//                    win();
//                }
                btn[i].setText("X");
                btn[i].setEnabled(false);
                list.add(i);
                cnt++;
                win();
                System.out.println("User tick="+i);
                if(cnt<=4)
                {
                    while (true)
                    {
                        int min=0,max=9;
                        int r=new Random().nextInt(max-min)+min;
                        System.out.println("Random="+r);
                        if(!list.contains(r))
                        {
                            btn[r].setText("O");
                            btn[r].setEnabled(false);
                            list.add(r);
                            win();
                            System.out.println("System Tick="+r);
                            break;
                        }
                    }
                }


            }

        }
        System.out.println("List"+list);

    }
    private void win()
    {
       if (btn[0].getText().toString().equalsIgnoreCase("x") && btn[1].getText().toString().equalsIgnoreCase("x") && btn[2].getText().toString().equalsIgnoreCase("x"))
       {
            textView.setText("x win");
            disabled();

       }
       else if (btn[0].getText().toString().equalsIgnoreCase("O") && btn[1].getText().toString().equalsIgnoreCase("O") && btn[2].getText().toString().equalsIgnoreCase("O")){
           textView.setText("o win");
           disabled();
       }
       else if (btn[3].getText().toString().equalsIgnoreCase("x") && btn[4].getText().toString().equalsIgnoreCase("x") && btn[5].getText().toString().equalsIgnoreCase("x"))
        {
            textView.setText("x win");
            disabled();
        }
        else if (btn[3].getText().toString().equalsIgnoreCase("O") && btn[4].getText().toString().equalsIgnoreCase("O") && btn[5].getText().toString().equalsIgnoreCase("O")) {
            textView.setText("o win");
            disabled();
        }
        else if (btn[6].getText().toString().equalsIgnoreCase("x") && btn[7].getText().toString().equalsIgnoreCase("x") && btn[8].getText().toString().equalsIgnoreCase("x"))
        {
            textView.setText("x win");
            disabled();
        }
        else if (btn[6].getText().toString().equalsIgnoreCase("O") && btn[7].getText().toString().equalsIgnoreCase("O") && btn[8].getText().toString().equalsIgnoreCase("O")) {
            textView.setText("o win");
            disabled();
        }
        else if (btn[0].getText().toString().equalsIgnoreCase("x") && btn[3].getText().toString().equalsIgnoreCase("x") && btn[6].getText().toString().equalsIgnoreCase("x"))
        {
            textView.setText("x win");
            disabled();
        }
        else if (btn[0].getText().toString().equalsIgnoreCase("O") && btn[3].getText().toString().equalsIgnoreCase("O") && btn[6].getText().toString().equalsIgnoreCase("O")) {
            textView.setText("o win");
            disabled();
        }
        else if (btn[1].getText().toString().equalsIgnoreCase("x") && btn[4].getText().toString().equalsIgnoreCase("x") && btn[7].getText().toString().equalsIgnoreCase("x"))
        {
            textView.setText("x win");
            disabled();
        }
        else if (btn[1].getText().toString().equalsIgnoreCase("O") && btn[4].getText().toString().equalsIgnoreCase("O") && btn[7].getText().toString().equalsIgnoreCase("O")) {
            textView.setText("o win");
            disabled();
        }
        else if (btn[2].getText().toString().equalsIgnoreCase("x") && btn[5].getText().toString().equalsIgnoreCase("x") && btn[8].getText().toString().equalsIgnoreCase("x"))
        {
            textView.setText("x win");
            disabled();
        }
        else if (btn[2].getText().toString().equalsIgnoreCase("O") && btn[5].getText().toString().equalsIgnoreCase("O") && btn[8].getText().toString().equalsIgnoreCase("O")){
            textView.setText("o win");
            disabled();
        }
        else if (btn[0].getText().toString().equalsIgnoreCase("x") && btn[4].getText().toString().equalsIgnoreCase("x") && btn[8].getText().toString().equalsIgnoreCase("x"))
        {
            textView.setText("x win");
            disabled();
        }
        else if (btn[0].getText().toString().equalsIgnoreCase("O") && btn[4].getText().toString().equalsIgnoreCase("O") && btn[8].getText().toString().equalsIgnoreCase("O")){
            textView.setText("o win");
            disabled();
        }
        else if (btn[2].getText().toString().equalsIgnoreCase("x") && btn[4].getText().toString().equalsIgnoreCase("x") && btn[6].getText().toString().equalsIgnoreCase("x"))
        {
            textView.setText("x win");
            disabled();
        }
       else if (btn[2].getText().toString().equalsIgnoreCase("O") && btn[4].getText().toString().equalsIgnoreCase("O") && btn[6].getText().toString().equalsIgnoreCase("O"))
       {
           textView.setText("O win");
           disabled();
       }
//        else if (btn[0].getText().toString().equalsIgnoreCase("x") && btn[4].getText().toString().equalsIgnoreCase("x") && btn[8].getText().toString().equalsIgnoreCase("x") && btn[2].getText().toString().equalsIgnoreCase("x") && btn[4].getText().toString().equalsIgnoreCase("x") && btn[6].getText().toString().equalsIgnoreCase("x")){
//            textView.setText("x win");
//            disabled();
//        }
//       else if (btn[0].getText().toString().equalsIgnoreCase("O") && btn[4].getText().toString().equalsIgnoreCase("O") && btn[8].getText().toString().equalsIgnoreCase("O") && btn[2].getText().toString().equalsIgnoreCase("O") && btn[4].getText().toString().equalsIgnoreCase("O") && btn[6].getText().toString().equalsIgnoreCase("x") ){
//           textView.setText("O win");
//           disabled();
//       }

       else if(!btn[0].getText().toString().isEmpty()&&!btn[1].getText().toString().isEmpty()&&!btn[2].getText().toString().isEmpty()&&!btn[3].getText().toString().isEmpty()&&!btn[4].getText().toString().isEmpty()&&!btn[5].getText().toString().isEmpty()&&!btn[6].getText().toString().isEmpty()&&!btn[7].getText().toString().isEmpty()&&!btn[8].getText().toString().isEmpty())
       {
                textView.setText("Game Tied..");
                disabled();
       }
        System.out.println("Count="+cnt);

    }

    private void disabled()
    {
        for(int i=0;i<btn.length;i++)
        {
            btn[i].setEnabled(false);
            list.clear();
            cnt=0;
        }

    }
}