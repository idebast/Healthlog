package com.idebast.healthlog.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.idebast.healthlog.DatabaseHelper;
import com.idebast.healthlog.MainActivity;
import com.idebast.healthlog.R;
import com.idebast.healthlog.fragments.util.LogEntryAdapter;
import com.idebast.healthlog.fragments.util.LogEntryComparatorByDateTime;
import com.idebast.healthlog.model.DbHelperSingleton;


public class HistoryFragment extends Fragment {

    private static HistoryFragment mHistoryFragment;
    private LogEntryAdapter mLogEntryAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance() {
        mHistoryFragment = new HistoryFragment();

        return mHistoryFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);

        MainActivity activity = (MainActivity) getActivity();

        RecyclerView mRecyclerView = rootView.findViewById(R.id.rv_log);

        mLinearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        // https://stackoverflow.com/questions/46168245/recyclerview-reverse-order/56887306
        // https://stackoverflow.com/questions/46168245/recyclerview-reverse-order
        mLinearLayoutManager.setReverseLayout(true);
        mLinearLayoutManager.setStackFromEnd(true);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        ((MainActivity)getActivity()).logEntries.sort(new LogEntryComparatorByDateTime());

        mLogEntryAdapter = new LogEntryAdapter(((MainActivity)getActivity()).logEntries);
        mRecyclerView.setAdapter(mLogEntryAdapter);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Context fragmentContext = (MainActivity) view.getContext();
    }

    public void updateUi() {
        DatabaseHelper dbh = DbHelperSingleton.getINSTANCE().getDbHelper();

        dbh.readLogEntries(((MainActivity)getActivity()).logEntries);
        ((MainActivity)getActivity()).logEntries.sort(new LogEntryComparatorByDateTime());

        int indexLast = ((MainActivity)getActivity()).logEntries.size()-1;

        // https://stackoverflow.com/questions/31367599/how-to-update-recyclerview-adapter-data
        mLogEntryAdapter.notifyDataSetChanged();
        mLinearLayoutManager.scrollToPosition(indexLast); // index last omdat lijst omgekeerd is
    }
}