package cherry.domain;


public enum SubjectType {
    KOR("국어"),
    ENG("영어"),
    MATH("수학");

    private String description;

    SubjectType(String description){
        this.description = description;
    }
}
