package katale.nelson.nrmapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import katale.nelson.nrmapp.Adapters.ListAdapter;
import katale.nelson.nrmapp.Models.ListItems;
import katale.nelson.nrmapp.R;
import katale.nelson.nrmapp.Utils;

public class Structure extends Fragment implements AdapterView.OnItemClickListener {
    private Context mContext;
    ListAdapter listAdapter;
    ListView listView;
    ArrayList<ListItems> arrayList;
    ArrayAdapter arrayAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_structure, container, false);
        listView = view.findViewById(R.id.list);
        arrayList = new ArrayList();
        Utils.log("VALUES->"+ getString(R.string.cec));
        Utils.log("VALUES->"+ getString(R.string.nec));

        arrayList.add(new ListItems(getString(R.string.cec)));
        arrayList.add(new ListItems(getString(R.string.nec)));
        listAdapter = new ListAdapter(mContext,R.layout.fragment_structure,arrayList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
            case 0:
//                Structure.this.getActivity().getSupportFragmentManager().beginTransaction()
//                        .remove(Structure.this)
//                        .replace(((ViewGroup) Structure.this.getView().getParent()).getId(), new Cec(), "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();
                Structure.this.getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(Structure.this)
                        .replace(view.getId(), new Cec(), "Central executive council")
                        .addToBackStack(null)
                        .commit();

                break;
            case 1:
                Structure.this.getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(Structure.this)
                        .replace(view.getId(), new Nec(), "National Executive Council")
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }

}
