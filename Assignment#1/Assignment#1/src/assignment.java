
public class assignment {
	String assign;
	String date;

	assignment(String assign, String date) {
		this.assign = assign;
		this.date = date;
	}

	public String getassign() {
		return assign;
	}

	public void setassign(String assign) {
		this.assign = assign;
	}

	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public String toString() {
		return "Assignment: " + assign + " Date:" + date;
	}
}
