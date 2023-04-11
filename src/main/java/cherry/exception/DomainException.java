package cherry.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }

    public static DomainException notFoundRow(Long id){
        return new DomainException(String.format("%s 해당 ROW가 존재하지 않습니다",id));
    }
    public static DomainException notFoundRow(String str){
        return new DomainException(String.format("%s 해당 ROW가 존재하지 않습니다",str));
    }
}
