package ProjectWebServices.WebServices.controller;

import ProjectWebServices.WebServices.entity.Song;
import ProjectWebServices.WebServices.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
@CrossOrigin("*")
public class SongController {

    //ALLT FUNKAR VIA POSTMAN
    @Autowired
    private SongService songService;

    @PostMapping("/create") //FUNKAR
    public ResponseEntity<Song> createSong(
            @RequestBody Song song) {
        try {
            return songService.createSong(song);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/selectOne/{id}") //FUNKAR
    public ResponseEntity<Optional<Song>> selectOneSong(
            @PathVariable Long id
    ) {
        try {
            return songService.selectOneSong(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/selectall")
    public ResponseEntity<List<Song>> selectAllSongs() {
        try {
            return songService.selectAllSongs();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Song> updateSong(
            @PathVariable Long id,
            @RequestBody Song song
    ) {
        try {
            return songService.updateSong(id, song);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSong(
            @PathVariable Long id
    ) {
        try {
            return songService.deleteSong(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
