package io.github.cepr0.demo;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class NumberData implements PayloadData {
	@NotNull private Integer num;
}
