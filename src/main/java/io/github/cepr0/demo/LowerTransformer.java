package io.github.cepr0.demo;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service("LOWER")
public class LowerTransformer implements ModelTransformer {

	private final Properties pairs;

	public LowerTransformer(Properties pairs) {
		this.pairs = pairs;
	}

	@Override
	public void transform(@NonNull Model model) {
		model.setText(model.getText().toLowerCase());
	}
}
