package br.com.cotemig.musicapi.services;

import br.com.cotemig.musicapi.models.Music;
import br.com.cotemig.musicapi.repositories.MusicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeedService {
    @Autowired
    private MusicRepository musicRepository;

    private final Logger logger = LoggerFactory.getLogger(SeedService.class);

    public void doSeed(){
        if(musicRepository.count() == 0){
            List<Music> music = List.of(
                    new Music(
                            "pamonha",
                            "Juse5",
                            "Pamonha com leite",
                            13
                    ),
                    new Music(
                            "pamonha2",
                            "Juse4",
                            "Pamonha com leite",
                            14
                    ),
                    new Music(
                            "pamonha3",
                            "Juse3",
                            "Pamonha com leite",
                            15
                    ),
                    new Music(
                            "pamonha4",
                            "Juse2",
                            "Pamonha com leite",
                            16
                    ),
                    new Music(
                            "pamonha5",
                            "Juse1",
                            "Pamonha com leite",
                            17
                    )
            );
            musicRepository.saveAll(music);
            logger.info("Music has been saved");
        }
        else {
            logger.info("Music has already been saved");
        }
    }
}
