// Generated by delombok at Sun Nov 06 21:21:45 CET 2022

import lombok.experimental.Tolerate;

public class BuilderWithTolerate {
	private final int value;

	public static void main(String[] args) {
		BuilderWithTolerate.builder().value("42").build();
	}


	public static class BuilderWithTolerateBuilder {
		@java.lang.SuppressWarnings("all")
		private int value;

		@Tolerate
		public BuilderWithTolerateBuilder value(String s) {
			return this.value(Integer.parseInt(s));
		}

		@java.lang.SuppressWarnings("all")
		BuilderWithTolerateBuilder() {
		}

		/**
		 * @return {@code this}.
		 */
		@java.lang.SuppressWarnings("all")
		public BuilderWithTolerate.BuilderWithTolerateBuilder value(final int value) {
			this.value = value;
			return this;
		}

		@java.lang.SuppressWarnings("all")
		public BuilderWithTolerate build() {
			return new BuilderWithTolerate(this.value);
		}

		@java.lang.Override
		@java.lang.SuppressWarnings("all")
		public java.lang.String toString() {
			return "BuilderWithTolerate.BuilderWithTolerateBuilder(value=" + this.value + ")";
		}
	}

	@java.lang.SuppressWarnings("all")
	BuilderWithTolerate(final int value) {
		this.value = value;
	}

	@java.lang.SuppressWarnings("all")
	public static BuilderWithTolerate.BuilderWithTolerateBuilder builder() {
		return new BuilderWithTolerate.BuilderWithTolerateBuilder();
	}
}
