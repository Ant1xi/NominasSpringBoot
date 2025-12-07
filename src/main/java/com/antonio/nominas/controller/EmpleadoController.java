package com.antonio.nominas.controller;

import com.antonio.nominas.excepciones.EmpleadoDataException;
import com.antonio.nominas.excepciones.FormatoDniException;
import com.antonio.nominas.excepciones.FormatoSexoException;
import com.antonio.nominas.model.Empleado;
import com.antonio.nominas.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("listaEmpleados", empleadoService.findAll());
        return "empleados/lista";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/crear";
    }

    @PostMapping("/crear")
    public String procesarFormularioCrear(Empleado empleado, Model model) {
        try {
            empleadoService.crearEmpleado(empleado);
            return "redirect:/empleados/lista";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("empleado", empleado);
            return "empleados/crear";
        }
    }

    @GetMapping("/consultar")
    public String mostrarFormularioConsultar(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/consultar";
    }

    @PostMapping("/consultar")
    public String mostrarFormularioConsultar(Empleado empleado, Model model) {
        String sueldo;

        try {
            sueldo =  String.valueOf(empleadoService.getSalarioByDni(empleado.getDni()));
            System.out.println(sueldo);
            if (sueldo.equals("null")) {
                sueldo = "Empleado sin nómina";
            }
            model.addAttribute("sueldo", sueldo);
        } catch (FormatoDniException e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("empleado", empleado);
        return "empleados/consultar";
    }

    @GetMapping("/modificar")
    public String mostrarListaEmpleadosModificables(Model model) {
        model.addAttribute("listaEmpleados", empleadoService.findAll());
        return "/empleados/modificar";
    }

    @PostMapping("/modificar")
    public String procesarFormularioModificar(String dni, Model model) {
        Empleado empleado = empleadoService.findByDni(dni);
        model.addAttribute("empleadoSeleccionado", empleado);
        return "empleados/modificar";
    }


    @PostMapping("/guardar")
    public String procesarFormularioGuardar(Empleado empleado, Model model) {
        List<String> listaErrores = new ArrayList<>();
        int numModificado = 0;
        try {
            numModificado = empleadoService.updateEmpleado(empleado);
        } catch (FormatoDniException |FormatoSexoException | EmpleadoDataException e) {
            listaErrores.add(e.getMessage());
        }
        if (numModificado > 0) {
            model.addAttribute("exito", "Empleado modificado correctamente");
            return "redirect:/empleados/lista";
        } else {
            model.addAttribute("errores", listaErrores);
            return "empleados/modificar";
        }
   }
}
