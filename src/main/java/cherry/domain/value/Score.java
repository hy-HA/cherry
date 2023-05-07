package cherry.domain.value;

import javax.persistence.AttributeConverter;

public class Score {
    private final int value;

    public Score(int value) {
        if(value<0 || value >100){
            throw new IllegalArgumentException("존재할 수 없는 점수입니다");
        }
        this.value = value;
    }

    public Integer getValue(){return value;}

    public String toString(){
        return String.format("%s점",value);
    }

    public static class ScoreConverter implements AttributeConverter<Score, Integer>{

        @Override
        public Integer convertToDatabaseColumn(Score attribute) {
            return attribute.getValue();
        }

        @Override
        public Score convertToEntityAttribute(Integer dbData) {
            return new Score(dbData);
        }
    }
}
