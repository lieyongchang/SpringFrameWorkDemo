package domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.model.User;

@XmlRootElement
public class UserDomain {

	private List<User> users;

	@XmlElement
	public List<User> getVetList() {
		if (users == null) {
			users = new ArrayList<>();
		}
		return users;
	}
}
