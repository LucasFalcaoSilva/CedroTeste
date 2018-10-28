package com.cedro.cedroteste.base;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;

@EActivity
public class BaseActivity extends AppCompatActivity {

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
        finish();
    }

}
