package example1.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "login")
@AllArgsConstructor
@NoArgsConstructor

public class Model
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    
    private String email;
    private String projectId;
    private String projectName;
    private String projectDescription;
    private String projectManager;
    private String deadline;
    private String password;
}


