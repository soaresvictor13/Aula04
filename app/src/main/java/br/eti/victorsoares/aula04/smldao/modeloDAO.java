package br.eti.victorsoares.aula04.smldao;

import java.util.ArrayList;

/**
 * Created by samuel on 09/06/15.
 */
public interface modeloDAO {
    void insert(Object obj);
    void update(Object obj);
    void delete(Object obj);
    ArrayList<Object> get();
}
