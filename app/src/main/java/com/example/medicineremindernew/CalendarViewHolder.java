package com.example.medicineremindernew;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    private final ArrayList<LocalDate> days;
    private final ArrayList<String> numberWeek;
    public final View parentView;
    public final TextView dayOfMonth;
    public final TextView weekText;
    private final CalendarAdapter.OnItemListener onItemListener;
    private MainActivity context;


    public CalendarViewHolder(@NonNull View itemView, CalendarAdapter.OnItemListener onItemListener, ArrayList<LocalDate> days, ArrayList<String> numberWeek, MainActivity context)
    {
        super(itemView);
        parentView = itemView.findViewById(R.id.parentView);
        dayOfMonth = itemView.findViewById(R.id.cellDayText);
        weekText = itemView.findViewById(R.id.weekText);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
        this.days = days;
        this.numberWeek = numberWeek;
        this.context = context;
    }


    @Override
    public void onClick(View itemView)
    {
        onItemListener.onItemClick(getAdapterPosition(),
                days.get(getAdapterPosition()));

        context.onCalendarItem(context.databaseHelper, context.db);


    }
}
