// Generated by delombok at Sat Jun 11 11:12:44 CEST 2016

public enum DataOnEnum {
	A("hello");
	private final String someField;

	@java.lang.SuppressWarnings("all")
	public String getSomeField() {
		return this.someField;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public java.lang.String toString() {
		return "DataOnEnum(someField=" + this.getSomeField() + ")";
	}

	@java.lang.SuppressWarnings("all")
	private DataOnEnum(final String someField) {
		this.someField = someField;
	}
}