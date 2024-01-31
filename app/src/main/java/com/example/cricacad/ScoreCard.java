package com.example.cricacad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.LinkedList;

public class ScoreCard extends AppCompatActivity {


    private int ovafterdeci=0;
    private int ovbeforedeci=0;
    private int times=0;
    private int undosafety=0;
    private int wkt=0;
    private int prevundo=0;
    class ll {
        Node head,tail;
        Node prev,temp;
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
        public void addl(int data)
        {
            Node nNode=new Node(data);
            if(head==null)
            {
                head=nNode;
                tail=nNode;
                prev=nNode;
                return;
            }
            Node cur=head;
            while(cur.next!=null)
            {
                cur=cur.next;
            }
            cur.next=nNode;

            prev=cur;
            prev.next=nNode;
            tail.next=nNode;
            tail = nNode;

        }
        public int curvalue()
        {
            return tail.data;
        }
        public int prevvalue()
        {
            temp=tail;
            tail=prev;
            tail.next=null;
            return prev.data;
        }
        public int redovalue()
        {
            tail.next=temp;
            tail=tail.next;
            return temp.data;
        }
        public int newredo()
        {
            return temp.data;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        getSupportActionBar().hide();

        TextView Batsman1=findViewById(R.id.textView37);
        TextView Batsman2=findViewById(R.id.textView45);
        TextView TeamsName=findViewById(R.id.textView18);
        TextView BattingTeamName=findViewById(R.id.textView14);
        TextView BowlerName=findViewById(R.id.textView58);
        TextView TotalRunView=findViewById(R.id.textView15);
        TextView Batsman1runsview=findViewById(R.id.textView39);
        TextView Batsman1bowlsview=findViewById(R.id.textView41);
        TextView Batsman2runsview=findViewById(R.id.textView46);
        TextView Batsman2bowlsview=findViewById(R.id.textView47);

        Intent intent=getIntent();

        Batsman1.setText(intent.getStringExtra("Striker"));
        Batsman2.setText(intent.getStringExtra("NonStriker"));
        TeamsName.setText("Match: "+intent.getStringExtra("teamAname")+" vs "+intent.getStringExtra("teamBname"));
        BattingTeamName.setText(intent.getStringExtra("teamAname")+",(T"+intent.getStringExtra("overs")+")");
        BowlerName.setText(intent.getStringExtra("Bowler"));

        ll TotalRuns=new ll();
        ll Batsman1Runs=new ll();
        ll Batsman1bowls=new ll();
        ll Batsman2Runs=new ll();
        ll Batsman2bowls=new ll();


        TotalRuns.addl(0);
        Batsman1Runs.addl(0);
        Batsman1bowls.addl(0);
        Batsman2Runs.addl(0);
        Batsman2bowls.addl(0);



        ImageButton dot=findViewById(R.id.imageButton2);
        ImageButton one=findViewById(R.id.imageButton3);
        ImageButton two=findViewById(R.id.imageButton4);
        ImageButton three=findViewById(R.id.imageButton5);
        ImageButton four=findViewById(R.id.imageButton6);
        ImageButton five=findViewById(R.id.imageButton7);
        ImageButton six=findViewById(R.id.imageButton8);
        ImageButton wide=findViewById(R.id.imageButton9);
        ImageButton undo=findViewById(R.id.imageButton11);
        ImageButton redo=findViewById(R.id.imageButton12);
        ImageButton wicket=findViewById(R.id.imageButton);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setEnabled(false);
                undosafety=0;
                int totalrun = TotalRuns.curvalue() ;
                totalrun++;
                TotalRuns.addl(totalrun);
                times++;

                ovafterdeci++;

                if (ovafterdeci < 6 && times%2!=0) {
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);

                    int batsman1run = Batsman1Runs.curvalue();
                    int batsman1bowls = Batsman1bowls.curvalue();
                    batsman1run++;
                    batsman1bowls++;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman1bowlsview.setText(Batsman2bowls.curvalue()+"");
                    Batsman2runsview.setText(batsman1run+"");
                    Batsman2bowlsview.setText(batsman1bowls+"");
                }

                else if(ovafterdeci < 6 && times%2==0){
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);
                        int batsman2run = Batsman2Runs.curvalue() ;
                        int batsman2bowls = Batsman2bowls.curvalue() ;
                    batsman2run++;
                    batsman2bowls++;
                        Batsman2Runs.addl(batsman2run);
                        Batsman2bowls.addl(batsman2bowls);
                        Batsman2runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                        Batsman2bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                        Batsman1runsview.setText(String.valueOf(batsman2run));
                        Batsman1bowlsview.setText(String.valueOf(batsman2bowls));
                }
                else if (ovafterdeci == 6 && times%2!=0) {
                    ovbeforedeci++;
                    ovafterdeci = 0;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                        int batsman1run = Batsman1Runs.curvalue() ;
                        int batsman1bowls = Batsman1bowls.curvalue() ;
                    batsman1run++;
                    batsman1bowls++;
                        Batsman1Runs.addl(batsman1run);
                        Batsman1bowls.addl(batsman1bowls);
                        Batsman1runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                        Batsman1bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                    Batsman2runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    }
                    else{
                    ovbeforedeci++;
                    ovafterdeci = 0;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                        int batsman2run = Batsman2Runs.curvalue() ;
                        int batsman2bowls = Batsman2bowls.curvalue() ;
                    batsman2run++;
                    batsman2bowls++;
                        Batsman2Runs.addl(batsman2run);
                        Batsman2bowls.addl(batsman2bowls);
                        Batsman2runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                        Batsman2bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    Batsman1runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                    }
                one.setEnabled(true);
                }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                three.setEnabled(false);
                undosafety=0;
                int totalrun = TotalRuns.curvalue() ;
                totalrun+=3;
                TotalRuns.addl(totalrun);
                times++;

                ovafterdeci++;

                if (ovafterdeci < 6 && times%2!=0) {
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);

                    int batsman1run = Batsman1Runs.curvalue();
                    int batsman1bowls = Batsman1bowls.curvalue();
                    batsman1run+=3;
                    batsman1bowls+=1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman1bowlsview.setText(Batsman2bowls.curvalue()+"");
                    Batsman2runsview.setText(batsman1run+"");
                    Batsman2bowlsview.setText(batsman1bowls+"");
                }

                else if(ovafterdeci < 6 && times%2==0){
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);
                    int batsman2run = Batsman2Runs.curvalue() ;
                    int batsman2bowls = Batsman2bowls.curvalue() ;
                    batsman2run+=3;
                    batsman2bowls+=1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman2runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                    Batsman1runsview.setText(String.valueOf(batsman2run));
                    Batsman1bowlsview.setText(String.valueOf(batsman2bowls));
                }
                else if (ovafterdeci == 6 && times%2!=0) {
                    ovbeforedeci++;
                    ovafterdeci = 0;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                    int batsman1run = Batsman1Runs.curvalue() ;
                    int batsman1bowls = Batsman1bowls.curvalue() ;
                    batsman1run+=3;
                    batsman1bowls+=1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                    Batsman2runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                }
                else if (ovafterdeci == 6 &&times%2==0){
                    ovbeforedeci++;
                    ovafterdeci = 0;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    int batsman2run = Batsman2Runs.curvalue() ;
                    int batsman2bowls = Batsman2bowls.curvalue() ;
                    batsman2run+=3;
                    batsman2bowls+=1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman2runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    Batsman1runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                three.setEnabled(true);
            }

        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                five.setEnabled(false);
                undosafety=0;
                int totalrun = TotalRuns.curvalue() ;
                totalrun+=5;
                TotalRuns.addl(totalrun);
                times++;

                ovafterdeci++;

                if (ovafterdeci < 6 && times%2!=0) {
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);

                    int batsman1run = Batsman1Runs.curvalue();
                    int batsman1bowls = Batsman1bowls.curvalue();
                    batsman1run+=5;
                    batsman1bowls+=1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman1bowlsview.setText(Batsman2bowls.curvalue()+"");
                    Batsman2runsview.setText(batsman1run+"");
                    Batsman2bowlsview.setText(batsman1bowls+"");
                }

                else if(ovafterdeci < 6 && times%2==0){
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);
                    int batsman2run = Batsman2Runs.curvalue() ;
                    int batsman2bowls = Batsman2bowls.curvalue() ;
                    batsman2run+=5;
                    batsman2bowls+=1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman2runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                    Batsman1runsview.setText(String.valueOf(batsman2run));
                    Batsman1bowlsview.setText(String.valueOf(batsman2bowls));
                }
                else if (ovafterdeci == 6 && times%2!=0) {
                    ovbeforedeci++;
                    ovafterdeci = 0;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                    int batsman1run = Batsman1Runs.curvalue() ;
                    int batsman1bowls = Batsman1bowls.curvalue() ;
                    batsman1run+=5;
                    batsman1bowls+=1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                    Batsman2runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                }
                else if (ovafterdeci == 6 &&times%2==0){
                    ovbeforedeci++;
                    ovafterdeci = 0;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    int batsman2run = Batsman2Runs.curvalue() ;
                    int batsman2bowls = Batsman2bowls.curvalue() ;
                    batsman2run+=5;
                    batsman2bowls+=1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman2runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    Batsman1runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                five.setEnabled(true);
            }

        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                two.setEnabled(false);

                int totalrun = TotalRuns.curvalue() ;
                totalrun+=2;
                TotalRuns.addl(totalrun);
                undosafety=0;

                ovafterdeci++;

                if (ovafterdeci != 6 && times%2==0) {
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                    Batsman1.setText(Batsman1.getText().toString());
                    Batsman2.setText(Batsman2.getText().toString());

                    int batsman1run =Batsman1Runs.curvalue()+2;
                    int batsman1bowls=Batsman1bowls.curvalue()+1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(Batsman1Runs.curvalue()+"");
                    Batsman1bowlsview.setText(Batsman1bowls.curvalue()+"");
                    Batsman2runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman2bowlsview.setText(Batsman2bowls.curvalue()+"");
                }

                else if(ovafterdeci != 6 && times%2!=0){
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                    Batsman1.setText(Batsman1.getText().toString());
                    Batsman2.setText(Batsman2.getText().toString());

                    int batsman2run =Batsman2Runs.curvalue()+2;
                    int batsman2bowls=Batsman2bowls.curvalue()+1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman1runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman1bowlsview.setText(Batsman2bowls.curvalue()+"");
                    Batsman2runsview.setText(Batsman1Runs.curvalue()+"");
                    Batsman2bowlsview.setText(Batsman1bowls.curvalue()+"");
                }
                else if (ovafterdeci == 6 && times%2!=0) {
                    ovbeforedeci++;
                    times++;
                    ovafterdeci = 0;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);
                    int batsman2run = Batsman2Runs.curvalue() ;
                    int batsman2bowls = Batsman2bowls.curvalue() ;
                    batsman2run+=2;
                    batsman2bowls+=1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman1runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    Batsman2runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                else if (ovafterdeci == 6 &&times%2==0){
                    ovbeforedeci++;
                    ovafterdeci = 0;
                    times++;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);
                    int batsman1run = Batsman1Runs.curvalue() ;
                    int batsman1bowls = Batsman1bowls.curvalue() ;
                    batsman1run+=2;
                    batsman1bowls+=1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    Batsman2runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                two.setEnabled(true);
            }

        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                four.setEnabled(false);
                undosafety=0;
                int totalrun = TotalRuns.curvalue() ;
                totalrun+=4;
                TotalRuns.addl(totalrun);


                ovafterdeci++;

                if (ovafterdeci != 6 && times%2==0) {
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                    Batsman1.setText(Batsman1.getText().toString());
                    Batsman2.setText(Batsman2.getText().toString());

                    int batsman1run =Batsman1Runs.curvalue()+4;
                    int batsman1bowls=Batsman1bowls.curvalue()+1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(Batsman1Runs.curvalue()+"");
                    Batsman1bowlsview.setText(Batsman1bowls.curvalue()+"");
                    Batsman2runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman2bowlsview.setText(Batsman2bowls.curvalue()+"");
                }

                else if(ovafterdeci != 6 && times%2!=0){
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                    Batsman1.setText(Batsman1.getText().toString());
                    Batsman2.setText(Batsman2.getText().toString());

                    int batsman2run =Batsman2Runs.curvalue()+4;
                    int batsman2bowls=Batsman2bowls.curvalue()+1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman1runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman1bowlsview.setText(Batsman2bowls.curvalue()+"");
                    Batsman2runsview.setText(Batsman1Runs.curvalue()+"");
                    Batsman2bowlsview.setText(Batsman1bowls.curvalue()+"");
                }
                else if (ovafterdeci == 6 && times%2!=0) {
                    ovbeforedeci++;
                    times++;
                    ovafterdeci = 0;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);
                    int batsman2run = Batsman2Runs.curvalue() ;
                    int batsman2bowls = Batsman2bowls.curvalue() ;
                    batsman2run+=4;
                    batsman2bowls+=1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman1runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    Batsman2runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                else if (ovafterdeci == 6 &&times%2==0){
                    ovbeforedeci++;
                    ovafterdeci = 0;
                    times++;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);
                    int batsman1run = Batsman1Runs.curvalue() ;
                    int batsman1bowls = Batsman1bowls.curvalue() ;
                    batsman1run+=4;
                    batsman1bowls+=1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    Batsman2runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                four.setEnabled(true);
            }

        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                six.setEnabled(false);
                undosafety=0;
                int totalrun = TotalRuns.curvalue() ;
                totalrun+=6;
                TotalRuns.addl(totalrun);


                ovafterdeci++;

                if (ovafterdeci != 6 && times%2==0) {
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                    Batsman1.setText(Batsman1.getText().toString());
                    Batsman2.setText(Batsman2.getText().toString());

                    int batsman1run =Batsman1Runs.curvalue()+6;
                    int batsman1bowls=Batsman1bowls.curvalue()+1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(Batsman1Runs.curvalue()+"");
                    Batsman1bowlsview.setText(Batsman1bowls.curvalue()+"");
                    Batsman2runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman2bowlsview.setText(Batsman2bowls.curvalue()+"");
                }

                else if(ovafterdeci != 6 && times%2!=0){
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                    Batsman1.setText(Batsman1.getText().toString());
                    Batsman2.setText(Batsman2.getText().toString());

                    int batsman2run =Batsman2Runs.curvalue()+6;
                    int batsman2bowls=Batsman2bowls.curvalue()+1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman1runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman1bowlsview.setText(Batsman2bowls.curvalue()+"");
                    Batsman2runsview.setText(Batsman1Runs.curvalue()+"");
                    Batsman2bowlsview.setText(Batsman1bowls.curvalue()+"");
                }
                else if (ovafterdeci == 6 && times%2!=0) {
                    ovbeforedeci++;
                    times++;
                    ovafterdeci = 0;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);
                    int batsman2run = Batsman2Runs.curvalue() ;
                    int batsman2bowls = Batsman2bowls.curvalue() ;
                    batsman2run+=6;
                    batsman2bowls+=1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman1runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    Batsman2runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                else if (ovafterdeci == 6 &&times%2==0){
                    ovbeforedeci++;
                    ovafterdeci = 0;
                    times++;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);
                    int batsman1run = Batsman1Runs.curvalue() ;
                    int batsman1bowls = Batsman1bowls.curvalue() ;
                    batsman1run+=6;
                    batsman1bowls+=1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    Batsman2runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                six.setEnabled(true);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot.setEnabled(false);
                undosafety=0;
                int totalrun = TotalRuns.curvalue() ;

                TotalRuns.addl(totalrun);


                ovafterdeci++;

                if (ovafterdeci != 6 && times%2==0) {
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                    Batsman1.setText(Batsman1.getText().toString());
                    Batsman2.setText(Batsman2.getText().toString());

                    int batsman1run =Batsman1Runs.curvalue();
                    int batsman1bowls=Batsman1bowls.curvalue()+1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(Batsman1Runs.curvalue()+"");
                    Batsman1bowlsview.setText(Batsman1bowls.curvalue()+"");
                    Batsman2runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman2bowlsview.setText(Batsman2bowls.curvalue()+"");
                }

                else if(ovafterdeci != 6 && times%2!=0){
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                    Batsman1.setText(Batsman1.getText().toString());
                    Batsman2.setText(Batsman2.getText().toString());

                    int batsman2run =Batsman2Runs.curvalue();
                    int batsman2bowls=Batsman2bowls.curvalue()+1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman1runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman1bowlsview.setText(Batsman2bowls.curvalue()+"");
                    Batsman2runsview.setText(Batsman1Runs.curvalue()+"");
                    Batsman2bowlsview.setText(Batsman1bowls.curvalue()+"");
                }
                else if (ovafterdeci == 6 && times%2!=0) {
                    ovbeforedeci++;
                    times++;
                    ovafterdeci = 0;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);
                    int batsman2run = Batsman2Runs.curvalue() ;
                    int batsman2bowls = Batsman2bowls.curvalue() ;

                    batsman2bowls+=1;
                    Batsman2Runs.addl(batsman2run);
                    Batsman2bowls.addl(batsman2bowls);
                    Batsman1runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    Batsman2runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                else if (ovafterdeci == 6 &&times%2==0){
                    ovbeforedeci++;
                    ovafterdeci = 0;
                    times++;
                    TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    String tempswapBatsman1 = Batsman1.getText().toString();
                    Batsman1.setText(Batsman2.getText().toString());
                    Batsman2.setText(tempswapBatsman1);
                    int batsman1run = Batsman1Runs.curvalue() ;
                    int batsman1bowls = Batsman1bowls.curvalue() ;

                    batsman1bowls+=1;
                    Batsman1Runs.addl(batsman1run);
                    Batsman1bowls.addl(batsman1bowls);
                    Batsman1runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                    Batsman2runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman2bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                dot.setEnabled(true);
            }
        });
        wide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wide.setEnabled(false);
                int totalrun=TotalRuns.curvalue();
                totalrun++;
                TotalRuns.addl(totalrun);
                TotalRunView.setText(totalrun + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                wide.setEnabled(true);
            }
        });
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(undosafety==0) {
                undo.setEnabled(false);

                    ovafterdeci--;
                    undosafety++;
                    prevundo=TotalRuns.prevvalue();
                    TotalRunView.setText(prevundo + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                    int a = TotalRuns.curvalue();
                    int b = TotalRuns.prevvalue();
                    if ((a - b) % 2 != 0 && times % 2 == 0) {
                        times--;

                        String tempswapBatsman1 = Batsman1.getText().toString();
                        Batsman1.setText(Batsman2.getText().toString());
                        Batsman2.setText(tempswapBatsman1);
                        Batsman1runsview.setText(Batsman1Runs.prevvalue()+"");
                        Batsman1bowlsview.setText(Batsman1bowls.prevvalue()+"");
                        Batsman2runsview.setText(Batsman2Runs.curvalue()+"");
                        Batsman2bowlsview.setText(Batsman2bowls.curvalue()+"");
                    }
                    else if ((a - b) % 2 != 0 && times % 2 != 0) {
                        times--;

                        String tempswapBatsman1 = Batsman1.getText().toString();
                        Batsman1.setText(Batsman2.getText().toString());
                        Batsman2.setText(tempswapBatsman1);
                        Batsman1runsview.setText(Batsman2Runs.prevvalue()+"");
                        Batsman1bowlsview.setText(Batsman2bowls.prevvalue()+"");
                        Batsman2runsview.setText(Batsman1Runs.curvalue()+"");
                        Batsman2bowlsview.setText(Batsman1bowls.curvalue()+"");
                    }
                    else if ((a - b) % 2 == 0 && times % 2 != 0) {

                        Batsman1runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                        Batsman1bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                        Batsman2runsview.setText(String.valueOf(Batsman2Runs.prevvalue()));
                        Batsman2bowlsview.setText(String.valueOf(Batsman2bowls.prevvalue()));
                    } else if ((a - b) % 2 == 0 && times % 2 == 0) {
                        Batsman1runsview.setText(Batsman1Runs.prevvalue() + "");
                        Batsman1bowlsview.setText(Batsman1bowls.prevvalue() + "");
                        Batsman2runsview.setText(Batsman2Runs.curvalue() + "");
                        Batsman2bowlsview.setText(Batsman2bowls.curvalue() + "");
                    }
                    undo.setEnabled(true);
                }
            }
        });
        wicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket.setEnabled(false);
                wkt++;
                ovafterdeci++;
                if(ovafterdeci<6 && times%2==0)
                {
                    Batsman1Runs.addl(0);
                    Batsman1bowls.addl(0);
                    Batsman1runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                else if(ovafterdeci<6 && times%2!=0)
                {

                    Batsman2Runs.addl(0);
                    Batsman2bowls.addl(0);
                    Batsman1runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));

                }
                else if(ovafterdeci==6 && times%2==0)
                {
                    ovbeforedeci++;
                    times--;
                    ovafterdeci=0;
                    Batsman1Runs.addl(0);
                    Batsman1bowls.addl(0);
                    Batsman2runsview.setText(Batsman1Runs.curvalue()+"");
                    Batsman2bowlsview.setText(Batsman1bowls.curvalue()+"");
                    Batsman1runsview.setText(String.valueOf(Batsman2Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman2bowls.curvalue()));
                }
                else if(ovafterdeci==6 && times%2!=0)
                {
                    ovbeforedeci++;
                    times--;
                    ovafterdeci=0;
                    Batsman2Runs.addl(0);
                    Batsman2bowls.addl(0);
                    Batsman2runsview.setText(Batsman2Runs.curvalue()+"");
                    Batsman2bowlsview.setText(Batsman2bowls.curvalue()+"");
                    Batsman1runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                    Batsman1bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                }
                TotalRunView.setText(TotalRuns.curvalue() + "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");
                wicket.setEnabled(true);
            }
        });
        redo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(undosafety==1) {
                    redo.setEnabled(false);
                    ovafterdeci++;
                    undosafety--;
                    int a = TotalRuns.newredo();
                    int b=prevundo;
                    int tempredo=TotalRuns.redovalue()+(a-b);
                    TotalRunView.setText( tempredo+ "-" + wkt + " " + "(" + ovbeforedeci + "." + ovafterdeci + ")");

                    if ((a - b) % 2 != 0 && times % 2 == 0) {
                        times++;
                        String tempswapBatsman1 = Batsman1.getText().toString();
                        Batsman1.setText(Batsman2.getText().toString());
                        Batsman2.setText(tempswapBatsman1);
                        Batsman1runsview.setText(Batsman1Runs.redovalue()+"");
                        Batsman1bowlsview.setText(Batsman1bowls.redovalue()+"");
                        Batsman2runsview.setText(Batsman2Runs.curvalue()+"");
                        Batsman2bowlsview.setText(Batsman2bowls.curvalue()+"");
                    }
                    else if ((a - b) % 2 != 0 && times % 2 != 0) {
                        times++;

                        String tempswapBatsman1 = Batsman1.getText().toString();
                        Batsman1.setText(Batsman2.getText().toString());
                        Batsman2.setText(tempswapBatsman1);
                        Batsman1runsview.setText(Batsman2Runs.redovalue()+"");
                        Batsman1bowlsview.setText(Batsman2bowls.redovalue()+"");
                        Batsman2runsview.setText(Batsman1Runs.curvalue()+"");
                        Batsman2bowlsview.setText(Batsman1bowls.curvalue()+"");
                    }
                    else if ((a - b) % 2 == 0 && times % 2 != 0) {

                        Batsman1runsview.setText(String.valueOf(Batsman1Runs.curvalue()));
                        Batsman1bowlsview.setText(String.valueOf(Batsman1bowls.curvalue()));
                        Batsman2runsview.setText(String.valueOf(Batsman2Runs.redovalue()));
                        Batsman2bowlsview.setText(String.valueOf(Batsman2bowls.redovalue()));
                    } else if ((a - b) % 2 == 0 && times % 2 == 0) {
                        Batsman1runsview.setText(Batsman1Runs.redovalue() + "");
                        Batsman1bowlsview.setText(Batsman1bowls.redovalue() + "");
                        Batsman2runsview.setText(Batsman2Runs.curvalue() + "");
                        Batsman2bowlsview.setText(Batsman2bowls.curvalue() + "");
                    }
                    redo.setEnabled(true);
                }

            }
        });




    }
}