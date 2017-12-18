package common.enumType;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

public class PropSingleTon {

	// The question was asked about enum, I wanted to create an enum based on
	// property. I gave up the idea, because this enum needed to be dynamic, if
	// we get a new error code, it should be added to property file. Sadly I see
	// no way to do that with enum so I chose different path as I read everybody
	// suggests Map based solution. Instead of enum I created a singleton which
	// just reads a property file, and responds on the keywords to give back the
	// value.

	// the property file:

	/*
	 * C102 = Blablabla1 C103 = Blablabla2 C104 = Blablabla3
	 * 
	 * the singleton code:
	 */

	

	private final HashMap<String, String> codes;

	private static PropSingleTon instance;

	public static PropSingleTon getInstance() {
		if (instance == null) {
			instance = new PropSingleTon();
		}
		return instance;
	}

	private PropSingleTon() {
	    super();
	    codes = new HashMap<String, String>();
	    initEntry();
	}

	private void initEntry() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resources/codes.properties"));
			for (Entry<Object, Object> element : prop.entrySet()) {
				codes.put(element.getKey().toString(), element.getValue().toString());
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String getValueByCode(String code) {
		return codes.get(code);
	}
}

/*
 * to get the values, simply call:
 * 
 * ResponseValidationTypeCodes.getInstance() .getValueByCode("C102");
 */
// the initial property reading runs only once. So you just expand the property
// when some change comes in, and redeploy your stuffs that time. I hope it
// helps for somebody who is open to use some alternative to enum.
