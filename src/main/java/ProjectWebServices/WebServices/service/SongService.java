package ProjectWebServices.WebServices.service;

import ProjectWebServices.WebServices.models.Song;
import ProjectWebServices.WebServices.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    //private static final Logger logger = LoggerFactory.getLogger(SongService.class);

    public ResponseEntity<Song> createSong(Song song) {
        try {
            return ResponseEntity.ok(songRepository.save(song));
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<Optional<Song>> selectOneSong(Long id){
        try {
            if(songRepository.existsById(id)){
                //logger.info("Song was found!");
                return ResponseEntity.ok(songRepository.findById(id));
            } else {
                //logger.info("Could not find that song");
                return ResponseEntity.status(400).body(Optional.empty());
            }
        } catch (Exception e) {
            //logger.info("Error finding song");
            return ResponseEntity.status(400).body(Optional.empty());
        }
    }

    public ResponseEntity<List<Song>> selectAllSongs() {
        try {
            List<Song> songs = songRepository.findAll();
            if(songs.isEmpty()) {
                //logger.info("Could not load any songs");
                return ResponseEntity.status(204).body(List.of());
            } else {
                //logger.info("Songs found: ");
                return ResponseEntity.ok(songs);
            }
        } catch(Exception e) {
            //logger.info("Error finding songs");
            return ResponseEntity.status(400).body(List.of());
        }
    }

    public ResponseEntity<Song> updateSong(Long id, Song song) {
        try {
            Song updateSong = songRepository.findById(id).orElseThrow();
            updateSong.setTitle(song.getTitle());
            updateSong.setArtist(song.getArtist());
            //logger.info(String.format("Song %s was updated", song.getTitle()));
            return ResponseEntity.ok(songRepository.save(updateSong));
        } catch (Exception e) {
            //logger.info("Error updating song");
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<String> deleteSong(Long id) {
        try {
            if(songRepository.existsById(id)) {
                songRepository.deleteById(id);
                return ResponseEntity.ok("Song was deleted");
            } else {
                return ResponseEntity.status(400).body("Song was not found!");
            }
        } catch (Exception e) {
            //logger.info("Error deleting song!");
            return ResponseEntity.status(400).build();
        }
    }
}
