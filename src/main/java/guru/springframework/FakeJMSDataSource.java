package guru.springframework;

public class FakeJMSDataSource {

	private String jmsnameString;
	private String jmspassword;
	private String jmsurl;

	public String getJmsurl() {
		return jmsurl;
	}

	public void setJmsurl(String jmsurl) {
		this.jmsurl = jmsurl;
	}

	public String getJmspassword() {
		return jmspassword;
	}

	public void setJmspassword(String jmspassword) {
		this.jmspassword = jmspassword;
	}

	public String getJmsnameString() {
		return jmsnameString;
	}

	public void setJmsnameString(String jmsnameString) {
		this.jmsnameString = jmsnameString;
	}

}
