
package com.ProyectoFinal.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {
    @Autowired
    @GetMapping("/")
    public String index(){
   // List<evento> listaEventos=eventoService.getAllevents();
   // model.addAttribute("Titulo","Lista de Eventos");
  //  model.addAttribute("Evento",listaEventos);
    return "Login";
    }
    
    @GetMapping("/Menu")
    public String Menu(){
   // List<evento> listaEventos=eventoService.getAllevents();
   // model.addAttribute("Titulo","Lista de Eventos");
  //  model.addAttribute("Evento",listaEventos);
    return "Sliderbar";
    }
    
}
