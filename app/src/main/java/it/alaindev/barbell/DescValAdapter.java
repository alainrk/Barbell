package it.alaindev.barbell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by narko on 29/09/16.
 */

public class DescValAdapter extends ArrayAdapter<Map.Entry<String, String>> {

    private Context context;

    public DescValAdapter(Context context, ArrayList<Map.Entry<String, String>> descval) {
        super(context, 0, descval);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        Map.Entry<String, String> descval = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.desc_and_val, parent, false);
        }

        TextView desctv = (TextView) convertView.findViewById(R.id.desctv);
        TextView valtv = (TextView) convertView.findViewById(R.id.valtv);

        // Populate the data into the template view using the data object
        String desc = descval.getKey();
        String val = descval.getValue();
        switch (desc) {
            case User.USER_PARAM_NAME:
                desc = User.USER_PARAM_NAME_DESC;
                break;
            case User.USER_PARAM_AGE:
                desc = User.USER_PARAM_AGE_DESC;
                break;
            case User.USER_PARAM_WEIGHT:
                desc = User.USER_PARAM_WEIGHT_DESC;
                val += " kg";
                break;
            case User.USER_PARAM_HEIGHT:
                desc = User.USER_PARAM_HEIGHT_DESC;
                val += " cm";
                break;
            case User.USER_PARAM_ACTIV:
                desc = User.USER_PARAM_ACTIV_DESC;
                val += "/4";
                break;
            case User.USER_PARAM_NUMWOS:
                desc = User.USER_PARAM_NUMWOS_DESC;
                break;
            case User.USER_PARAM_MINUTES:
                desc = User.USER_PARAM_MINUTES_DESC;
                val += " min";
                break;
            case User.USER_PARAM_HARDWO:
                desc = User.USER_PARAM_HARDWO_DESC;
                val += "/4";
                break;
        }

        desctv.setText(desc);
        valtv.setText(val);

        return convertView;
    }

}
