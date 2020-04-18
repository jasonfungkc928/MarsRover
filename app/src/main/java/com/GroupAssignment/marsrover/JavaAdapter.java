package com.GroupAssignment.marsrover;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class JavaAdapter extends RecyclerView.Adapter<JavaAdapter.JavaViewHolder> {
    private Context context;
    private ArrayList<String> lessons;
    private JavaListener listener;
    public JavaAdapter(Context context, ArrayList<String> lessons, JavaListener listener) {
        this.context = context;
        this.lessons = lessons;
        this.listener = listener;
    }

    public interface JavaListener {
        void onClick(View view, int position);
    }

    @NonNull
    @Override
    public JavaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_row, parent, false);
        return new JavaViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull JavaViewHolder holder, int position) {
        holder.lessonText.setText(lessons.get(position));
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public static class JavaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView lessonText;
        JavaListener listener;
        public JavaViewHolder(@NonNull View itemView, JavaListener listener) {
            super(itemView);
            this.lessonText = itemView.findViewById(R.id.lessonText);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }
}
