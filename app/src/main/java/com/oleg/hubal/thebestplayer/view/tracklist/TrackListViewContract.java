package com.oleg.hubal.thebestplayer.view.tracklist;

import com.oleg.hubal.thebestplayer.model.TrackItem;

import java.util.ArrayList;

/**
 * Created by User on 22.11.2016.
 */

public interface TrackListViewContract {

    void showTrackList(ArrayList<TrackItem> trackList);

}
