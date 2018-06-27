package com.example.nesterkin.asynctaskexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

/**
 * @author Nesterkin Alexander on 25.06.2018
 */
public class ThirdFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Integer>> {

    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.third_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mProgressBar = view.findViewById(R.id.progress_bar);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (getActivity() != null) {
            Loader<List<Integer>> loader = getActivity().getSupportLoaderManager().initLoader(1, null, this);
            loader.forceLoad();
        }
    }

    @NonNull
    @Override
    public Loader<List<Integer>> onCreateLoader(int id, @Nullable Bundle args) {
        return new MyLoader2(getActivity());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Integer>> loader, List<Integer> data) {
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setAdapter(new MyAdapter(data));
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Integer>> loader) {
    }
}