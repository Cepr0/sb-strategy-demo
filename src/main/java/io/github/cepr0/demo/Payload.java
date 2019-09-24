package io.github.cepr0.demo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class Payload<T extends PayloadData> {

	@NotNull private DataType type;

	@JsonTypeInfo(
			use = JsonTypeInfo.Id.NAME,
			include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
			property = "type"
	)
	@JsonSubTypes({
			@JsonSubTypes.Type(value = TextData.class, name = "TEXT"),
			@JsonSubTypes.Type(value = NumberData.class, name = "NUMBER")
	})
	@NotNull private T data;
}
