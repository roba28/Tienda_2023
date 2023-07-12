
package com.Tienda_2023.service.impl;

import com.Tienda_2023.dao.CategoriaDao;
import com.Tienda_2023.dao.ProductoDao;
import com.Tienda_2023.domain.Categoria;
import com.Tienda_2023.domain.Producto;
import com.Tienda_2023.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{
     @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        List<Producto> lista = productoDao.findAll();
        if(activos){
        lista.removeIf(x->!x.isActivo());
        }
        return lista;
    }
      @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
}
