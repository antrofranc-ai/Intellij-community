// Generated by delombok at Sun Nov 06 21:23:53 CET 2022

import java.util.List;

class BuilderSimpleProtected<T> {
	private List<T> also;

	@java.lang.SuppressWarnings("all")
	BuilderSimpleProtected(final List<T> also) {
		this.also = also;
	}


	@java.lang.SuppressWarnings("all")
	protected static class BuilderSimpleProtectedBuilder<T> {
		@java.lang.SuppressWarnings("all")
		private List<T> also;

		@java.lang.SuppressWarnings("all")
		BuilderSimpleProtectedBuilder() {
		}

		/**
		 * @return {@code this}.
		 */
		@java.lang.SuppressWarnings("all")
		public BuilderSimpleProtected.BuilderSimpleProtectedBuilder<T> also(final List<T> also) {
			this.also = also;
			return this;
		}

		@java.lang.SuppressWarnings("all")
		public BuilderSimpleProtected<T> build() {
			return new BuilderSimpleProtected<T>(this.also);
		}

		@java.lang.Override
		@java.lang.SuppressWarnings("all")
		public java.lang.String toString() {
			return "BuilderSimpleProtected.BuilderSimpleProtectedBuilder(also=" + this.also + ")";
		}
	}

	@java.lang.SuppressWarnings("all")
	protected static <T> BuilderSimpleProtected.BuilderSimpleProtectedBuilder<T> builder() {
		return new BuilderSimpleProtected.BuilderSimpleProtectedBuilder<T>();
	}
}
