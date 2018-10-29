package com.cedro.cedroteste.base;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;

@EActivity
public class BaseActivity extends AppCompatActivity {

    protected View.OnClickListener onClickListener;

    @AfterInject
    public void init(){
        onClickListener = null;
    }

    @AfterViews
    protected void loadBase() {
        carregarIcone();
    }

    protected void carregarTitulo(String titulo){
        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null)
            actionBar.setTitle(titulo);
    }

    private void carregarIcone(){
        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @OptionsItem(android.R.id.home)
    protected void callIcone() {
        if(onClickListener == null)
            finish();
        else
            onClickListener.onClick(null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
