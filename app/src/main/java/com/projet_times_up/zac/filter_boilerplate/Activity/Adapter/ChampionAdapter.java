package com.projet_times_up.zac.filter_boilerplate.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.projet_times_up.zac.filter_boilerplate.Activity.Data.Champion;
import com.projet_times_up.zac.filter_boilerplate.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zaccharie.BOUVY on 30/06/2017.
 */

public class ChampionAdapter extends BaseAdapter implements Filterable {

    private Context mContext;
    private ArrayList<Object> mItems;
    private ArrayList<Object> mFilterItems = new ArrayList<>();
    private LayoutInflater mInflater;

    private static String TAG = "ChampionAdapter";
    private static String TAG_OBJECT = "Champion";

    public ChampionAdapter(Context mContext, ArrayList<Object> items) {
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mContext = mContext;
        this.mItems = items;
        this.mFilterItems = items;
    }

    @Override
    public int getCount() {
        return mFilterItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LineHolder holder = new LineHolder();

        final Object item = mFilterItems.get(position);
        String className = item.getClass().getSimpleName();

        if(TAG_OBJECT.equals(className)) {
            convertView = mInflater.inflate(R.layout.row_champion, null);

            holder.name = (TextView) convertView.findViewById(R.id.tv_champion_name);
            holder.pi = (TextView) convertView.findViewById(R.id.tv_champion_pi);

            holder.name.setText(((Champion)item).getName());
            holder.pi.setText(String.valueOf(((Champion)item).getPricePI()));
        }
        else {
            convertView = mInflater.inflate(R.layout.row_letter, null);
            holder.letter = (TextView) convertView.findViewById(R.id.tv_letter);
            holder.letter.setText(item.toString());
        }

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();

                if (constraint == null || constraint.length() == 0) {
                    //no constraint given, just return all the data. (no search)
                    results.count = mItems.size();
                    results.values = mItems;

                } else {//do the search
                    List<Object> resultsData = new ArrayList<>();
                    String searchStr = constraint.toString().toUpperCase();
                    Collections.reverse(mItems);
                    boolean collabExistForThisHeader = false;
                    for (Object o : mItems) {
                        String className = o.getClass().getSimpleName();
                        if (TAG_OBJECT.equals(className)) {
                            if (((Champion) o).getName().toUpperCase().contains(searchStr)) {
                                resultsData.add(o);
                                collabExistForThisHeader = true;
                            }
                        }
                        else if(collabExistForThisHeader){
                            resultsData.add(o);
                            collabExistForThisHeader = false;
                        }
                    }
                    Collections.reverse(mItems);
                    Collections.reverse(resultsData);

                    results.count = resultsData.size();
                    results.values = resultsData;
                }
                return results;

            }

            @Override
            protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                mFilterItems =(ArrayList<Object>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    public static class LineHolder {
        public TextView name;
        public TextView pi;
        public TextView letter;

    }


}
