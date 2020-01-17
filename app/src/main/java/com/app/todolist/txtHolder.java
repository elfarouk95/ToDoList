package com.app.todolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class txtHolder extends RecyclerView.ViewHolder {
    TextView txt;
    CheckBox checkbox;

    public txtHolder(@NonNull View itemView) {
        super(itemView);
        txt = itemView.findViewById(R.id.txt);
        checkbox = itemView.findViewById(R.id.checkbox);
    }
}
