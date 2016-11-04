package com.example.anjimacwan.easylifeapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anjimacwan.easylifeapp.R;
import com.example.anjimacwan.easylifeapp.models.Note;

import java.util.List;

/**
 * Created by Anji Macwan on 2016-11-01.
 */
public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder>{

private List<Note> mNotes;
private Context mContext;


public NoteListAdapter(List<Note> notes, Context context){
        mNotes = notes;
        mContext = context;

        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_note_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
        }

@Override
public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.noteTitle.setText(mNotes.get(position).getTitle());
        holder.noteCreateDate.setText(mNotes.get(position).getReadableModifiedDate());
        }

@Override
public int getItemCount() {
        return mNotes.size();
        }


public static class ViewHolder extends RecyclerView.ViewHolder {
    public final TextView noteTitle, noteCreateDate;



    public ViewHolder(View itemView) {
        super(itemView);
        noteTitle = (TextView)itemView.findViewById(R.id.text_view_note_title);
        noteCreateDate = (TextView)itemView.findViewById(R.id.text_view_note_date);
    }

}
}