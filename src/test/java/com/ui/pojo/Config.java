package com.ui.pojo;

import java.util.Map;

public class Config {

Map<String , Environment>environments;

public Map<String, Environment> getEnvironments() {
	return environments;
}

public void setEnvironments(Map<String, Environment> environments) {
	this.environments = environments;
}
/*DEV, QA, and UAT are just keys in a map representing different instances of the same
 *  Environment structure,not different object types, so only one Environment POJO is needed.*/

}
