package com.Tienda_2023.service.impl;

import com.Tienda_2023.dao.CategoriaDao;
import com.Tienda_2023.domain.Categoria;
import com.Tienda_2023.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        List<Categoria> lista = categoriaDao.findAll();
        if(activos){
        lista.removeIf(x->!x.isActivo());
        }
        return lista;
    }
      @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    public List<Categoria> getByDescripcion(String descripcion) {
   return categoriaDao.findByDescripcion(descripcion);
    }

 

}
