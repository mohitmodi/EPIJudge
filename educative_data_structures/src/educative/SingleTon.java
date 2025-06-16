package educative;

public class SingleTon {
    private static volatile SingleTon singleton = null;

    private SingleTon() {
    }

    public static SingleTon getSingleTon() {
        if (singleton == null) {
            synchronized (SingleTon.class) {
                if (singleton == null) {
                    singleton = new SingleTon();
                }
            }
        }
        return singleton;
    }
    protected SingleTon readResolve(){
        return singleton;
    }

}