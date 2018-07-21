package ua.aiplines.entity.enums;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SeatsClass {
	
	BUSINESS("BUSINESS", new BigDecimal(1.5)),
	ECONOMY("ECONOMY", new BigDecimal(1));
	
	private String name;
	private BigDecimal coef;
	
}
