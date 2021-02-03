package utility;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileRead {
	
	public  String getProperties(String propertyname) {
		
		String propertyvalue = null;
	    InputStream inputStream;
	    try {
	        // Class path is found under WEB-INF/classes
	        Properties prop = new Properties();
	        String propFileName = "application.properties";

	        inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);
	        // read the file
	        if (inputStream != null) {
	            prop.load(inputStream);
	        } else {
	            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
	        }

	        // get the property value and print it out
	        propertyvalue = prop.getProperty(propertyname);

	        System.out.println("Property name is " + propertyname);
	    } catch (Exception e) {
	        System.out.println("Exception: " + e);
	    }
        
	    return propertyvalue;
		
	}
	
	public static void main(String args[]) {
		PropertyFileRead pf = new PropertyFileRead();
		System.out.println( pf.getProperties("username"));
	}

}
