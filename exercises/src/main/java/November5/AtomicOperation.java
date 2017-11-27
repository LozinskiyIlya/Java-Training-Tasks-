package November5;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicOperation {
    static AtomicBoolean isLocked = new AtomicBoolean(false);

    public static void main(String[] args) {
    }

    public static boolean tryLock(){
        return isLocked.compareAndSet(false,true);
    }


    public static void Unlock(){
        isLocked.compareAndSet(true,false);
    }
}

