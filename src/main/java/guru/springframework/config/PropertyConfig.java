package guru.springframework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import guru.springframework.FakeDataSource;
import guru.springframework.FakeJMSDataSource;

@Configuration
@PropertySources({ @PropertySource("classpath:datasource.properties"), @PropertySource("classpath:jms.properties") })
public class PropertyConfig {

	@Value("${guru.username}")
	String username;
	@Value("${guru.password}")
	String password;
	@Value("${guru.dburl}")
	String url;

	@Value("${guru.jms.username}")
	String jmsusername;
	@Value("${guru.jms.password}")
	String jmspassword;
	@Value("${guru.jms.dburl}")
	String jmsurl;

	@Bean
	public FakeJMSDataSource jmsfakeDataSource() {
		FakeJMSDataSource jmsfakeDataSource = new FakeJMSDataSource();
		jmsfakeDataSource.setJmsnameString(jmsusername);
		jmsfakeDataSource.setJmspassword(jmspassword);
		jmsfakeDataSource.setJmsurl(jmsurl);
		return jmsfakeDataSource;
	}

	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setNameString(username);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}

}
