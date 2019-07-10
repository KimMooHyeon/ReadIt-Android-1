package com.computer.inu.readit_appjam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.computer.inu.readit_appjam.Data.HomeCategoryTab;
import com.computer.inu.readit_appjam.R;

import java.util.ArrayList;


public class AdapterSpinner1 extends BaseAdapter {
    Context context;
    ArrayList<HomeCategoryTab> data;
    LayoutInflater inflater;

    public AdapterSpinner1(Context context, ArrayList<HomeCategoryTab> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        if (data != null) return data.size();
        else return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinner_spinner1_normal, parent, false);
        }

        if (data != null) {
            //데이터세팅
            String text = data.get(position).getTabName();
            ((TextView) convertView.findViewById(R.id.spinnerText)).setText(text);
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinner_spinner1_dropdown, parent, false);
        }

        //데이터세팅
        String text = data.get(position).getTabName();
        ((TextView) convertView.findViewById(R.id.spinnerText)).setText(text);

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getCategory_idx();
    }


}
