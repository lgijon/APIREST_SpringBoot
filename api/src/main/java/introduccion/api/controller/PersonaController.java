package introduccion.api.controller;

import introduccion.api.model.Persona;
import introduccion.api.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/personas")
    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("/personas/nombre/{nombre}")
    public List<Persona> getPersonasByNombre(@PathVariable("nombre") String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    @GetMapping("/personas/usuario/{usuario}")
    public Persona getPersonaByUsuario(@PathVariable("usuario") String usuario) {
        return personaRepository.findByUsuario(usuario);
    }

    @GetMapping("/personas/usuario/existe/{usuario}")
    public boolean existeUsuario(@PathVariable("usuario") String usuario) {
        return personaRepository.existsByUsuario(usuario);
    }

    @PostMapping("/persona")
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @PutMapping("/persona/{id}")
    public Persona actualizarPersona(@PathVariable int id, @RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @PutMapping("/persona/usuario/{usuario}")
    public Persona actualizarPersonaByUsuario(@PathVariable String usuario, @RequestBody Persona persona) {
        Persona personaActual = personaRepository.findByUsuario(usuario);
        personaActual.setNombre(persona.getNombre());
        personaActual.setUsuario(persona.getUsuario());
        return personaRepository.save(personaActual);
    }

    @DeleteMapping("/persona/{id}")
    public void eliminarPersona(@PathVariable("id") Long id) {
        personaRepository.deleteById(id);
    }

    @DeleteMapping("/persona/usuario/{usuario}")
    public void eliminarPersonaByUsuario(@PathVariable String usuario) {
        personaRepository.deleteByUsuario(usuario);
    }
}