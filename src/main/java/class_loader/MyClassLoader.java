package class_loader;

public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String path) throws ClassNotFoundException {
        Class clzz=loadClass(path);
        System.out.println(clzz);
        return clzz;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader l=new MyClassLoader();
        Class<?> aClass = l.findClass("class_loader.ClassLoaderTest");
        System.out.println(aClass.getClassLoader());
    }
}
