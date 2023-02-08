package introduccion.api.repository;

import introduccion.api.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    List<Persona> findByNombre(@Param("nombre") String nombre);
    Persona findByUsuario(@Param("usuario") String usuario);
    boolean existsByUsuario(@Param("usuario") String usuario);
    void deleteByUsuario(@Param("usuario") String usuario);
}