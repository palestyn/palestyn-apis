package org.palestyn.container;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public abstract class PalestynContainer {
	
	public abstract void start(ClassLoader classloader, Properties properties);

	public static class Properties {
		
		java.util.Properties props = new java.util.Properties();

		public Properties() {
			
			try (InputStream inputStream=getClass().getResourceAsStream("/container.properties")) {
				props.load(inputStream);
			} catch (IOException e) {
				throw new RuntimeException("Missing container.properties file");
			}
		}

		public Optional<String> getProperty(String name) {

			Optional<String> value = Optional.ofNullable(System.getProperty(name));
			if (!value.isPresent())
				value = Optional.ofNullable(props.getProperty(name));

			return value;
		}
	}

}
