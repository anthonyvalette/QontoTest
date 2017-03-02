package qonto.test.qontotest.ui.fragments.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import qonto.test.qontotest.R;
import qonto.test.qontotest.model.user.User;

public class HomeFragmentUserListAdapter extends RecyclerView.Adapter<HomeFragmentUserListAdapter.ViewHolder> {
    private final ArrayList<User> users;
    private final OnItemClickListener listener;


    public HomeFragmentUserListAdapter(ArrayList users, OnItemClickListener listener) {
        this.users = users;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setOnItemClickListener(listener, position);
        holder.setName(users.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mName = (TextView) itemView.findViewById(R.id.user_item_name);
        }

        public void setName(String name) {
            mName.setText(name);
        }

        public void setOnItemClickListener(final OnItemClickListener listener, final int position) {
            mName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(users.get(position));
                }
            });
        }
    }
}

