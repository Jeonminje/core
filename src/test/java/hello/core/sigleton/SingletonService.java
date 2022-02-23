package hello.core.sigleton;

public class SingletonService {

    private static final SingletonService intance = new SingletonService();

    public static SingletonService getInstance() {
        return intance;
    }

    private SingletonService(){
        //생성자를 private으로 막아서 new못하게 막음.!!
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
