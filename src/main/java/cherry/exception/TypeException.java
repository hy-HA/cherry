package cherry.exception;

public class TypeException extends RuntimeException{

    private TypeException(String message){ super(message);}

    public static TypeException of(String typeName, String name){
        return new TypeException(String.format("[%s] 해당 이름을 가진 [%s]가 존재하지 않습니다", typeName, name));
    }
}
