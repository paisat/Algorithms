package javaquirks;

/**
 * Created by sarvothampai on 16/11/15.
 */
public class SingleTon {

    private static SingleTon instance;

    private SingleTon(){
    }

    public  static SingleTon getInstance(){

        if(instance==null){
            synchronized (SingleTon.class){
                instance=new SingleTon();
            }
        }

        return instance;
    }

}
