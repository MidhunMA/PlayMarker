package com.PlayMarker.usermanage;

import com.PlayMarker.playground.PlayGround;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
    private String username;
    
    @NotBlank
    @Size(max = 20,min=8)
    private String password;
    
    @Column(unique = true)
    private String email;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "groundId")
    private PlayGround playGround;
    // Constructors, getters, and setters
}
