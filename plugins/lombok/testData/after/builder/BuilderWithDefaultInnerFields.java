// Generated by delombok at Sun Nov 06 21:21:45 CET 2022

public class BuilderWithDefaultInnerFields {
  // added initializer to delomboked code
  private Object bar = new Object();

    public static class BuilderWithDefaultInnerFieldsBuilder {
        @java.lang.SuppressWarnings("all")
        private boolean bar$set;
        @java.lang.SuppressWarnings("all")
        private Object bar$value;

        public BuilderWithDefaultInnerFieldsBuilder barManual(Object bar) {
            this.bar$value = bar;
            this.bar$set = true;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        BuilderWithDefaultInnerFieldsBuilder() {
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public BuilderWithDefaultInnerFields.BuilderWithDefaultInnerFieldsBuilder bar(final Object bar) {
            this.bar$value = bar;
            this.bar$set = true;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public BuilderWithDefaultInnerFields build() {
            Object bar$value = this.bar$value;
            if (!this.bar$set) {
              bar$value = BuilderWithDefaultInnerFields.$default$bar();
            }
            return new BuilderWithDefaultInnerFields(bar$value);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public java.lang.String toString() {
            return "BuilderWithDefaultInnerFields.BuilderWithDefaultInnerFieldsBuilder(bar$value=" + this.bar$value + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    private static Object $default$bar() {
        return new Object();
    }

    @java.lang.SuppressWarnings("all")
    BuilderWithDefaultInnerFields(final Object bar) {
        this.bar = bar;
    }

    @java.lang.SuppressWarnings("all")
    public static BuilderWithDefaultInnerFields.BuilderWithDefaultInnerFieldsBuilder builder() {
        return new BuilderWithDefaultInnerFields.BuilderWithDefaultInnerFieldsBuilder();
    }

    @java.lang.SuppressWarnings("all")
    public BuilderWithDefaultInnerFields.BuilderWithDefaultInnerFieldsBuilder toBuilder() {
        return new BuilderWithDefaultInnerFields.BuilderWithDefaultInnerFieldsBuilder().bar(this.bar);
    }
}
