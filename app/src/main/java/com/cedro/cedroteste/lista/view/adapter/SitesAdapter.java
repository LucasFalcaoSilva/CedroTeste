package com.cedro.cedroteste.lista.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.cedro.cedroteste.base.ViewWrapper;
import com.cedro.cedroteste.lista.domain.SiteUsuario;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class SitesAdapter extends RecyclerView.Adapter<ViewWrapper> {

    @RootContext
    Context mContext;

    private List<SiteUsuario> sites;

    private OnItemClickListener onItemClickListener;

    @Override
    public ViewWrapper onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper(ListaItem_.build(mContext));
    }

    @Override
    public void onBindViewHolder(ViewWrapper holder, int position) {
        final SiteUsuario filme = sites.get(position);
        ((ListaItem) holder.getView()).bind(filme, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return sites.size();
    }

    public void setSites(List<SiteUsuario> sites) {
        this.sites = sites;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(SiteUsuario siteUsuario);
    }
}
