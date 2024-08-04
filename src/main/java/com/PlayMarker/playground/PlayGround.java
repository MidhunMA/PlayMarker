package com.PlayMarker.playground;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import com.PlayMarker.usermanage.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    
    @JsonManagedReference
    @OneToMany(mappedBy = "confirmedPlayGround", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<User> confirmedUsers = new LinkedHashSet<>();
    
    public void addUser(User user) {
        confirmedUsers.add(user);
        user.setConfirmedPlayGround(this);
    }
    
    public void removeUser(User user) {
        confirmedUsers.remove(user);
        user.setConfirmedPlayGround(null);
    }
    
    public Set<User> getConfirmedUsers(){
		return  this.confirmedUsers;
    }
   
    public void setConfirmedUsers(Set<User> userlist){
		  this.confirmedUsers=userlist;
    }
   
   

}
