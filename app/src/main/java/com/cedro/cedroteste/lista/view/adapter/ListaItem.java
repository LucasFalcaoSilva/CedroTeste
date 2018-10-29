package com.cedro.cedroteste.lista.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cedro.cedroteste.R;
import com.cedro.cedroteste.lista.domain.SiteUsuario;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.lista_item)
public class ListaItem extends RelativeLayout {

    @ViewById(R.id.txt_site)
    TextView txtSite;

    @ViewById(R.id.txt_usuario)
    TextView txtUsuario;

    @ViewById(R.id.txt_senha)
    TextView txtSenha;

    @ViewById(R.id.linear_principal)
    LinearLayout llPrincipal;

    public ListaItem(Context context) {
        super(context);
    }

    public void bind(final SiteUsuario siteUsuario, final SitesAdapter.OnItemClickListener onItemClickListener) {
        llPrincipal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(siteUsuario);
            }
        });
        txtSite.setText("Site: " + siteUsuario.getSite());
        txtSenha.setText("Senha: " + siteUsuario.getUsuario());
        txtUsuario.setText("Usuario: " + siteUsuario.getUsuario());
    }

}
