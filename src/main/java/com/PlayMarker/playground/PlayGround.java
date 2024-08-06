package com.PlayMarker.playground;


import java.util.LinkedList;
import java.util.List;


import com.PlayMarker.usermanage.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    
    @JsonManagedReference
    @OneToMany(mappedBy = "confirmedPlayGround", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<User> confirmedUsers = new LinkedList<>();
    
    public void addUser(User user) {
        confirmedUsers.add(user);
        user.setConfirmedPlayGround(this);
    }
    
    public void removeUser(User user) {
        confirmedUsers.remove(user);
        user.setConfirmedPlayGround(null);
    }
    


}
