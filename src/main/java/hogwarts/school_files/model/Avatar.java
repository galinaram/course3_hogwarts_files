package hogwarts.school_files.model;

import jakarta.persistence.*;

@Entity
public class Avatar {
    @Id
    @GeneratedValue
    Long id;

    String filePath;
    long fileSize;
    String mediaType;
    byte[] data;

    @OneToOne
    @JoinColumn(name = "student_id")
    Student student;
}
