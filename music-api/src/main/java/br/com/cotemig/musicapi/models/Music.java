package br.com.cotemig.musicapi.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30  )
    private String title;
    @Column(nullable = false, length = 30  )
    private String artist;
    @Column(nullable = false, length = 30  )
    private String album;
    @Column(nullable = false, length = 30  )
    private Integer duration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Music(){}

    public Music(String title, String artist, String album, Integer duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        // Compara apenas pelo ID, que é a chave primária da entidade.
        return Objects.equals(id, music.id);
    }

    @Override
    public int hashCode() {
        // Usa Objects.hash() para lidar com segurança caso o 'id' seja nulo (nova entidade).
        return Objects.hash(id);
    }
}
