package com.example.nesterkin.asynctaskexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author Nesterkin Alexander on 25.06.2018
 */
public class FirstFragment extends Fragment implements LoaderManager.LoaderCallbacks<Integer> {

    private Button mButton;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton = view.findViewById(R.id.first_button);

        if (getActivity() != null) {
            Loader<Integer> loader = getActivity().getSupportLoaderManager().initLoader(0, null, this);
            loader.forceLoad();
        }
    }

    @NonNull
    @Override
    public Loader<Integer> onCreateLoader(int id, @Nullable Bundle args) {
        return new MyLoader(getActivity());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Integer> loader, Integer data) {
        mButton.setBackgroundColor(data);
        mButton.setText(Integer.toHexString(data));
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Integer> loader) {
    }
}