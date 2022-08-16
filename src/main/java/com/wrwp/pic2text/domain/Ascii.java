package com.wrwp.pic2text.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ascii {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    @Lob
    private String asciiText;

    public Ascii() {
    }

    public Ascii(String title, String description, String asciiText) {
        this.title = title;
        this.description = description;
        this.asciiText = asciiText;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAsciiText() {
        return asciiText;
    }

    public void setAsciiText(String asciiText) {
        this.asciiText = asciiText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ascii ascii = (Ascii) o;

        if (!Objects.equals(id, ascii.id)) return false;
        if (!Objects.equals(title, ascii.title)) return false;
        if (!Objects.equals(description, ascii.description)) return false;
        return Objects.equals(asciiText, ascii.asciiText);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (asciiText != null ? asciiText.hashCode() : 0);
        return result;
    }
}


