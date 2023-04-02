package com.cybertek;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadingPropertiesFile {
	
	
	@Test
	public void testReadingProperties() {
		
		Properties properties = new Properties();
		
		try {
			FileInputStream in = new FileInputStream("config.properties");
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
