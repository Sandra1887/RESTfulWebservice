package ProjectWebServices.WebServices.repository;

import ProjectWebServices.WebServices.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
