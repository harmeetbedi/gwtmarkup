package emforium.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * collection of general utility functions
 */
public class GenUtil {
	/**
	 * converts fully qualified class name to class name without package prefix
	 */
	public static String getLeafClassName(Object obj) { 
		return getLeafClassName(obj.getClass().getName()); 
	}
	/**
	 * converts fully qualified class name to class name without package prefix
	 */
	public static String getLeafClassName(Class<?> cls) { 
		return getLeafClassName(cls.getName()); 
	}
	/**
	 * converts fully qualified class name to class name without package prefix
	 */
	public static String getLeafClassName(String fqClassName) {
		int idx = fqClassName.lastIndexOf('.');
		if ( idx > 0 )
			fqClassName = fqClassName.substring(idx+1);
		return fqClassName;
	}
	
	private static String s_hostName;
	/**
	 * obtains hostname of machine running this code
	 */
    public static String getHostName() {
    	if ( s_hostName == null ) {
	    	String hostname = "localhost";
	    	try {
	    		hostname = InetAddress.getLocalHost().getHostName();
	    		int idx = hostname.indexOf('.');
	    		if ( idx > 0)
	    			hostname = hostname.substring(0,idx);
	    	} catch(Exception ex) {
	    		ex.printStackTrace();
	    		throw new RuntimeException("Could not resolve local hostname",ex);
	    	}
	    	s_hostName = hostname;
    	}
    	return s_hostName;
    }

    /**
     * create map that ignores entries that either have a null key or a null value 
     */
    @SuppressWarnings("serial")
	public static<K extends Object, V extends Object> HashMap<K,V> createNoNullHashMap() {
        return new HashMap<K,V>() {
                public V put(K k,V v) {
                    return ( k==null || v==null ) ? null : super.put(k,v);
                }
            };
    }
    /**
     * creates a set that ignores null entries 
     */
    @SuppressWarnings("serial")
    public static<T> HashSet<T> createNoNullHashSet() {
        return new HashSet<T>() {
                public boolean add(T value) {
                    return ( value==null ) ? false : super.add(value);
                }
            };
    }
    /**
     * collects error stack trace, message and other useful information into a string
     * @param throwable exception to collection on
     * @return
     */
    public static String getInfo(Throwable throwable) {
        StringWriter str = new StringWriter();
        PrintWriter prt = new PrintWriter(str,true);
        prt.println(throwable.toString());
        throwable.printStackTrace(prt);
        prt.flush();
        return str.toString();
    }

    @SuppressWarnings("unchecked")
    /**
     * create a single comparater that chains a set of comparaters.
     */
	public static Comparator cat(Comparator[] compInp) {
        final Comparator[] comp = ( compInp == null )
            ? new Comparator[0] 
            : compInp;
        return new Comparator() {
                public int compare(Object o1, Object o2) {
                    int val = 0;
                    for ( int i = 0 ; val == 0 && i < comp.length ; i++ )
                        val = comp[i].compare(o1,o2);
                    return val;
                }
            };
    }

    /**
     * obtain an integer from sting. String could have suffix indicating metric. Non numeric suffix is removed and converted into multiple.
     * Suffix to multiple mapping is S:1(date format millisecond), s:1000(date format second)
     * , m:1000*60(date format minute, h:1000*60*60 (hour), d:1000*60*60*24(day), k:1024(2^10)
     * @param s string to convert
     * @return numeric value
     */
    public static int getInt(String s) {
        final int len = s.length();
        if ( len == 0 )
            return 0;
        char c = s.charAt(len-1);
        String rest = s.substring(0,len-1);
        switch(c) {
        case 'S':
            return Integer.parseInt(rest);
        case 's':
            return Integer.parseInt(rest)*1000;
        case 'm':
            return Integer.parseInt(rest)*1000*60;
        case 'h':
            return Integer.parseInt(rest)*1000*60*60;
        case 'd':
            return Integer.parseInt(rest)*1000*60*60*24;
        case 'k':
            return Integer.parseInt(rest)*1024;
        default:
            return Integer.parseInt(s);
        }
    }

    /** throw exception if status is false. Acts as java assert without using 'assert' keyword */
    public static void affirm(boolean status) {
        affirm(status,"");
    }
    /** throw exception with message if status is false. Acts as java assert without using 'assert' keyword */
    public static void affirm(boolean b,String message) {
        if ( !b ) throw new RuntimeException("Assertion Failed: "+message);
    }

    /** convert numeric to array of bytes */
    public static byte[] convertIntToBytes(int v) {
        byte[] ba = new byte[4];
        convertIntToBytes(v,ba,0);
        return ba;
    }
    /** convert numeric to array of bytes */
    public static byte[] convertIntToBytes(int v,boolean littleEndian) {
        byte[] ba = new byte[4];
        convertIntToBytes(v,ba,0,littleEndian);
        return ba;
    }
    /** convert numeric to array of bytes */
    public static byte[] convertShortToBytes(int v) {
        byte[] ba = new byte[2];
        convertShortToBytes(v,ba,0);
        return ba;
    }
    /** convert numeric to array of bytes */
    public static void convertShortToBytes(int v,byte[] ba,int offset) {
        ba[0+offset] = (byte)((v >>>  8) & 0xFF);
        ba[1+offset] = (byte)((v >>>  0) & 0xFF);
    }
    /** convert numeric to array of bytes */
    public static void convertLongToBytes(long v,byte[] ba,int offset) {
        ba[0+offset] = (byte)((v >>> 56) & 0xFF);
        ba[1+offset] = (byte)((v >>> 48) & 0xFF);
        ba[2+offset] = (byte)((v >>> 40) & 0xFF);
        ba[3+offset] = (byte)((v >>> 32) & 0xFF);
        ba[4+offset] = (byte)((v >>> 24) & 0xFF);
        ba[5+offset] = (byte)((v >>> 16) & 0xFF);
        ba[6+offset] = (byte)((v >>>  8) & 0xFF);
        ba[7+offset] = (byte)((v >>>  0) & 0xFF);
    }
    /** convert numeric to array of bytes */
    public static void convertIntToBytes(int v,byte[] ba,int offset) {
    	convertIntToBytes(v,ba,offset,true);
    }
    /** convert numeric to array of bytes */
    public static void convertIntToBytes(int v,byte[] ba,int offset,boolean littleEndian) {
    	if ( littleEndian ) {
	        ba[0+offset] = (byte)((v >>> 24) & 0xFF);
	        ba[1+offset] = (byte)((v >>> 16) & 0xFF);
	        ba[2+offset] = (byte)((v >>>  8) & 0xFF);
	        ba[3+offset] = (byte)((v >>>  0) & 0xFF);
    	} else {
	        ba[0+offset] = (byte)((v >>> 0) & 0xFF);
	        ba[1+offset] = (byte)((v >>> 8) & 0xFF);
	        ba[2+offset] = (byte)((v >>> 16) & 0xFF);
	        ba[3+offset] = (byte)((v >>> 24) & 0xFF);
    	}
    }
    /** convert array of bytes to numeric */
    public static int convertBytesToInt(byte[] ba,int offset) {
        return ((ba[0+offset] << 24) & 0xFF) 
            | ((ba[1+offset] << 16) & 0xFF) 
            | ((ba[2+offset] <<  8) & 0xFF) 
            | (ba[3+offset]);
    }
    /** create an array of bytes, with each byte having same value */
    public static byte[] newByteArray(int len,byte value) {
        byte[] data = new byte[len];
        if ( value != 0 )
            for ( int i = 0 ; i < data.length ; i++ )
                data[i] = value;
        return data;
    }
    /** append object arrays and return resulting array */
    public static Object[] cat(Object[] n1,Object[] n2) {
        Object[] res = new Object[n1.length+n2.length];
        System.arraycopy(n1,0,res,0,n1.length);
        System.arraycopy(n2,0,res,n1.length,n2.length);
        return res;
    }
    /** append arrays and return resulting array */
    public static byte[] cat(byte[] b1,byte[] b2) {
        return cat(new byte[][] { b1, b2} );
    }
    /** append arrays and return resulting array */
    public static int[] cat(int[] b1,int[] b2) {
        return cat(new int[][] { b1, b2} );
    }
    /** returns a part of byte array from offset upto requested size */
    public static byte[] slice(byte[] ba,int offset,int size) {
        if ( (offset == 0) && (ba.length == size) )
            return ba;
        byte[] res = new byte[size];
        System.arraycopy(ba,offset,res,0,size);
        return res;
    }
    /** append arrays and return resulting array */
    public static byte[] cat(byte[][] ba) {
        int len = 0;
        for ( int i = 0 ; i < ba.length ; i++ )
            len += ba[i].length;
        byte[] res = new byte[len];
        len = 0;
        for ( int i = 0 ; i < ba.length ; i++ ) {
            System.arraycopy(ba[i],0,res,len,ba[i].length);
            len += ba[i].length;
        }
        return res;
    }

    /** append arrays and return resulting array */
    public static int[] cat(int[][] ba) {
        int len = 0;
        for ( int i = 0 ; i < ba.length ; i++ )
            len += ba[i].length;
        int[] res = new int[len];
        len = 0;
        for ( int i = 0 ; i < ba.length ; i++ ) {
            System.arraycopy(ba[i],0,res,len,ba[i].length);
            len += ba[i].length;
        }
        return res;
    }

    /** append arrays and return resulting array */
    public static void cat(byte[] b1,int b1off,int b1len,byte[] b2,int b2off, int b2len,byte[] trg,int toff) {
        System.arraycopy(b1,b1off,trg,toff,b1len);
        System.arraycopy(b2,b2off,trg,toff+b1len,b2len);
    }

    /** append arrays and return resulting array */
    public static boolean isEqual(byte[] b1,byte[] b2) {
        boolean match = (b1.length==b2.length);
        for ( int i = 0 ; match && (i < b1.length) ; i++ ) 
            match = (b1[i] == b2[i]);
        return match;
    }

    /** create md5 digest for a byte array */
    public static byte[] md5(byte[] ba) {
        return digest(ba,"MD5");
    }
    /** create sha digest for a byte array */
    public static byte[] sha(byte[] ba) {
        return digest(ba,"SHA1");
    }
    /** create digest for a byte array using secified algorithm */
    public static byte[] digest(byte[] ba,String alg) {
        try {
            return MessageDigest.getInstance(alg).digest(ba);
        } catch(java.security.NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex.toString());
        }
    }
    private static final char[] HEXARR = { 
            '0', '1', '2', '3', '4', '5', '6', '7', 
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' 
        };

    /** convert byte array to hex equivalent */
    public static String hex(byte[] ba) {
        return toHexString(ba);
    }
    /** convert byte array to hex equivalent */
    public static String toHexString(byte[] ba) {
    	return toHexString(ba,0,true);
    }
    /**
     * convert byte array to hex equivalent. Partial byte array would be converted if offset != 0
     * @param ba  source byte array to convert
     * @param offset  ignore bytes before offset index or after offset index based on trimFromLeft value
     * @param trimFromLeft controls what portion of array is ignored left of right.
     * @return
     */
    public static String toHexString(byte[] ba,int offset,boolean trimFromLeft) {
        StringBuffer buf = new StringBuffer();
        final int startIdx;
        final int endIdx;
        if ( offset > 0 ) {
        	if ( trimFromLeft ) {
        		startIdx = offset;
        		endIdx = ba.length - 1;
        	} else {
        		startIdx = 0;
        		endIdx = ba.length - 1 - offset;
        	}
        } else {
        	startIdx = 0;
        	endIdx = ba.length-1;
        }
        for ( int i = startIdx ; i <= endIdx ; i++ ) {
            char c0 = HEXARR[( ba[i] >> 4 ) & 0x0f];
            char c1 = HEXARR[ba[i] & 0x0f];
            buf.append(c0);
            buf.append(c1);
        }
        return buf.toString();
    }
    /** convert single byte to hex equivalent */
    public static String toHexString(byte ba) {
        StringBuffer buf = new StringBuffer();
        buf.append(HEXARR[( ba >> 4 ) & 0x0f]);
        buf.append(HEXARR[ba & 0x0f]);
        return buf.toString();
    }
    /** convert numeric to hex equivalent */
    public static String toHexString(int v) {
    	return toHexString(convertIntToBytes(v));
    }
    /** convert numeric to hex equivalent */
    public static String toHexString(short v) {
    	return toHexString(convertShortToBytes(v));
    }
    /**
     * convert byte array to hex equivalent. String can be spread across multiple 
     * lines to make it easy to see. Some standards require hex storage and split across lines.
     * @param ba    source byte array
     * @param sep   separator between bytes
     * @param lineSize  number of bytes in one line
     * @return
     */
    public static String toHexString(byte[] ba,char sep,int lineSize) {
        StringBuffer buf = new StringBuffer();
        for ( int i = 0 ; i < ba.length ; i++ ) {
            if ( (lineSize > 0) && (i > 0) && (i % lineSize == 0) )
                buf.append("\r\n");
            char c0 = HEXARR[( ba[i] >> 4 ) & 0x0f];
            char c1 = HEXARR[ba[i] & 0x0f];
            buf.append(c0);
            buf.append(c1);
            buf.append(sep);
        }
        return buf.toString();
    }

    /** generate random bytes. */
    public static byte[] rndBytes(int size,boolean strong) {
        strong = false;
        Random rnd = (strong) ? new SecureRandom() : new Random();
        byte ba[] = new byte[size];
        rnd.nextBytes(ba);
        return ba;
    }

    /** generate random number between [lower,upper). */
    public static int rndInt(int lower,int upper,boolean strong) {
        Random rnd = (strong) ? new SecureRandom() : new Random();
        int size = upper - lower;
        if ( size > 0 ) {
            int val = rnd.nextInt();
            return ((val % size)+lower);
        } else {
            return lower;
        }
    }

    /**
     * returns the field value for a particular object instance. 
     * Ignores accessibility. This can be used to retrieve private values.
     * @param cls  class of object instance
     * @param obj  object instance
     * @param name field name
     * @return value of field
     */
    public static Object getFieldValue(Class<?> cls,Object obj,String name) 
        throws NoSuchFieldException, IllegalAccessException
    {
        //System.out.println("cls,field="+cls.getName()+","+name);
        Field f = cls.getDeclaredField(name);
        f.setAccessible(true);
        return f.get(obj);
    }

    /**
     * set the field value for a particular object instance. 
     * Ignores accessibility. This can be used to retrieve private values.
     * @param cls  class of object instance
     * @param obj  object instance
     * @param name field name
     * @param value of field
     */
    public static void setFieldValue(Class<?> cls,Object obj,String name,Object value) 
        throws NoSuchFieldException,IllegalAccessException
    {
        //System.out.println("cls,field="+cls.getName()+","+name);
        Field f = cls.getDeclaredField(name);
        f.setAccessible(true);
        f.set(obj,value);
    }

    /** converts string to hex of bytes and returns it */
    public static String hashhex(String s) {
        return hashhex(s.getBytes());
    }
    /** converts byte array to hex of bytes and returns it */
    public static String hashhex(byte[] ba) {
        return hex(hash(ba));
    }
    /** converts byte array to digest using SHA algorithm */
    public static byte[] hash(byte[] ba) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            return md.digest(ba);
        } catch(java.security.NoSuchAlgorithmException nsaex) {
            throw new RuntimeException(nsaex.toString());
        }
    }

    /** dumps hex equivalent of byte array onto console. useful for network debugging of binary data */
    public static void dump(String label,byte[] ba) {
        String tid=Thread.currentThread().getName();
        if ( ba == null )
            ba = new byte[0];
        System.out.println(label+" ["+tid+"], "+ba.length);
        StringBuffer buf = new StringBuffer();
        final String LINE_SEP = System.getProperty("line.separator");
        final String SPC = " ";
        final String ZERO = "0";
        for( int i = 0 ; i < ba.length ; i++ ) {
            if ( i > 0 && (i % 16) == 0 )
                buf.append(LINE_SEP);
            if ( i % 8 == 0 ) 
                buf.append(SPC);
            int val = ba[i];
            if ( val < 0 )
                val += 256;
            String s = Integer.toHexString(val);
            if ( s.length() == 1 )
                buf.append(ZERO);
            buf.append(s+SPC);
        }
        if ( ba.length > 0 )
            System.out.println(buf.toString().toUpperCase());
    }

    /** gets position of item in a collection of items */
    public static int getPosition(Object elem,Object[] list)  {
        for ( int i = 0 ; i < list.length ; i++ )
            if ( elem.equals(list[i]) )
                return i;
        return -1;
    }
    
    /** adds key and value to a map of sorted sets(key -> set(values)) */
    static public<K,V> void addToMultiMapSortedSet(Map<K,Set<V>> map,K key, V value) {
    	Set<V> list = map.get(key);
    	if ( list == null ) {
    		list = new TreeSet<V>();
    		map.put(key, list);
    	}
    	list.add(value);
     }
    /** adds key and value to a map of hashed sets(key -> set(values)) */
    static public<K,V> void addToMultiMapSet(Map<K,Set<V>> map,K key, V value) {
    	Set<V> list = map.get(key);
    	if ( list == null ) {
    		list = new HashSet<V>();
    		map.put(key, list);
    	}
    	list.add(value);
     }
    /** adds key and value to a map of key -> list(of values) */
    static public<K,V> void addToMultiMap(Map<K,List<V>> map,K key, V value) {
    	addToMultiMap(map, key, value, false);
     }
    /** adds key and value to a map of key -> list(of values). existing key -> value entries are ignored */
    static public<K,V> void addToMultiMap(Map<K,List<V>> map, K key, V value, boolean ignoreDupes) {
    	List<V> list = map.get(key);
    	if ( list == null ) {
    		list = new ArrayList<V>();
    		map.put(key, list);
    	}
    	if ((!ignoreDupes) || (!list.contains(value))) {
    		list.add(value);
    	}
    }
    /** adds key, key2 and value to a map of key -> map(key2->(value). */
    static public<X,Y,Z> void addToMultiMap(Map<X,Map<Y,Z>> map, X key, Y key2, Z value) {
    	Map<Y,Z> innerMap = map.get(key);
    	if ( innerMap == null ) {
    		innerMap = new HashMap<Y,Z>();
    		map.put(key, innerMap);
    	}
    	innerMap.put(key2,value);
    }
}