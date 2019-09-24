package io.github.cepr0.demo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Model {
	@NotNull private CaseType type;
	@NotBlank private String text;
}
