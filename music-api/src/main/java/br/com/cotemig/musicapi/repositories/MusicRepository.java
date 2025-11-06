package br.com.cotemig.musicapi.repositories;

import br.com.cotemig.musicapi.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {

}
