package emforium.codegen;

import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ObjectType;
import org.apache.bcel.generic.Type;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.extjs.gxt.ui.client.widget.Layout;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import emforium.util.GenUtil;

/**
 * generates widget factories. Widget factory read XML element, construct GWT Widgets and set attributes of widget based element attributes 
 */
public class WidgetFactoryGenerator {
	/** 
	 * input arguments are 
	 * [0]: directory where source code exists for templates and where generated code is emitted
	 * [1]: target package of generate code
	 * [2]: jar file containing gwt library
	 */
    public static void main(String[] args) throws Exception {
        String baseDir = args[0];
        String trgPkg = args[1];
        String libFile = args[2];
        boolean gwtLib = libFile.toLowerCase().contains("gwt-user.jar");
        
        // collect all the gwt classes
        Map<String,Set<String>> hierParentChildGwtMap = new HashMap<String,Set<String>>();
        Map<String,Set<String>> hierChildParentGwtMap = new HashMap<String,Set<String>>();
        Map<String,JavaClass> jclsGwtMap = new HashMap<String,JavaClass>();
        Map<String,JavaClass> jclsGwtArgsConstructorMap = new HashMap<String,JavaClass>();
        collectClassHierarchy("./lib/gwt-user.jar",hierParentChildGwtMap,hierChildParentGwtMap,jclsGwtMap,jclsGwtArgsConstructorMap);
        Set<String> uiObjectDerivedSet = new HashSet<String>();
        collectDerivedClasses(hierParentChildGwtMap,UIObject.class.getName(),uiObjectDerivedSet);
        //System.out.println("DerivedClasses:     "+uiObjectDerivedSet);

        // collect candidate list of classes to generate
        Map<String,Set<String>> hierParentChildMap = new HashMap<String,Set<String>>();
        Map<String,Set<String>> hierChildParentMap = new HashMap<String,Set<String>>();
        Map<String,JavaClass> jclsMap = new HashMap<String,JavaClass>();
        Map<String,JavaClass> jclsArgsConstructorMap = new HashMap<String,JavaClass>();
        collectClassHierarchy(libFile,hierParentChildMap,hierChildParentMap,jclsMap,jclsArgsConstructorMap);
        //System.out.println("Button:     "+hierChildParentMap.get(Button.class.getName()));

        // collect factory of classes
        Map<String,ClassInfo> classesToGen = new HashMap<String,ClassInfo>();
        if ( gwtLib ) {
        	String rootCls = UIObject.class.getName();
    		JavaClass jcls = jclsMap.get(rootCls);
    		if ( jcls != null ) {
    			collectFactoryClass(Object.class.getName(),jcls,0,trgPkg,gwtLib,classesToGen,!jcls.isAbstract());
    		}
    		JavaClass jclsArgs = jclsArgsConstructorMap.get(rootCls);
    		if ( jclsArgs != null ) {
    			collectFactoryClass(Object.class.getName(),jcls,0,trgPkg,gwtLib,classesToGen,false);
    		}
        	collectFactoryClasses(hierParentChildMap,jclsMap,jclsArgsConstructorMap,rootCls,1,trgPkg,gwtLib,classesToGen);
    	} else {
    		for ( String baseCls : uiObjectDerivedSet )
    			collectFactoryClasses(hierParentChildMap,jclsMap,jclsArgsConstructorMap,baseCls,1,trgPkg,gwtLib,classesToGen);
        }
    	collectFactoryClasses(hierParentChildMap,jclsMap,jclsArgsConstructorMap,Layout.class.getName(),1,trgPkg,gwtLib,classesToGen);
    	//collectFactoryClasses(hierParentChildMap,jclsMap,RefDataClass.class.getName(),1,trgPkg,gwtLib,classesToGen);
    	for ( ClassInfo ci : classesToGen.values() )
    		ci.collectWidgetAssociations(classesToGen,hierChildParentMap);

        

        // generate classes
        generateClasses(baseDir,"widgetfactory.vm",classesToGen);
        generateLookupClass(baseDir,"widgetfactorylookup.vm",trgPkg,classesToGen);
        //System.out.println("****************: "+subClsMap.keySet());
    }
    private static void collectDerivedClasses(Map<String,Set<String>> hierParentChildMap,String topLevelClass,Set<String> derivedSet) {
		derivedSet.add(topLevelClass);
    	Set<String> set = hierParentChildMap.get(topLevelClass);
    	if ( set == null )
    		return;
    	for ( String cls : set ) {
    		collectDerivedClasses(hierParentChildMap,cls,derivedSet);
    	}
    }
    /** generates all the factories */
    private static void generateClasses(String baseDir,String template,Map<String,ClassInfo> classesToGen) throws Exception {
    	for ( ClassInfo ci : classesToGen.values() )
    		generateClass(baseDir,template,ci);
    }
    
    /** generates factory lookup */
    private static void generateLookupClass(String baseDir,String template,String trgPkg, Map<String,ClassInfo> ci) throws Exception {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("package",trgPkg);
		param.put("classes",ci);
		String outFileName = "GwtFactoryRegistryImpl.java";
		String outFile = baseDir+"/"+trgPkg.replace('.','/')+'/'+outFileName;
		generate(baseDir,template,outFile,param);
    }
    /** generates single widget factory */
    private static void generateClass(String baseDir,String template,ClassInfo ci) throws Exception {
    	//System.out.println("generateClass: "+ci.getClassName());
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("class",ci);
		String outFileName = ci.getLeafName()+"Factory.java";
		String outFile = (baseDir+"/"+ci.getPackageName()).replace('.','/')+'/'+outFileName;
		generate(baseDir,template,outFile,param);
    }
    /** generate single velocity template */
    private static void generate(String baseDir,String template,String outFile,Map<String,Object> param) throws Exception {
	    VelocityContext ctxt = new VelocityContext(param);
	    StringWriter writer = new StringWriter();
	    template = baseDir+'/'+WidgetFactoryGenerator.class.getPackage().getName().replace('.','/')+"/"+template;
	    Velocity.mergeTemplate(template,"UTF-8",ctxt,writer);
	    FileOutputStream fout = new FileOutputStream(outFile);
	    try {
	        fout.write(writer.toString().getBytes());
	    } finally {
	        try { fout.close(); } catch(Exception ex) { }
	    }
    }
    
    /** collect classes to generate into output parameter @param classesToGen */
    private static void collectFactoryClasses(Map<String,Set<String>> hierMap
    		,Map<String,JavaClass> jclsMap, Map<String,JavaClass> jclsArgsMap
    		,String rootClsName, int level, String trgPkg, boolean gwtLib
    		,Map<String,ClassInfo> classesToGen) throws Exception 
    {
        Set<String> subClsMap = hierMap.get(rootClsName);
        if ( subClsMap == null )
        	return;
    	for ( String cls : subClsMap ) {
    		JavaClass jcls = jclsMap.get(cls);
    		JavaClass jclsArgs = jclsArgsMap.get(cls);
    		if ( jcls == null && jclsArgs == null )
    			continue;
    		boolean abstractCls = (jcls != null) ? jcls.isAbstract() : jclsArgs.isAbstract();
    		boolean newInstancePossible = (jcls != null) && !jcls.isAbstract();
    		String className = (jcls != null ) ? jcls.getClassName() : jclsArgs.getClassName();
    		int newLevel = abstractCls ? level : (level+1);
    		collectFactoryClass(rootClsName,jcls != null ? jcls : jclsArgs,level,trgPkg,gwtLib,classesToGen,newInstancePossible);
    		collectFactoryClasses(hierMap,jclsMap,jclsArgsMap,className,newLevel,trgPkg,gwtLib,classesToGen);
    	}
    }
    /** collect classes to generate into output parameter @param classesToGen */
    private static void collectFactoryClass(String rootClsName
    										,JavaClass jcls
								    		,int level
								    		,String trgPkg
								    		,boolean gwtLib
								    		,Map<String,ClassInfo> classesToGen
								    		,boolean newInstancePossible) 
    throws Exception 
    {
    	if ( !jcls.isPublic())
    		return;
    	// omit desktop
    	if (  jcls.getClassName().indexOf("com.extjs.gxt.desktop") >= 0 )
    		return;
    	classesToGen.put(jcls.getClassName(),new ClassInfo(trgPkg,jcls,rootClsName,gwtLib,level,newInstancePossible));
    }
    
    /** collect class hierarchy in a jar file.  collect both parent to child and child to all ancestors relationships */
    private static void 
    collectClassHierarchy(String zipLib
    		,Map<String,Set<String>> hierParentChildMap
    		,Map<String,Set<String>> hierChildParentMap
    		,Map<String,JavaClass> jclsMap
    		,Map<String,JavaClass> jclsArgsConstructorMap
    		) 
    throws Exception 
    {
    	//System.out.println("hierParentChildMap: "+hierParentChildMap.keySet());
        ZipFile zip = new ZipFile(zipLib);
        Enumeration<? extends ZipEntry> entryEnum = zip.entries();
        while ( entryEnum.hasMoreElements() ) {
        	ZipEntry entry = (ZipEntry)entryEnum.nextElement();
        	//if ( entry.isDirectory() )         		return;
        	String name = entry.getName();
        	if ( !name.endsWith(".class") )
        		continue;

        	// remove extension
        	name = name.substring(0,name.length()-6);

        	// ignore inner classes
        	if ( name.indexOf('$') > 0 )
        		continue;
        	
        	ClassParser parser = new ClassParser(zipLib, entry.getName());
    		JavaClass jcls = parser.parse();

    		String superCls = jcls.getSuperclassName();
    		if ( superCls != null && superCls.length() > 0 )
    			GenUtil.addToMultiMapSet(hierParentChildMap, superCls, jcls.getClassName());
        }

        entryEnum = zip.entries();
        while ( entryEnum.hasMoreElements() ) {
        	ZipEntry entry = (ZipEntry)entryEnum.nextElement();
        	//if ( entry.isDirectory() )         		return;
        	String name = entry.getName();
        	if ( !name.endsWith(".class") )
        		continue;

        	// remove extension
        	name = name.substring(0,name.length()-6);

        	// ignore inner classes
        	if ( name.indexOf('$') > 0 )
        		continue;
        	
        	ClassParser parser = new ClassParser(zipLib, entry.getName());
    		JavaClass jcls = parser.parse();

    		// consider only abstract classes and concrete classes that have a no argument constructor
			boolean noArgConstructor = false;
    		Method[] methods = jcls.getMethods();
			//System.out.println(jcls.getClassName());
    		for ( Method mthd : methods )  {
    			//System.out.println("	"+mthd.getName());
    			if ( mthd.isPublic() && mthd.getName().equals("<init>") ) {
    				noArgConstructor = (mthd.getArgumentTypes().length == 0);
    			}
    			if ( noArgConstructor )
    				break;
    		}
        
    		Set<String> derivedSet = hierParentChildMap.get(jcls.getClassName());
    		// include class if it is not private and has a no args constructor
    		// and include all abstract classes. There may be derived class with no arg constructor
    		if ( jcls.isAbstract() ) {
    			jclsMap.put(jcls.getClassName(),jcls);
    		}
    		else if ( !jcls.isPrivate() ) {
    			if ( noArgConstructor ) {
    				jclsMap.put(jcls.getClassName(),jcls);
    			} else {
    				jclsArgsConstructorMap.put(jcls.getClassName(),jcls);
    			}
    		}
        }
        
        for ( String parent : hierParentChildMap.keySet() ) {
        	createChildParentHierarchy(parent, parent, hierParentChildMap, hierChildParentMap);
        }
    }
    
    /** recursively walk the parent to child hierarchy to build map of child -> set(of all ancestors) */
    private static void createChildParentHierarchy(String topParent, String currParent, Map<String
    		,Set<String>> hierParentChildMap
    		, Map<String,Set<String>> hierChildParentMap) 
    {
    	Set<String> set = hierParentChildMap.get(currParent);
    	if ( set == null )
    		return;
    	for ( String child : set ) {
			GenUtil.addToMultiMapSet(hierChildParentMap, child, currParent);
			createChildParentHierarchy(currParent,child,hierParentChildMap,hierChildParentMap);
    		if ( !topParent.equals(currParent) ) {
    			GenUtil.addToMultiMapSet(hierChildParentMap, child, topParent);
    			createChildParentHierarchy(topParent,child,hierParentChildMap,hierChildParentMap);
    		}
    	}
    }
    
    // --------------------------- helper classes  ---------------------

    /**
     * collects all information to generate a single widget factory class 
     */
    public static class ClassInfo {
        private static Map<Type,AttributeTypeInfo> s_supportedAttrTypeMap = new HashMap<Type,AttributeTypeInfo>();
        static {
            s_supportedAttrTypeMap.put(Type.BOOLEAN,new AttributeTypeInfo("Boolean","boolean"));
            s_supportedAttrTypeMap.put(Type.INT,new AttributeTypeInfo("Integer","int"));
            s_supportedAttrTypeMap.put(Type.SHORT,new AttributeTypeInfo("Short","short"));
            s_supportedAttrTypeMap.put(Type.BYTE,new AttributeTypeInfo("Byte","byte"));
            s_supportedAttrTypeMap.put(Type.LONG,new AttributeTypeInfo("Long","long"));
            s_supportedAttrTypeMap.put(Type.DOUBLE,new AttributeTypeInfo("Double","double"));
            s_supportedAttrTypeMap.put(Type.FLOAT,new AttributeTypeInfo("Float","float"));
            s_supportedAttrTypeMap.put(Type.CHAR,new AttributeTypeInfo("Character","char"));
            s_supportedAttrTypeMap.put(Type.STRING,new AttributeTypeInfo("String","String"));
        }

        private final String packageName;
    	private final JavaClass jcls;
    	private final String parentClassName;
		private final boolean extendsGeneric;
		private final boolean generic;
		private final boolean gwtLib;
		private boolean newInstancePossible;
		private final Map<String,AttributeInfo> attributes = new LinkedHashMap<String,AttributeInfo>();
		private final Set<WidgetAddMethodInfo> widgetAddMethods = new LinkedHashSet<WidgetAddMethodInfo>();
    	ClassInfo(String packageName, JavaClass jcls, String parentClassName, boolean gwtLib, int inheritenceLevel, boolean newInstancePossible) {
    		this.packageName = packageName;
    		this.jcls = jcls;
    		this.parentClassName = parentClassName;
    		this.gwtLib = gwtLib;
			if (  jcls.isAbstract() )
				newInstancePossible = false;
    		this.newInstancePossible = newInstancePossible;
    		//if ( inheritenceLevel <= 2 )
    		//	System.out.println(jcls.getClassName()+", level:"+inheritenceLevel);
    		extendsGeneric = (inheritenceLevel==1) && jcls.isAbstract();
    		if ( extendsGeneric )
    			generic = false;
    		else 
    			generic = (inheritenceLevel <= 2);

        	for ( Method mthd : jcls.getMethods() ) {
    			if ( mthd.isAbstract() )
    				continue;

    			// consider only methods that are public and with bean setter pattern 'setXXX(type foo)'
        		if ( !mthd.isPublic() )
        			continue;
        		String mthdName = mthd.getName();
        		//System.out.println("m1: "+mthdName);
        		if ( !mthdName.startsWith("set") )
        			continue;
        		if ( mthdName.length() <= 3 )
        			continue;

        		Type[] argTypes = mthd.getArgumentTypes();
        		if ( argTypes.length != 1 )
        			continue;
        		Type type = argTypes[0];
        		AttributeTypeInfo attrType = s_supportedAttrTypeMap.get(type);
        		if ( attrType == null )
        			continue;
        		AttributeInfo attr = new AttributeInfo(mthdName,attrType);
        		AttributeInfo existing = attributes.get(attr.getAttributeName());
        		if ( (existing == null) || (type == Type.STRING) ) {
        			//if ( attr.getAttributeName().equals("width") ) {
        				//System.out.println("setting width attr: "+jcls.getClassName()+", "+attr.getType().objectType+", existing="+existing);
        			//}
					attributes.put(attr.getAttributeName(), attr);
        		}
        	}
    	}
		void collectWidgetAssociations(Map<String,ClassInfo> classesToGen,Map<String,Set<String>> hierChildParentMap) {
			Set<WidgetAddMethodInfo> ignoreWidgetAddMethods = new HashSet<WidgetAddMethodInfo>();
			boolean debug = false;
			//debug = debug || ( "LayoutContainer".equalsIgnoreCase(getLeafName()));
			collectWidgetAssociations(debug,widgetAddMethods,classesToGen,hierChildParentMap,ignoreWidgetAddMethods);
		}
		void collectWidgetAssociations(boolean debug,Set<WidgetAddMethodInfo> widgetAddMethods,Map<String,ClassInfo> classesToGen,Map<String,Set<String>> hierChildParentMap,Set<WidgetAddMethodInfo> ignoreWidgetAddMethods) {
    		if ( debug )
    			System.out.println("class: "+getLeafName()+", parents:"+hierChildParentMap.get(getClassName()));
        	for ( Method mthd : jcls.getMethods() ) {
//    			if ( !newInstancePossible && mthd.isPublic() && mthd.getName().equals("<init>") ) {
//    				newInstancePossible = (mthd.getArgumentTypes().length == 0);
//    			}

    			// consider only methods that are public and with bean setter pattern 'setXXX(type foo)'
        		if ( !mthd.isPublic() )
        			continue;
        		String mthdName = mthd.getName();
        		if ( debug )
        			System.out.println("mthdName: "+mthdName);

        		Type[] argTypes = mthd.getArgumentTypes();
        		if ( argTypes.length != 1 ) {
        			if ( debug )
            			System.out.println("arguments != 1");
        			continue;
        		}
        		Type type = argTypes[0];
        		if ( !( type instanceof ObjectType ) ) {
        			if ( debug )
            			System.out.println("not an object type "+type.getSignature());
        			continue;
        		}
        		String className = ((ObjectType)type).getClassName();

        		boolean defaultMapping = mthdName.equals("set"+GenUtil.getLeafClassName(className)) 
				|| mthdName.equals("add")
				|| mthdName.equals("add"+GenUtil.getLeafClassName(className))
				;
        		if ( !defaultMapping ) {
            		// ignore specific method naming that does not start with 'set'
            		if ( !mthdName.startsWith("set") && !mthdName.startsWith("add")) {
                		if ( debug )
                			System.out.println("ignoring method : "+mthdName);
            			continue;
            		}
        		}
        		/*
        		if ( !ok ) {
        			if ( debug )
            			System.out.println("name does not match pattern");
        			continue;
        		}
        		*/
        		
        		if ( !classesToGen.containsKey(className) && !className.equals("com.google.gwt.user.client.ui.Widget") ) {
        			// let us see if there is a base class that is generated and if it is let us mask base classes off
        			WidgetAddMethodInfo wm = new WidgetAddMethodInfo(mthdName,className, defaultMapping);
        			for ( WidgetAddMethodInfo overrideWM : wm.getOverridenMethodSignatures(hierChildParentMap) ) {
        				ignoreWidgetAddMethods.add(overrideWM);
            			if ( debug ) {
            				System.out.println("ignoring : "+overrideWM);
            			}
        			}
        			if ( debug )
            			System.out.println("class is not generated "+className);
        			continue;
        		}
        		WidgetAddMethodInfo wm = new WidgetAddMethodInfo(mthdName,className,defaultMapping);
        		if ( !ignoreWidgetAddMethods.contains(wm) ) {
        			widgetAddMethods.add(wm);
    				ignoreWidgetAddMethods.add(wm);
        			for ( WidgetAddMethodInfo overrideWM : wm.getOverridenMethodSignatures(hierChildParentMap) ) {
        				ignoreWidgetAddMethods.add(overrideWM);
        			}
        			if ( debug ) {
        				System.out.println("add done : "+wm);
        				System.out.println("ignore list : "+ignoreWidgetAddMethods);
        			}
        		}
        	}
    		ClassInfo parentCi = classesToGen.get(parentClassName);
    		if ( parentCi != null ) {
    			parentCi.collectWidgetAssociations(debug,widgetAddMethods,classesToGen,hierChildParentMap,ignoreWidgetAddMethods);
    		}
		}
    	public String getPackageName() {
			return packageName;
		}
    	public String getClassName() {
			return jcls.getClassName();
		}
    	public String getLeafName() {
			return GenUtil.getLeafClassName(jcls.getClassName());
		}
		public String getParentClassName() {
			return parentClassName;
		}
		public String getParentLeafName() {
			return GenUtil.getLeafClassName(parentClassName);
		}
		public boolean isExtendsGeneric() {
			return extendsGeneric;
		}
		public boolean isGeneric() {
			return generic;
		}
		public boolean isAbstract() {
			return jcls.isAbstract();
		}
		public boolean isNewInstancePossible() {
			return newInstancePossible;
		}
		public boolean isGwtLibGeneration() {
			return gwtLib;
		}
		public Collection<AttributeInfo> getAttributes() {
			return attributes.values();
		}
		public Set<WidgetAddMethodInfo> getWidgetAddMethods() {
			return widgetAddMethods;
		}
    }

    /** information of a single attribute setter that maps to xml attribute and a widget property */
    public static class AttributeInfo {
    	private final String attributeName;
    	private final String methodName;
    	private final AttributeTypeInfo type;
    	AttributeInfo(String method, AttributeTypeInfo type) {
    		String attrName = method.substring(3);
    		if ( attrName.length() == 1 )
    			attrName = Character.toLowerCase(attrName.charAt(0))+"";
    		else
    			attrName = Character.toLowerCase(attrName.charAt(0))+attrName.substring(1);

    		this.attributeName = attrName;
    		this.methodName = method;
    		this.type = type;
    	}
    	public String getAttributeName() {
			return attributeName;
		}
		public String getMethodName() {
			return methodName;
		}
		public AttributeTypeInfo getType() {
			return type;
		}
		public String toString() {
			return attributeName+", type="+type.objectType;
		}
    }
    /** information about type of attribute */
	public static class AttributeTypeInfo {
    	private final String objectType;
		private final String primitiveType;
    	AttributeTypeInfo(String objectType, String primitiveType) {
    		this.objectType = objectType;
    		this.primitiveType = primitiveType;
    	}
    	public String getObjectType() {
			return objectType;
		}
		public String getPrimitiveType() {
			return primitiveType;
		}
    }

    /** information about widget class and method information */
    public static class WidgetAddMethodInfo {
    	private final String className;
    	private final String methodName;
    	private final boolean defaultMapping;
    	WidgetAddMethodInfo(String method, String className,boolean defaultMapping) {
    		this.methodName = method;
    		this.className = className;
    		this.defaultMapping = defaultMapping;
    	}
    	public String getClassName() {
			return className;
		}
		public String getMethodName() {
			return methodName;
		}
		public boolean isDefaultMapping() {
			return defaultMapping;
		}
		public boolean equals(Object o) {
			if ( !( o instanceof WidgetAddMethodInfo) )
				return false;
			WidgetAddMethodInfo other = (WidgetAddMethodInfo)o;
			return ( other.methodName.equals(methodName) && other.className.equals(className) ); 
		}
		public int hashCode() { return (methodName+"::"+className).hashCode(); }
		public Set<WidgetAddMethodInfo> getOverridenMethodSignatures(Map<String,Set<String>> hierChildParentMap) {
			Set<WidgetAddMethodInfo> set = new HashSet<WidgetAddMethodInfo>();
			Set<String> parentSet = hierChildParentMap.get(className);
			if ( parentSet != null ) {
				for ( String parentClassName : parentSet )
					set.add(new WidgetAddMethodInfo(methodName,parentClassName,defaultMapping));
			}
			return set;
		}
		public String toString() { return methodName+"("+className+")"; }
    }
}
