package com.PlayMarker.playground;

import java.util.LinkedHashSet;

import com.PlayMarker.usermanage.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class PlayGround {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer groundId;
    
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
	private String groundName;
    
    @NotNull
	private Integer capacity;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "confirmedPlayGround")
    private LinkedHashSet<User> confirmedUsers;
	
    

}
