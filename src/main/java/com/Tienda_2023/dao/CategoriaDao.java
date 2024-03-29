
package com.Tienda_2023.dao;

import com.Tienda_2023.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    List<Categoria> findByDescripcion(String descripcion);
    
}
