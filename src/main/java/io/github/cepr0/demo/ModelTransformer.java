package io.github.cepr0.demo;

import org.springframework.lang.NonNull;

public interface ModelTransformer {
	void transform(@NonNull Model model);
}
