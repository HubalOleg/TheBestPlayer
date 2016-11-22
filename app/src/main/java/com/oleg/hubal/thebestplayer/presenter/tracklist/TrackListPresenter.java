package com.oleg.hubal.thebestplayer.presenter.tracklist;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.oleg.hubal.thebestplayer.model.TrackItem;
import com.oleg.hubal.thebestplayer.view.tracklist.TrackListViewContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 22.11.2016.
 */

public class TrackListPresenter implements TrackListPresenterContract {

    private final Context mContext;
    private TrackListViewContract mView;

//    CALLBACK

    private LoaderManager.LoaderCallbacks<Cursor> mCursorLoader = new LoaderManager.LoaderCallbacks<Cursor>() {
        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            return new CursorLoader(mContext,
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    null,
                    null,
                    null,
                    null);
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            List<TrackItem> trackItems = new ArrayList<>();

            if (data.moveToFirst()) {
                do {
                    int albumId = data.getInt(data.getColumnIndex(MediaStore.Audio.AlbumColumns.ALBUM_ID));
                    Uri uri = ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), albumId);
                    String albumImage = uri.toString();
                    String artist = data.getString(data.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                    artist = artist.replace("<unknown>", "");
                    String title = data.getString(data.getColumnIndex(MediaStore.Audio.Media.TITLE));
                    trackItems.add(new TrackItem(albumImage, artist, title));
                } while (data.moveToNext());
            }

            mView.showTrackList(trackItems);
        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {

        }
    };

//    CALLBACK END

    public TrackListPresenter(Context context, TrackListViewContract view) {
        mContext = context;
        mView = view;
    }

    @Override
    public LoaderManager.LoaderCallbacks<Cursor> getTrackListLoader() {
        return mCursorLoader;
    }

    @Override
    public void onStop() {
    }
}
