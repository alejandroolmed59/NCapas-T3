package com.example.olmedo.tarea3.Controller;

import com.example.olmedo.tarea3.Model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping(value="/ingresar", method = RequestMethod.GET)
    public static ModelAndView ingresar(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("hola", "holaa");
        mav.setViewName("agregarUsuario");
        return mav;
    }
    @RequestMapping(value="/nuevoAlumno")
    public ModelAndView nuevoAlumno(@RequestParam(required = true) String nombres, @RequestParam(required = true)  String apellidos, @RequestParam(required = true)  String diaB, @RequestParam(required = true)  String lugarB,
                              @RequestParam(required = true)  String instituto, @RequestParam(required = true)  String telefonoFijo, @RequestParam(required = true)  String telefonoMovil){
        List<String> errores = new ArrayList<>();
        ModelAndView mav = new ModelAndView();

        if(nombres.length()<1 || nombres.length()>25){
            errores.add("Nombre no puede ser mayor de 25 caracteres ni menor a 1");
        }
        if(apellidos.length()<1 || apellidos.length()>25){
            errores.add("Apellidos no puede ser mayor de 25 caracteres ni menor a 1");
        }

        int annio = Integer.parseInt(diaB.substring(0, 4));
        if(annio < 2003){
            errores.add("Tu año de nacimiento no puede ser menor a 2003");
        }
        if(lugarB.length()<1 || lugarB.length()>25){
            errores.add("Lugar de nacimiento no puede ser mayor de 25 caracteres ni menor a 1");
        }
        if(instituto.length()<1 || instituto.length()>100){
            errores.add("Instituto no puede ser mayor de 100 caracteres ni menor a 1");
        }
        if(telefonoFijo.length()!=8 ){
            errores.add("Numero de telefono fijo tiene que ser igual a 8 caracteres");
        }
        if(telefonoMovil.length()!=8 ){
            errores.add("Numero de telefono movil tiene que ser igual a 8 caracteres");
        }
        for(String error : errores ){
            System.out.println(error);
        }
        if(errores.size()==0) {
            mav.setViewName("mostrarMensaje");
        }else{
            mav.addObject("errores", errores);
            mav.setViewName("Errores");
        }
        return mav;
    }
}
