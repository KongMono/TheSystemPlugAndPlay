package net.thesystemplugplay.tspp.listener;

import android.view.View;

public interface OnRecyclerViewItemClickListener<Model> {
    void onItemClick(View view, Model model);
}