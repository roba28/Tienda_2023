
package com.Tienda_2023.controller;

import com.Tienda_2023.domain.Categoria;
import com.Tienda_2023.domain.Producto;
import com.Tienda_2023.service.CategoriaService;
import com.Tienda_2023.service.ProductoService;
import com.Tienda_2023.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Slf4j
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        log.info("Consumiendo /categoria/listado");
        List<Producto> producto=productoService.getProductos(false);
        model.addAttribute("producto", producto);
        model.addAttribute("totalCategorias", producto.size());
        return "/Producto/listado";
    }
     @GetMapping("/nuevo")
    public String categoriaNuevo(Producto producto) {
        return "/producto/modificar";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "categoria", 
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/eliminar/{idproducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idproducto}")
    public String categoriaModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modificar";
    }
    
}