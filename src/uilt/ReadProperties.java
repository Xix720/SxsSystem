package uilt;

import java.io.InputStream;
import java.util.Properties;

//∂¡»°≈‰÷√Œƒº˛
public class ReadProperties {

	public static ReadProperties rp;
	
	public String dbUrl;
	public String dbUserName;
	public String dbPassword;
	
	private ReadProperties() {
		loadProperties();
	}
	
	public static ReadProperties initial() {
		if(rp == null)
			rp = new ReadProperties();
		return rp;
	}
	
	private void loadProperties() {
		InputStream ips = getClass().getResourceAsStream("/db.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(ips);
			this.dbUrl = properties.getProperty("dburl");
			this.dbUserName = properties.getProperty("username");
			this.dbPassword = properties.getProperty("password");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}



	
		
	

}
