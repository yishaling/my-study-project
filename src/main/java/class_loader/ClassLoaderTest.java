package class_loader;

public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println("-----------boot-paths--------------------");
        String pathBoot=System.getProperty("sun.boot.class.path");
        System.out.println(pathBoot.replaceAll(";",System.lineSeparator())) ;
        String ext=System.getProperty("java.ext.dirs");
        System.out.println("------------------java.ext.dirs---------------");
        System.out.println(ext.replaceAll(";",System.lineSeparator()));
        System.out.println("-------------------app-paths");
        String app=System.getProperty("java.class.path");
        System.out.println(app.replaceAll(";",System.lineSeparator()));

    }
}
