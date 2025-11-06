package br.com.cotemig.musicapi.controllers;

import br.com.cotemig.musicapi.dtos.ErrorDTO;
import br.com.cotemig.musicapi.dtos.MusicDTO;
import br.com.cotemig.musicapi.models.Music;
import br.com.cotemig.musicapi.repositories.MusicRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musics")
@CrossOrigin
public class MusicController {

    private final MusicRepository musicRepository;
    private final View error;

    public MusicController(MusicRepository musicRepository, View error) {
        this.musicRepository = musicRepository;
        this.error = error;
    }

    @GetMapping
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Music> findById(@PathVariable(value = "Id") long id) {
        if  (musicRepository.findById(id).isPresent()) {
            Optional<Music> music = musicRepository.findById(id);
            return ResponseEntity.ok().body(music.get());
        }
        else  {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Music> create(@Valid @RequestBody MusicDTO musicDTO) {
        var music = musicRepository.save(musicDTO.createMusic());
        return ResponseEntity.status(HttpStatus.CREATED).body(music);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Music> Update(@PathVariable(value = "id") Long id, @Valid @RequestBody MusicDTO musicDTO) {
        var music = musicRepository.findById(id).orElse(null);
        if (music == null) {
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok().body(musicRepository.save(musicDTO.updateMusic(music)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Music> delete(@PathVariable(value = "id") Long id) {
        var music = musicRepository.findById(id).orElse(null);
        if (music == null)
            return ResponseEntity.notFound().build();

        musicRepository.delete(music);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toArray(String[]::new);
        return ResponseEntity.badRequest().body(new ErrorDTO("Dados Invalidos", message));
    }
}
