package com.cedro.cedroteste.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ViewWrapper extends RecyclerView.ViewHolder {

    private View view;

    public ViewWrapper(View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public View getView() {
        return view;
    }

}
