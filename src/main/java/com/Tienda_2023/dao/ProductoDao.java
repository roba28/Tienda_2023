
package com.Tienda_2023.dao;


import com.Tienda_2023.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDao  extends JpaRepository<Producto, Long>  {
    
}
