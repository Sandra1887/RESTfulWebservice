package ProjectWebServices.WebServices.repository;

import ProjectWebServices.WebServices.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {
}
