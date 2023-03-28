package hello.core.singleton;

public class SingletonService {
    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();
    //2. public으로 열어서 객체 인스턴스가 필요하면 조회하여 사용한다.
    public static SingletonService getInstance(){
        return instance;
    }
    //3. private으로 선언하여 new 를 이용한 객체 생성을 막는다.
    private SingletonService(){
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
