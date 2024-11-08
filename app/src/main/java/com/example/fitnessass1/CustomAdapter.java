package com.example.fitnessass1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.TextView;



import com.example.fitnessass1.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item> {

    private final Context context;
    private final List<Item> items;

    public CustomAdapter(Context context, List<Item> items) {
        super(context, R.layout.list_item, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView textView = convertView.findViewById(R.id.item_text);

        Item currentItem = items.get(position);
        imageView.setImageResource(currentItem.getImageResource());
        textView.setText(currentItem.getText());

        return convertView;
    }
}
