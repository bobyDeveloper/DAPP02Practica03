package org.uv.DAPP02Pracica03;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v2/")
public class ControllerEmpleados {
    
    @Autowired
    private RepositoryEmpleado repositoryEmpleado;
    
    @GetMapping("empleados")
    public List<Empleado> list() {
        return repositoryEmpleado.findAll();
    }
    
    @GetMapping("empleado/{id}")
    public Empleado get(@PathVariable Long id) {
        Optional<Empleado> resEmpl= repositoryEmpleado.findById(id);
        if (resEmpl.isPresent()) {
            return resEmpl.get();
        }else{
            return null;
        }
        
    }
    
    @PutMapping("empleado/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Empleado empleadoActualizado) {
        Optional<Empleado> optionalEmpleado = repositoryEmpleado.findById(Long.valueOf(id));
        if (optionalEmpleado.isPresent()) {
            Empleado empleado = optionalEmpleado.get();
            empleado.setNombre(empleadoActualizado.getNombre());
            empleado.setDireccion(empleadoActualizado.getDireccion());
            empleado.setTelefono(empleadoActualizado.getTelefono());
            repositoryEmpleado.save(empleado);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("empleado")
public ResponseEntity<Empleado> post(@RequestBody Empleado nuevoEmpleado) {
    Empleado empleadoGuardado = repositoryEmpleado.save(nuevoEmpleado);
    return ResponseEntity.ok().body(empleadoGuardado);
}

    
    @DeleteMapping("empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
         if (repositoryEmpleado.existsById(Long.valueOf(id))) {
            repositoryEmpleado.deleteById(Long.valueOf(id));
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
