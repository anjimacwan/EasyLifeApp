package com.example.anjimacwan.easylifeapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.anjimacwan.easylifeapp.R;
import com.example.anjimacwan.easylifeapp.activities.Notepad;
import com.example.anjimacwan.easylifeapp.adapters.NoteListAdapter;
import com.example.anjimacwan.easylifeapp.models.Note;
import com.example.anjimacwan.easylifeapp.utilities.SampleData;
import com.melnykov.fab.FloatingActionButton;

import java.util.List;


public class NoteListFragment extends Fragment {

    private FloatingActionButton mFab;
    private View mRootView;
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    Note mNotes;
    NoteListAdapter mAdapter;

    public NoteListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment and hold the reference
        //in mRootView
        mRootView = inflater.inflate(R.layout.fragment_note_list, container, false);

        //Get a programmatic reference to the Floating Action Button
        mFab = (FloatingActionButton)mRootView.findViewById(R.id.fab);

        //attach an onClick listener to the Floating Action Button
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Notepad.class));
            }
        });
        setupList();
        return mRootView;
    }

    private void setupList() {
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.note_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        final GestureDetector mGestureDetector =
                new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }
                });

        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    int position = recyclerView.getChildLayoutPosition(child);
                    //Note selectedNote = mNotes.get(position);

                    //now we have the selected note

                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        mNotes = (Note) SampleData.getSampleNotes();
        mAdapter = new NoteListAdapter((List<Note>) mNotes, getActivity());
        mRecyclerView.setAdapter(mAdapter);
    }

}