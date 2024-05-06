package com.PlayMarker.playground;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity

public class PlayGround {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groundId;
    
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
	private String groundName;
    
    @NotBlank
	private int capacity;
	//private Set<String> PriorityUsers;//for marking users always allow even if in waiting list, can be used to mark homeground players
	//private String[] PlayingUsers;
	//private ArrayList<String> WaitingListUsers;

	public PlayGround(@NotBlank @Size(max = 30) String groundName, @NotBlank int capacity) {
		super();
		this.groundName = groundName;
		this.capacity = capacity;
	}

	public int getPlayId() {
		return groundId;
	}

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
