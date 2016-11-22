package com.oleg.hubal.thebestplayer.view.tracklist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleg.hubal.thebestplayer.R;
import com.oleg.hubal.thebestplayer.model.TrackItem;
import com.oleg.hubal.thebestplayer.presenter.tracklist.TrackListPresenter;
import com.oleg.hubal.thebestplayer.presenter.tracklist.TrackListPresenterContract;

import java.util.ArrayList;

/**
 * Created by User on 22.11.2016.
 */

public class TrackListFragment extends Fragment implements TrackListViewContract {

    private static final String TAG = "TrackListFragment";

    private TrackListPresenterContract mPresenter;

    public static TrackListFragment newInstance() {
        return new TrackListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        mPresenter = new TrackListPresenter(getContext(), TrackListFragment.this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tracklist, container, false);

        launchTrackListLoader();
        return view;
    }

    void launchTrackListLoader() {
        getLoaderManager().initLoader(0, null, mPresenter.getTrackListLoader());
    }

    @Override
    public void showTrackList(ArrayList<TrackItem> trackList) {
        for (TrackItem trackItem : trackList) {
            Log.d(TAG, "showTrackList: " + trackItem.getTrackName() + " : " + trackItem.getArtist() + " : " + trackItem.getAlbumImage());
        }
    }
}