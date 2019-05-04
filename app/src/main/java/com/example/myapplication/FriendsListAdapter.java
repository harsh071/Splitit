package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.okhttp.internal.Internal;

import java.util.List;

public class FriendsListAdapter extends RecyclerView.Adapter<FriendsListAdapter.ViewHolder> {

    public List<Friend> fList;

    public FriendsListAdapter(List<Friend> friends){
        fList = friends;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mNametext.setText(fList.get(i).getName());
        viewHolder.mOwestext.setText(String.valueOf(fList.get(i).getOwes()));
    }

    @Override
    public int getItemCount() {
        return fList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        View mview;

        public TextView mNametext;
        public TextView mOwestext;

        public ViewHolder(View itemView){
            super(itemView);
            mview = itemView;

            mNametext = (TextView) mview.findViewById(R.id.FriendName);
            mOwestext = (TextView) mview.findViewById(R.id.Owes);

        }
    }
}
