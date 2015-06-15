/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.ctrip.hermes.portal.meta.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AvroVisitEventLess extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroVisitEventLess\",\"namespace\":\"com.ctrip.hermes.meta.avro\",\"fields\":[{\"name\":\"ip\",\"type\":\"string\"},{\"name\":\"url\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence ip;
  @Deprecated public java.lang.CharSequence url;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public AvroVisitEventLess() {}

  /**
   * All-args constructor.
   */
  public AvroVisitEventLess(java.lang.CharSequence ip, java.lang.CharSequence url) {
    this.ip = ip;
    this.url = url;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return ip;
    case 1: return url;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: ip = (java.lang.CharSequence)value$; break;
    case 1: url = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'ip' field.
   */
  public java.lang.CharSequence getIp() {
    return ip;
  }

  /**
   * Sets the value of the 'ip' field.
   * @param value the value to set.
   */
  public void setIp(java.lang.CharSequence value) {
    this.ip = value;
  }

  /**
   * Gets the value of the 'url' field.
   */
  public java.lang.CharSequence getUrl() {
    return url;
  }

  /**
   * Sets the value of the 'url' field.
   * @param value the value to set.
   */
  public void setUrl(java.lang.CharSequence value) {
    this.url = value;
  }

  /** Creates a new AvroVisitEventLess RecordBuilder */
  public static com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder newBuilder() {
    return new com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder();
  }
  
  /** Creates a new AvroVisitEventLess RecordBuilder by copying an existing Builder */
  public static com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder newBuilder(com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder other) {
    return new com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder(other);
  }
  
  /** Creates a new AvroVisitEventLess RecordBuilder by copying an existing AvroVisitEventLess instance */
  public static com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder newBuilder(com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess other) {
    return new com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder(other);
  }
  
  /**
   * RecordBuilder for AvroVisitEventLess instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroVisitEventLess>
    implements org.apache.avro.data.RecordBuilder<AvroVisitEventLess> {

    private java.lang.CharSequence ip;
    private java.lang.CharSequence url;

    /** Creates a new Builder */
    private Builder() {
      super(com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.ip)) {
        this.ip = data().deepCopy(fields()[0].schema(), other.ip);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.url)) {
        this.url = data().deepCopy(fields()[1].schema(), other.url);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing AvroVisitEventLess instance */
    private Builder(com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess other) {
            super(com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.SCHEMA$);
      if (isValidValue(fields()[0], other.ip)) {
        this.ip = data().deepCopy(fields()[0].schema(), other.ip);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.url)) {
        this.url = data().deepCopy(fields()[1].schema(), other.url);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'ip' field */
    public java.lang.CharSequence getIp() {
      return ip;
    }
    
    /** Sets the value of the 'ip' field */
    public com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder setIp(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.ip = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'ip' field has been set */
    public boolean hasIp() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'ip' field */
    public com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder clearIp() {
      ip = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'url' field */
    public java.lang.CharSequence getUrl() {
      return url;
    }
    
    /** Sets the value of the 'url' field */
    public com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder setUrl(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.url = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'url' field has been set */
    public boolean hasUrl() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'url' field */
    public com.ctrip.hermes.portal.meta.avro.AvroVisitEventLess.Builder clearUrl() {
      url = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public AvroVisitEventLess build() {
      try {
        AvroVisitEventLess record = new AvroVisitEventLess();
        record.ip = fieldSetFlags()[0] ? this.ip : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.url = fieldSetFlags()[1] ? this.url : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
