package katale.nelson.nrmapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Struct;
import java.util.ArrayList;

import katale.nelson.nrmapp.Adapters.ListAdapter;
import katale.nelson.nrmapp.CecActivity;
import katale.nelson.nrmapp.Models.ListItems;
import katale.nelson.nrmapp.NecActivity;
import katale.nelson.nrmapp.R;
import katale.nelson.nrmapp.Utils;

public class Structure extends Fragment implements AdapterView.OnItemClickListener {
    private Context mContext;
    ListAdapter listAdapter;
    ListView listView;
    ArrayList<ListItems> arrayList;

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
                startActivity(new Intent(getActivity(),CecActivity.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(), NecActivity.class));
                break;
        }
    }

}
