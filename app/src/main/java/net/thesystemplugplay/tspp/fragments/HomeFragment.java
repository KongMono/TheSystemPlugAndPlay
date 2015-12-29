package net.thesystemplugplay.tspp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import net.thesystemplugplay.tspp.R;

import butterknife.ButterKnife;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.util.TypefaceManager;

/**
 * Created by kongmono on 12/28/15.
 */
public class HomeFragment extends Fragment {

    private TypefaceManager fontManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        fontManager = new TypefaceManager(getActivity().getAssets());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        View toolbar =  ((MaterialNavigationDrawer)getActivity()).getToolbar().findViewById(R.id.toolbar);

        TextView title = (TextView)toolbar.findViewById(R.id.toolbar_title);
        ImageView logo = (ImageView)toolbar.findViewById(R.id.toolbar_logo);
        logo.setVisibility(View.GONE);
        title.setTypeface(fontManager.getTBold());
        title.setText(getActivity().getResources().getText(R.string.sb1));

        return view;
    }
}
