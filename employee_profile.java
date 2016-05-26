// ORM class for table 'employee_profile'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Mon May 09 11:15:41 PDT 2016
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class employee_profile extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private String profile_id;
  public String get_profile_id() {
    return profile_id;
  }
  public void set_profile_id(String profile_id) {
    this.profile_id = profile_id;
  }
  public employee_profile with_profile_id(String profile_id) {
    this.profile_id = profile_id;
    return this;
  }
  private String first_name;
  public String get_first_name() {
    return first_name;
  }
  public void set_first_name(String first_name) {
    this.first_name = first_name;
  }
  public employee_profile with_first_name(String first_name) {
    this.first_name = first_name;
    return this;
  }
  private String last_name;
  public String get_last_name() {
    return last_name;
  }
  public void set_last_name(String last_name) {
    this.last_name = last_name;
  }
  public employee_profile with_last_name(String last_name) {
    this.last_name = last_name;
    return this;
  }
  private java.sql.Timestamp modified_date;
  public java.sql.Timestamp get_modified_date() {
    return modified_date;
  }
  public void set_modified_date(java.sql.Timestamp modified_date) {
    this.modified_date = modified_date;
  }
  public employee_profile with_modified_date(java.sql.Timestamp modified_date) {
    this.modified_date = modified_date;
    return this;
  }
  private String ssn;
  public String get_ssn() {
    return ssn;
  }
  public void set_ssn(String ssn) {
    this.ssn = ssn;
  }
  public employee_profile with_ssn(String ssn) {
    this.ssn = ssn;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof employee_profile)) {
      return false;
    }
    employee_profile that = (employee_profile) o;
    boolean equal = true;
    equal = equal && (this.profile_id == null ? that.profile_id == null : this.profile_id.equals(that.profile_id));
    equal = equal && (this.first_name == null ? that.first_name == null : this.first_name.equals(that.first_name));
    equal = equal && (this.last_name == null ? that.last_name == null : this.last_name.equals(that.last_name));
    equal = equal && (this.modified_date == null ? that.modified_date == null : this.modified_date.equals(that.modified_date));
    equal = equal && (this.ssn == null ? that.ssn == null : this.ssn.equals(that.ssn));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof employee_profile)) {
      return false;
    }
    employee_profile that = (employee_profile) o;
    boolean equal = true;
    equal = equal && (this.profile_id == null ? that.profile_id == null : this.profile_id.equals(that.profile_id));
    equal = equal && (this.first_name == null ? that.first_name == null : this.first_name.equals(that.first_name));
    equal = equal && (this.last_name == null ? that.last_name == null : this.last_name.equals(that.last_name));
    equal = equal && (this.modified_date == null ? that.modified_date == null : this.modified_date.equals(that.modified_date));
    equal = equal && (this.ssn == null ? that.ssn == null : this.ssn.equals(that.ssn));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.profile_id = JdbcWritableBridge.readString(1, __dbResults);
    this.first_name = JdbcWritableBridge.readString(2, __dbResults);
    this.last_name = JdbcWritableBridge.readString(3, __dbResults);
    this.modified_date = JdbcWritableBridge.readTimestamp(4, __dbResults);
    this.ssn = JdbcWritableBridge.readString(5, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.profile_id = JdbcWritableBridge.readString(1, __dbResults);
    this.first_name = JdbcWritableBridge.readString(2, __dbResults);
    this.last_name = JdbcWritableBridge.readString(3, __dbResults);
    this.modified_date = JdbcWritableBridge.readTimestamp(4, __dbResults);
    this.ssn = JdbcWritableBridge.readString(5, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(profile_id, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(first_name, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(last_name, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(modified_date, 4 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeString(ssn, 5 + __off, 12, __dbStmt);
    return 5;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(profile_id, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(first_name, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(last_name, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(modified_date, 4 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeString(ssn, 5 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.profile_id = null;
    } else {
    this.profile_id = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.first_name = null;
    } else {
    this.first_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.last_name = null;
    } else {
    this.last_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.modified_date = null;
    } else {
    this.modified_date = new Timestamp(__dataIn.readLong());
    this.modified_date.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.ssn = null;
    } else {
    this.ssn = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.profile_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, profile_id);
    }
    if (null == this.first_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, first_name);
    }
    if (null == this.last_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, last_name);
    }
    if (null == this.modified_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.modified_date.getTime());
    __dataOut.writeInt(this.modified_date.getNanos());
    }
    if (null == this.ssn) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ssn);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.profile_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, profile_id);
    }
    if (null == this.first_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, first_name);
    }
    if (null == this.last_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, last_name);
    }
    if (null == this.modified_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.modified_date.getTime());
    __dataOut.writeInt(this.modified_date.getNanos());
    }
    if (null == this.ssn) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ssn);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(profile_id==null?"null":profile_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(first_name==null?"null":first_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_name==null?"null":last_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(modified_date==null?"null":"" + modified_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ssn==null?"null":ssn, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(profile_id==null?"null":profile_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(first_name==null?"null":first_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_name==null?"null":last_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(modified_date==null?"null":"" + modified_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ssn==null?"null":ssn, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.profile_id = null; } else {
      this.profile_id = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.first_name = null; } else {
      this.first_name = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.last_name = null; } else {
      this.last_name = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.modified_date = null; } else {
      this.modified_date = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ssn = null; } else {
      this.ssn = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.profile_id = null; } else {
      this.profile_id = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.first_name = null; } else {
      this.first_name = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.last_name = null; } else {
      this.last_name = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.modified_date = null; } else {
      this.modified_date = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ssn = null; } else {
      this.ssn = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    employee_profile o = (employee_profile) super.clone();
    o.modified_date = (o.modified_date != null) ? (java.sql.Timestamp) o.modified_date.clone() : null;
    return o;
  }

  public void clone0(employee_profile o) throws CloneNotSupportedException {
    o.modified_date = (o.modified_date != null) ? (java.sql.Timestamp) o.modified_date.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("profile_id", this.profile_id);
    __sqoop$field_map.put("first_name", this.first_name);
    __sqoop$field_map.put("last_name", this.last_name);
    __sqoop$field_map.put("modified_date", this.modified_date);
    __sqoop$field_map.put("ssn", this.ssn);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("profile_id", this.profile_id);
    __sqoop$field_map.put("first_name", this.first_name);
    __sqoop$field_map.put("last_name", this.last_name);
    __sqoop$field_map.put("modified_date", this.modified_date);
    __sqoop$field_map.put("ssn", this.ssn);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("profile_id".equals(__fieldName)) {
      this.profile_id = (String) __fieldVal;
    }
    else    if ("first_name".equals(__fieldName)) {
      this.first_name = (String) __fieldVal;
    }
    else    if ("last_name".equals(__fieldName)) {
      this.last_name = (String) __fieldVal;
    }
    else    if ("modified_date".equals(__fieldName)) {
      this.modified_date = (java.sql.Timestamp) __fieldVal;
    }
    else    if ("ssn".equals(__fieldName)) {
      this.ssn = (String) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("profile_id".equals(__fieldName)) {
      this.profile_id = (String) __fieldVal;
      return true;
    }
    else    if ("first_name".equals(__fieldName)) {
      this.first_name = (String) __fieldVal;
      return true;
    }
    else    if ("last_name".equals(__fieldName)) {
      this.last_name = (String) __fieldVal;
      return true;
    }
    else    if ("modified_date".equals(__fieldName)) {
      this.modified_date = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else    if ("ssn".equals(__fieldName)) {
      this.ssn = (String) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
