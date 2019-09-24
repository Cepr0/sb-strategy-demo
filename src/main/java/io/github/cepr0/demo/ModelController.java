package io.github.cepr0.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class ModelController {

	private final Map<String, ModelTransformer> transformers;
	private final Map<Class<? extends PayloadData>, DataHandler> handlers;

	public ModelController(
			@NonNull final Map<String, ModelTransformer> transformers,
			@Qualifier("handlers") @NonNull final Map<Class<? extends PayloadData>, DataHandler> handlers
	) {
		this.transformers = transformers;
		this.handlers = handlers;
	}

	@PostMapping("/models")
	public Model post(@NonNull @RequestBody @Valid Model model) {
		transformers.getOrDefault(model.getType().name(), transformers.get("LOWER")).transform(model);
		return model;
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/payloads")
	public <T extends PayloadData> PayloadData payload(@NonNull @RequestBody @Valid Payload<T> payload) {
		T data = payload.getData();
		handlers.get(data.getClass()).handle(data);
		return data;
	}

}
