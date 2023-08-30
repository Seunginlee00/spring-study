package org.example.singleton;

public class SingletonService {
    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();
    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한 다.
    public static SingletonService getInstance() {
        // 인스턴스에 참조로 넣어둠 -> 꺼낼수 있는 유일한 방법
        // private 이라 딴대서 호출이 힘듬
        // 항상 같은 인스턴스를 호출, but 어디서든 못쓰도록 new로 객체 생성 못하도록 private으로 설정 하는 것이 중요함.. !!
        return instance;
    }
//3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다. private SingletonService() {}
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
