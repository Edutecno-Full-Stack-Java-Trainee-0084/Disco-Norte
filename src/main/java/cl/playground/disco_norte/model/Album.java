package cl.playground.disco_norte.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", nullable = false)
    private Long album_id;

    @Column(name = "artist_name", length = 100, nullable = false)
    private String artist_name;

    @Column(name = "album_title", length = 200, nullable = false)
    private String album_title;

    @Column(name = "duration", length = 50, nullable = false)
    private String duration;

    @Column(name = "music_genre", length = 50, nullable = false)
    private String music_genre;

    @Column(name = "label", length = 50, nullable = false)
    private String label;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "price", nullable = false)
    private int price;

    @OneToMany(mappedBy = "albumId")
    private List<MemberPurchase> purchases;
}
