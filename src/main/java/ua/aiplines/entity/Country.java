package ua.aiplines.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Country extends BaseEntity{

	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "country")
	private List<Destination> destination;
}
