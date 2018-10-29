package com.cedro.cedroteste.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.cedro.cedroteste.lista.domain.SiteUsuario;

import java.util.List;

@Dao
public interface SiteUsuarioDAO {

    String ID = "id";
    String EMAIL_TOKEN = "emailToken";
    String START_QUERY = "SELECT * FROM SITES  WHERE ";

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SiteUsuario siteUsuario);

    @Delete
    void delete(SiteUsuario siteUsuario);

    @Query(START_QUERY + ID + " = :id")
    SiteUsuario getById(Long id);


    @Query(START_QUERY + EMAIL_TOKEN + " = :emailToken")
    List<SiteUsuario> getByEmailToken(String emailToken);

    @Query("SELECT * FROM SITES")
    List<SiteUsuario> getAll();
}
