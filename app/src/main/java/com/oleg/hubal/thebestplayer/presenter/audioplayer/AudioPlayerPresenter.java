package com.oleg.hubal.thebestplayer.presenter.audioplayer;

import com.oleg.hubal.thebestplayer.view.audioplayer.AudioPlayerViewContract;

/**
 * Created by User on 23.11.2016.
 */

public class AudioPlayerPresenter implements AudioPlayerPresenterContract {

    private AudioPlayerViewContract mView;

    public AudioPlayerPresenter(AudioPlayerViewContract view) {
        mView = view;
    }

    @Override
    public void onStop() {

    }
}
