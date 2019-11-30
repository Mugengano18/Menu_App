package com.example.menu_app.models;

import android.widget.Filter;


import com.example.menu_app.adapter.Myadapter;

import java.util.ArrayList;

public class CustomFilter extends Filter {


    ArrayList<Model> filterList;
    Myadapter myadapter;

    public CustomFilter(ArrayList<Model> filterList, Myadapter myadapter) {
        this.filterList = filterList;
        this.myadapter = myadapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results =new FilterResults();
        if (constraint != null && constraint.length() > 0){

            constraint=constraint.toString().toUpperCase();

            ArrayList<Model>filterModels =new ArrayList<>();

            for (int i=0;i<filterList.size();i++){
                if (filterList.get(i).getName().toUpperCase().contains(constraint)){
                    filterModels.add(filterList.get(i));
                }
            }

            results.count=filterModels.size();
            results.values=filterModels;
        }
        else {
            results.count=filterList.size();
            results.values=filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        myadapter.models=(ArrayList<Model>)results.values;
        myadapter.notifyDataSetChanged();

    }
}
