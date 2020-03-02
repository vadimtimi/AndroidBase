package com.refresh.pos.telegabot;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UsersListFragment extends Fragment {
    private List<Users> users = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users_list, container, false);
        Button button = (Button) view.findViewById(R.id.cmdLoadList);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recycleItemList);

        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(new CustomAdapter(generateData()));
        recyclerView.addItemDecoration(new DividerItemDecoration(container.getContext(), DividerItemDecoration.VERTICAL));

        return view;
    }

    private List<String> generateData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(String.valueOf(i) + "th Element");
        }
        return data;
    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
        private List<String> data;
        public CustomAdapter (List<String> data){
            this.data = data;
        }

        @Override
        public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ViewHolder(rowItem);
        }

        @Override
        public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
            holder.textView.setText(this.data.get(position));
        }

        @Override
        public int getItemCount() {
            return this.data.size();
        }

        public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView textView;

            public ViewHolder(View view) {
                super(view);
                view.setOnClickListener(this);
                this.textView = view.findViewById(R.id.textID);
            }

            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "position : " + getLayoutPosition() + " text : " + this.textView.getText(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static class Users {
        private String name;
        private String id;

        public Users(String name, String id){
            this.name=name;
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String name) {
            this.id = name;
        }
    }
}
