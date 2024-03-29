package Utilities;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
public class ConfigurationReader {
	
	
	private static Properties properties = new Properties();
	
	static {
		
			try {
				//2- We need to open the file in java memory: FileInputStream
				FileInputStream file = new FileInputStream("config.properties");
				
				//3- Load the properties object using FileInputStream object
				properties.load(file);
				
				//close the file
				file.close();
				
			
			
			} catch (IOException e){
				System.out.println("File not found in the ConfiguationReader.class.");
				e.printStackTrace();
			}
	}
	
	public static String getProperty(String keyword) {
		return properties.getProperty(keyword);
	}

}
