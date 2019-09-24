package io.github.cepr0.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NumberDataHandler implements DataHandler<NumberData> {
	@Override
	public NumberData handle(final NumberData data) {
		log.info("[i] Handled a number data.");
		return data;
	}

}
