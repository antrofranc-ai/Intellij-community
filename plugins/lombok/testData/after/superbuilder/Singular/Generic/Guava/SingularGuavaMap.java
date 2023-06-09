// Generated by delombok at Sun Nov 06 10:56:35 CET 2022

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class SingularGuavaMap<A, B> {
  private ImmutableMap rawTypes;
  private ImmutableMap<Integer, Float> integers;
  private ImmutableMap<A, B> generics;
  private ImmutableMap<? extends Number, ? extends String> extendsGenerics;

  public static void main(String[] args) {
  }


  @java.lang.SuppressWarnings("all")
  public static abstract class SingularGuavaMapBuilder<A, B, C extends SingularGuavaMap<A, B>, B2 extends SingularGuavaMap.SingularGuavaMapBuilder<A, B, C, B2>> {
    @java.lang.SuppressWarnings("all")
    private com.google.common.collect.ImmutableMap.Builder<java.lang.Object, java.lang.Object> rawTypes;
    @java.lang.SuppressWarnings("all")
    private com.google.common.collect.ImmutableMap.Builder<Integer, Float> integers;
    @java.lang.SuppressWarnings("all")
    private com.google.common.collect.ImmutableMap.Builder<A, B> generics;
    @java.lang.SuppressWarnings("all")
    private com.google.common.collect.ImmutableMap.Builder<Number, String> extendsGenerics;

    @java.lang.SuppressWarnings("all")
    protected abstract B2 self();

    @java.lang.SuppressWarnings("all")
    public abstract C build();

    @java.lang.SuppressWarnings("all")
    public B2 rawType(final java.lang.Object key, final java.lang.Object value) {
      if (this.rawTypes == null) this.rawTypes = com.google.common.collect.ImmutableMap.builder();
      this.rawTypes.put(key, value);
      return self();
    }

    @java.lang.SuppressWarnings("all")
    public B2 rawTypes(final java.util.Map<?, ?> rawTypes) {
      if (rawTypes == null) {
        throw new java.lang.NullPointerException("rawTypes cannot be null");
      }
      if (this.rawTypes == null) this.rawTypes = com.google.common.collect.ImmutableMap.builder();
      this.rawTypes.putAll(rawTypes);
      return self();
    }

    @java.lang.SuppressWarnings("all")
    public B2 clearRawTypes() {
      this.rawTypes = null;
      return self();
    }

    @java.lang.SuppressWarnings("all")
    public B2 integer(final Integer key, final Float value) {
      if (this.integers == null) this.integers = com.google.common.collect.ImmutableMap.builder();
      this.integers.put(key, value);
      return self();
    }

    @java.lang.SuppressWarnings("all")
    public B2 integers(final java.util.Map<? extends Integer, ? extends Float> integers) {
      if (integers == null) {
        throw new java.lang.NullPointerException("integers cannot be null");
      }
      if (this.integers == null) this.integers = com.google.common.collect.ImmutableMap.builder();
      this.integers.putAll(integers);
      return self();
    }

    @java.lang.SuppressWarnings("all")
    public B2 clearIntegers() {
      this.integers = null;
      return self();
    }

    @java.lang.SuppressWarnings("all")
    public B2 generic(final A key, final B value) {
      if (this.generics == null) this.generics = com.google.common.collect.ImmutableMap.builder();
      this.generics.put(key, value);
      return self();
    }

    @java.lang.SuppressWarnings("all")
    public B2 generics(final java.util.Map<? extends A, ? extends B> generics) {
      if (generics == null) {
        throw new java.lang.NullPointerException("generics cannot be null");
      }
      if (this.generics == null) this.generics = com.google.common.collect.ImmutableMap.builder();
      this.generics.putAll(generics);
      return self();
    }

    @java.lang.SuppressWarnings("all")
    public B2 clearGenerics() {
      this.generics = null;
      return self();
    }

    @java.lang.SuppressWarnings("all")
    public B2 extendsGeneric(final Number key, final String value) {
      if (this.extendsGenerics == null) this.extendsGenerics = com.google.common.collect.ImmutableMap.builder();
      this.extendsGenerics.put(key, value);
      return self();
    }

    @java.lang.SuppressWarnings("all")
    public B2 extendsGenerics(final java.util.Map<? extends Number, ? extends String> extendsGenerics) {
      if (extendsGenerics == null) {
        throw new java.lang.NullPointerException("extendsGenerics cannot be null");
      }
      if (this.extendsGenerics == null) this.extendsGenerics = com.google.common.collect.ImmutableMap.builder();
      this.extendsGenerics.putAll(extendsGenerics);
      return self();
    }

    @java.lang.SuppressWarnings("all")
    public B2 clearExtendsGenerics() {
      this.extendsGenerics = null;
      return self();
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
      return "SingularGuavaMap.SingularGuavaMapBuilder(rawTypes=" + this.rawTypes + ", integers=" + this.integers + ", generics=" + this.generics + ", extendsGenerics=" + this.extendsGenerics + ")";
    }
  }


  @java.lang.SuppressWarnings("all")
  private static final class SingularGuavaMapBuilderImpl<A, B> extends SingularGuavaMap.SingularGuavaMapBuilder<A, B, SingularGuavaMap<A, B>, SingularGuavaMap.SingularGuavaMapBuilderImpl<A, B>> {
    @java.lang.SuppressWarnings("all")
    private SingularGuavaMapBuilderImpl() {
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    protected SingularGuavaMap.SingularGuavaMapBuilderImpl<A, B> self() {
      return this;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public SingularGuavaMap<A, B> build() {
      return new SingularGuavaMap<A, B>(this);
    }
  }

  @java.lang.SuppressWarnings("all")
  protected SingularGuavaMap(final SingularGuavaMap.SingularGuavaMapBuilder<A, B, ?, ?> b) {
    com.google.common.collect.ImmutableMap<java.lang.Object, java.lang.Object> rawTypes = b.rawTypes == null ? com.google.common.collect.ImmutableMap.<java.lang.Object, java.lang.Object>of() : b.rawTypes.build();
    this.rawTypes = rawTypes;
    com.google.common.collect.ImmutableMap<Integer, Float> integers = b.integers == null ? com.google.common.collect.ImmutableMap.<Integer, Float>of() : b.integers.build();
    this.integers = integers;
    com.google.common.collect.ImmutableMap<A, B> generics = b.generics == null ? com.google.common.collect.ImmutableMap.<A, B>of() : b.generics.build();
    this.generics = generics;
    com.google.common.collect.ImmutableMap<Number, String> extendsGenerics = b.extendsGenerics == null ? com.google.common.collect.ImmutableMap.<Number, String>of() : b.extendsGenerics.build();
    this.extendsGenerics = extendsGenerics;
  }

  @java.lang.SuppressWarnings("all")
  public static <A, B> SingularGuavaMap.SingularGuavaMapBuilder<A, B, ?, ?> builder() {
    return new SingularGuavaMap.SingularGuavaMapBuilderImpl<A, B>();
  }
}
