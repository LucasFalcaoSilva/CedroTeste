package com.cedro.cedroteste.repository.db;

import android.arch.persistence.room.RoomDatabase;

import com.cedro.cedroteste.lista.domain.SiteUsuario;
import com.cedro.cedroteste.repository.dao.SiteUsuarioDAO;

@android.arch.persistence.room.Database(entities = {SiteUsuario.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract SiteUsuarioDAO getSiteUsuarioDAO();

}
