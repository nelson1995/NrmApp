package katale.nelson.nrmapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import katale.nelson.nrmapp.Adapters.ListAdapter;
import katale.nelson.nrmapp.Manifesto_2016_Activity;
import katale.nelson.nrmapp.Manifesto_2020_Activity;
import katale.nelson.nrmapp.Models.ListItems;
import katale.nelson.nrmapp.R;
import katale.nelson.nrmapp.Utils;


public class Manifesto extends Fragment implements AdapterView.OnItemClickListener {
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
        View view = inflater.inflate(R.layout.fragment_manifesto, container, false);
        listView = view.findViewById(R.id.list);
        arrayList = new ArrayList();
        Utils.log("VALUES->"+ getString(R.string.cec));
        Utils.log("VALUES->"+ getString(R.string.nec));
        arrayList.add(new ListItems(getString(R.string.manifesto_2020)));
        arrayList.add(new ListItems(getString(R.string.manifesto_2016)));
        listAdapter = new ListAdapter(mContext,R.layout.fragment_manifesto,arrayList);
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
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position){
            case 0:
                startActivity(new Intent(getActivity(), Manifesto_2020_Activity.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(), Manifesto_2016_Activity.class));
                break;

        }
    }
}
