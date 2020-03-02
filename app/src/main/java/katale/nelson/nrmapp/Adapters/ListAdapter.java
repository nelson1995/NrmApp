package katale.nelson.nrmapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import katale.nelson.nrmapp.Models.ListItems;
import katale.nelson.nrmapp.R;

public class ListAdapter extends ArrayAdapter<ListItems> {
    private ArrayList<ListItems> places;
    private LayoutInflater layoutInflater;

    public ListAdapter(Context context,int resource ,ArrayList<ListItems> objects) {
        super(context, resource, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    public View getView(int position, View view, ViewGroup vg) {
        ListItems listItems = getItem(position);
        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_items, null);
        }
        TextView textView = view.findViewById(R.id.text_name1);
        textView.setText(listItems.getItem());

        return view;
    }
}
