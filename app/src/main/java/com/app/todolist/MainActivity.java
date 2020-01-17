package com.app.todolist;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    LinearLayout lin;
    String[] Rdays;
    String dat = "";

    ArrayList<Button> btns = new ArrayList<>();
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int x = 0;
            for (int i = 0; i < btns.size(); i++) {
                btns.get(i).setTextColor(Color.WHITE);
                if (v.equals(btns.get(i))) {
                    a.setDays(Rdays[i]);
                }
            }
            Button b = (Button) v;
            b.setTextColor(Color.BLACK);


        }
    };

    RecyclerView rs;
    LsAdapter a;
    Data d = new Data();

    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rs = findViewById(R.id.ls);

        tabs = findViewById(R.id.tab_layout);
        lin = findViewById(R.id.lin);
        inti();

        final Date t = new Date();
        final SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

        a = new LsAdapter();
        Api.getClient().GetRoadMap(Rdays[0].replace(".", ""), Rdays[6].replace(".", "")).enqueue(new Callback<RoadMapModel>() {
            @Override
            public void onResponse(Call<RoadMapModel> call, Response<RoadMapModel> response) {
                d = response.body().getData();
                a.setVisiteds((ArrayList<Visited>) d.getNotVisited(), 0, format2.format(t));
            }

            @Override
            public void onFailure(Call<RoadMapModel> call, Throwable t) {

            }
        });
        rs.setAdapter(a);
        rs.setLayoutManager(new LinearLayoutManager(this));


        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0)
                    a.setVisiteds((ArrayList<Visited>) d.getNotVisited(), 0);
                else
                    a.setVisiteds((ArrayList<Visited>) d.getVisited(), 1);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    void inti() {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("EE\ndd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

        Rdays = new String[7];
        String[] days = new String[7];
        int delta = -now.get(GregorianCalendar.DAY_OF_WEEK); //add 2 if your week start on monday
        now.add(Calendar.DAY_OF_MONTH, delta);

        for (int i = 0; i < 7; i++) {
            Date t = new Date();
            String ts = format.format(t);
            Rdays[i] = format2.format(now.getTime());
            days[i] = format.format(now.getTime());
            if (ts.equals(days[i])) {
                days[i] += "-";
               // Rdays[i] += ".";
            }
            now.add(Calendar.DAY_OF_MONTH, 1);
        }
        //  Rdays[1] = format2.format(now.getTime());


        for (int i = 0; i < days.length; i++) {
            Button btn = new Button(this);
            btn.setText(days[i].replace("-", ""));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 80);
            layoutParams.setMargins(20, 20, 20, 0);
            // layoutParams.setMargins(100, 500, 100, 200);
            btn.setBackgroundResource(R.drawable.daybg);
            btn.setTextColor(Color.WHITE);
            if (days[i].contains("-")) {
                btn.setTextColor(Color.BLACK);
            }
            btn.setTypeface(btn.getTypeface(), Typeface.BOLD);
            btn.setLayoutParams(layoutParams);
            btn.setOnClickListener(click);
            lin.addView(btn);
            btns.add(btn);

        }
    }


}
