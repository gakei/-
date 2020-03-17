package WHJ.mapper;

import WHJ.dto.QuestionDTO;
import WHJ.dto.QuestionQueryDTO;
import WHJ.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);
    List<QuestionDTO> selectLatestQuestions();
    Integer countBySearch(QuestionQueryDTO questionQueryDTO);
    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}
