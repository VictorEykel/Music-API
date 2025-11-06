package br.com.cotemig.musicapi.dtos;
import br.com.cotemig.musicapi.models.Music;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record MusicDTO(@NotNull(message = "Título da música deve ser informado!")
                       @Size(min = 10, max = 30, message = "Título da música deve ter entre 10 e 30 carecteres!")
                       String title,
                       @NotNull(message = "Nome do artista deve ser informado!")
                       @Size(min = 5, max = 30, message = "Nome do artista deve conter de 5 a 30 caracteres!")
                       String artist,
                       @NotNull(message = "Album da música deve ser informado!")
                       @Size(min = 10, max = 30, message = "Album da música deve conter de 10 a 30 caracteres!")
                       String album,
                       @NotNull(message = "Duração da música deve ser informada!")
                       @Positive(message = "A duração da música deve ser maior que zero!")
                       Integer duration
) {
    public Music createMusic() {
        return new Music(title, artist, album, duration);
    }

    public Music updateMusic(Music music) {
        music.setTitle(title);
        music.setArtist(artist);
        music.setAlbum(album);
        music.setDuration(duration);
        return music;
    }
}