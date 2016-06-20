package emforium.util;

import java.util.*;
import java.util.zip.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

/**
 * collection of network utilities
 */
public class IOUtil {
	/**
	 * read file and return individual lines
	 * @param file source file
	 * @param trim if true, trim each line
	 * @param ignoreEmpty if true, empty lines are ignored
	 * @return lines in file
	 * @throws IOException
	 */
    public static String[] lines(File file,boolean trim,boolean ignoreEmpty) 
        throws IOException 
    {
        FileReader f = new FileReader(file);
        String[] retval = lines(f,trim,ignoreEmpty);
        f.close();
        return retval;
    }

	/**
	 * read file/stream and return individual lines
	 */
    public static String[] lines(String fname,boolean trim,boolean ignoreEmpty) 
        throws IOException 
    {
        return lines(new File(fname),trim,ignoreEmpty);
    }

	/**
	 * read file/stream and return individual lines
	 */
    public static String[] lines(InputStream inp,boolean trim,boolean ignoreEmpty) 
        throws IOException 
    {
        return lines(new InputStreamReader(inp),trim,ignoreEmpty);
    }
	/**
	 * read file/stream and return individual lines
	 */
    public static String[] lines(Reader inp,boolean trim,boolean ignoreEmpty) 
        throws IOException 
    {
        return lines(inp,trim,ignoreEmpty,false);
    }
	/**
	 * read file/stream and return individual lines
	 */
    public static String[] lines(Reader inp,boolean trim,boolean ignoreEmpty,boolean close) 
        throws IOException 
    {
        if ( close ) {
            try {
                return lines(inp,trim,ignoreEmpty,false);
            } finally {
                try { inp.close(); } catch(Throwable t) { }
            }
        }

        BufferedReader reader = ( inp instanceof BufferedReader )
        	? (BufferedReader)inp : new BufferedReader(inp);
        List<String> list = new ArrayList<String>();
        String line = null;
        while ( (line = reader.readLine()) != null ) {
            if ( trim )
                line = line.trim();
            boolean ignore = false;
            if ( ignoreEmpty )
                ignore = ( trim && line.length() == 0 ) || 
                    ( !trim && line.trim().length() == 0 );
            if ( ignore == false )
                list.add(line);
        }
        return (String[])list.toArray(new String[0]);
    }

    /**
     * read input stream and return data bytes
     * @param inp  sources
     * @param max  maximum size to read. <0 for no limit
     * @return data read
     */
    public static byte[] drain(InputStream inp,int max) throws IOException {
        // @param max: max bytes read, if -1 all bytes are read
        return drain(inp,max,false);
    }

    /**
     * read input stream and return data bytes
     * @param inp  sources
     * @param max  maximum size to read. <0 for no limit
     * @param close if true, close input stream after reading is complete
     * @return data read
     * @throws IOException
     */
    public static byte[] drain(InputStream inp,int max,boolean close) throws IOException {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        drain(inp,ba,max,-1,close);
        return ba.toByteArray();
    }

    /**
     * read input stream and return data bytes
     */
    public static void drain(InputStream inp,OutputStream out,int max,int chunk,boolean close)
        throws IOException 
    {
        drain(inp,out,max,chunk,close,false);
    }

    /**
     * read input stream and return data bytes
     */
    public static boolean drain(Reader inp,Writer out,int max,int chunk,boolean close)
        throws IOException 
    {
        if ( close ) {
            try {
                return drain(inp,out,max,chunk,false);
            } finally {
                try { inp.close(); } catch(Throwable t) { }
            }
        }
        if ( chunk <= 0 )
            chunk = 1024*8;
        char[] ba = new char[chunk];
        while ( max != 0 ) {
            int count = inp.read(ba,0,(max>0)?Math.min(max,ba.length):ba.length);
            if ( count == -1 )
                return true;
            if ( max > 0 )
                max = max - count;
            out.write(ba,0,count);
        }
        return false;
    }

    /** NOTE: out is flushed at end of write operations */
    public static void drain(InputStream inp,OutputStream out,int max,int chunk,boolean close,boolean tryfilenio)
        throws IOException 
    {
        if ( close ) {
            try {
                drain(inp,out,max,chunk,false,tryfilenio);
                return;
            } finally {
                inp.close();
            }
        }

        if ( chunk <= 0 )
            chunk = 1024*8;
        byte[] ba = new byte[chunk];
        if ( tryfilenio && inp instanceof FileInputStream ) {
            FileChannel chan = ((FileInputStream)inp).getChannel();
            MappedByteBuffer buf = chan.map(FileChannel.MapMode.READ_ONLY,0,chan.size());
            while ( true ) {
                int remaining = buf.remaining();
                if ( remaining == 0 )
                    break;
                int len = Math.min(remaining,ba.length);
                buf.get(ba,0,len);
                out.write(ba,0,len);
            }
        }
        else {
            while ( max != 0 ) {
                int count = inp.read(ba,0,(max>0)?Math.min(max,ba.length):ba.length);
                if ( count == -1 )
                    break;
                if ( max > 0 )
                    max = max - count;
                out.write(ba,0,count);
            }
        }
        out.flush();
    }

    /** @param chunk: size data is read in and written out. */
    public static void drain(InputStream inp,OutputStream out,int max,int chunk)
        throws IOException 
    {
        drain(inp,out,max,chunk,false);
    }

    /** @param chunk: size data is read in and written out. */
    public static void drainToFile(InputStream inp,String file,int max,int chunk) throws IOException {
        FileOutputStream fout = new FileOutputStream(file);
        try {
            drain(inp,fout,max,chunk);
            fout.flush();
        } finally {
            fout.close();
        }    
    }

    /** read and return content of file */
    public static byte[] drainFromFile(String file) throws IOException {
        File f = new File(file);
        FileInputStream fin = new FileInputStream(f);
        byte[] ba = drain(fin,(int)f.length());
        fin.close();
        return ba;
    }

    /**
     * adds data from stream into zip entry
     * @param out output zip entry for stream
     * @param path path in zip file for zip entry
     * @param inp input stream that has content of zip entry
     */
    public static void addZipEntry(ZipOutputStream out,String path,InputStream inp) throws IOException {
        byte[] data = drain(inp,-1);
        ZipEntry entry = new ZipEntry(path);
        entry.setMethod(ZipEntry.STORED);
        entry.setSize(data.length);
        CRC32 crc = new CRC32();
        crc.update(data);
        entry.setCrc(crc.getValue());
        out.putNextEntry(entry);
        byte[] extra = entry.getExtra();
        if ( extra != null )
            out.write(extra);
        out.write(data);
        out.closeEntry();
    }

    /**
     * create a NOT filter
     */
    public static FilenameFilter invertFilter(final FilenameFilter filter) {
        return new FilenameFilter() {
                public boolean accept(File f,String name) {
                    return !filter.accept(f,name);
                }
            };
    }
    /**
     * create AND filter given two file filters
     */
    public static FilenameFilter andFilter(final FilenameFilter filter1, 
                                           final FilenameFilter filter2) {
        return new FilenameFilter() {
                public boolean accept(File f,String name) {
                    return filter1.accept(f,name) && filter2.accept(f,name);
                }
            };
    }
    /**
     * create OR filter from two input filters
     */
    public static FilenameFilter orFilter(final FilenameFilter filter1, 
                                          final FilenameFilter filter2) {
        return new FilenameFilter() {
                public boolean accept(File f,String name) {
                    return filter1.accept(f,name) || filter2.accept(f,name);
                }
            };
    }

    /**
     * remove file or directory
     */
    public static boolean cleanup(File f) {
        if ( !f.exists() )
            return true;
        if ( f.isDirectory() ) {
            File[] list = f.listFiles();
            if ( list != null && list.length > 0 )
                for ( int i = 0 ; i < list.length ; i++ ) {
                    cleanup(list[i]);
            }
        }
        return f.delete();
    }

    /**
     * read 3 bytes(LSB) and convert to integer
     */
    public static int readInt24(DataInputStream din) throws IOException {
        int b1 = ((din.readByte() & 0xff) << 16);
        int b2 = ((din.readByte() & 0xff) << 8);
        int b3 = (din.readByte() & 0xff);
        return (b1+b2+b3);
    }

    /**
     * read 3 bytes(LSB) of integer
     */
    public static void writeInt24(OutputStream out,int val) throws IOException {
        out.write((val >>> 16) & 0xFF);
        out.write((val >>>  8) & 0xFF);
        out.write((val >>>  0) & 0xFF);
    }
    
    /** write bytes to a file */
    public static void writeBytes(File f, byte[] ba) throws IOException {
        FileOutputStream fout = new FileOutputStream(f);
        try {
            fout.write(ba);
        } finally {
            try { fout.close(); } catch(Exception ex) { }
        }
    }

    /** write set of lines to file */
    public static void writeLines(File f,Iterable<String> lines) throws IOException {
        FileOutputStream fout = new FileOutputStream(f);
        try {
            PrintStream prt = new PrintStream(fout);
            for ( String str : lines ) 
                prt.println(str);
            prt.flush();
        } finally {
            fout.close();
        }
    }
    
    /** rename one file to another */
    public static void forceRename(File src,File dest) throws IOException {
        //System.out.println(src.getAbsolutePath()+"->"+dest.getAbsolutePath());
        
        if ( !src.exists() )
            throw new IOException("Source does not exist: "+src.getAbsolutePath());
        if ( dest.exists() )
            throw new IOException("Destination already exists: "+dest.getAbsolutePath());
        boolean b = src.renameTo(dest);
        if ( !b ) 
            throw new IOException("Rename failed. "+
                                  "src="+src.getAbsolutePath()+
                                  ", dest="+dest.getAbsolutePath());
    }

    /** read integer (4 bytes) */
    public static int readInt(InputStream in,boolean bigEndian) throws IOException {
        int ch1 = in.read();
        int ch2 = in.read();
        int ch3 = in.read();
        int ch4 = in.read();
        if ((ch1 | ch2 | ch3 | ch4) < 0)
            throw new EOFException();
        return ( bigEndian )
            ? ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0))
            : ((ch4 << 24) + (ch3 << 16) + (ch2 << 8) + (ch1 << 0));
    }
    /** read short ( 2 bytes ) */
    public static short readShort(InputStream in,boolean bigEndian) throws IOException {
        int ch1 = in.read();
        int ch2 = in.read();
        if ((ch1 | ch2) < 0)
            throw new EOFException();
        return ( bigEndian )
            ? (short)((ch1 << 8) + (ch2 << 0))
            : (short)((ch2 << 8) + (ch1 << 0));
    }

    /** transfer data from one file channel to another. File Channel could be network/tcp backed */
    @SuppressWarnings("static-access")
	public static void transferFrom(FileChannel fc,ReadableByteChannel src,boolean close) throws IOException {
        if ( close ) {
            try {
                transferFrom(fc,src,false);
            } finally {
                try { fc.close(); } catch(Throwable t) { }
            }
        }
        long offset = 0;
        final long chunkSize = 1024*4;
        while ( true ) {
            //long written = 
            fc.transferFrom(src,offset,chunkSize);
            if ( src.isOpen() )
                try {
                    Thread.currentThread().sleep(250);
                } catch(InterruptedException ex) {
                    throw new IOException("interrupted during transferTo: "+ex.toString());
                }
            else
                break;
        } 
    }
    /** transfer data from one file channel to another. File Channel could be network/tcp backed */
    public static void transferTo(FileChannel fc,WritableByteChannel trg,boolean close) throws IOException {
        if ( close ) {
            try {
                transferTo(fc,trg,false);
                return;
            } finally {
                try { fc.close(); } catch(Throwable t) { }
            }
        }

        long sizeLeft = fc.size();
        long offset = 0;
        while ( true ) {
            long written = fc.transferTo(offset,sizeLeft,trg);
            //System.out.println("size="+sizeLeft+", written="+written);
            sizeLeft -= written;
            offset += written;
            
            // give CPU some rest.
            if ( sizeLeft <= 0 )
                break;
            else {
                try {
                    //Thread.currentThread().sleep(250);
                    Thread.sleep(250);
                } catch(InterruptedException ex) {
                    throw new IOException("interrupted during transferTo: "+ex.toString());
                }
            }
        } 
    }
    
    /** Recursively apply filter to a directory and collect all files that match */
    private static void collectFiles(File dir,FilenameFilter filter,boolean recurse,List<File> result) {
    	//System.out.println("dir="+dir+", recurse="+recurse+", results="+result.size()+", filter="+filter);
    	if ( recurse ) {
    		//File[] files = ;
        	//System.out.println("files="+files);
    		for ( File child : dir.listFiles(filter)) {
    			if ( child.isDirectory() )
    				collectFiles(child,filter,true,result);
    			else if ( filter.accept(dir, child.getName()))
        			result.add(child);
    		}
    	} else {
    		for ( File f : dir.listFiles(filter))
    			result.add(f);
		}
    }
    
    /** Recursively apply filter to a directory and collect all files that match */
    public static List<File> findFiles(File dir,FilenameFilter filter,boolean recurse) {
    	List<File> result = new ArrayList<File>();
    	collectFiles(dir,filter,recurse,result);
    	return result;
    }
    
    /** load properties from a resource in classpath */
    public static Properties loadPropertiesResource(String rootDir, String path) throws IOException {
		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
		if ( in == null ) {
			// needed for tests. for some reason test is not picking resource from classpath
			String fileName = (rootDir+"/"+path).replace('/', File.separatorChar);
			in = new FileInputStream(new File(fileName));
		}
		try {
			Properties prop = new Properties();
			prop.load(in);
			return prop;
		} finally {
			in.close();
		}
    }
}
