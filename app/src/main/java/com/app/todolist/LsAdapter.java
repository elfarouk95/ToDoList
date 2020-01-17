package com.app.todolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

public class LsAdapter extends RecyclerView.Adapter<txtHolder> {


    int type;
    ArrayList<Visited> RealVist = new ArrayList<>();
    ArrayList<Visited> visiteds = new ArrayList<>();


    @NonNull
    @Override
    public txtHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new txtHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull txtHolder t, int i) {

        t.txt.setText(visiteds.get(i).getCompanies().getName());
        if (type == 0)
            t.checkbox.setChecked(false);
        else
            t.checkbox.setChecked(true);

    }


    @Override
    public int getItemCount() {
        return RealVist.size();
    }


    String day;

    public void setDays(String getRday) {
        day = getRday;
        getRealVisit();
    }

    private void getRealVisit() {

        RealVist.clear();
        for (int i = 0; i < visiteds.size(); i++) {
            if (visiteds.get(i).getDate().contains(day)) {
                RealVist.add(visiteds.get(i));
            }
        }
    }

    public void setVisiteds(ArrayList<Visited> notVisited, int i, String format) {
        this.visiteds = notVisited;
        type = i;
        day = format;
        getRealVisit();
        notifyDataSetChanged();
    }

    public void setVisiteds(ArrayList<Visited> notVisited, int i) {
        setVisiteds(notVisited, i, day);
    }
}
