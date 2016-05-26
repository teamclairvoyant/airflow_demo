import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.hadoop.hive.ql.exec.UDF;

public class Masking extends UDF{
		  public static String evaluate( String input) {
		    if (input == null) { 
		    	return null; 
		    }
		    
		    String regex = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$";
		    Pattern pattern = Pattern.compile(regex);
		    Matcher matcher = pattern.matcher(input);
		    if(matcher.matches()){
		    	 return  "***-**-***";
		    }
		    return input;
		  }
}
