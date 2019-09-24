package io.github.cepr0.demo;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service("UPPER")
public class UpperTransformer implements ModelTransformer {

	private final Properties pairs;

	public UpperTransformer(Properties pairs) {
		this.pairs = pairs;
	}

	@Override
	public void transform(@NonNull Model model) {
		model.setText(model.getText().toUpperCase());
	}
}
