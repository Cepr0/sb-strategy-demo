package io.github.cepr0.demo;

public interface DataHandler<T extends PayloadData> {
	T handle(T data);
}
