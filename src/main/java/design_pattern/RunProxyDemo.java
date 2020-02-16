package design_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IStation{
    public void sale();
}
class Station implements IStation{
    public void sale(){
        System.out.println("Station sale");
    }
    public String toString(){
        System.out.println("--------------");
        return "";
    }
}
public class RunProxyDemo {
    public static void main(String[] args) {
        Station station=new Station();
        //每次 stationProxy 执行任何方法的时候 都会进入 invoke （除了native 本地方法除外 如 ：hashCode）
        //JDBC 线程池就是 当getConnection 的时候 从List 里面remove，然后close的时候再把那个Connection 放回去
        IStation stationProxy = (IStation)Proxy.newProxyInstance(RunProxyDemo.class.getClassLoader(), new Class[]{IStation.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("被代理了");
                method.invoke(station,null);
                System.out.println("被调用方法："+method.getName());
                return null;
            }
        });
        stationProxy.sale(); // invoke 里面的Method 就会是同一个
        stationProxy.toString();

    }
}
