package cl.playground.disco_norte.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = "purchases")  // Excluimos la colección
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", nullable = false)
    private Long albumId;  // Cambiado a camelCase

    @Column(name = "artist_name", length = 100, nullable = false)
    private String artistName;  // Cambiado a camelCase

    @Column(name = "album_title", length = 200, nullable = false)
    private String albumTitle;  // Cambiado a camelCase

    @Column(name = "duration", length = 50, nullable = false)
    private String duration;

    @Column(name = "music_genre", length = 50, nullable = false)
    private String musicGenre;  // Cambiado a camelCase

    @Column(name = "label", length = 50, nullable = false)
    private String label;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "price", nullable = false)
    private int price;

    @OneToMany(mappedBy = "albumId")
    private List<MemberPurchase> purchases;
}
