package io.github.cepr0.demo;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class TextData implements PayloadData {
	@NotBlank private String text;
}
