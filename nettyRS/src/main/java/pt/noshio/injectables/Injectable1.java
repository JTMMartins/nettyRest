package pt.noshio.injectables;

import javax.inject.Named;

@Named
public class Injectable1 {
	private String justAString;

	public String getJustAString() {
		return justAString;
	}

	public void setJustAString(String justAString) {
		this.justAString = justAString;
	}


}
