

package sam.LoadIniFiles;

import java.util.Vector;
import java.lang.Math;

/** Utility knife for efficiently parsing stuff out of strings.
 * provided by Nathan at BBN.
 * Title:        Sam<p>
 * Description:  ALP Business Process User Interface<p>
 * <copyright>
 *    Copyright (c) 2000-2001 Defense Advanced Research Projects
 *    Agency (DARPA) and Mobile Intelligence Corporation.
 *    This software to be used only in accordance with the
 *    COUGAAR license agreement.
 * </copyright>
 * Company:      Mobile Intelligence Corp.<p>
 * @author Doug MacKenzie
 * @version 1.0
 */


public class StringUtility
{

  /** an empty String instance **/
  public static String emptyString = "";

  /** @return an array of strings which represents the comma-separated-
   * values list from the range of characters in buf.
   **/
  public static Vector parseCSV(String buf, int start, int their_end, char comma) {
    Vector tmp = new Vector();

    StringBuffer sb = new StringBuffer(); // temp storage

	 int end = Math.min(their_end, buf.length());

    int i = start;
    int lc = -1;                 // last comma index
    boolean white = true;
    for (; i < end; i++)
	 {
      char c = buf.charAt(i);
      if (c == comma)
		{
        tmp.addElement(trimStringBufferRight(sb));
        sb.setLength(0);
        lc = i;
        white = true;
      }
		else
		{
        if (c == '\\') {
          i++;
          c = buf.charAt(i);
        }

        if (! white ) {
          sb.append(c);
        } else if (! Character.isWhitespace(c)) {
          sb.append(c);
          white=false;
        } else {
          // white and still reading initial white space
        }
      }
    }
    if (sb.length() > 0) {
      // still chars in the buffer?
      tmp.addElement(trimStringBufferRight(sb));
    } else if (lc > -1 && i>lc) {
      tmp.addElement(emptyString);
    }

    return tmp;
  }

  public static String trimStringBufferRight(StringBuffer sb) {
    int l = sb.length();

    // if empty, return an empty string
    if (l == 0) return emptyString;

    // skip trailing whitespace
    int j;
    for (j = (l-1); j>=0; j--) {
      if (! Character.isWhitespace(sb.charAt(j))) {
        break;
      }
    }

    // if only whitespace return empty
    if (j < 0) return emptyString;

    sb.setLength(j+1);

    return sb.toString();
  }


  public static Vector parseCSV(String buf) {
    return parseCSV(buf, 0, buf.length(), ',');
  }
  public static Vector parseCSV(String buf, int start) {
    return parseCSV(buf, start, buf.length(), ',');
  }
  public static Vector parseCSV(String buf, int start, int end) {
    return parseCSV(buf, start, end, ',');
  }

  public static Vector parseCSV(String buf, char comma) {
    return parseCSV(buf, 0, buf.length(), comma);
  }

  public static Vector explode(String s) {
    Vector v = new Vector();
    int k = 0;                  // char after last white
    int l = s.length();
    int i = 0;
    while (i < l) {
      if (Character.isWhitespace(s.charAt(i))) {
        // is white - what do we do?
        if (i == k) {           // skipping contiguous white
          k++;
        } else {                // last char wasn't white - word boundary!
          v.addElement(s.substring(k,i));
          k=i+1;
        }
      } else {                  // nonwhite
        // let it advance
      }
      i++;
    }
    if (k != i) {               // leftover non-white chars
      v.addElement(s.substring(k,i));
    }
    return v;
  }

  /**
   * Prefix all lines of "s" with "prefix", e.g.<br>
   *   <code>prefixLines("X: ", "a\nb")</code><br>
   * returns<br>
   *   <code>"X: a\nA: b"</code><br>
   */
  public static String prefixLines(String prefix, String s) {
    StringBuffer sb = new StringBuffer();
    int j = s.indexOf('\n');
    if (j < 0) {
      sb.append(prefix).append(s);
    } else {
      int i = 0;
      do {
        sb.append(prefix).append(s.substring(i, ++j));
        i = j;
        j = s.indexOf('\n', i);
      } while (j >= 0);
      sb.append(prefix).append(s.substring(i));
    }
    return sb.toString();
  }

  public static String arrayToString(Object[] array) {
    return appendArray(new StringBuffer(), array).substring(0);
  }

  public static StringBuffer appendArray(StringBuffer buf, Object[] array) {
    buf.append('[');
    for (int i = 0; i < array.length; i++) {
      if (i > 0) buf.append(',');
      buf.append(array[i]);
    }
    buf.append(']');
    return buf;
  }

  private static void test1(String s) {

    Vector v = parseCSV(s);
    System.out.print("'"+s+"'='");
    for (int i = 0; i < v.size(); i++) {
      if (i > 0) System.out.print("|");
      System.out.print(v.elementAt(i));
    }
    System.out.println("'");
  }

  private static void test2(String s) {
    Vector v = explode(s);
    System.out.print("'"+s+"'='");
    for (int i = 0; i < v.size(); i++) {
      if (i > 0) System.out.print("|");
      System.out.print(v.elementAt(i));
    }
    System.out.println("'");
  }
}
