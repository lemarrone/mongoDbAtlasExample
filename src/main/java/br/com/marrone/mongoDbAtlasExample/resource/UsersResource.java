package br.com.marrone.mongoDbAtlasExample.resource;

import br.com.marrone.mongoDbAtlasExample.model.Users;
import br.com.marrone.mongoDbAtlasExample.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersResource {

    private final Logger log = LoggerFactory.getLogger(UsersResource.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Users> listar() {
        List<Users> usr = userRepository.findAll();
        return usr;
    }

    @GetMapping("/{nome}")
    public List<Users> listarPorNome(@PathVariable String nome) {
        List<Users> usr = userRepository.findFirst10ByNameLikeIgnoreCaseOrderById(nome);
        return usr;
    }

    @PostMapping
    public ResponseEntity<Users> criar(@RequestBody Users usr, HttpServletResponse response) {
        Users usrSalvo = userRepository.save(usr);
        return ResponseEntity.status(HttpStatus.CREATED).body(usrSalvo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Users> apagar(@PathVariable String codigo) {
        userRepository.deleteById(codigo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}