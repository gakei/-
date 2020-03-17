package WHJ.mapper;

import WHJ.dto.QuestionDTO;
import WHJ.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);
    List<QuestionDTO> selectLatestQuestions();
}
