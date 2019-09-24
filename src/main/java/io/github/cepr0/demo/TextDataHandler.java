package io.github.cepr0.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TextDataHandler implements DataHandler<TextData> {
	@Override
	public TextData handle(final TextData data) {
		log.info("[i] Handled a text data.");
		return data;
	}

}
