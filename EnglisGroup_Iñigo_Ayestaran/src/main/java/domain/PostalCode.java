package domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class PostalCode {

    @NotEmpty
    @Pattern(regexp = "^(([1-8][0-9]{3})|(9[0-9][0-8][0-9])|(9990))$", message = "Postal code must be a number between 1000-9990")
    private String postalCode;
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
    
}
