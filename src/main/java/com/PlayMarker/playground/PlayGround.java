package com.PlayMarker.playground;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity

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
	//private Set<String> PriorityUsers;//for marking users always allow even if in waiting list, can be used to mark homeground players
	//private String[] PlayingUsers;
	//private ArrayList<String> WaitingListUsers;

	public PlayGround(@NotBlank @Size(max = 30) String groundName, @NotBlank Integer capacity) {
		super();
		this.groundName = groundName;
		this.capacity = capacity;
	}

	public Integer getGroundId() {
		return groundId;
	}

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public PlayGround() {
        // Default constructor
    }

}
