package com.oleg.hubal.thebestplayer.utility.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.oleg.hubal.thebestplayer.R;
import com.oleg.hubal.thebestplayer.model.TrackItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by User on 22.11.2016.
 */

public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.ViewHolder> {

    private final Context mContext;
    private OnTrackItemClickListener mOnTrackItemClickListener;
    private List<TrackItem> mTrackItems;

    public TrackListAdapter(Context context, OnTrackItemClickListener onTrackItemClickListener) {
        mContext = context;
        mOnTrackItemClickListener = onTrackItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_track, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(position, mTrackItems.get(position));

    }

    @Override
    public int getItemCount() {
        return (mTrackItems != null) ? mTrackItems.size() : 0;
    }

    public void setData(List<TrackItem> trackItems) {
        mTrackItems = trackItems;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private View mItemView;
        private TextView mArtistTextView;
        private TextView mTitleTextView;
        private Button mPlaylistQueueButton;
        private ImageView mAlbumArtImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            mAlbumArtImageView = (ImageView) itemView.findViewById(R.id.iv_album_art);
            mArtistTextView = (TextView) itemView.findViewById(R.id.tv_artist);
            mTitleTextView = (TextView) itemView.findViewById(R.id.tv_title);
            mPlaylistQueueButton = (Button) itemView.findViewById(R.id.btn_playlist_queue);
        }

        public void onBind(final int position, TrackItem trackItem) {
            Picasso.with(mContext).load(trackItem.getAlbumImage()).into(mAlbumArtImageView);
            mArtistTextView.setText(trackItem.getArtist());
            mTitleTextView.setText(trackItem.getTitle());
            mItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnTrackItemClickListener.onTrackClicked(position);
                }
            });
            mPlaylistQueueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnTrackItemClickListener.onQueueClicked(position);
                }
            });
        }
    }

    public interface OnTrackItemClickListener {
        void onTrackClicked(int position);
        void onQueueClicked(int position);
    }
}
