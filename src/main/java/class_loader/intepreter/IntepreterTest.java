package class_loader.intepreter;

/**
 * 编译器-解释器
 */
public class IntepreterTest {

    /*    编译
        命令-Mixed默认为混合模式
    -Mint 启动快执行慢
    -Xcomp 纯编译模式 启动很慢执行很快*/
    public static void main(String[] args) {
        Long t1=System.currentTimeMillis();
        for(long i=0;i<10_000L;i++){
            method();
        }
        for(long i=0;i<10_000L;i++){
            method();
        }
        System.out.println(System.currentTimeMillis()-t1);
    }
    public static void method(){
        
        for(int i=0;i<10_000;i++){
            int j=i%3;
        }
    }
}
